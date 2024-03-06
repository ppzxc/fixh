package io.github.ppzxc.fixh;

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
