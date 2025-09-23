package io.github.ppzxc.fixh;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class StringUtils {

  private StringUtils() {
  }

  public static boolean isBlank(String src) {
    return isEmpty(src) || src.trim().isEmpty();
  }

  public static boolean isNotBlank(String src) {
    return !isBlank(src);
  }

  public static String nvl(String src) {
    return isNull(src) ? "" : src;
  }

  public static String nvl(String src, String defaults) {
    return isNull(src) ? defaults : src;
  }

  public static boolean isNull(String src) {
    return src == null;
  }

  public static boolean isNotNull(String src) {
    return !isNull(src);
  }

  public static boolean isEmpty(String src) {
    return isNull(src) || src.isEmpty();
  }

  public static boolean isNotEmpty(String src) {
    return !isEmpty(src);
  }

  public static String isEmptyToDefault(String src, String def) {
    return isEmpty(src) ? def : src;
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

  public static String join(String... paths) {
    return String.join("", paths);
  }

  public static String giveMeOneKorean(int length) {
    return IntStream.range(0, length)
      .mapToObj(i -> String.valueOf((char) ((Math.random() * 11172) + 0xAC00)))
      .collect(Collectors.joining());
  }

  public static String giveMeOneKoreanAsBytes(int lengthOfBytes) {
    StringBuilder stringBuilder = new StringBuilder();
    while (stringBuilder.toString().getBytes(Charset.forName("MS949")).length < lengthOfBytes) {
      char ch = (char) ((Math.random() * 11172) + 0xAC00);
      stringBuilder.append(ch);
    }
    return stringBuilder.toString();
  }

  public static String giveMeOne() {
    return giveMeOne(512);
  }

  public static String giveMeOne(int origin, int bound) {
    return giveMeOne(ThreadLocalRandom.current().nextInt(origin, bound));
  }

  public static String giveMeOne(int origin, int bound, int... without) {
    int srcSize;
    do {
      srcSize = ThreadLocalRandom.current().nextInt(origin, bound);
    } while (isNotContains(without, srcSize));
    return giveMeOne(srcSize);
  }

  private static boolean isNotContains(int[] without, int match) {
    return Arrays.stream(without).anyMatch(w -> w == match);
  }

  public static String giveMeOne(int length) {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    StringBuilder buffer = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomLimitedInt = leftLimit + (int)
        (ThreadLocalRandom.current().nextFloat() * (rightLimit - leftLimit + 1));
      buffer.append((char) randomLimitedInt);
    }
    return buffer.toString();
  }

  public static String requireNotNull(String src) {
    if (isNull(src)) {
      throw new IllegalArgumentException("required not null");
    }
    return src;
  }

  public static String requireNotBlank(String src) {
    if (isBlank(src)) {
      throw new IllegalArgumentException("required not blank");
    }
    return src;
  }

  public static String requireNotEmpty(String src) {
    if (isEmpty(src)) {
      throw new IllegalArgumentException("required not empty");
    }
    return src;
  }

  public static String requireNotNull(String src, RuntimeException exception) {
    if (src == null) {
      throw exception;
    }
    return src;
  }

  public static String requireNotEmpty(String src, RuntimeException exception) {
    if (requireNotNull(src, exception).isEmpty()) {
      throw exception;
    }
    return src;
  }

  public static String requireNotBlank(String src, RuntimeException exception) {
    if (requireNotEmpty(src, exception).trim().isEmpty()) {
      throw exception;
    }
    return src;
  }
}
