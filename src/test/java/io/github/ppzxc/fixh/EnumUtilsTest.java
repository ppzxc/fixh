package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EnumUtilsTest {

  @Test
  void should_contains_given_enum() {
    assertThat(TestEnum.values()).contains(EnumUtils.giveMeOne(TestEnum.class));
  }

  private enum TestEnum {
    A, B, C, D, E, F, G
  }
}