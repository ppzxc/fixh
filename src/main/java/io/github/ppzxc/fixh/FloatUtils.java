package io.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Float utils.
 */
public final class FloatUtils {

  private FloatUtils() {
  }

  /**
   * Give me one float.
   *
   * @return the float
   */
  public static float giveMeOne() {
    return ThreadLocalRandom.current().nextFloat();
  }
}
