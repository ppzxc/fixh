package io.github.ppzxc.fixh;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class EnumMapperTest {

  @Test
  void should_create() {
    assertThatCode(EnumMapper::new).doesNotThrowAnyException();
  }

  @Test
  void should_put() {
    // given
    EnumMapper given = new EnumMapper();

    // when, then
    assertThatCode(() -> given.put(TestEnum.class)).doesNotThrowAnyException();
    assertThatCode(() -> given.put(TestEnum.class.getSimpleName(), TestEnum.class)).doesNotThrowAnyException();
  }

  @Test
  void should_get() {
    // given
    EnumMapper given = new EnumMapper();

    // when
    given.put(TestEnum.class);
    List<EnumMapperValue> actual = given.get(TestEnum.class.getSimpleName());

    // then
    assertThat(actual).isNotNull();
  }

  @Test
  void should_empty_when_null_or_empty() {
    // given
    EnumMapper given = new EnumMapper();

    // when, then
    assertThat(given.get((List<String>) null)).isNotNull().isEmpty();
    assertThat(given.get(new ArrayList<>())).isNotNull().isEmpty();
  }

  @Test
  void should_exists() {
    // given
    EnumMapper given = new EnumMapper();

    // when
    given.put(TestEnum.class);

    // then
    assertThat(given.get(Collections.singletonList(TestEnum.class.getSimpleName()))).isNotNull().isNotEmpty();
  }

  @Test
  void should_return_all() {
    // given
    EnumMapper given = new EnumMapper();

    // when
    given.put(TestEnum.class);

    // then
    assertThat(given.getAll()).isNotNull().isNotEmpty();
  }

  private enum TestEnum implements EnumMapperType {
    A("AA"), B("BB"), C("CC"), D("DD"), E("EE"), F("FF"), G("GG");

    private final String title;

    TestEnum(String title) {
      this.title = title;
    }

    @Override
    public String getCode() {
      return name();
    }

    @Override
    public String getTitle() {
      return title;
    }
  }
}