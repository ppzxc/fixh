package com.github.ppzxc.fixh;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class StringUtils {

  private StringUtils() {
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

  public static String getCurrentPath() throws IOException {
    return (new File(".")).getCanonicalFile().getPath();
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

  public static String join(String... paths) {
    return String.join("", paths);
  }

  public static String lowerCase(int length) {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    return IntStream.range(0, length)
      .mapToObj(
        i -> String.valueOf(
          (char) (leftLimit + (int) (FixhConstants.SECURE_RANDOM.nextFloat() * (rightLimit - leftLimit + 1)))))
      .collect(Collectors.joining());
  }

  public static String giveMeOne() {
    return giveMeOne(512);
  }

  public static String giveMeOne(int origin, int bound) {
    return giveMeOne(ThreadLocalRandom.current().nextInt(origin, bound));
  }

  public static String giveMeOne(int origin, int bound, int... without) {
    while (true) {
      int givenSize = ThreadLocalRandom.current().nextInt(origin, bound);
      if (Arrays.stream(without).noneMatch(w -> w == givenSize)) {
        return giveMeOne(givenSize);
      }
    }
  }

  public static String giveMeOne(int length) {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    StringBuilder buffer = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomLimitedInt = leftLimit + (int)
        (FixhConstants.SECURE_RANDOM.nextFloat() * (rightLimit - leftLimit + 1));
      buffer.append((char) randomLimitedInt);
    }
    return buffer.toString();
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
