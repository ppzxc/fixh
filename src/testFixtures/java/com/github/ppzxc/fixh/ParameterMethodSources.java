package com.github.ppzxc.fixh;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class ParameterMethodSources {

  private static final SecureRandom SECURE_RANDOM = new SecureRandom();

  private ParameterMethodSources() {
  }

  public static List<Integer> integers() {
    List<Integer> randomInteger = new ArrayList<>();
    IntStream.range(0, SECURE_RANDOM.nextInt()).forEach(i -> randomInteger.add(SECURE_RANDOM.nextInt()));
    return randomInteger;
  }
}
