package com.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class DoubleUtilsTest {

  @RepeatedTest(100)
  void should_return_bound_double() {
    assertThat(DoubleUtils.giveMeOne())
      .isGreaterThanOrEqualTo(Double.MIN_VALUE)
      .isLessThanOrEqualTo(Double.MAX_VALUE);
  }

  @RepeatedTest(100)
  void should_return_negative() {
    assertThat(DoubleUtils.giveMeNegative()).isNegative();
  }

  @RepeatedTest(100)
  void should_return_positive() {
    assertThat(DoubleUtils.giveMePositive()).isPositive();
  }
}