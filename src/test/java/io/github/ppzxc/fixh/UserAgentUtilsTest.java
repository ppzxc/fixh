package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class UserAgentUtilsTest {

  @RepeatedTest(10)
  void should_return_user_agent() {
    assertThat(UserAgentUtils.getInstance().getRandomUserAgent()).isNotBlank();
  }
}