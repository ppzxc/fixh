package com.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

public final class DoubleUtils {

  private DoubleUtils() {
  }

  public static double giveMeOne() {
    return ThreadLocalRandom.current().nextDouble();
  }

  public static double giveMeOne(double origin, double bound) {
    return ThreadLocalRandom.current().nextDouble(origin, bound);
  }

  public static double giveMeNegative() {
    return giveMeOne(-1, Double.MIN_VALUE);
  }

  public static double giveMePositive() {
    return giveMeOne(1, Double.MAX_VALUE);
  }
}
