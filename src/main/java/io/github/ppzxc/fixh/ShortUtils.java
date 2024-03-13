package io.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

public final class ShortUtils {

  private ShortUtils() {
  }

  public static short getNegative() {
    return (short) ThreadLocalRandom.current().nextInt(Short.MIN_VALUE, -1);
  }

  public static short getPositive() {
    return (short) ThreadLocalRandom.current().nextInt(1, Short.MAX_VALUE);
  }

  public static int getUnsignedBoundary() {
    return ThreadLocalRandom.current().nextInt(0, FixhConstants.UNSIGNED_MAX_VALUE_SHORT);
  }

  public static int getGreaterThanUnsignedIntegerMaxValue() {
    return ThreadLocalRandom.current().nextInt(FixhConstants.UNSIGNED_MAX_VALUE_SHORT + 1, Integer.MAX_VALUE);
  }

  public static short giveMeOne() {
    return (short) ThreadLocalRandom.current().nextInt(Short.MIN_VALUE, Short.MAX_VALUE);
  }
}
