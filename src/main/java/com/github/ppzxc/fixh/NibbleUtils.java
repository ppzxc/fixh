package com.github.ppzxc.fixh;

import java.util.List;

public final class RandomNibble {

  public final static int MAX_VALUE = 15;
  public final static int MIN_VALUE = -16;
  public final static int UNSIGNED_MAX_VALUE = 31;

  private RandomNibble() {
  }

  public static byte getNegative() {
    return (byte) FixhConstants.SECURE_RANDOM.nextInt(MIN_VALUE, -1);
  }

  public static byte getPositive() {
    return (byte) Math.abs(FixhConstants.SECURE_RANDOM.nextInt(1, MAX_VALUE));
  }

  public static byte getUnsignedBoundary() {
    return (byte) FixhConstants.SECURE_RANDOM.nextInt(0, UNSIGNED_MAX_VALUE);
  }

  public static byte getGreaterThanUnsignedByteMaxValue() {
    return (byte) FixhConstants.SECURE_RANDOM.nextInt(UNSIGNED_MAX_VALUE + 1, Byte.MAX_VALUE);
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
