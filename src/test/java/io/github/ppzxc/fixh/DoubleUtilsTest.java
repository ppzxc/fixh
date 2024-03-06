package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class DoubleUtilsTest {

  @RepeatedTest(10)
  void should_return_bound_double_1() {
    assertThat(DoubleUtils.giveMeOne())
      .isGreaterThanOrEqualTo(Double.MIN_VALUE)
      .isLessThanOrEqualTo(Double.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_bound_double_2() {
    assertThat(DoubleUtils.giveMeOne(Double.MIN_VALUE, Double.MAX_VALUE))
      .isGreaterThanOrEqualTo(Double.MIN_VALUE)
      .isLessThanOrEqualTo(Double.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_negative() {
    assertThat(DoubleUtils.giveMeNegative()).isNegative();
  }

  @RepeatedTest(10)
  void should_return_positive() {
    assertThat(DoubleUtils.giveMePositive()).isPositive();
  }
}