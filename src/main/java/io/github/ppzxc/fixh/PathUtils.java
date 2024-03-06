package io.github.ppzxc.fixh;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Path utils.
 */
public final class PathUtils {

  private PathUtils() {
  }

  /**
   * Gets user dir.
   *
   * @return the user dir
   */
  public static String getUserDir() {
    return System.getProperty("user.dir");
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

  /**
   * Gets current path.
   *
   * @return the current path
   * @throws IOException the io exception
   */
  public static String getCurrentPath() throws IOException {
    return (new File(".")).getCanonicalFile().getPath();
  }
}
