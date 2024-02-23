package com.github.ppzxc.fixh;

import java.io.File;

public final class FileUtils {

  private FileUtils() {
  }

  public static String[] getFileNames(String path, String pattern) {
    return new File(path).list((dir, name) -> name.startsWith(pattern));
  }
}
