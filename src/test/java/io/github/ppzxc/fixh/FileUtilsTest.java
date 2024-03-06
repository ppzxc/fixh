package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FileUtilsTest {

  @Test
  void should_find_file_names() {
    assertThat(FileUtils.getFileNames(PathUtils.getUserDir(), "README")).containsExactly("README.md");
  }
}