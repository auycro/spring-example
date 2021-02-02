package com.auycro.score.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

public class DateUtility_toUnixTimestampTest {

  @Test
  public void shouldBeThrows_ParseException() {
    assertThrows(ParseException.class, () -> {
      DateUtility.toUnixTimestamp("Foo");
    });
  }

  @Test
  public void shouldBeThrows_NullPointerException() {
    assertThrows(NullPointerException.class, () -> {
      DateUtility.toUnixTimestamp(null);
    });
  }

  @Test
  public void shouldBeEquals_DateTime() throws Exception {
    assertEquals(1609463410, DateUtility.toUnixTimestamp("2021-01-01 10:10:10"));
  }

  @Test
  public void shouldBeEquals_DateOnly() throws Exception {
    assertEquals(1609426800, DateUtility.toUnixTimestamp("2021-01-01"));
  }

  @Test
  public void shouldBeNotEquals() throws Exception{
    long currentMilliseconds = System.currentTimeMillis();
    String currentMillisecondsString = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(currentMilliseconds);
    assertNotEquals(currentMilliseconds, DateUtility.toUnixTimestamp(currentMillisecondsString));
  }
}
