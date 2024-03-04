package com.github.ppzxc.fixh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Int utils.
 */
public final class IntUtils {

  private IntUtils() {
  }

  /**
   * Give me one int.
   *
   * @param bound the bound
   * @return the int
   */
  public static int giveMeOne(int bound) {
    return ThreadLocalRandom.current().nextInt(bound);
  }

  /**
   * Give me one int.
   *
   * @return the int
   */
  public static int giveMeOne() {
    return ThreadLocalRandom.current().nextInt();
  }

  /**
   * Give me without list.
   *
   * @param count   the count
   * @param without the without
   * @return the list
   */
  public static List<Integer> giveMeWithout(int count, int... without) {
    List<Integer> given = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      while (true) {
        int back = giveMeOne();
        if (Arrays.stream(without).noneMatch(w -> w == back)) {
          given.add(back);
          break;
        }
      }
    }
    return given;
  }

  /**
   * Give me one unsigned long.
   *
   * @return the long
   */
  public static long giveMeOneUnsigned() {
    return Integer.toUnsignedLong(giveMeOne());
  }

  /**
   * Give me negative int.
   *
   * @return the int
   */
  public static int giveMeNegative() {
    int given = giveMeOne();
    if (given > 0) {
      return given * -1;
    }
    return given;
  }

  /**
   * Give me positive int.
   *
   * @return the int
   */
  public static int giveMePositive() {
    int given = giveMeOne();
    if (given < 0) {
      return given * -1;
    }
    return given;
  }

  /**
   * Give me one int.
   *
   * @param origin the origin
   * @param bound  the bound
   * @return the int
   */
  public static int giveMeOne(int origin, int bound) {
    return ThreadLocalRandom.current().nextInt(bound + origin);
  }

  /**
   * Give me positive int.
   *
   * @param bound the bound
   * @return the int
   */
  public static int giveMePositive(int bound) {
    return ThreadLocalRandom.current().nextInt(bound);
  }

  /**
   * Give me unsigned boundary long.
   *
   * @return the long
   */
  public static long giveMeUnsignedBoundary() {
    return ThreadLocalRandom.current().nextLong(0, FixhConstants.UNSIGNED_MAX_VALUE_INT);
  }

  /**
   * Give me greater than unsigned integer max value long.
   *
   * @return the long
   */
  public static long giveMeGreaterThanUnsignedIntegerMaxValue() {
    return ThreadLocalRandom.current().nextLong(FixhConstants.UNSIGNED_MAX_VALUE_INT + 1, Long.MAX_VALUE);
  }
}
