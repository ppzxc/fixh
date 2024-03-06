package io.github.ppzxc.fixh;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Byte utils.
 */
public final class ByteUtils {

  private ByteUtils() {
  }

  /**
   * Length to human readable string.
   *
   * @param v the v
   * @return the string
   */
  public static String lengthToHumanReadable(long v) {
    if (v < 1024) {
      return v + " B";
    }
    int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
    return String.format("%.1f %sB", (double) v / (1L << (z * 10)), " KMGTPE".charAt(z));
  }

  /**
   * Gets ascii.
   *
   * @return the ascii
   */
  public static byte getAscii() {
    return (byte) ThreadLocalRandom.current().nextInt(0, 127);
  }

  /**
   * Gets negative.
   *
   * @return the negative
   */
  public static byte getNegative() {
    return (byte) ThreadLocalRandom.current().nextInt(Byte.MIN_VALUE, -1);
  }

  /**
   * Gets positive.
   *
   * @return the positive
   */
  public static byte getPositive() {
    return (byte) Math.abs(ThreadLocalRandom.current().nextInt(1, Byte.MAX_VALUE));
  }

  /**
   * Gets unsigned boundary.
   *
   * @return the unsigned boundary
   */
  public static short getUnsignedBoundary() {
    return (short) Byte.toUnsignedInt((byte) ThreadLocalRandom.current().nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE));
  }

  /**
   * Gets greater than unsigned byte max value.
   *
   * @return the greater than unsigned byte max value
   */
  public static short getGreaterThanUnsignedByteMaxValue() {
    return (short) ThreadLocalRandom.current().nextInt(FixhConstants.UNSIGNED_MAX_VALUE_BYTE + 1, Short.MAX_VALUE);
  }

  /**
   * Give me one without byte.
   *
   * @param without the without
   * @return the byte
   */
  public static byte giveMeOneWithout(byte without) {
    byte given;
    do {
      given = giveMeOne();
    } while (without == given);
    return given;
  }

  /**
   * Give me one without byte.
   *
   * @param without the without
   * @return the byte
   */
  public static byte giveMeOneWithout(List<Byte> without) {
    int given;
    do {
      given = ThreadLocalRandom.current().nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE);
    } while (without.contains((byte) given));
    return (byte) given;
  }

  /**
   * Give me one byte.
   *
   * @return the byte
   */
  public static byte giveMeOne() {
    byte[] given = new byte[1];
    ThreadLocalRandom.current().nextBytes(given);
    return given[0];
  }
}
