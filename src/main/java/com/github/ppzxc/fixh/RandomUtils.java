package com.github.ppzxc.fixh;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class RandomUtils {

  private final List<String> lowerChar;
  private final List<String> upperChar;
  private final List<String> digitChar;
  private final List<String> specialChar;
  private final List<String> httpProtocols;

  private RandomUtils() {
    httpProtocols = Arrays.asList("http", "https");
    lowerChar = Stream.of("abcdefghijklmnopqrstuvwxyz")
      .map(value -> value.split(""))
      .flatMap(Arrays::stream)
      .collect(Collectors.toList());
    upperChar = Stream.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
      .map(value -> value.split(""))
      .flatMap(Arrays::stream)
      .collect(Collectors.toList());
    digitChar = Stream.of("1234567890")
      .map(value -> value.split(""))
      .flatMap(Arrays::stream)
      .collect(Collectors.toList());
    specialChar = Stream.of("+`~!@#$%^&*{}\\[\\]\"':;,.<>?/|\\\\")
      .map(value -> value.split(""))
      .flatMap(Arrays::stream)
      .collect(Collectors.toList());
  }

  public int port() {
    return ThreadLocalRandom.current().nextInt(65535 - 1024) + 1024;
  }

  public int integer(int length, int minimum) {
    return ThreadLocalRandom.current().nextInt(length) + minimum;
  }

  public int integer(int length) {
    return ThreadLocalRandom.current().nextInt(length);
  }

  public String number(int length) {
    return IntStream.range(0, length)
      .mapToObj(i -> String.valueOf(ThreadLocalRandom.current().nextInt(9)))
      .collect(Collectors.joining());
  }

  public int integer() {
    return ThreadLocalRandom.current().nextInt();
  }

  public String cellPhoneNumber() {
    return "010" + ThreadLocalRandom.current().nextInt(99999999);
  }

  public String email() {
    return lowerCase(10) + "@" + lowerCase(10) + "." + lowerCase(3);
  }

  public String representativeNumber() {
    return "15" + ThreadLocalRandom.current().nextInt(999999);
  }

  public String internetNumber() {
    return "070" + ThreadLocalRandom.current().nextInt(99999999);
  }

  public String koreanString(int length) {
    return IntStream.range(0, length)
      .mapToObj(i -> String.valueOf((char) ((Math.random() * 11172) + 0xAC00)))
      .collect(
        Collectors.joining());
  }

  public String koreanStringByBytes(int lengthOfBytes) {
    StringBuilder stringBuilder = new StringBuilder();
    while (stringBuilder.toString().getBytes(Charset.forName("MS949")).length < lengthOfBytes) {
      char ch = (char) ((Math.random() * 11172) + 0xAC00);
      stringBuilder.append(ch);
    }
    return stringBuilder.toString();
  }

  public int integerByIndex(int index) {
    return ThreadLocalRandom.current().nextInt(index);
  }

  public long positiveLong() {
    return positiveLong(1L, 999999999999999999L);
  }

  public long positiveLong(long min, long max) {
    return ThreadLocalRandom.current().nextLong() % (max - min) + max;
  }

  public String longByNumberOfDigit(int numberOfDigit) {
    return IntStream.range(0, numberOfDigit)
      .mapToObj(i -> String.valueOf(ThreadLocalRandom.current().nextInt(9) + 1))
      .collect(Collectors.joining());
  }

  public String url() {
    return httpProtocols.get(ThreadLocalRandom.current().nextInt(httpProtocols.size())) + "://" + lowerCase(10)
      + ".com";
  }

  public String yyyyMMdd() {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }

  public String complexPassword() {
    return specialCase() + digitCase(4) + upperCase() + lowerCase(10);
  }

  public String lowerCase() {
    return lowerChar.stream().skip(ThreadLocalRandom.current().nextInt(lowerChar.size())).findFirst().orElse(null);
  }

  public String lowerCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> lowerCase()).collect(Collectors.joining());
  }

  public String upperCase() {
    return upperChar.stream().skip(ThreadLocalRandom.current().nextInt(upperChar.size())).findFirst().orElse(null);
  }

  public String upperCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> upperCase()).collect(Collectors.joining());
  }

  public String digitCase() {
    return digitChar.stream().skip(ThreadLocalRandom.current().nextInt(digitChar.size())).findFirst().orElse(null);
  }

  public String digitCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> digitCase()).collect(Collectors.joining());
  }

  public String specialCase() {
    return specialChar.stream().skip(ThreadLocalRandom.current().nextInt(specialChar.size())).findFirst().orElse(null);
  }

  public String specialCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> specialCase()).collect(Collectors.joining());
  }

  public List<String> listString() {
    return listString(ThreadLocalRandom.current().nextInt(9) + 1, ThreadLocalRandom.current().nextInt(9) + 1);
  }

  public List<String> listString(int arrayLength, int stringLength) {
    return IntStream.range(0, arrayLength)
      .mapToObj(value -> String.valueOf(ThreadLocalRandom.current().nextInt(stringLength)))
      .collect(Collectors.toList());
  }

  public static RandomUtils getInstance() {
    return RandomUtils.Singleton.INSTANCE;
  }

  private static final class Singleton {

    private static final RandomUtils INSTANCE = new RandomUtils();
  }
}
