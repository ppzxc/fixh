package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.FileSystems;
import org.junit.jupiter.api.Test;

class PathUtilsTest {

  @Test
  void should_return_user_dir() {
    assertThat(PathUtils.getUserDir()).isEqualTo(System.getProperty("user.dir"));
  }

  @Test
  void should_return_file_separator() {
    assertThat(PathUtils.getFileSeparator()).isEqualTo(FileSystems.getDefault().getSeparator());
  }

  @Test
  void should_return_join() {
    assertThat(PathUtils.join("test", "java", "project")).contains("test", "java", "project");
  }

  @Test
  void should_return_current_path() throws IOException {
    assertThat(PathUtils.getCurrentPath()).contains(PathUtils.getUserDir());
  }
}