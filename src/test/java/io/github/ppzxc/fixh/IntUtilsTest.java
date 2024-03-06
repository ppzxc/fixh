package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
    assertThat(actual)
      .isGreaterThan(0)
      .isLessThanOrEqualTo(Integer.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_integer_list_when_without() {
    // given
    int givenInt = ThreadLocalRandom.current().nextInt();
    int given = givenInt < 0 ? givenInt * -1 : givenInt;

    // when
    List<Integer> actual = IntUtils.giveMeWithout(100, given);

    // then
    assertThat(actual).hasSize(100);
    assertThat(actual).doesNotContain(given);
  }

  @RepeatedTest(10)
  void should_return_unsigned_integer() {
    assertThat(IntUtils.giveMeOneUnsigned())
      .isGreaterThan(0)
      .isLessThanOrEqualTo(Integer.toUnsignedLong(-1));
  }

  @RepeatedTest(10)
  void should_return_negative() {
    assertThat(IntUtils.giveMeNegative())
      .isGreaterThanOrEqualTo(Integer.MIN_VALUE)
      .isLessThan(0);
  }

  @RepeatedTest(10)
  void should_return_positive() {
    assertThat(IntUtils.giveMePositive())
      .isGreaterThan(0)
      .isLessThanOrEqualTo(Integer.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_positive_boundary() {
    assertThat(IntUtils.giveMeOne(0, Integer.MAX_VALUE))
      .isGreaterThan(0)
      .isLessThanOrEqualTo(Integer.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_positive_boundary_two() {
    // given
    int bound = IntUtils.giveMePositive();

    // when, then
    assertThat(IntUtils.giveMePositive(bound))
      .isGreaterThan(0)
      .isLessThanOrEqualTo(bound);
  }
}