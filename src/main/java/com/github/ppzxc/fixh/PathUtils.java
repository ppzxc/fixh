package com.github.ppzxc.fixh;

import java.nio.file.FileSystems;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class PathUtils {

  private static final String USER_DIR = System.getProperty("user.dir");

  private PathUtils() {
  }

  public static String getUserDir() {
    return USER_DIR;
  }

  public static String getFileSeparator() {
    return FileSystems.getDefault().getSeparator();
  }

  public static String joinPath(String... paths) {
    return IntStream.range(0, paths.length)
      .mapToObj(i -> {
        String path = paths[i];
        if (i != paths.length - 1) {
          path = path + PathUtils.getFileSeparator();
        }
        return path;
      }).collect(Collectors.joining());
  }
}
