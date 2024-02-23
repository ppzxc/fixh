package com.github.ppzxc.fixh;

public final class FloatUtils {

  private FloatUtils() {
  }

  public static float giveMeOne() {
    return FixhConstants.SECURE_RANDOM.nextFloat();
  }

  public static float getNegative() {
    return FixhConstants.SECURE_RANDOM.nextFloat(Float.MIN_VALUE, -1);
  }

  public static float getPositive() {
    return FixhConstants.SECURE_RANDOM.nextFloat(1, Float.MAX_VALUE);
  }
}
