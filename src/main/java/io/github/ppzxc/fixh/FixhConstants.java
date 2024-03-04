package io.github.ppzxc.fixh;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * The type Fixh constants.
 */
public final class FixhConstants {

  /**
   * The constant BINARY_UNIT_ONE_BIT.
   */
  public static final int BINARY_UNIT_ONE_BIT = 1;
  /**
   * The constant BINARY_UNIT_ONE_BYTE.
   */
  public static final int BINARY_UNIT_ONE_BYTE = BINARY_UNIT_ONE_BIT * 8;
  /**
   * The constant BINARY_UNIT_ONE_KILOBYTE.
   */
  public static final int BINARY_UNIT_ONE_KILOBYTE = 1024;
  /**
   * The constant BINARY_UNIT_ONE_MEGABYTE.
   */
  public static final int BINARY_UNIT_ONE_MEGABYTE = BINARY_UNIT_ONE_KILOBYTE * 1024;

  /**
   * The constant SHA_1_PRNG.
   */
  public static final String SHA_1_PRNG = "SHA1PRNG";
  /**
   * The constant SUN.
   */
  public static final String SUN = "SUN";
  /**
   * The constant SECURE_RANDOM.
   */
  public static final SecureRandom SECURE_RANDOM;

  /**
   * The constant UNSIGNED_MAX_VALUE_SHORT.
   */
  public static final int UNSIGNED_MAX_VALUE_SHORT = 65535;
  /**
   * The constant UNSIGNED_MAX_VALUE_SHORT_STRING.
   */
  public static final String UNSIGNED_MAX_VALUE_SHORT_STRING = "65535";
  /**
   * The constant UNSIGNED_MAX_VALUE_INT.
   */
  public static final long UNSIGNED_MAX_VALUE_INT = 4294967295L;
  /**
   * The constant UNSIGNED_MAX_VALUE_INT_STRING.
   */
  public static final String UNSIGNED_MAX_VALUE_INT_STRING = "4294967295";
  /**
   * The constant UNSIGNED_MAX_VALUE_BYTE.
   */
  public static final short UNSIGNED_MAX_VALUE_BYTE = 255;
  /**
   * The constant UNSIGNED_MAX_VALUE_BYTE_STRING.
   */
  public static final String UNSIGNED_MAX_VALUE_BYTE_STRING = "255";
  /**
   * The constant UNSIGNED_MAX_VALUE_NIBBLE.
   */
  public static final byte UNSIGNED_MAX_VALUE_NIBBLE = 31;
  /**
   * The constant UNSIGNED_MAX_VALUE_NIBBLE_STRING.
   */
  public static final String UNSIGNED_MAX_VALUE_NIBBLE_STRING = "31";
  /**
   * The constant SIGNED_NIBBLE_MAX_VALUE.
   */
  public static final int SIGNED_NIBBLE_MAX_VALUE = 15;
  /**
   * The constant SIGNED_NIBBLE_MIN_VALUE.
   */
  public static final int SIGNED_NIBBLE_MIN_VALUE = -16;
  /**
   * The constant UNSIGNED_NIBBLE_MAX_VALUE.
   */
  public static final int UNSIGNED_NIBBLE_MAX_VALUE = 31;

  private FixhConstants() {
  }

  static {
    try {
      SECURE_RANDOM = SecureRandom.getInstance(SHA_1_PRNG, SUN);
    } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
      throw new RuntimeException(e);
    }
  }
}
