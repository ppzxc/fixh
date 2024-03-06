package io.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Short utils.
 */
public final class ShortUtils {

  private ShortUtils() {
  }

  /**
   * Gets negative.
   *
   * @return the negative
   */
  public static short getNegative() {
    return (short) ThreadLocalRandom.current().nextInt(Short.MIN_VALUE, -1);
  }

  /**
   * Gets positive.
   *
   * @return the positive
   */
  public static short getPositive() {
    return (short) ThreadLocalRandom.current().nextInt(1, Short.MAX_VALUE);
  }

  /**
   * Gets unsigned boundary.
   *
   * @return the unsigned boundary
   */
  public static int getUnsignedBoundary() {
    return ThreadLocalRandom.current().nextInt(0, FixhConstants.UNSIGNED_MAX_VALUE_SHORT);
  }

  /**
   * Gets greater than unsigned integer max value.
   *
   * @return the greater than unsigned integer max value
   */
  public static int getGreaterThanUnsignedIntegerMaxValue() {
    return ThreadLocalRandom.current().nextInt(FixhConstants.UNSIGNED_MAX_VALUE_SHORT + 1, Integer.MAX_VALUE);
  }

  /**
   * Give me one short.
   *
   * @return the short
   */
  public static short giveMeOne() {
    return (short) ThreadLocalRandom.current().nextInt(Short.MIN_VALUE, Short.MAX_VALUE);
  }
}
