package io.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

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
    return ThreadLocalRandom.current().nextBoolean();
  }
}
