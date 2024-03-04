package com.github.ppzxc.fixh;

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
   * @param pattern the pattern
   * @return the string [ ]
   */
  public static String[] getFileNames(String path, String pattern) {
    return new File(path).list((dir, name) -> name.startsWith(pattern));
  }
}
