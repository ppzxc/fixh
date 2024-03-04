package com.github.ppzxc.fixh;

/**
 * The type Boolean utils.
 */
public final class BooleanUtils {

  private BooleanUtils() {
  }

  /**
   * Give me one boolean.
   *
   * @return the boolean
   */
  public static boolean giveMeOne() {
    return FixhConstants.SECURE_RANDOM.nextBoolean();
  }
}
