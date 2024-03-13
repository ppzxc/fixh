package io.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

public final class FloatUtils {

  private FloatUtils() {
  }

  public static float giveMeOne() {
    return ThreadLocalRandom.current().nextFloat();
  }
}
