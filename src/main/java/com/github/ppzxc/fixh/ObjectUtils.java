package com.github.ppzxc.fixh;

/**
 * The type Object utils.
 */
public final class ObjectUtils {

  private ObjectUtils() {
  }

  /**
   * Require non null t.
   *
   * @param <T>       the type parameter
   * @param obj       the obj
   * @param exception the exception
   * @return the t
   */
  public static <T> T requireNonNull(T obj, RuntimeException exception) {
    if (obj == null) {
      throw exception;
    }
    return obj;
  }
}
