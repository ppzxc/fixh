package com.github.ppzxc.fixh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RandomInteger {

  private RandomInteger() {
  }

  public static int giveMeOne() {
    return FixhConstants.SECURE_RANDOM.nextInt();
  }

  public static List<Integer> giveMeWithout(int count, int... without) {
    List<Integer> given = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      while (true) {
        int back = giveMeOne(64);
        if (Arrays.stream(without).noneMatch(w -> w == back)) {
          given.add(back);
          break;
        }
      }
    }
    return given;
  }

  public static int giveMeOne(int bound) {
    return FixhConstants.SECURE_RANDOM.nextInt(bound);
  }

  public static long giveMeOneUnsigned() {
    return Integer.toUnsignedLong(FixhConstants.SECURE_RANDOM.nextInt());
  }

  public static int getNegative() {
    return FixhConstants.SECURE_RANDOM.nextInt(Integer.MIN_VALUE, -1);
  }

  public static int getPositive(int origin, int bound) {
    return FixhConstants.SECURE_RANDOM.nextInt(origin, bound);
  }

  public static int getPositive(int bound) {
    return FixhConstants.SECURE_RANDOM.nextInt(1, bound);
  }

  public static int getPositive() {
    return getPositive(Integer.MAX_VALUE);
  }

  public static long getUnsignedBoundary() {
    return FixhConstants.SECURE_RANDOM.nextLong(0, UnsignedMaxValues.INT);
  }

  public static long getGreaterThanUnsignedIntegerMaxValue() {
    return FixhConstants.SECURE_RANDOM.nextLong(UnsignedMaxValues.INT + 1, Long.MAX_VALUE);
  }
}
