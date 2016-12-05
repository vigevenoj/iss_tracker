package com.sharkbaitextraordinaire.isstracker;

public interface IssLocationFetchStrategy {
	
	// TODO add rate-limiting handling to our API here?

	/**
	 * The url which will be requested to fetch the ISS location
	 */
	public String getApiUrl();

	/** 
	 * The number of seconds this strategy waits between requests for an update from the API
	 */
	public int getPollInterval();

}
