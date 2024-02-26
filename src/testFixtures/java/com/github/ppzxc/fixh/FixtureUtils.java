package com.github.ppzxc.fixh;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.BuilderArbitraryIntrospector;
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin;
import java.util.List;

public final class FixtureUtils {

  private static final FixtureMonkey FIXTURE_MONKEY;

  static {
    JakartaValidationPlugin jakartaValidationPlugin = new JakartaValidationPlugin();

    FIXTURE_MONKEY = FixtureMonkey.builder()
      .objectIntrospector(BuilderArbitraryIntrospector.INSTANCE)
      .plugin(jakartaValidationPlugin)
      .build();
  }

  private FixtureUtils() {
  }

  public static FixtureMonkey getFixtureMonkey() {
    return FIXTURE_MONKEY;
  }

  public static <T> List<T> giveMe(Class<T> tClass, int size) {
    return FIXTURE_MONKEY.giveMe(tClass, size);
  }

  public static <T> List<T> giveMe(Class<T> tClass) {
    return giveMe(tClass, 10);
  }

  public static <T> T giveMeOne(Class<T> tClass) {
    return FIXTURE_MONKEY.giveMeOne(tClass);
  }

  public static <T> T giveMeOne(Class<T> tClass, String field, Object value) {
    return FIXTURE_MONKEY.giveMeBuilder(tClass).set(field, value).sample();
  }
}
