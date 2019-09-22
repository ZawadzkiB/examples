package com.bzawadzki.pages.assertions;

import com.codeborne.selenide.Condition;

import static com.bzawadzki.pages.locators.HeaderPageLocators.USERNAME_LINK;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPageAssertions {

  public void checkUsername(String usernameAndLastname) {
    $(USERNAME_LINK).shouldHave(Condition.text(usernameAndLastname));
  }

}
