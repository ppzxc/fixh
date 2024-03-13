package io.github.ppzxc.fixh;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class RandomUtils {

  private static final List<String> HTTP_PROTOCOLS;
  private static final List<String> LOWER_CHAR;
  private static final List<String> UPPER_CHAR;
  private static final List<String> DIGIT_CHAR;
  private static final List<String> SPECIAL_CHAR;

  private RandomUtils() {
  }

  static {
    HTTP_PROTOCOLS = Arrays.asList("http", "https");
    LOWER_CHAR = Stream.of("abcdefghijklmnopqrstuvwxyz")
      .map(value -> value.split(""))
      .flatMap(Arrays::stream)
      .collect(Collectors.toList());
    UPPER_CHAR = Stream.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
      .map(value -> value.split(""))
      .flatMap(Arrays::stream)
      .collect(Collectors.toList());
    DIGIT_CHAR = Stream.of("1234567890")
      .map(value -> value.split(""))
      .flatMap(Arrays::stream)
      .collect(Collectors.toList());
    SPECIAL_CHAR = Stream.of("+`~!@#$%^&*{}\\[\\]\"':;,.<>?/|\\\\")
      .map(value -> value.split(""))
      .flatMap(Arrays::stream)
      .collect(Collectors.toList());
  }

  public static int port() {
    return ThreadLocalRandom.current().nextInt(65535 - 1024) + 1024;
  }

  public static String cellPhoneNumber() {
    return "010" + ThreadLocalRandom.current().nextInt(99999999);
  }

  public static String email() {
    return lowerCase(10) + "@" + lowerCase(10) + "." + lowerCase(3);
  }

  public static String representativeNumber() {
    return "15" + ThreadLocalRandom.current().nextInt(999999);
  }

  public static String internetNumber() {
    return "070" + ThreadLocalRandom.current().nextInt(99999999);
  }

  public static String url() {
    return HTTP_PROTOCOLS.get(ThreadLocalRandom.current().nextInt(HTTP_PROTOCOLS.size())) + "://" + lowerCase(10)
      + ".com";
  }

  public static String yyyyMMdd() {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }

  public static String complexPassword() {
    return specialCase() + digitCase(4) + upperCase() + lowerCase(10);
  }

  public static String lowerCase() {
    return LOWER_CHAR.get(ThreadLocalRandom.current().nextInt(LOWER_CHAR.size()));
  }

  public static String lowerCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> lowerCase()).collect(Collectors.joining());
  }

  public static String upperCase() {
    return UPPER_CHAR.get(ThreadLocalRandom.current().nextInt(UPPER_CHAR.size()));
  }

  public static String upperCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> upperCase()).collect(Collectors.joining());
  }

  public static String digitCase() {
    return DIGIT_CHAR.get(ThreadLocalRandom.current().nextInt(DIGIT_CHAR.size()));
  }

  public static String digitCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> digitCase()).collect(Collectors.joining());
  }

  public static String specialCase() {
    return SPECIAL_CHAR.get(ThreadLocalRandom.current().nextInt(SPECIAL_CHAR.size()));
  }

  public static String specialCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> specialCase()).collect(Collectors.joining());
  }

  public static List<String> listString() {
    return listString(ThreadLocalRandom.current().nextInt(9) + 1, ThreadLocalRandom.current().nextInt(9) + 1);
  }

  public static List<String> listString(int arrayLength, int stringLength) {
    return IntStream.range(0, arrayLength)
      .mapToObj(value -> String.valueOf(ThreadLocalRandom.current().nextInt(stringLength)))
      .collect(Collectors.toList());
  }
}
