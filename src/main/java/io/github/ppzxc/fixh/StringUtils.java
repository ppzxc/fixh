package io.github.ppzxc.fixh;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class StringUtils {

  private StringUtils() {
  }

  public static String isBlank(String value, String defaults) {
    return isBlank(value) ? defaults : value;
  }

  public static boolean isBlank(String value) {
    return isEmpty(value) || value.trim().isEmpty();
  }

  public static String isNotBlank(String value, String defaults) {
    return isNotBlank(value) ? value : defaults;
  }

  public static boolean isNotBlank(String value) {
    return !isBlank(value);
  }

  public static String nvl(String value) {
    return isNull(value) ? "" : value;
  }

  public static String nvl(String value, String defaults) {
    return isNull(value) ? defaults : value;
  }

  public static boolean isNull(String value) {
    return value == null;
  }

  public static String isNull(String value, String defaults) {
    return value == null ? defaults : value;
  }

  public static boolean isNotNull(String value) {
    return !isNull(value);
  }

  public static String isNotNull(String value, String defaults) {
    return !isNull(value) ? defaults : value;
  }

  public static boolean isEmpty(String value) {
    return isNull(value) || value.isEmpty();
  }

  public static boolean isNotEmpty(String value) {
    return !isEmpty(value);
  }

  public static String isEmptyToDefault(String value, String def) {
    return isEmpty(value) ? def : value;
  }

  public static String leftPad(String value, int padSize, String padChar) {
    return padding(value, padSize, padChar) + value;
  }

  public static String rightPad(String value, int padSize, String padChar) {
    return value + padding(value, padSize, padChar);
  }

  private static String padding(String value, int padSize, String padChar) {
    if (value.length() >= padSize) {
      return value;
    }
    return IntStream.range(0, padSize - value.length())
      .mapToObj(j -> padChar)
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
    int size;
    do {
      size = ThreadLocalRandom.current().nextInt(origin, bound);
    } while (isNotContains(without, size));
    return giveMeOne(size);
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

  public static String requireNotNull(String value) {
    if (isNull(value)) {
      throw new IllegalArgumentException("required not null");
    }
    return value;
  }

  public static String requireNotBlank(String value) {
    if (isBlank(value)) {
      throw new IllegalArgumentException("required not blank");
    }
    return value;
  }

  public static String requireNotEmpty(String value) {
    if (isEmpty(value)) {
      throw new IllegalArgumentException("required not empty");
    }
    return value;
  }

  public static String requireNotNull(String value, RuntimeException exception) {
    if (value == null) {
      throw exception;
    }
    return value;
  }

  public static String requireNotEmpty(String value, RuntimeException exception) {
    if (requireNotNull(value, exception).isEmpty()) {
      throw exception;
    }
    return value;
  }

  public static String requireNotBlank(String value, RuntimeException exception) {
    if (requireNotEmpty(value, exception).trim().isEmpty()) {
      throw exception;
    }
    return value;
  }
}
