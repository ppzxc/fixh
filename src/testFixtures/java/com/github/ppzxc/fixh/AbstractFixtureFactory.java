package com.github.ppzxc.fixh;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.BuilderArbitraryIntrospector;
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin;

public abstract class AbstractFixtureFactory {

  private static final FixtureMonkey FIXTURE_MONKEY;

  static {
    FIXTURE_MONKEY = FixtureMonkey.builder()
      .objectIntrospector(BuilderArbitraryIntrospector.INSTANCE)
      .plugin(new JakartaValidationPlugin())
      .build();
  }

  public <T> T giveMeOne(Class<T> tClass) {
    return FIXTURE_MONKEY.giveMeOne(tClass);
  }
}
