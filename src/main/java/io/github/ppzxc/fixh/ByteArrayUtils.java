package io.github.ppzxc.fixh;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

public final class ByteArrayUtils {

  private ByteArrayUtils() {
  }

  public static byte[] giveMeOne(int length) {
    byte[] bytes = new byte[length];
    ThreadLocalRandom.current().nextBytes(bytes);
    return bytes;
  }

  public static byte[] giveMeOneWithUtf8(int length) {
    return new String(giveMeOne(length), StandardCharsets.UTF_8).getBytes(StandardCharsets.UTF_8);
  }

  public static byte[] giveMeOne() {
    return giveMeOne(1024);
  }

  public static byte[] giveMeOneWithUtf8() {
    return giveMeOneWithUtf8(1024);
  }
}
