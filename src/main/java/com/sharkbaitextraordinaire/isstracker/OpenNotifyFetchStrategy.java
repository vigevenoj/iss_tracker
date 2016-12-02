package com.sharkbaitextraordinaire.isstracker;

public class OpenNotifyFetchStrategy implements IssLocationFetchStrategy {

	private static final String OPEN_NOTIFY_API_URL = "http://api.open-notify.org/iss-now.json";  

  public String getApiUrl() {
    return OPEN_NOTIFY_API_URL;
  }

  public int getPollInterval() {
    return 30;
  }

}
