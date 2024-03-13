package io.github.ppzxc.fixh;

import java.io.File;

public final class FileUtils {

  private FileUtils() {
  }

  public static String[] getFileNames(String path, String startsWith) {
    return new File(path).list((dir, name) -> name.startsWith(startsWith));
  }
}
