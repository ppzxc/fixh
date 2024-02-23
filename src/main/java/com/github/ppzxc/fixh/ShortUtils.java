package com.github.ppzxc.fixh;

import java.util.List;

public final class ShortUtils {

  private ShortUtils() {
  }

  public static short getNegative() {
    return (short) FixhConstants.SECURE_RANDOM.nextInt(Short.MIN_VALUE, -1);
  }

  public static short getPositive() {
    return (short) FixhConstants.SECURE_RANDOM.nextInt(1, Short.MAX_VALUE);
  }

  public static int getUnsignedBoundary() {
    return FixhConstants.SECURE_RANDOM.nextInt(0, FixhConstants.UNSIGNED_MAX_VALUE_SHORT);
  }

  public static int getGreaterThanUnsignedIntegerMaxValue() {
    return FixhConstants.SECURE_RANDOM.nextInt(FixhConstants.UNSIGNED_MAX_VALUE_SHORT + 1, Short.MAX_VALUE);
  }

  public static short giveMeOne() {
    return (short) FixhConstants.SECURE_RANDOM.nextInt(Short.MIN_VALUE, Short.MAX_VALUE);
  }

  public static short giveMeOneWithout(List<Short> without) {
    while (true) {
      short given = (short) FixhConstants.SECURE_RANDOM.nextInt(Short.MIN_VALUE, Short.MAX_VALUE);
      if (without.stream().noneMatch(withoutValue -> withoutValue == given)) {
        return given;
      }
    }
  }
}
