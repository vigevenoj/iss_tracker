package com.sharkbaitextraordinaire.isstracker;

public interface IssLocationFetchStrategy {

  /**
   * The url which will be requested to fetch the ISS location
   */
  public String getApiUrl();

  /** 
   * The number of seconds this strategy waits between requests for an update from the API
   */
  public int getPollInterval();

}
