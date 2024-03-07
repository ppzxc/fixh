package io.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

public final class IntUtils {

  private IntUtils() {
  }

  public static int giveMeOne(int bound) {
    return ThreadLocalRandom.current().nextInt(bound);
  }

  public static int giveMeOne() {
    return ThreadLocalRandom.current().nextInt();
  }

  public static Integer giveMeWithout(int origin, int bound, int without) {
    int given = giveMeOne(origin, bound);
    if (given == without) {
      return giveMeWithout(origin, bound, without);
    }
    return given;
  }

  public static long giveMeOneUnsigned() {
    return Integer.toUnsignedLong(giveMeOne());
  }

  public static int giveMeNegative() {
    int given = giveMeOne();
    if (given > 0) {
      return given * -1;
    }
    return given;
  }

  public static int giveMePositive() {
    int given = giveMeOne();
    if (given < 0) {
      return given * -1;
    }
    return given;
  }

  public static int giveMeOne(int origin, int bound) {
    return ThreadLocalRandom.current().nextInt(origin, bound);
  }

  public static int giveMePositive(int bound) {
    return ThreadLocalRandom.current().nextInt(bound);
  }

  public static long giveMeUnsignedBoundary() {
    return ThreadLocalRandom.current().nextLong(0, FixhConstants.UNSIGNED_MAX_VALUE_INT);
  }

  public static long giveMeGreaterThanUnsignedIntegerMaxValue() {
    return ThreadLocalRandom.current().nextLong(FixhConstants.UNSIGNED_MAX_VALUE_INT + 1, Long.MAX_VALUE);
  }
}
