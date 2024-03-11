package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class LongUtilsTest {

  @RepeatedTest(10)
  void should_return_long_boundary() {
    assertThat(LongUtils.giveMeOne())
      .isGreaterThanOrEqualTo(Long.MIN_VALUE)
      .isLessThanOrEqualTo(Long.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_negative_long_boundary() {
    assertThat(LongUtils.giveMeNegative())
      .isGreaterThanOrEqualTo(Long.MIN_VALUE)
      .isNegative();
  }

  @RepeatedTest(10)
  void should_return_positive_long_boundary() {
    assertThat(LongUtils.giveMePositive())
      .isPositive()
      .isLessThanOrEqualTo(Long.MAX_VALUE);
  }
}