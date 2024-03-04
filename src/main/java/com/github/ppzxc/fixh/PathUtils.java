package com.github.ppzxc.fixh;

import java.nio.file.FileSystems;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Path utils.
 */
public final class PathUtils {

  private static final String USER_DIR = System.getProperty("user.dir");

  private PathUtils() {
  }

  /**
   * Gets user dir.
   *
   * @return the user dir
   */
  public static String getUserDir() {
    return USER_DIR;
  }

  /**
   * Gets file separator.
   *
   * @return the file separator
   */
  public static String getFileSeparator() {
    return FileSystems.getDefault().getSeparator();
  }

  /**
   * Join path string.
   *
   * @param paths the paths
   * @return the string
   */
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
