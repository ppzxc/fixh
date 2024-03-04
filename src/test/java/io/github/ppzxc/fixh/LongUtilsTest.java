package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class LongUtilsTest {

  @RepeatedTest(100)
  void should_return_long_boundary() {
    assertThat(LongUtils.giveMeOne())
      .isGreaterThanOrEqualTo(Long.MIN_VALUE)
      .isLessThanOrEqualTo(Long.MAX_VALUE);
  }

  @RepeatedTest(100)
  void should_return_negative_long_boundary() {
    assertThat(LongUtils.giveMeNegative())
      .isGreaterThanOrEqualTo(Long.MIN_VALUE)
      .isLessThan(0);
  }

  @RepeatedTest(100)
  void should_return_positive_long_boundary() {
    assertThat(LongUtils.giveMePositive())
      .isGreaterThan(0)
      .isLessThanOrEqualTo(Long.MAX_VALUE);
  }
}