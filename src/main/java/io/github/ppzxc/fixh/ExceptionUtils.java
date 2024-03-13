package io.github.ppzxc.fixh;

public final class ExceptionUtils {

  private ExceptionUtils() {
  }

  public static Throwable getRootCause(Throwable throwable) {
    Throwable rootCause = ObjectUtils.requireNonNull(throwable);
    while (rootCause.getCause() != null) {
      rootCause = rootCause.getCause();
    }
    return rootCause;
  }

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
