package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.RepeatedTest;

class IntUtilsTest {

  @RepeatedTest(10)
  void should_return_integer_boundary() {
    assertThat(IntUtils.giveMeOne())
      .isGreaterThanOrEqualTo(Integer.MIN_VALUE)
      .isLessThanOrEqualTo(Integer.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_integer_boundary_when_input_boundary() {
    // given
    int givenInt = ThreadLocalRandom.current().nextInt();
    int given = givenInt < 0 ? givenInt * -1 : givenInt;

    // when
    int actual = IntUtils.giveMeOne(given);

    // then
    assertThat(actual).isPositive().isLessThanOrEqualTo(Integer.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_integer_list_when_without() {
    // given
    int without = 2;

    // when
    Integer actual = IntUtils.giveMeWithout(1, 3, without);

    // then
    assertThat(actual).isNotEqualTo(without);
  }

  @RepeatedTest(10)
  void should_return_unsigned_integer() {
    assertThat(IntUtils.giveMeOneUnsigned()).isPositive().isLessThanOrEqualTo(Integer.toUnsignedLong(-1));
  }

  @RepeatedTest(10)
  void should_return_negative() {
    assertThat(IntUtils.giveMeNegative()).isGreaterThanOrEqualTo(Integer.MIN_VALUE).isNegative();
  }

  @RepeatedTest(10)
  void should_return_positive() {
    assertThat(IntUtils.giveMePositive()).isPositive().isLessThanOrEqualTo(Integer.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_positive_boundary() {
    assertThat(IntUtils.giveMeOne(0, Integer.MAX_VALUE)).isPositive().isLessThanOrEqualTo(Integer.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_positive_boundary_two() {
    // given
    int bound = IntUtils.giveMePositive();

    // when, then
    assertThat(IntUtils.giveMePositive(bound)).isPositive().isLessThanOrEqualTo(bound);
  }

  @RepeatedTest(10)
  void should_return_unsigned() {
    assertThat(IntUtils.giveMeUnsignedBoundary()).isNotNegative()
      .isLessThanOrEqualTo(FixhConstants.UNSIGNED_MAX_VALUE_INT);
  }

  @RepeatedTest(10)
  void should_return_unsigned_when_over_int_max_value() {
    assertThat(IntUtils.giveMeGreaterThanUnsignedIntegerMaxValue())
      .isGreaterThanOrEqualTo(FixhConstants.UNSIGNED_MAX_VALUE_INT + 1)
      .isLessThanOrEqualTo(Long.MAX_VALUE);
  }
}