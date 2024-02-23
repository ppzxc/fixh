package com.github.ppzxc.fixh;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class ByteUtils {

  private ByteUtils() {
  }

  public static String lengthToHumanReadable(long v) {
    if (v < 1024) {
      return v + " B";
    }
    int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
    return String.format("%.1f %sB", (double) v / (1L << (z * 10)), " KMGTPE".charAt(z));
  }

  public static byte getAscii() {
    return (byte) ThreadLocalRandom.current().nextInt(0, 127);
  }

  public static byte getNegative() {
    return (byte) ThreadLocalRandom.current().nextInt(Byte.MIN_VALUE, -1);
  }

  public static byte getPositive() {
    return (byte) Math.abs(ThreadLocalRandom.current().nextInt(1, Byte.MAX_VALUE));
  }

  public static short getUnsignedBoundary() {
    return (short) ThreadLocalRandom.current().nextInt(0, FixhConstants.UNSIGNED_MAX_VALUE_BYTE);
  }

  public static short getGreaterThanUnsignedByteMaxValue() {
    return (short) ThreadLocalRandom.current().nextInt(FixhConstants.UNSIGNED_MAX_VALUE_BYTE + 1, Short.MAX_VALUE);
  }

  public static byte giveMeOneWithout(byte without) {
    while (true) {
      byte given = giveMeOne();
      if (without != given) {
        return given;
      }
    }
  }

  public static byte giveMeOneWithout(List<Byte> without) {
    while (true) {
      int given = ThreadLocalRandom.current().nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE);
      if (without.stream().noneMatch(b -> b == given)) {
        return (byte) given;
      }
    }
  }

  public static byte giveMeOne() {
    byte[] given = new byte[1];
    FixhConstants.SECURE_RANDOM.nextBytes(given);
    return given[0];
  }
}
