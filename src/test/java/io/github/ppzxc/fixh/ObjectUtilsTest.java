package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class ObjectUtilsTest {

  @Test
  void should_throw() {
    Object given = null;
    assertThatCode(() -> ObjectUtils.requireNonNull(given))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void should_throw_exception() {
    Object given = null;
    String expected = RandomUtils.lowerCase(1024);
    assertThatCode(() -> ObjectUtils.requireNonNull(given, expected))
      .isInstanceOf(NullPointerException.class)
      .hasMessage(expected);
  }

  @Test
  void should_not_throw_exception() {
    assertThat(ObjectUtils.requireNonNull("TEST", RandomUtils.lowerCase(1024))).isEqualTo("TEST");
  }

  @Test
  void should_throw_exception_2() {
    Object given = null;
    IllegalStateException expected = new IllegalStateException(StringUtils.giveMeOne(1024));
    assertThatCode(() -> ObjectUtils.requireNonNull(given, expected))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage(expected.getMessage());
  }

  @Test
  void should_not_throw_exception_2() {
    assertThat(
      ObjectUtils.requireNonNull("TEST", new IllegalStateException(StringUtils.giveMeOne(1024)))).isEqualTo(
      "TEST");
  }
}