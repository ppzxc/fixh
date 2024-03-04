package io.github.ppzxc.fixh;

/**
 * The type Object utils.
 */
public final class ObjectUtils {

  private ObjectUtils() {
  }

  /**
   * Require non null t.
   *
   * @param <T> the type parameter
   * @param obj the obj
   * @return the t
   */
  public static <T> T requireNonNull(T obj) {
    if (obj == null) {
      throw new NullPointerException();
    }
    return obj;
  }

  /**
   * Require non null t.
   *
   * @param <T>     the type parameter
   * @param obj     the obj
   * @param message the message
   * @return the t
   */
  public static <T> T requireNonNull(T obj, String message) {
    if (obj == null) {
      throw new NullPointerException(message);
    }
    return obj;
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
