package com.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Float utils.
 */
public final class FloatUtils {

  private FloatUtils() {
  }

  /**
   * Give me one float.
   *
   * @return the float
   */
  public static float giveMeOne() {
    return ThreadLocalRandom.current().nextFloat();
  }

  /**
   * Give me negative float.
   *
   * @return the float
   */
  public static float giveMeNegative() {
    float next = giveMeOne();
    if (next > 0) {
      return next * -1;
    }
    return next;
  }

  /**
   * Give me positive float.
   *
   * @return the float
   */
  public static float giveMePositive() {
    float next = giveMeOne();
    if (next < 0) {
      return next * -1;
    }
    return next;
  }
}
