package com.nanoit.gateway.common;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class StringUtils {

  private StringUtils() {
  }

  public static String prettyBytes(long v) {
    if (v < 1024) {
      return v + " B";
    }
    int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
    return String.format("%.1f %sB", (double) v / (1L << (z * 10)), " KMGTPE".charAt(z));
  }

  public static void requireNotNull(String given) {
    if (isNull(given)) {
      throw new IllegalArgumentException("required not null");
    }
  }

  public static void requireNotBlank(String given) {
    if (isBlank(given)) {
      throw new IllegalArgumentException("required not blank");
    }
  }

  public static void requireNotEmpty(String given) {
    if (isEmpty(given)) {
      throw new IllegalArgumentException("required not empty");
    }
  }

  public static boolean isBlank(String src) {
    return src == null || src.isEmpty() || src.trim().isEmpty();
  }

  public static boolean isNotBlank(String src) {
    return !isBlank(src);
  }

  public static String nvl(String src) {
    return isNull(src) ? "" : src;
  }

  public static boolean isNull(String src) {
    return src == null;
  }

  public static boolean isNotNull(String src) {
    return !isNull(src);
  }

  public static boolean isEmpty(String src) {
    return (src == null || src.isEmpty());
  }

  public static boolean isNotEmpty(String src) {
    return !isEmpty(src);
  }

  public static String isEmptyToDefault(String src, String def) {
    return isEmpty(src) ? def : src;
  }

  public static String getOnlyNumbers(String str) {
    if (str == null) {
      return "";
    }

    StringBuilder sb = new StringBuilder();//버퍼 설정
    sb.setLength(0);// 초기화
    IntStream.range(0, str.length())
      .filter(i -> Character.isDigit(str.charAt(i)))
      .forEach(i -> sb.append(str.charAt(i)));
    return sb.toString();
  }

  public static String getCurrentPath() throws IOException {
    return (new File(".")).getCanonicalFile().getPath();
  }

  public static String[] getFileNames(String path, final String patternName) {
    File directory = new File(path);

    return directory.list((dir, name) -> name.startsWith(patternName));
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

  public static void requiredNonBlank(String given) {
    if (isBlank(given)) {
      throw new IllegalArgumentException("input is blank");
    }
  }

  public static String leftPad(String type, int i, String space) {
    return padding(type, i, space) + type;
  }

  public static String rightPad(String type, int i, String space) {
    return type + padding(type, i, space);
  }

  private static String padding(String type, int i, String space) {
    if (type.length() >= i) {
      return type;
    }
    return IntStream.range(0, i - type.length())
      .mapToObj(j -> space)
      .collect(Collectors.joining());
  }

  public static String joinPath(String... paths) {
    return IntStream.range(0, paths.length)
      .mapToObj(i -> {
        String path = paths[i];
        if (i != paths.length - 1) {
          path = path + PathUtils.getFileSeparator();
        }
        return path;
      }).collect(Collectors.joining());
  }

  public static String join(String... paths) {
    return String.join("", paths);
  }

  public static String generateKey(int length) {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    return IntStream.range(0, length)
      .mapToObj(
        i -> String.valueOf(
          (char) (leftLimit + (int) (RandomConstants.getSecureRandom().nextFloat() * (rightLimit - leftLimit + 1)))))
      .collect(Collectors.joining());
  }

  public static String requireNonNull(String value, RuntimeException exception) {
    if (value == null) {
      throw exception;
    }
    return value;
  }

  public static String requireNonEmpty(String value, RuntimeException exception) {
    if (requireNonNull(value, exception).isEmpty()) {
      throw exception;
    }
    return value;
  }

  public static String requireNonBlank(String value, RuntimeException exception) {
    if (requireNonEmpty(value, exception).trim().isEmpty()) {
      throw exception;
    }
    return value;
  }
}
