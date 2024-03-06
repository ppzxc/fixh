package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class BooleanUtilsTest {

  @RepeatedTest(10)
  void should_return_random_boolean() {
    assertThat(BooleanUtils.giveMeOne()).isInstanceOfAny(Boolean.class);
  }
}