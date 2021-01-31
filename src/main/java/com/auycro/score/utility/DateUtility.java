package com.auycro.score.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
  public static long toUnixTimestamp(String input) throws ParseException {
    String format = (input.length() <= 10)? "yyyy-MM-dd" : "yyyy-MM-dd hh:mm:ss";
    Date date = new SimpleDateFormat(format).parse(input);
    return date.getTime() / 1000L;
  }

  public static Timestamp toTimestamp(long input){
    return new Timestamp((long)input*1000);
  }
}
