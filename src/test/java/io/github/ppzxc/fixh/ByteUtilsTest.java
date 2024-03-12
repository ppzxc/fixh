package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ByteUtilsTest {

  @RepeatedTest(10)
  void should_return_length_to_human_readable_1() {
    assertThat(ByteUtils.lengthToHumanReadable(LongUtils.giveMeOne(1, 1024)))
      .containsAnyOf("B", "K", "M", "G", "T", "P", "E");
  }

  @RepeatedTest(10)
  void should_return_length_to_human_readable_2() {
    assertThat(ByteUtils.lengthToHumanReadable(LongUtils.giveMePositive()))
      .containsAnyOf("B", "K", "M", "G", "T", "P", "E");
  }

  @RepeatedTest(10)
  void should_return_ascii() {
    assertThat(ByteUtils.getAscii())
      .isGreaterThanOrEqualTo((byte) 0)
      .isLessThanOrEqualTo((byte) 127);
  }

  @RepeatedTest(10)
  void should_return_negative() {
    assertThat(ByteUtils.getNegative()).isNegative();
  }

  @RepeatedTest(10)
  void should_return_positive() {
    assertThat(ByteUtils.getPositive()).isPositive();
  }

  @RepeatedTest(10)
  void should_return_unsigned_byte() {
    // given
    short given = ByteUtils.getUnsignedBoundary();

    // when, then
    assertThat(given).isPositive();
    assertThat((byte) given)
      .isGreaterThanOrEqualTo(Byte.MIN_VALUE)
      .isLessThanOrEqualTo(Byte.MAX_VALUE);
  }

  @RepeatedTest(10)
  void should_greater_byte_max_value() {
    assertThat(ByteUtils.getGreaterThanUnsignedByteMaxValue()).isGreaterThan(FixhConstants.UNSIGNED_MAX_VALUE_BYTE);
  }

  @RepeatedTest(10)
  void should_return_byte_when_given_without() {
    byte given = ByteUtils.giveMeOne();
    assertThat(ByteUtils.giveMeOneWithout(Byte.MIN_VALUE, Byte.MAX_VALUE, given)).isNotEqualTo(given);
  }

  @RepeatedTest(10)
  void should_return_byte_when_given_without_2() {
    assertThat(ByteUtils.giveMeOneWithout((byte) 2, (byte) 4, (byte) 2)).isEqualTo((byte) 3);
  }

  @RepeatedTest(100)
  void should_return_byte_when_given_without_list() {
    List<Byte> withoutList = IntStream.range(0, IntUtils.giveMePositive(100))
      .mapToObj(ignored -> ByteUtils.giveMeOne())
      .collect(Collectors.toList());
    assertThat(withoutList).doesNotContain(ByteUtils.giveMeOneWithout(withoutList));
  }

  @RepeatedTest(10)
  void should_return_byte() {
    assertThat(ByteUtils.giveMeOne())
      .isGreaterThanOrEqualTo(Byte.MIN_VALUE)
      .isLessThanOrEqualTo(Byte.MAX_VALUE);
  }

  @Test
  void should_return_hex() {
    // given
    byte expected = ByteUtils.giveMeOne();

    // when
    String actual = ByteUtils.toHex(expected);

    // then
    assertThat(actual)
      .startsWith("0x")
      .endsWith(Integer.toHexString(expected & 0xFF));
  }
}