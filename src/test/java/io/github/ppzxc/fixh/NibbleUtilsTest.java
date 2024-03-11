package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.RepeatedTest;

class NibbleUtilsTest {

  @RepeatedTest(10)
  void should_return_negative_nibble() {
    assertThat((int) NibbleUtils.getNegative())
      .isNegative()
      .isGreaterThanOrEqualTo(FixhConstants.SIGNED_NIBBLE_MIN_VALUE)
      .isNotPositive();
  }

  @RepeatedTest(10)
  void should_return_positive_nibble() {
    assertThat((int) NibbleUtils.getPositive())
      .isPositive()
      .isNotNegative()
      .isLessThanOrEqualTo(FixhConstants.SIGNED_NIBBLE_MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_unsigned_nibble() {
    assertThat((int) NibbleUtils.getUnsignedBoundary())
      .isPositive()
      .isNotNegative()
      .isLessThanOrEqualTo(FixhConstants.UNSIGNED_NIBBLE_MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_greater_than_unsigned_nibble_max_value() {
    assertThat((int) NibbleUtils.getGreaterThanUnsignedByteMaxValue())
      .isPositive()
      .isGreaterThanOrEqualTo(FixhConstants.UNSIGNED_NIBBLE_MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_return_nibble_without_value() {
    List<Byte> givenList = IntStream.range(0, IntUtils.giveMeOne(10))
      .mapToObj(ignored -> (byte) IntUtils.giveMeOne(-8, 7))
      .collect(Collectors.toList());
    assertThat(givenList).doesNotContain(NibbleUtils.giveMeOneWithout(givenList));
  }
}