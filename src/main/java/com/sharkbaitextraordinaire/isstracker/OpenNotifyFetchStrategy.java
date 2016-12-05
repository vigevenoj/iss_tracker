package com.sharkbaitextraordinaire.isstracker;

public class OpenNotifyFetchStrategy implements IssLocationFetchStrategy {

	private static final String OPEN_NOTIFY_API_URL = "http://api.open-notify.org/iss-now.json";
	
	// TODO handle rate-limiting.
	// The documentation says that a well-behaved client would poll most-frequently at
	// a 5-second interval, so we're just using 30 seconds as our default

	public String getApiUrl() {
		return OPEN_NOTIFY_API_URL;
	}

	public int getPollInterval() {
		return 30;
	}

}
