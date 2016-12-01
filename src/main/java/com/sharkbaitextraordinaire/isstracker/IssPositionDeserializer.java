package com.sharkbaitextraordinaire.isstracker;

import java.io.IOException;

import org.geojson.Point;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IssPositionDeserializer extends JsonDeserializer<Point> {

	@Override
	public Point deserialize(JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		String text = jsonParser.getText();
		System.out.println("DESERIALIZER: " + text);
		return null;
	}

}
