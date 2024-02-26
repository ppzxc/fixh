package com.github.ppzxc.fixh;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class RandomUtils {

  private static final SecureRandom SECURE_RANDOM;
  private static final List<String> LOWER_CHAR;
  private static final List<String> UPPER_CHAR;
  private static final List<String> DIGIT_CHAR;
  private static final List<String> SPECIAL_CHAR;
  private static final List<String> HTTP_PROTOCOLS;

  static {
    SECURE_RANDOM = new SecureRandom();
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

  private RandomUtils() {
  }

  public static int port() {
    return SECURE_RANDOM.nextInt(65535 - 1024) + 1024;
  }

  public static int integer(int length, int minimum) {
    return SECURE_RANDOM.nextInt(length) + minimum;
  }

  public static int integer(int length) {
    return SECURE_RANDOM.nextInt(length);
  }

  public static String number(int length) {
    return IntStream.range(0, length)
      .mapToObj(i -> String.valueOf(SECURE_RANDOM.nextInt(9)))
      .collect(Collectors.joining());
  }

  public static int integer() {
    return SECURE_RANDOM.nextInt();
  }

  public static String cellPhoneNumber() {
    return "010" + SECURE_RANDOM.nextInt(99999999);
  }

  public static String email() {
    return lowerCase(10) + "@" + lowerCase(10) + "." + lowerCase(3);
  }

  public static String representativeNumber() {
    return "15" + SECURE_RANDOM.nextInt(999999);
  }

  public static String internetNumber() {
    return "070" + SECURE_RANDOM.nextInt(99999999);
  }

  public static String koreanString(int length) {
    return IntStream.range(0, length)
      .mapToObj(i -> String.valueOf((char) ((Math.random() * 11172) + 0xAC00)))
      .collect(
        Collectors.joining());
  }

  public static String koreanStringByBytes(int lengthOfBytes) {
    StringBuilder stringBuilder = new StringBuilder();
    while (stringBuilder.toString().getBytes(Charset.forName("MS949")).length < lengthOfBytes) {
      char ch = (char) ((Math.random() * 11172) + 0xAC00);
      stringBuilder.append(ch);
    }
    return stringBuilder.toString();
  }

  public static int integerByIndex(int index) {
    return SECURE_RANDOM.nextInt(index);
  }

  public static long positiveLong() {
    return positiveLong(1L, 999999999999999999L);
  }

  public static long positiveLong(long min, long max) {
    return SECURE_RANDOM.nextLong() % (max - min) + max;
  }

  public static String longByNumberOfDigit(int numberOfDigit) {
    return IntStream.range(0, numberOfDigit)
      .mapToObj(i -> String.valueOf(SECURE_RANDOM.nextInt(9) + 1))
      .collect(Collectors.joining());
  }

  public static String url() {
    return HTTP_PROTOCOLS.get(SECURE_RANDOM.nextInt(HTTP_PROTOCOLS.size())) + "://" + lowerCase(10) + ".com";
  }

  public static String yyyyMMdd() {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }

  public static String complexPassword() {
    return specialCase() + digitCase(4) + upperCase() + lowerCase(10);
  }

  public static String lowerCase() {
    return LOWER_CHAR.stream().skip(SECURE_RANDOM.nextInt(LOWER_CHAR.size())).findFirst().orElse(null);
  }

  public static String lowerCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> lowerCase()).collect(Collectors.joining());
  }

  public static String upperCase() {
    return UPPER_CHAR.stream().skip(SECURE_RANDOM.nextInt(UPPER_CHAR.size())).findFirst().orElse(null);
  }

  public static String upperCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> upperCase()).collect(Collectors.joining());
  }

  public static String digitCase() {
    return DIGIT_CHAR.stream().skip(SECURE_RANDOM.nextInt(DIGIT_CHAR.size())).findFirst().orElse(null);
  }

  public static String digitCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> digitCase()).collect(Collectors.joining());
  }

  public static String specialCase() {
    return SPECIAL_CHAR.stream().skip(SECURE_RANDOM.nextInt(SPECIAL_CHAR.size())).findFirst().orElse(null);
  }

  public static String specialCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> specialCase()).collect(Collectors.joining());
  }

  public static List<String> listString() {
    return listString(SECURE_RANDOM.nextInt(9) + 1, SECURE_RANDOM.nextInt(9) + 1);
  }

  public static List<String> listString(int arrayLength, int stringLength) {
    return IntStream.range(0, arrayLength)
      .mapToObj(value -> String.valueOf(SECURE_RANDOM.nextInt(stringLength)))
      .collect(Collectors.toList());
  }
}
