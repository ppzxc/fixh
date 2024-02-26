package com.github.ppzxc.fixh;

public final class ObjectUtils {

  private ObjectUtils() {
  }

  public static <T> T requireNonNull(T obj, RuntimeException exception) {
    if (obj == null) {
      throw exception;
    }
    return obj;
  }
}
