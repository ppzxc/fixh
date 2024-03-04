package com.github.ppzxc.fixh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Number utils.
 */
public final class NumberUtils {

  private NumberUtils() {
  }

  /**
   * Gets only numbers.
   *
   * @param str the str
   * @return the only numbers
   */
  public static String getOnlyNumbers(String str) {
    if (StringUtils.isBlank(str)) {
      throw new IllegalArgumentException("'str' require not blank");
    }
    return IntStream.range(0, str.length())
      .filter(i -> Character.isDigit(str.charAt(i)))
      .mapToObj(str::charAt)
      .map(String.class::cast)
      .collect(Collectors.joining());
  }

  /**
   * Gets only digit.
   *
   * @param str the str
   * @return the only digit
   */
  public static String getOnlyDigit(String str) {
    if (str != null && !str.isEmpty()) {
      StringBuffer sb = new StringBuffer();
      Pattern p = Pattern.compile("[^\\d]");
      Matcher m = p.matcher(str);
      while (m.find()) {
        m.appendReplacement(sb, "");
      }
      m.appendTail(sb);
      return sb.toString();
    } else {
      return "";
    }
  }
}
