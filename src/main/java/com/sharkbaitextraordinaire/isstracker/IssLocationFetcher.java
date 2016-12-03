package com.sharkbaitextraordinaire.isstracker;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author vigevenoj
 *
 */
public class IssLocationFetcher {

	// TODO set up so end user can pick one or the other or an alternate api
	private static final String OPEN_NOTIFY_API_URL = "http://api.open-notify.org/iss-now.json";
	private static final String WHERETHEISSAT_URL = "http://wheretheiss.at/w/developer";
	private static ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	private static int POLL_INTERVAL = 30; // only check every 30 seconds
	private static DecimalFormat df = new DecimalFormat("#.####");
	private final ScheduledExecutorService scheduler =
			Executors.newScheduledThreadPool(1);


	// We'll push updates onto this for a consumer to pop off as they wish
	private LinkedBlockingQueue<IssLocation> queue;
	private JerseyClient client;

	public IssLocationFetcher() {
		// If a queue isn't provided, set one up
		this.queue = new LinkedBlockingQueue<IssLocation>();
	}

	public IssLocationFetcher(LinkedBlockingQueue<IssLocation> queue) {
		this.queue = queue;


		ClientConfig configuration = new ClientConfig();
		client = JerseyClientBuilder.createClient(configuration);

		// Set up rounding for lat/lng
		df.setRoundingMode(RoundingMode.HALF_UP); 

		// TODO make the interval configurable
		scheduler.scheduleAtFixedRate(() -> {
			fetch();
		}, 0, 30, TimeUnit.SECONDS);
	}

	public void fetch() {
		JerseyWebTarget target = client.target(OPEN_NOTIFY_API_URL);
		Invocation.Builder invocationBuilder = target.request();
		Response response = invocationBuilder.get();

		int status = response.getStatus();
		if (status == 200) {
			String responseString = response.readEntity(String.class);

			System.out.println(responseString);
			try {
				IssLocation issLocation = mapper.readValue(responseString, IssLocation.class);
				if (null == issLocation) {
					System.out.println("no location");
				} else {
					System.out.println("ISS is at " + issLocation.getLocation().getCoordinates().getLatitude() 
							+ ", " + issLocation.getLocation().getCoordinates().getLongitude());
					System.out.println("At " + issLocation.getTimestamp());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}




}
