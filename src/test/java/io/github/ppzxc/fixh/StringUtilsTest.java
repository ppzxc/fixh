package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

  @Test
  void should_return_org_if_null() {
    assertThat(StringUtils.isBlank(null, "DEF")).isEqualTo("DEF");
  }

  @Test
  void should_return_org_if_empty() {
    assertThat(StringUtils.isBlank("", "DEF")).isEqualTo("DEF");
  }

  @Test
  void should_return_org_if_blank() {
    assertThat(StringUtils.isBlank("   ", "DEF")).isEqualTo("DEF");
  }

  @Test
  void should_return_org_if_null_1() {
    assertThat(StringUtils.isNotBlank(null, "DEF")).isEqualTo("DEF");
  }

  @Test
  void should_return_org_if_empty_1() {
    assertThat(StringUtils.isNotBlank("", "DEF")).isEqualTo("DEF");
  }

  @Test
  void should_return_org_if_blank_1() {
    assertThat(StringUtils.isNotBlank("   ", "DEF")).isEqualTo("DEF");
  }

  @Test
  void should_return_true_if_null_3() {
    assertThat(StringUtils.isBlank(null)).isTrue();
  }

  @Test
  void should_return_true_if_blank_4() {
    assertThat(StringUtils.isBlank("")).isTrue();
  }

  @Test
  void should_return_true_if_blank() {
    assertThat(StringUtils.isBlank(" ")).isTrue();
  }

  @Test
  void should_return_false_if_not_blank() {
    assertThat(StringUtils.isBlank("asdf   ")).isFalse();
  }

  @Test
  void should_return_false_if_blank() {
    assertThat(StringUtils.isNotBlank(" ")).isFalse();
  }

  @Test
  void should_return_true_if_not_blank() {
    assertThat(StringUtils.isNotBlank("asdf   ")).isTrue();
  }

  @Test
  void should_return_empty_when_input_null() {
    assertThat(StringUtils.nvl(null)).isEmpty();
  }

  @Test
  void should_return_empty_when_input_not_null() {
    assertThat(StringUtils.nvl("null")).isEqualTo("null");
  }

  @Test
  void should_return_default_when_input_null() {
    assertThat(StringUtils.nvl(null, "defaults")).isEqualTo("defaults");
  }

  @Test
  void should_return_true_if_null() {
    assertThat(StringUtils.isNull(null)).isTrue();
  }

  @Test
  void should_return_true_if_not_null() {
    assertThat(StringUtils.isNull("null")).isFalse();
  }

  @Test
  void should_return_defaults_when_input_null() {
    assertThat(StringUtils.isNull(null, "defaults")).isEqualTo("defaults");
  }

  @Test
  void should_return_false_if_null() {
    assertThat(StringUtils.isNotNull(null)).isFalse();
  }

  @Test
  void should_return_false_if_not_null() {
    assertThat(StringUtils.isNotNull("null")).isTrue();
  }

  @Test
  void should_return_defaults_when_not_null() {
    assertThat(StringUtils.isNotNull("null", "defaults")).isEqualTo("defaults");
  }

  @Test
  void should_return_true_if_null_2() {
    assertThat(StringUtils.isEmpty(null)).isTrue();
  }

  @Test
  void should_return_true_if_empty() {
    assertThat(StringUtils.isEmpty("")).isTrue();
  }

  @Test
  void should_return_false_if_not_empty() {
    assertThat(StringUtils.isEmpty("asdfsa")).isFalse();
  }

  @Test
  void should_return_false_if_empty() {
    assertThat(StringUtils.isNotEmpty("")).isFalse();
  }

  @Test
  void should_return_false_if_not_empty_2() {
    assertThat(StringUtils.isNotEmpty("asdf")).isTrue();
  }

  @Test
  void should_return_default_if_empty() {
    assertThat(StringUtils.isEmptyToDefault("", "TEST")).isEqualTo("TEST");
  }

  @Test
  void should_return_default_if_empty_2() {
    String given = StringUtils.giveMeOne(128);
    assertThat(StringUtils.isEmptyToDefault(given, "TEST")).isEqualTo(given);
  }

  @Test
  void should_return_add_pad() {
    assertThat(StringUtils.leftPad("TEST", 0, "@")).startsWith("TEST").hasSize(8);
  }

  @Test
  void should_return_add_left_pad() {
    assertThat(StringUtils.leftPad("TEST", 10, "@")).startsWith("@@@@@@").hasSize(10);
  }

  @Test
  void should_return_add_right_pad() {
    assertThat(StringUtils.rightPad("TEST", 10, "@")).endsWith("@@@@@@").hasSize(10);
  }

  @Test
  void should_return_join_vararg() {
    assertThat(StringUtils.join("t", "e", "s", "t")).isEqualTo("test");
  }

  @Test
  void should_return_exception_when_null() {
    assertThatCode(() -> StringUtils.requireNotNull(null)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_return_exception_when_null_3() {
    assertThatCode(() -> StringUtils.requireNotNull("123")).doesNotThrowAnyException();
  }

  @Test
  void should_return_exception_when_empty() {
    assertThatCode(() -> StringUtils.requireNotEmpty("")).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_return_exception_when_empty_3() {
    assertThatCode(() -> StringUtils.requireNotEmpty("asdf")).doesNotThrowAnyException();
  }

  @Test
  void should_return_exception_when_blank() {
    assertThatCode(() -> StringUtils.requireNotBlank("    ")).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_return_exception_when_blank_4() {
    assertThatCode(() -> StringUtils.requireNotBlank("asdjfkl")).doesNotThrowAnyException();
  }

  @Test
  void should_return_exception_when_null_2() {
    NullPointerException given = new NullPointerException("TEST");
    assertThatCode(() -> StringUtils.requireNotNull(null, given))
      .isInstanceOf(NullPointerException.class)
      .hasMessage("TEST");
  }

  @Test
  void should_return_exception_when_empty_2() {
    NullPointerException given = new NullPointerException("TEST");
    assertThatCode(() -> StringUtils.requireNotEmpty("", given))
      .isInstanceOf(NullPointerException.class)
      .hasMessage("TEST");
  }

  @Test
  void should_return_exception_when_blank_2() {
    NullPointerException given = new NullPointerException("TEST");
    assertThatCode(() -> StringUtils.requireNotBlank("   ", given))
      .isInstanceOf(NullPointerException.class)
      .hasMessage("TEST");
  }

  @Test
  void should_return_exception_when_blank_3() {
    assertThat(StringUtils.requireNotBlank("asdf", new NullPointerException("TEST"))).isEqualTo("asdf");
  }

  @RepeatedTest(10)
  void should_return_random_string() {
    assertThat(StringUtils.giveMeOne()).isNotBlank();
  }

  @RepeatedTest(10)
  void should_return_random_string_bound() {
    assertThat(StringUtils.giveMeOne(1, Byte.MAX_VALUE)).isNotBlank();
  }

  @RepeatedTest(10)
  void should_return_random_string_bound_without() {
    assertThat(StringUtils.giveMeOne(1, Byte.MAX_VALUE, 1, 2, 3))
      .hasSizeGreaterThanOrEqualTo(4)
      .hasSizeLessThanOrEqualTo(Byte.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_random_string_bound_without_2() {
    assertThat(StringUtils.giveMeOne(1, 5, 1, 2, 3))
      .hasSize(4);
  }

  @RepeatedTest(10)
  void should_return_random_string_when_given_length() {
    assertThat(StringUtils.giveMeOne(IntUtils.giveMeOne(1, 1024)))
      .isNotBlank()
      .hasSizeGreaterThanOrEqualTo(1)
      .hasSizeLessThanOrEqualTo(1023);
  }

  @RepeatedTest(10)
  void should_return_korean_string() {
    assertThat(StringUtils.giveMeOneKorean(IntUtils.giveMeOne(1024)))
      .isNotBlank()
      .hasSizeGreaterThanOrEqualTo(1)
      .hasSizeLessThanOrEqualTo(1023);
  }

  @RepeatedTest(10)
  void should_return_korean_string_by_bytes() {
    assertThat(StringUtils.giveMeOneKoreanAsBytes(IntUtils.giveMeOne(1024)))
      .isNotBlank()
      .hasSizeGreaterThanOrEqualTo(1)
      .hasSizeLessThanOrEqualTo(1023);
  }
}