package com.auycro.score.utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class StringUtility {
  public static String toMD5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    String result = null;
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(input.getBytes("UTF-8"), 0, input.length());
    result = DatatypeConverter.printHexBinary(md.digest());
    return result.toLowerCase();
  }
}
