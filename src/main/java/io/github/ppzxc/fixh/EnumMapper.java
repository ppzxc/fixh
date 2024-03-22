package io.github.ppzxc.fixh;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://techblog.woowahan.com/2527/">reference</a>
 */
public class EnumMapper {

  private final Map<String, List<EnumMapperValue>> factory;

  public EnumMapper() {
    this.factory = new LinkedHashMap<>();
  }

  public void put(String key, Class<? extends EnumMapperType> e) {
    factory.put(StringUtils.requireNotBlank(key), toEnumValue(e));
  }

  public void put(Class<? extends EnumMapperType> e) {
    put(e.getSimpleName(), e);
  }

  private List<EnumMapperValue> toEnumValue(Class<? extends EnumMapperType> e) {
    return Arrays.stream(e.getEnumConstants())
      .map(constant -> EnumMapperValue.of(constant.getCode(), constant.getTitle()))
      .collect(Collectors.toList());
  }

  public List<EnumMapperValue> get(String key) {
    return factory.get(StringUtils.requireNotBlank(key));
  }

  public Map<String, List<EnumMapperValue>> get(List<String> keys) {
    if (keys == null || keys.isEmpty()) {
      return new LinkedHashMap<>();
    }
    return keys.stream()
      .collect(Collectors.toMap(Function.identity(), factory::get));
  }

  public Map<String, List<EnumMapperValue>> getAll() {
    return factory;
  }
}
