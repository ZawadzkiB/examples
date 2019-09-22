package com.bzawadzki.pages;

import java.util.function.Consumer;

public class BasePage {

  public HeaderPage onPageHeader(Consumer<HeaderPage> onHeader) {
    HeaderPage headerPage = new HeaderPage();
    onHeader.accept(headerPage);
    return headerPage;
  }
}
