package io.github.ppzxc.fixh;

import java.nio.charset.StandardCharsets;

/**
 * The type Byte array utils.
 */
public final class ByteArrayUtils {

  private ByteArrayUtils() {
  }

  /**
   * Give me one byte [ ].
   *
   * @param length the length
   * @return the byte [ ]
   */
  public static byte[] giveMeOne(int length) {
    byte[] bytes = new byte[length];
    FixhConstants.SECURE_RANDOM.nextBytes(bytes);
    return bytes;
  }

  /**
   * Give me one with utf 8 byte [ ].
   *
   * @param length the length
   * @return the byte [ ]
   */
  public static byte[] giveMeOneWithUtf8(int length) {
    return new String(giveMeOne(length), StandardCharsets.UTF_8).getBytes(StandardCharsets.UTF_8);
  }

  /**
   * Give me one byte [ ].
   *
   * @return the byte [ ]
   */
  public static byte[] giveMeOne() {
    return giveMeOne(1024);
  }

  /**
   * Give me one with utf 8 byte [ ].
   *
   * @return the byte [ ]
   */
  public static byte[] giveMeOneWithUtf8() {
    return giveMeOneWithUtf8(1024);
  }
}
