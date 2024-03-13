package io.github.ppzxc.fixh;

public final class FixhConstants {

  public static final int BINARY_UNIT_ONE_BIT = 1;
  public static final int BINARY_UNIT_ONE_BYTE = BINARY_UNIT_ONE_BIT * 8;
  public static final int BINARY_UNIT_ONE_KILOBYTE = 1024;
  public static final int BINARY_UNIT_ONE_MEGABYTE = BINARY_UNIT_ONE_KILOBYTE * 1024;

  public static final String SHA_1_PRNG = "SHA1PRNG";
  public static final String SUN = "SUN";
  public static final int UNSIGNED_MAX_VALUE_SHORT = 65535;
  public static final String UNSIGNED_MAX_VALUE_SHORT_STRING = "65535";
  public static final long UNSIGNED_MAX_VALUE_INT = 4294967295L;
  public static final String UNSIGNED_MAX_VALUE_INT_STRING = "4294967295";
  public static final short UNSIGNED_MAX_VALUE_BYTE = 255;
  public static final String UNSIGNED_MAX_VALUE_BYTE_STRING = "255";
  public static final byte UNSIGNED_MAX_VALUE_NIBBLE = 31;
  public static final String UNSIGNED_MAX_VALUE_NIBBLE_STRING = "31";
  public static final int SIGNED_NIBBLE_MAX_VALUE = 15;
  public static final int SIGNED_NIBBLE_MIN_VALUE = -16;
  public static final int UNSIGNED_NIBBLE_MAX_VALUE = 31;

  private FixhConstants() {
  }
}
