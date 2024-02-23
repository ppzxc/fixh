package com.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

public final class LongUtils {

  private LongUtils() {
  }

  public static long giveMeOne() {
    return ThreadLocalRandom.current().nextLong();
  }

  public static long giveMeOne(long origin, long bound) {
    return ThreadLocalRandom.current().nextLong(origin, bound);
  }

  public static long giveMeNegative() {
    return giveMeOne(Long.MIN_VALUE, -1);
  }

  public static long giveMePositive() {
    return giveMeOne(1, Long.MAX_VALUE);
  }
}
