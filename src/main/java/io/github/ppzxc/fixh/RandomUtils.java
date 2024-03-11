package io.github.ppzxc.fixh;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The type Random utils.
 */
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

  /**
   * Port int.
   *
   * @return the int
   */
  public int port() {
    return ThreadLocalRandom.current().nextInt(65535 - 1024) + 1024;
  }

  /**
   * Cell phone number string.
   *
   * @return the string
   */
  public String cellPhoneNumber() {
    return "010" + ThreadLocalRandom.current().nextInt(99999999);
  }

  /**
   * Email string.
   *
   * @return the string
   */
  public String email() {
    return lowerCase(10) + "@" + lowerCase(10) + "." + lowerCase(3);
  }

  /**
   * Representative number string.
   *
   * @return the string
   */
  public String representativeNumber() {
    return "15" + ThreadLocalRandom.current().nextInt(999999);
  }

  /**
   * Internet number string.
   *
   * @return the string
   */
  public String internetNumber() {
    return "070" + ThreadLocalRandom.current().nextInt(99999999);
  }

  /**
   * Korean string string.
   *
   * @param length the length
   * @return the string
   */
  public String koreanString(int length) {
    return IntStream.range(0, length)
      .mapToObj(i -> String.valueOf((char) ((Math.random() * 11172) + 0xAC00)))
      .collect(
        Collectors.joining());
  }

  /**
   * Korean string by bytes string.
   *
   * @param lengthOfBytes the length of bytes
   * @return the string
   */
  public String koreanStringByBytes(int lengthOfBytes) {
    StringBuilder stringBuilder = new StringBuilder();
    while (stringBuilder.toString().getBytes(Charset.forName("MS949")).length < lengthOfBytes) {
      char ch = (char) ((Math.random() * 11172) + 0xAC00);
      stringBuilder.append(ch);
    }
    return stringBuilder.toString();
  }

  /**
   * Url string.
   *
   * @return the string
   */
  public String url() {
    return httpProtocols.get(ThreadLocalRandom.current().nextInt(httpProtocols.size())) + "://" + lowerCase(10)
      + ".com";
  }

  /**
   * Yyyy m mdd string.
   *
   * @return the string
   */
  public String yyyyMMdd() {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }

  /**
   * Complex password string.
   *
   * @return the string
   */
  public String complexPassword() {
    return specialCase() + digitCase(4) + upperCase() + lowerCase(10);
  }

  /**
   * Lower case string.
   *
   * @return the string
   */
  public String lowerCase() {
    return lowerChar.stream().skip(ThreadLocalRandom.current().nextInt(lowerChar.size())).findFirst().orElse(null);
  }

  /**
   * Lower case string.
   *
   * @param length the length
   * @return the string
   */
  public String lowerCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> lowerCase()).collect(Collectors.joining());
  }

  /**
   * Upper case string.
   *
   * @return the string
   */
  public String upperCase() {
    return upperChar.stream().skip(ThreadLocalRandom.current().nextInt(upperChar.size())).findFirst().orElse(null);
  }

  /**
   * Upper case string.
   *
   * @param length the length
   * @return the string
   */
  public String upperCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> upperCase()).collect(Collectors.joining());
  }

  /**
   * Digit case string.
   *
   * @return the string
   */
  public String digitCase() {
    return digitChar.stream().skip(ThreadLocalRandom.current().nextInt(digitChar.size())).findFirst().orElse(null);
  }

  /**
   * Digit case string.
   *
   * @param length the length
   * @return the string
   */
  public String digitCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> digitCase()).collect(Collectors.joining());
  }

  /**
   * Special case string.
   *
   * @return the string
   */
  public String specialCase() {
    return specialChar.stream().skip(ThreadLocalRandom.current().nextInt(specialChar.size())).findFirst().orElse(null);
  }

  /**
   * Special case string.
   *
   * @param length the length
   * @return the string
   */
  public String specialCase(int length) {
    return IntStream.range(0, length).mapToObj(operand -> specialCase()).collect(Collectors.joining());
  }

  /**
   * List string list.
   *
   * @return the list
   */
  public List<String> listString() {
    return listString(ThreadLocalRandom.current().nextInt(9) + 1, ThreadLocalRandom.current().nextInt(9) + 1);
  }

  /**
   * List string list.
   *
   * @param arrayLength  the array length
   * @param stringLength the string length
   * @return the list
   */
  public List<String> listString(int arrayLength, int stringLength) {
    return IntStream.range(0, arrayLength)
      .mapToObj(value -> String.valueOf(ThreadLocalRandom.current().nextInt(stringLength)))
      .collect(Collectors.toList());
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static RandomUtils getInstance() {
    return RandomUtils.Singleton.INSTANCE;
  }

  private static final class Singleton {

    private static final RandomUtils INSTANCE = new RandomUtils();
  }
}
