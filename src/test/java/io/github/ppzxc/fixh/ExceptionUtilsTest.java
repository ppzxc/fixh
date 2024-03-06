package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class ExceptionUtilsTest {

  @RepeatedTest(10)
  void should_find_root_cause() {
    RuntimeException expected = new RuntimeException(new IllegalArgumentException(new NullPointerException("HELLO")));
    assertThat(expected).isInstanceOf(RuntimeException.class);
    assertThat(ExceptionUtils.getRootCause(expected)).isInstanceOf(NullPointerException.class);
  }
}