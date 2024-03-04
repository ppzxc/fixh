package com.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Long utils.
 */
public final class LongUtils {

  private LongUtils() {
  }

  /**
   * Give me one long.
   *
   * @return the long
   */
  public static long giveMeOne() {
    return ThreadLocalRandom.current().nextLong();
  }

  /**
   * Give me one long.
   *
   * @param origin the origin
   * @param bound  the bound
   * @return the long
   */
  public static long giveMeOne(long origin, long bound) {
    return ThreadLocalRandom.current().nextLong(origin, bound);
  }

  /**
   * Give me negative long.
   *
   * @return the long
   */
  public static long giveMeNegative() {
    return giveMeOne(Long.MIN_VALUE, -1);
  }

  /**
   * Give me positive long.
   *
   * @return the long
   */
  public static long giveMePositive() {
    return giveMeOne(1, Long.MAX_VALUE);
  }
}
