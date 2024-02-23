package com.github.ppzxc.fixh;

public final class FloatUtils {

  private FloatUtils() {
  }

  public static float giveMeOne() {
    return FixhConstants.SECURE_RANDOM.nextFloat();
  }

  public static float giveMeNegative() {
    float nextFloat = giveMeOne();
    if (nextFloat > 0) {
      return nextFloat * -1;
    }
    return nextFloat;
  }

  public static float giveMePositive() {
    float nextFloat = giveMeOne();
    if (nextFloat < 0) {
      return nextFloat * -1;
    }
    return nextFloat;
  }
}
