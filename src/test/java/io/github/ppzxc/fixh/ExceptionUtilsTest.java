package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import org.junit.jupiter.api.RepeatedTest;

class ExceptionUtilsTest {

  @RepeatedTest(10)
  void should_return_root_cause() {
    RuntimeException expected = new RuntimeException(new IllegalArgumentException(new NullPointerException("HELLO")));
    assertThat(expected).isInstanceOf(RuntimeException.class);
    assertThat(ExceptionUtils.getRootCause(expected)).isInstanceOf(NullPointerException.class);
  }

  @RepeatedTest(10)
  void should_return_root_cause_2() {
    RuntimeException expected = new RuntimeException();
    assertThat(expected).isInstanceOf(RuntimeException.class);
    assertThat(ExceptionUtils.getRootCause(expected)).isInstanceOf(RuntimeException.class);
  }

  @RepeatedTest(10)
  void should_return_root_cause_3() {
    RuntimeException expected = new RuntimeException(new RuntimeException());
    assertThat(expected).isInstanceOf(RuntimeException.class);
    assertThat(ExceptionUtils.getRootCause(expected)).isInstanceOf(RuntimeException.class);
  }

  @RepeatedTest(10)
  void should_return_root_cause_4() {
    RuntimeException expected = new RuntimeException(new IOException());
    assertThat(expected).isInstanceOf(RuntimeException.class);
    assertThat(ExceptionUtils.getRootCause(expected)).isInstanceOf(IOException.class);
  }

  @RepeatedTest(10)
  void should_return_root_cause_5() {
    RuntimeException expected = new RuntimeException();
    assertThat(expected).isInstanceOf(RuntimeException.class);
    assertThat(ExceptionUtils.getRootCause(expected)).isInstanceOf(RuntimeException.class);
  }

  @RepeatedTest(10)
  void should_return_find_cause() {
    RuntimeException expected = new RuntimeException(new IOException(new IllegalStateException(new IllegalArgumentException(new NullPointerException("HELLO")))));
    assertThat(expected).isInstanceOf(RuntimeException.class);
    assertThat(ExceptionUtils.findCause(expected, IllegalStateException.class)).isInstanceOf(IllegalStateException.class);
  }

  @RepeatedTest(10)
  void should_return_root_cause_when_not_found() {
    RuntimeException expected = new RuntimeException(new IOException(new IllegalStateException(new IllegalArgumentException(new NullPointerException("HELLO")))));
    assertThat(expected).isInstanceOf(RuntimeException.class);
    assertThat(ExceptionUtils.findCause(expected, ClosedChannelException.class)).isInstanceOf(NullPointerException.class);
  }
}