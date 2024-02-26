package com.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

public final class FloatUtils {

  private FloatUtils() {
  }

  public static float giveMeOne() {
    return ThreadLocalRandom.current().nextFloat();
  }

  public static float giveMeNegative() {
    float next = giveMeOne();
    if (next > 0) {
      return next * -1;
    }
    return next;
  }

  public static float giveMePositive() {
    float next = giveMeOne();
    if (next < 0) {
      return next * -1;
    }
    return next;
  }
}
