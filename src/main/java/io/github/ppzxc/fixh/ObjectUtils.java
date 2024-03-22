package io.github.ppzxc.fixh;

public final class ObjectUtils {

  private ObjectUtils() {
  }

  public static <T> T requireNotNull(T obj) {
    if (obj == null) {
      throw new NullPointerException();
    }
    return obj;
  }

  public static <T> T requireNotNull(T obj, String message) {
    if (obj == null) {
      throw new NullPointerException(message);
    }
    return obj;
  }

  public static <T> T requireNotNull(T obj, RuntimeException exception) {
    if (obj == null) {
      throw exception;
    }
    return obj;
  }
}
