package com.github.ppzxc.fixh;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type String utils.
 */
public final class StringUtils {

  private StringUtils() {
  }

  /**
   * Is blank boolean.
   *
   * @param src the src
   * @return the boolean
   */
  public static boolean isBlank(String src) {
    return src == null || src.isEmpty() || src.trim().isEmpty();
  }

  /**
   * Is not blank boolean.
   *
   * @param src the src
   * @return the boolean
   */
  public static boolean isNotBlank(String src) {
    return !isBlank(src);
  }

  /**
   * Nvl string.
   *
   * @param src the src
   * @return the string
   */
  public static String nvl(String src) {
    return isNull(src) ? "" : src;
  }

  /**
   * Is null boolean.
   *
   * @param src the src
   * @return the boolean
   */
  public static boolean isNull(String src) {
    return src == null;
  }

  /**
   * Is not null boolean.
   *
   * @param src the src
   * @return the boolean
   */
  public static boolean isNotNull(String src) {
    return !isNull(src);
  }

  /**
   * Is empty boolean.
   *
   * @param src the src
   * @return the boolean
   */
  public static boolean isEmpty(String src) {
    return (src == null || src.isEmpty());
  }

  /**
   * Is not empty boolean.
   *
   * @param src the src
   * @return the boolean
   */
  public static boolean isNotEmpty(String src) {
    return !isEmpty(src);
  }

  /**
   * Is empty to default string.
   *
   * @param src the src
   * @param def the def
   * @return the string
   */
  public static String isEmptyToDefault(String src, String def) {
    return isEmpty(src) ? def : src;
  }

  /**
   * Gets current path.
   *
   * @return the current path
   * @throws IOException the io exception
   */
  public static String getCurrentPath() throws IOException {
    return (new File(".")).getCanonicalFile().getPath();
  }

  /**
   * Required non blank.
   *
   * @param given the given
   */
  public static void requiredNonBlank(String given) {
    if (isBlank(given)) {
      throw new IllegalArgumentException("input is blank");
    }
  }

  /**
   * Left pad string.
   *
   * @param type  the type
   * @param i     the
   * @param space the space
   * @return the string
   */
  public static String leftPad(String type, int i, String space) {
    return padding(type, i, space) + type;
  }

  /**
   * Right pad string.
   *
   * @param type  the type
   * @param i     the
   * @param space the space
   * @return the string
   */
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

  /**
   * Join string.
   *
   * @param paths the paths
   * @return the string
   */
  public static String join(String... paths) {
    return String.join("", paths);
  }

  /**
   * Lower case string.
   *
   * @param length the length
   * @return the string
   */
  public static String lowerCase(int length) {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    return IntStream.range(0, length)
      .mapToObj(
        i -> String.valueOf(
          (char) (leftLimit + (int) (FixhConstants.SECURE_RANDOM.nextFloat() * (rightLimit - leftLimit + 1)))))
      .collect(Collectors.joining());
  }

  /**
   * Give me one string.
   *
   * @return the string
   */
  public static String giveMeOne() {
    return giveMeOne(512);
  }

  /**
   * Give me one string.
   *
   * @param origin the origin
   * @param bound  the bound
   * @return the string
   */
  public static String giveMeOne(int origin, int bound) {
    return giveMeOne(ThreadLocalRandom.current().nextInt(origin, bound));
  }

  /**
   * Give me one string.
   *
   * @param origin  the origin
   * @param bound   the bound
   * @param without the without
   * @return the string
   */
  public static String giveMeOne(int origin, int bound, int... without) {
    while (true) {
      int givenSize = ThreadLocalRandom.current().nextInt(origin, bound);
      if (Arrays.stream(without).noneMatch(w -> w == givenSize)) {
        return giveMeOne(givenSize);
      }
    }
  }

  /**
   * Give me one string.
   *
   * @param length the length
   * @return the string
   */
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

  /**
   * Require not null.
   *
   * @param given the given
   */
  public static void requireNotNull(String given) {
    if (isNull(given)) {
      throw new IllegalArgumentException("required not null");
    }
  }

  /**
   * Require not blank.
   *
   * @param given the given
   */
  public static void requireNotBlank(String given) {
    if (isBlank(given)) {
      throw new IllegalArgumentException("required not blank");
    }
  }

  /**
   * Require not empty.
   *
   * @param given the given
   */
  public static void requireNotEmpty(String given) {
    if (isEmpty(given)) {
      throw new IllegalArgumentException("required not empty");
    }
  }

  /**
   * Require non null string.
   *
   * @param value     the value
   * @param exception the exception
   * @return the string
   */
  public static String requireNonNull(String value, RuntimeException exception) {
    if (value == null) {
      throw exception;
    }
    return value;
  }

  /**
   * Require non empty string.
   *
   * @param value     the value
   * @param exception the exception
   * @return the string
   */
  public static String requireNonEmpty(String value, RuntimeException exception) {
    if (requireNonNull(value, exception).isEmpty()) {
      throw exception;
    }
    return value;
  }

  /**
   * Require non blank string.
   *
   * @param value     the value
   * @param exception the exception
   * @return the string
   */
  public static String requireNonBlank(String value, RuntimeException exception) {
    if (requireNonEmpty(value, exception).trim().isEmpty()) {
      throw exception;
    }
    return value;
  }
}
