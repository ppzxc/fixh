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
    while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
      rootCause = rootCause.getCause();
    }
    return rootCause;
  }
}
