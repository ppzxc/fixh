package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class ShortUtilsTest {

  @RepeatedTest(10)
  void should_return_negative_short() {
    assertThat(ShortUtils.getNegative()).isNegative();
  }

  @RepeatedTest(10)
  void should_return_positive_short() {
    assertThat(ShortUtils.getPositive()).isPositive();
  }

  @RepeatedTest(10)
  void should_return_unsigned_short() {
    assertThat(ShortUtils.getUnsignedBoundary())
      .isPositive()
      .isLessThanOrEqualTo(FixhConstants.UNSIGNED_MAX_VALUE_SHORT);
  }

  @RepeatedTest(10)
  void should_return_greater_than_unsigned_short_max_value() {
    assertThat(ShortUtils.getGreaterThanUnsignedIntegerMaxValue())
      .isPositive()
      .isGreaterThan(FixhConstants.UNSIGNED_MAX_VALUE_SHORT);
  }

  @RepeatedTest(10)
  void should_return_short() {
    assertThat(ShortUtils.giveMeOne())
      .isGreaterThanOrEqualTo(Short.MIN_VALUE)
      .isLessThanOrEqualTo(Short.MAX_VALUE);
  }
}