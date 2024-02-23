package com.github.ppzxc.fixh;

public final class BooleanUtils {

  private BooleanUtils() {
  }

  public static boolean giveMeOne() {
    return FixhConstants.SECURE_RANDOM.nextBoolean();
  }
}
