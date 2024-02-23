package com.github.ppzxc.fixh;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public final class Constants {

  public static final int BINARY_UNIT_ONE_BIT = 1;
  public static final int BINARY_UNIT_ONE_BYTE = BINARY_UNIT_ONE_BIT * 8;
  public static final int BINARY_UNIT_ONE_KILOBYTE = 1024;
  public static final int BINARY_UNIT_ONE_MEGABYTE = BINARY_UNIT_ONE_KILOBYTE * 1024;
  public static final String SHA_1_PRNG = "SHA1PRNG";
  public static final String SUN = "SUN";
  public static final SecureRandom SECURE_RANDOM;

  public static final int UNSIGNED_MAX_VALUE_SHORT = 65535;
  public static final String UNSIGNED_MAX_VALUE_SHORT_STRING = "65535";
  public static final long UNSIGNED_MAX_VALUE_INT = 4294967295L;
  public static final String UNSIGNED_MAX_VALUE_INT_STRING = "4294967295";
  public static final short UNSIGNED_MAX_VALUE_BYTE = 255;
  public static final String UNSIGNED_MAX_VALUE_BYTE_STRING = "255";
  public static final byte UNSIGNED_MAX_VALUE_NIBBLE = 31;
  public static final String UNSIGNED_MAX_VALUE_NIBBLE_STRING = "31";

  private Constants() {
  }

  static {
    try {
      SECURE_RANDOM = SecureRandom.getInstance(SHA_1_PRNG, SUN);
    } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
      throw new RuntimeException(e);
    }
  }
}
