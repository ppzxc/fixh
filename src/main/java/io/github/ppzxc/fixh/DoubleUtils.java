package io.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Double utils.
 */
public final class DoubleUtils {

  private DoubleUtils() {
  }

  /**
   * Give me one double.
   *
   * @return the double
   */
  public static double giveMeOne() {
    return ThreadLocalRandom.current().nextDouble();
  }

  /**
   * Give me one double.
   *
   * @param origin the origin
   * @param bound  the bound
   * @return the double
   */
  public static double giveMeOne(double origin, double bound) {
    return ThreadLocalRandom.current().nextDouble(origin, bound);
  }

  /**
   * Give me negative double.
   *
   * @return the double
   */
  public static double giveMeNegative() {
    return giveMeOne(-1, Double.MIN_VALUE);
  }

  /**
   * Give me positive double.
   *
   * @return the double
   */
  public static double giveMePositive() {
    return giveMeOne(1, Double.MAX_VALUE);
  }
}
