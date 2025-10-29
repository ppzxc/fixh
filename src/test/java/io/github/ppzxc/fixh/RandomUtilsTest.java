package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

class RandomUtilsTest {

  @RepeatedTest(10)
  void should_return_korean_name() {
    assertThat(RandomUtils.koreaName()).hasSize(3);
  }

  @RepeatedTest(10)
  void should_return_port() {
    assertThat(RandomUtils.port())
      .isGreaterThanOrEqualTo(1024)
      .isLessThanOrEqualTo(65535);
  }

  @RepeatedTest(10)
  void should_return_cell_phone_number() {
    String given = RandomUtils.cellPhoneNumber();
    assertThat(given).startsWith("010");
    assertThat(given.length()).isLessThanOrEqualTo(11);
  }

  @RepeatedTest(10)
  void should_return_email() {
    assertThat(RandomUtils.email()).contains("@").contains(".");
  }

  @RepeatedTest(10)
  void should_return_representative_number() {
    String given = RandomUtils.representativeNumber();
    assertThat(given).startsWith("15");
    assertThat(given.length()).isLessThanOrEqualTo(8);
  }

  @RepeatedTest(10)
  void should_return_internet_number() {
    String given = RandomUtils.internetNumber();
    assertThat(given).startsWith("070");
    assertThat(given.length()).isLessThanOrEqualTo(11);
  }

  @RepeatedTest(10)
  void should_return_url() {
    String given = RandomUtils.url();
    assertThat(given).contains("://").contains(".com");
  }

  @RepeatedTest(10)
  void should_return_current_yyyMMdd() {
    String given = RandomUtils.yyyyMMdd();
    assertThat(given).contains(String.valueOf(LocalDateTime.now().getYear()))
      .contains(String.valueOf(LocalDateTime.now().getMonthValue()))
      .contains(String.valueOf(LocalDateTime.now().getDayOfMonth()));
  }

  @RepeatedTest(10)
  void should_return_complex_password() {
    assertThat(RandomUtils.complexPassword()).isNotBlank();
  }

  @RepeatedTest(10)
  void should_return_lower_case_1() {
    String given = RandomUtils.lowerCase();
    assertThat(given).isEqualTo(given.toLowerCase());
  }

  @RepeatedTest(10)
  void should_return_lower_case_2() {
    String given = RandomUtils.lowerCase(IntUtils.giveMeOne(1024));
    assertThat(given).isEqualTo(given.toLowerCase());
  }

  @RepeatedTest(10)
  void should_return_upper_case_1() {
    String given = RandomUtils.upperCase();
    assertThat(given).isEqualTo(given.toUpperCase());
  }

  @RepeatedTest(10)
  void should_return_upper_case_2() {
    String given = RandomUtils.upperCase(IntUtils.giveMeOne(1024));
    assertThat(given).isEqualTo(given.toUpperCase());
  }

  @RepeatedTest(10)
  void should_return_digit_case_1() {
    assertThat(RandomUtils.digitCase()).containsOnlyDigits();
  }

  @RepeatedTest(10)
  void should_return_digit_case_2() {
    assertThat(RandomUtils.digitCase(IntUtils.giveMeOne(1, 1024))).containsOnlyDigits();
  }

  @RepeatedTest(10)
  void should_return_special_case_1() {
    assertThat(RandomUtils.specialCase()).containsAnyOf("+", "`", "~", "!", "@", "#", "$", "%", "^", "&",
      "*", "{", "}", "\\", "[", "\\", "]", "\"", "'", ":", ";", ",", ".", "<", ">", "?", "/", "|", "\\", "\\");
  }

  @RepeatedTest(10)
  void should_return_special_case_2() {
    assertThat(RandomUtils.specialCase(IntUtils.giveMeOne(1024))).containsAnyOf("+", "`", "~", "!", "@",
      "#", "$", "%", "^", "&",
      "*", "{", "}", "\\", "[", "\\", "]", "\"", "'", ":", ";", ",", ".", "<", ">", "?", "/", "|", "\\", "\\");
  }

  @RepeatedTest(10)
  void should_return_list_string() {
    List<String> givenList = RandomUtils.listString();
    assertThat(givenList).isNotEmpty();
    for (String given : givenList) {
      assertThat(given).isNotBlank();
    }
  }
}