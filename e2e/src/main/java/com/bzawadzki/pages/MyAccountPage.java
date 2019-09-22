package com.bzawadzki.pages;

import com.bzawadzki.pages.assertions.MyAccountPageAssertions;

import java.util.function.Consumer;

import static com.bzawadzki.pages.locators.MyAccountPageLocators.MY_ADDRESSES_LINK;
import static com.bzawadzki.pages.locators.MyAccountPageLocators.PAGE_HEADER;
import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage extends BasePage {

  public MyAccountPage() {
    $(PAGE_HEADER).should(have(text("My account")));
  }

  public MyAddressPage openMyAddress() {
    $(MY_ADDRESSES_LINK).click();
    return new MyAddressPage();
  }

  public MyAccountPage assertThat(Consumer<MyAccountPageAssertions> assertThat) {
    assertThat.accept(new MyAccountPageAssertions());
    return this;
  }

}
