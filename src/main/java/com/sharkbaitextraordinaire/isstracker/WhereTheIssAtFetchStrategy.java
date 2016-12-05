package com.sharkbaitextraordinaire.isstracker;

public class WhereTheIssAtFetchStrategy implements IssLocationFetchStrategy {

	private static final String WHERETHEISSAT_URL = "http://wheretheiss.at/w/developer";
	// TODO add a rate-limiting check to our api
	// The wheretheiss.at api is rate-limited to ~1 request / second
	private static final String RATE_LIMIT_LIMIT_HEADER = "X-Rate-Limit-Limit"; // int, 350
	private static final String RATE_LIMIT_INTERVAL = "X-Rate-Limit-Interval"; // String, "5 minutes" 
	private static final String RATE_LIMIT_REMAINING = "X-Rate-Limit-Remaining"; // int, <= 350

	public String getApiUrl() {
		return WHERETHEISSAT_URL;
	}

	public int getPollInterval() {
		return 30;
	}

}
