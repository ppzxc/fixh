package io.github.ppzxc.fixh;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class PathUtils {

  private PathUtils() {
  }

  public static String getUserDir() {
    return System.getProperty("user.dir");
  }

  public static String getFileSeparator() {
    return FileSystems.getDefault().getSeparator();
  }

  public static String join(String... paths) {
    return IntStream.range(0, paths.length)
      .mapToObj(i -> {
        String path = paths[i];
        if (i != paths.length - 1) {
          path = path + PathUtils.getFileSeparator();
        }
        return path;
      }).collect(Collectors.joining());
  }

  public static String getCurrentPath() throws IOException {
    return (new File(".")).getCanonicalFile().getPath();
  }
}
