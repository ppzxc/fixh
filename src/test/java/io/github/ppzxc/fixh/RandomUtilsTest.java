package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

class RandomUtilsTest {

  @RepeatedTest(10)
  void should_return_port() {
    assertThat(RandomUtils.getInstance().port())
      .isGreaterThanOrEqualTo(1024)
      .isLessThanOrEqualTo(65535);
  }

  @RepeatedTest(10)
  void should_return_cell_phone_number() {
    String given = RandomUtils.getInstance().cellPhoneNumber();
    assertThat(given).startsWith("010");
    assertThat(given.length()).isLessThanOrEqualTo(11);
  }

  @RepeatedTest(10)
  void should_return_email() {
    assertThat(RandomUtils.getInstance().email()).contains("@").contains(".");
  }

  @RepeatedTest(10)
  void should_return_representative_number() {
    String given = RandomUtils.getInstance().representativeNumber();
    assertThat(given).startsWith("15");
    assertThat(given.length()).isLessThanOrEqualTo(8);
  }

  @RepeatedTest(10)
  void should_return_internet_number() {
    String given = RandomUtils.getInstance().internetNumber();
    assertThat(given).startsWith("070");
    assertThat(given.length()).isLessThanOrEqualTo(11);
  }

  @RepeatedTest(10)
  void should_return_korean_string() {
    assertThat(RandomUtils.getInstance().koreanString(IntUtils.giveMeOne(1024))).isNotBlank();
  }

  @RepeatedTest(10)
  void should_return_korean_string_by_bytes() {
    assertThat(RandomUtils.getInstance().koreanStringByBytes(IntUtils.giveMeOne(1024))).isNotBlank();
  }

  @RepeatedTest(10)
  void should_return_url() {
    String given = RandomUtils.getInstance().url();
    assertThat(given).contains("://");
    assertThat(given).contains(".com");
  }

  @RepeatedTest(10)
  void should_return_current_yyyMMdd() {
    String given = RandomUtils.getInstance().yyyyMMdd();
    assertThat(given).contains(String.valueOf(LocalDateTime.now().getYear()));
    assertThat(given).contains(String.valueOf(LocalDateTime.now().getMonthValue()));
    assertThat(given).contains(String.valueOf(LocalDateTime.now().getDayOfMonth()));
  }

  @RepeatedTest(10)
  void should_return_complex_password() {
    assertThat(RandomUtils.getInstance().complexPassword()).isNotBlank();
  }

  @RepeatedTest(10)
  void should_return_lower_case_1() {
    String given = RandomUtils.getInstance().lowerCase();
    assertThat(given).isEqualTo(given.toLowerCase());
  }

  @RepeatedTest(10)
  void should_return_lower_case_2() {
    String given = RandomUtils.getInstance().lowerCase(IntUtils.giveMeOne(1024));
    assertThat(given).isEqualTo(given.toLowerCase());
  }

  @RepeatedTest(10)
  void should_return_upper_case_1() {
    String given = RandomUtils.getInstance().upperCase();
    assertThat(given).isEqualTo(given.toUpperCase());
  }

  @RepeatedTest(10)
  void should_return_upper_case_2() {
    String given = RandomUtils.getInstance().upperCase(IntUtils.giveMeOne(1024));
    assertThat(given).isEqualTo(given.toUpperCase());
  }

  @RepeatedTest(10)
  void should_return_digit_case_1() {
    assertThat(RandomUtils.getInstance().digitCase()).containsOnlyDigits();
  }

  @RepeatedTest(10)
  void should_return_digit_case_2() {
    assertThat(RandomUtils.getInstance().digitCase(IntUtils.giveMeOne(1, 1024))).containsOnlyDigits();
  }

  @RepeatedTest(10)
  void should_return_special_case_1() {
    assertThat(RandomUtils.getInstance().specialCase()).containsAnyOf("+", "`", "~", "!", "@", "#", "$", "%", "^", "&",
      "*", "{", "}", "\\", "[", "\\", "]", "\"", "'", ":", ";", ",", ".", "<", ">", "?", "/", "|", "\\", "\\");
  }

  @RepeatedTest(10)
  void should_return_special_case_2() {
    assertThat(RandomUtils.getInstance().specialCase(IntUtils.giveMeOne(1024))).containsAnyOf("+", "`", "~", "!", "@",
      "#", "$", "%", "^", "&",
      "*", "{", "}", "\\", "[", "\\", "]", "\"", "'", ":", ";", ",", ".", "<", ">", "?", "/", "|", "\\", "\\");
  }

  @RepeatedTest(10)
  void should_return_list_string() {
    List<String> givenList = RandomUtils.getInstance().listString();
    assertThat(givenList).isNotEmpty();
    for (String given : givenList) {
      assertThat(given).isNotBlank();
    }
  }
}