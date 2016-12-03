package com.sharkbaitextraordinaire.isstracker;

public class WhereTheIssAtFetchStrategy implements IssLocationFetchStrategy {

	private static final String WHERETHEISSAT_URL = "http://wheretheiss.at/w/developer";  

	public String getApiUrl() {
		return WHERETHEISSAT_URL;
	}

	public int getPollInterval() {
		return 30;
	}

}
