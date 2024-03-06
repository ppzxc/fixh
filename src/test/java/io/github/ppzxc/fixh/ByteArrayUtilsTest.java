package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class ByteArrayUtilsTest {

  @RepeatedTest(10)
  void should_return_normal_when_given_length_1() {
    // given
    int given = IntUtils.giveMePositive(1024 * 1024);

    // when
    byte[] actual = ByteArrayUtils.giveMeOne(given);

    // then
    assertThat(actual).hasSize(given);
  }

  @RepeatedTest(10)
  void should_return_normal_when_given_length_2() {
    assertThat(ByteArrayUtils.giveMeOne()).isNotEmpty();
  }

  @RepeatedTest(10)
  void should_return_utf8_when_given_length_1() {
    // given
    int given = IntUtils.giveMePositive(1024 * 1024);

    // when
    byte[] actual = ByteArrayUtils.giveMeOneWithUtf8(given);

    // then
    assertThat(actual).isNotEmpty();
  }

  @RepeatedTest(10)
  void should_return_utf8_when_given_length_2() {
    assertThat(ByteArrayUtils.giveMeOneWithUtf8()).isNotEmpty();
  }
}