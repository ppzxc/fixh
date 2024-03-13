package io.github.ppzxc.fixh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NumberUtils {

  private NumberUtils() {
  }

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
