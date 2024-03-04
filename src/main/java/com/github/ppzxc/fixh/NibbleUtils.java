package com.github.ppzxc.fixh;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Nibble utils.
 */
public final class NibbleUtils {

  private NibbleUtils() {
  }

  /**
   * Gets negative.
   *
   * @return the negative
   */
  public static byte getNegative() {
    return (byte) ThreadLocalRandom.current().nextInt(FixhConstants.SIGNED_NIBBLE_MIN_VALUE, -1);
  }

  /**
   * Gets positive.
   *
   * @return the positive
   */
  public static byte getPositive() {
    return (byte) Math.abs(ThreadLocalRandom.current().nextInt(1, FixhConstants.SIGNED_NIBBLE_MAX_VALUE));
  }

  /**
   * Gets unsigned boundary.
   *
   * @return the unsigned boundary
   */
  public static byte getUnsignedBoundary() {
    return (byte) ThreadLocalRandom.current().nextInt(0, FixhConstants.UNSIGNED_NIBBLE_MAX_VALUE);
  }

  /**
   * Gets greater than unsigned byte max value.
   *
   * @return the greater than unsigned byte max value
   */
  public static byte getGreaterThanUnsignedByteMaxValue() {
    return (byte) ThreadLocalRandom.current().nextInt(FixhConstants.UNSIGNED_NIBBLE_MAX_VALUE + 1, Byte.MAX_VALUE);
  }

  /**
   * Give me one without byte.
   *
   * @param without the without
   * @return the byte
   */
  public static byte giveMeOneWithout(List<Byte> without) {
    while (true) {
      int given = ThreadLocalRandom.current().nextInt(-8, 7);
      if (without.stream().noneMatch(b -> b == given)) {
        return (byte) given;
      }
    }
  }
}
