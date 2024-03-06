package io.github.ppzxc.fixh;

import java.io.File;

/**
 * The type File utils.
 */
public final class FileUtils {

  private FileUtils() {
  }

  /**
   * Get file names string [ ].
   *
   * @param path    the path
   * @param startsWith the pattern
   * @return the string [ ]
   */
  public static String[] getFileNames(String path, String startsWith) {
    return new File(path).list((dir, name) -> name.startsWith(startsWith));
  }
}
