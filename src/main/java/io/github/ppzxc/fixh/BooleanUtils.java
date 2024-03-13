package io.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

public final class BooleanUtils {

  private BooleanUtils() {
  }

  public static boolean giveMeOne() {
    return ThreadLocalRandom.current().nextBoolean();
  }
}
