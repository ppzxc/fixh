package io.github.ppzxc.fixh;

/**
 * The type Exception utils.
 */
public final class ExceptionUtils {

  private ExceptionUtils() {
  }

  /**
   * Gets root cause.
   *
   * @param throwable the throwable
   * @return the root cause
   */
  public static Throwable getRootCause(Throwable throwable) {
    Throwable rootCause = ObjectUtils.requireNonNull(throwable);
    while (rootCause.getCause() != null) {
      rootCause = rootCause.getCause();
    }
    return rootCause;
  }

  /**
   * Find cause throwable.
   *
   * @param throwable the throwable
   * @param tClass    the t class
   * @return the throwable
   */
  public static <T extends Throwable> Throwable findCause(Throwable throwable, Class<T> tClass) {
    Throwable rootCause = ObjectUtils.requireNonNull(throwable);
    Class<T> find = ObjectUtils.requireNonNull(tClass);
    while (rootCause.getCause() != null) {
      rootCause = rootCause.getCause();
      if (rootCause.getClass().equals(find) || rootCause.getClass().getSuperclass().equals(tClass)) {
        break;
      }
    }
    return rootCause;
  }
}
