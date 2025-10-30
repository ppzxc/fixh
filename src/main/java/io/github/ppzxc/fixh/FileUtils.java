package io.github.ppzxc.fixh;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class FileUtils {

  private FileUtils() {
  }

  public static String[] getFileNames(String path, String startsWith) {
    return new File(path).list((dir, name) -> name.startsWith(startsWith));
  }

  public static List<String> getFileNamesToList(String path, String startsWith) {
    return Arrays.stream(getFileNames(path, startsWith)).collect(Collectors.toList());
  }
}
