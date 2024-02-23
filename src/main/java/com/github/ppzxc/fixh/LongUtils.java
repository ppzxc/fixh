package com.github.ppzxc.fixh;

public final class LongUtils {

  private LongUtils() {
  }

  public static long giveMeOne() {
    return FixhConstants.SECURE_RANDOM.nextLong();
  }

  public static long getNegative() {
    return FixhConstants.SECURE_RANDOM.nextLong(Long.MIN_VALUE, -1);
  }

  public static long getPositive() {
    return FixhConstants.SECURE_RANDOM.nextLong(1, Long.MAX_VALUE);
  }
}
