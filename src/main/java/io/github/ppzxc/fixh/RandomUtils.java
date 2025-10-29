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
  private static List<String> KOREA_LAST_NAME;

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
    KOREA_LAST_NAME = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
      "송",
      "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주", "우", "구",
      "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양", "변", "여", "추",
      "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금", "옥", "육", "인", "맹",
      "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용", "가", "강", "건", "경", "고", "관", "광", "구", "규", "근",
      "기", "길", "나", "남", "노", "누", "다", "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명",
      "무", "문", "미", "민", "바", "박", "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세",
      "소", "솔", "수", "숙", "순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용",
      "우", "원", "월", "위", "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조",
      "종", "주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁",
      "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을",
      "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
      "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠", "흔",
      "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
  }

  public static String koreaName() {
    return KOREA_LAST_NAME.get(ThreadLocalRandom.current().nextInt(KOREA_LAST_NAME.size())) + KOREA_LAST_NAME.get(
      ThreadLocalRandom.current().nextInt(KOREA_LAST_NAME.size())) + KOREA_LAST_NAME.get(
      ThreadLocalRandom.current().nextInt(KOREA_LAST_NAME.size()));
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
