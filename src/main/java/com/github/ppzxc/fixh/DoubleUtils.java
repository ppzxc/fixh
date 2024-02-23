package com.github.ppzxc.fixh;

public final class DoubleUtils {

  private DoubleUtils() {
  }

  public static double giveMeOne() {
    return FixhConstants.SECURE_RANDOM.nextDouble();
  }

  public static double getNegative() {
    return FixhConstants.SECURE_RANDOM.nextDouble(Double.MIN_VALUE, -1);
  }

  public static double getPositive() {
    return FixhConstants.SECURE_RANDOM.nextDouble(1, Double.MAX_VALUE);
  }
}
