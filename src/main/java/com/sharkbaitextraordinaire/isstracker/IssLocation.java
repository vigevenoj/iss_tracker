package com.sharkbaitextraordinaire.isstracker;

import org.geojson.LngLatAlt;
import org.geojson.Point;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = IssPositionDeserializer.class)
public class IssLocation {
	@JsonProperty("iss_position")
	private Point location;
	private Long timestamp;
	private String message;

  public IssLocation() { }

  public IssLocation(Point location, String message, Long timestamp) {
    this.location = location;
    this.message = message;
    this.timestamp = timestamp;
  }
	
	
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
