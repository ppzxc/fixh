package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberUtilsTest {

  @Test
  void should_return_digit() {
    assertThat(NumberUtils.getOnlyDigit("aksjdfusauf98382u40ujo34")).containsOnlyDigits();
  }

  @Test
  void should_return_empty() {
    assertThat(NumberUtils.getOnlyDigit(null)).isEmpty();
  }
}