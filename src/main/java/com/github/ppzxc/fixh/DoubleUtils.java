package com.github.ppzxc.fixh;

public final class DoubleUtils {

  private DoubleUtils() {
  }

  public static double giveMeOne() {
    return FixhConstants.SECURE_RANDOM.nextDouble();
  }

  public static double giveMeNegative() {
    double given = giveMeOne();
    if (given > 0) {
      return given * -1;
    }
    return given;
  }

  public static double giveMePositive() {
    double given = giveMeOne();
    if (given < 0) {
      return given * -1;
    }
    return given;
  }
}
