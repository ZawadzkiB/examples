package com.bzawadzki.pages;

import com.bzawadzki.pages.assertions.HeaderPageAssertions;

import java.util.function.Consumer;

public class HeaderPage {

  public HeaderPage assertThat(Consumer<HeaderPageAssertions> assertThat) {
    assertThat.accept(new HeaderPageAssertions());
    return this;
  }

}
