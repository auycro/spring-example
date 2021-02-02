package com.auycro.score.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringUtility_toMD5Test {
  
  @Test
  public void shouldBeEquals() throws Exception {
    assertEquals("3858f62230ac3c915f300c664312c63f", StringUtility.toMD5("foobar"));
  }

  @Test
  public void shouldBeEquals_EmptyString() throws Exception {
    assertEquals("d41d8cd98f00b204e9800998ecf8427e", StringUtility.toMD5(""));
  }

  @Test
  public void shouldBeNotOK() throws Exception {
    assertNotEquals("", StringUtility.toMD5(""));
  }

  @Test
  public void shouldBeThrows_NullPointerException() {
    assertThrows(NullPointerException.class, () -> {
      StringUtility.toMD5(null);
    });
  }  
}
