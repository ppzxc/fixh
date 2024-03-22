package io.github.ppzxc.fixh;

import java.util.concurrent.ThreadLocalRandom;

public final class EnumUtils {

  private EnumUtils() {
  }

  public static <T> T giveMeOne(Class<T> e) {
    T[] enums = e.getEnumConstants();
    return enums[ThreadLocalRandom.current().nextInt(enums.length)];
  }
}

