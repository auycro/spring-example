package com.auycro.score.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
  public static long toUnixTimestamp(String input) throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(input);
    return date.getTime() / 1000L;
  }

  public static Timestamp toTimestamp(long input){
    return new Timestamp((long)input*1000);
  }
}
