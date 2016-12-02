package com.sharkbaitextraordinaire.isstracker;

import java.io.IOException;

import org.geojson.Point;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import com.sharkbaitextraordinaire.isstracker.IssLocation;

public class IssPositionDeserializer extends StdDeserializer<IssLocation> {

  public IssPositionDeserializer() {
    this(null);
  }

  public IssPositionDeserializer(Class<?> vc) {
    super(vc);
  }

	@Override
	public IssLocation deserialize(JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    JsonNode root = jsonParser.getCodec().readTree(jsonParser);
    Double longitude = Double.valueOf(root.get("iss_position").get("longitude").asText());
    Double latitude = Double.valueOf(root.get("iss_position").get("latitude").asText());
    String message = root.get("message").asText();
    Long timestamp = Long.valueOf(root.get("timestamp").asText());
    Point p = new Point(longitude, latitude);
		return new IssLocation(p, message, timestamp);
	}

}
