package io.github.ppzxc.fixh;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class NibbleUtils {

  public static final int SIGNED_NIBBLE_MAX_VALUE = 15;
  public static final int SIGNED_NIBBLE_MIN_VALUE = -16;
  public static final int UNSIGNED_NIBBLE_MAX_VALUE = 31;

  private NibbleUtils() {
  }

  public static byte getNegative() {
    return (byte) ThreadLocalRandom.current().nextInt(SIGNED_NIBBLE_MIN_VALUE, -1);
  }

  public static byte getPositive() {
    return (byte) Math.abs(ThreadLocalRandom.current().nextInt(1, SIGNED_NIBBLE_MAX_VALUE));
  }

  public static byte getUnsignedBoundary() {
    return (byte) ThreadLocalRandom.current().nextInt(1, UNSIGNED_NIBBLE_MAX_VALUE);
  }

  public static byte getGreaterThanUnsignedByteMaxValue() {
    return (byte) ThreadLocalRandom.current().nextInt(UNSIGNED_NIBBLE_MAX_VALUE + 1, Byte.MAX_VALUE);
  }

  public static byte giveMeOneWithout(List<Byte> without) {
    while (true) {
      int given = ThreadLocalRandom.current().nextInt(-8, 7);
      if (without.stream().noneMatch(b -> b == given)) {
        return (byte) given;
      }
    }
  }
}
