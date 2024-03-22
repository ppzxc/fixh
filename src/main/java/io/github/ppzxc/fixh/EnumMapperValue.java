package io.github.ppzxc.fixh;

public final class EnumMapperValue {

  private final String code;
  private final String title;

  private EnumMapperValue(String code, String title) {
    this.code = StringUtils.requireNotBlank(code, new IllegalArgumentException("blank code"));
    this.title = StringUtils.requireNotBlank(title, new IllegalArgumentException("blank title"));
  }

  public String getCode() {
    return code;
  }

  public String getTitle() {
    return title;
  }

  public static EnumMapperValue of(String code, String title) {
    return new EnumMapperValue(code, title);
  }

  @Override
  public String toString() {
    return "EnumMapperValue{" +
      "code='" + code + '\'' +
      ", title='" + title + '\'' +
      '}';
  }
}
