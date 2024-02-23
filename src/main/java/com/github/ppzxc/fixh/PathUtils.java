package com.nanoit.gateway.common;

import java.nio.file.FileSystems;

public final class PathUtils {

  public static final String ROOT_SYS = "sys";
  public static final String ROOT_BK = "bk";
  public static final String ROOT_SEND = "send";
  public static final String ROOT_RECEIVE = "receive";

  public static final String RESULT = "rslt";
  public static final String PUBLIC = "public";
  public static final String MAPPER = "mapper";
  public static final String CONFIG = "config.yml";
  public static final String ROOT_CFG = "cfg";

  private PathUtils() {
  }

  public static String getUserDir() {
    return System.getProperty("user.dir");
  }

  public static String getFileSeparator() {
    return FileSystems.getDefault().getSeparator();
  }

  public static String getConfigResultAllJson() {
    return StringUtils.joinPath(getUserDir(), RESULT, "default-result-code-explain.json");
  }

  public static String getConfigResultMappedJson() {
    return StringUtils.joinPath(getUserDir(), RESULT, "mapped-result-code.json");
  }

  public static String getCfgKeyfile() {
    return StringUtils.joinPath(getUserDir(), ROOT_CFG, "keyfile");
  }

  public static String getCfgConfig() {
    return StringUtils.joinPath(getUserDir(), ROOT_CFG, CONFIG);
  }

  public static String getResourcesNanoServerResultCode() {
    return "nanoit-server.json";
  }

  public static String getStaticFolder() {
    return StringUtils.joinPath(getUserDir(), ROOT_SYS, PUBLIC);
  }

  public static String getBack(String fileName) {
    return StringUtils.joinPath(getUserDir(), ROOT_BK, fileName);
  }

  public static String getBackSend() {
    return StringUtils.joinPath(getUserDir(), ROOT_BK, ROOT_SEND);
  }

  public static String getBackReceive() {
    return StringUtils.joinPath(getUserDir(), ROOT_BK, ROOT_RECEIVE);
  }

  public static String getResultServerCode() {
    return StringUtils.joinPath(getUserDir(), RESULT, "server-code.json");
  }

  public static String getResultMappingCode() {
    return StringUtils.joinPath(getUserDir(), RESULT, "mapping-code.json");
  }

  public static String getResultAllCode() {
    return StringUtils.joinPath(getUserDir(), RESULT, "all-code.json");
  }

  public static String getSystemMapper() {
    return StringUtils.joinPath(getUserDir(), ROOT_SYS, MAPPER);
  }

  public static String getSystemPublic() {
    return StringUtils.joinPath(getUserDir(), ROOT_SYS, PUBLIC);
  }
}
