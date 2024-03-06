package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class FloatUtilsTest {

  @RepeatedTest(10)
  void should_return_bound_float() {
    assertThat(FloatUtils.giveMeOne())
      .isGreaterThanOrEqualTo(Float.MIN_VALUE)
      .isLessThanOrEqualTo(Float.MAX_VALUE);
  }
}