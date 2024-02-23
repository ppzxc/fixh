package com.nanoit.gateway.common;

public final class RandomBoolean {

  private RandomBoolean() {
  }

  public static boolean giveMeOne() {
    return RandomConstants.getSecureRandom().nextBoolean();
  }
}
