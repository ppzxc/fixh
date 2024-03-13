package io.github.ppzxc.fixh;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class ByteUtils {

  private ByteUtils() {
  }

  public static String toHex(byte value) {
    return String.format("0x%02x", value);
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
    return (short) ThreadLocalRandom.current().nextInt(1, FixhConstants.UNSIGNED_MAX_VALUE_BYTE);
  }

  public static short getGreaterThanUnsignedByteMaxValue() {
    return (short) ThreadLocalRandom.current().nextInt(FixhConstants.UNSIGNED_MAX_VALUE_BYTE + 1, Short.MAX_VALUE);
  }

  public static byte giveMeOneWithout(byte origin, byte bound, byte without) {
    byte given = giveMeOne(origin, bound);
    if (given == without) {
      return giveMeOneWithout(origin, bound, without);
    }
    return given;
  }

  public static byte giveMeOneWithout(List<Byte> without) {
    int given;
    do {
      given = ThreadLocalRandom.current().nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE);
    } while (without.contains((byte) given));
    return (byte) given;
  }

  public static byte giveMeOne(byte origin, byte bound) {
    return (byte) ThreadLocalRandom.current().nextInt(origin, bound);
  }

  public static byte giveMeOne() {
    return giveMeOne(Byte.MIN_VALUE, Byte.MAX_VALUE);
  }
}
