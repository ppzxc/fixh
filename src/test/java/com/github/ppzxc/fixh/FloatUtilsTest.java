package com.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class FloatUtilsTest {

  @RepeatedTest(100)
  void should_return_bound_float() {
    assertThat(FloatUtils.giveMeOne())
      .isGreaterThanOrEqualTo(Float.MIN_VALUE)
      .isLessThanOrEqualTo(Float.MAX_VALUE);
  }

  @RepeatedTest(100)
  void should_return_negative() {
    assertThat(FloatUtils.giveMeNegative()).isNegative();
  }

  @RepeatedTest(100)
  void should_return_positive() {
    assertThat(FloatUtils.giveMePositive()).isPositive();
  }
}