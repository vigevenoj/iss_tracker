package com.sharkbaitextraordinaire.isstracker;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Ignore;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

public class IssLocationDeserializerTest {

  private static String position_fixture = "{\"iss_position\": {\"latitude\": \"-51.6194\", \"longitude\": \"54.0272\"}, \"message\": \"success\", \"timestamp\": 1480147203}";

  private static final ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  @Test
  public void deserializeIssPosition() throws Exception {
    IssLocation readValue = MAPPER.readValue(position_fixture, IssLocation.class);
    
    assertNotNull(readValue);
    assertThat(readValue.getTimestamp()).isEqualTo(Long.valueOf(1480147203));
    
    assertNotNull(readValue.getLocation());
    assertNotNull(readValue.getLocation().getCoordinates());
    assertEquals(readValue.getLocation().getCoordinates().getLatitude(), -51.6194, 1.0);
    assertEquals(readValue.getLocation().getCoordinates().getLongitude(), 54.00272, 1.0);

    assertNotNull(readValue.getTimestamp());
  }
}
