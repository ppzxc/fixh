package com.github.ppzxc.fixh;

import java.util.List;

public final class NibbleUtils {

  private NibbleUtils() {
  }

  public static byte getNegative() {
    return (byte) FixhConstants.SECURE_RANDOM.nextInt(FixhConstants.SIGNED_NIBBLE_MIN_VALUE, -1);
  }

  public static byte getPositive() {
    return (byte) Math.abs(FixhConstants.SECURE_RANDOM.nextInt(1, FixhConstants.SIGNED_NIBBLE_MAX_VALUE));
  }

  public static byte getUnsignedBoundary() {
    return (byte) FixhConstants.SECURE_RANDOM.nextInt(0, FixhConstants.UNSIGNED_NIBBLE_MAX_VALUE);
  }

  public static byte getGreaterThanUnsignedByteMaxValue() {
    return (byte) FixhConstants.SECURE_RANDOM.nextInt(FixhConstants.UNSIGNED_NIBBLE_MAX_VALUE + 1, Byte.MAX_VALUE);
  }

  public static byte giveMeOneWithout(List<Byte> without) {
    while (true) {
      int given = FixhConstants.SECURE_RANDOM.nextInt(-8, 7);
      if (without.stream().noneMatch(b -> b == given)) {
        return (byte) given;
      }
    }
  }
}
