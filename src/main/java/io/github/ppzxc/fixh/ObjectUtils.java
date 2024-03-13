package io.github.ppzxc.fixh;

public final class ObjectUtils {

  private ObjectUtils() {
  }

  public static <T> T requireNonNull(T obj) {
    if (obj == null) {
      throw new NullPointerException();
    }
    return obj;
  }

  public static <T> T requireNonNull(T obj, String message) {
    if (obj == null) {
      throw new NullPointerException(message);
    }
    return obj;
  }

  public static <T> T requireNonNull(T obj, RuntimeException exception) {
    if (obj == null) {
      throw exception;
    }
    return obj;
  }
}
