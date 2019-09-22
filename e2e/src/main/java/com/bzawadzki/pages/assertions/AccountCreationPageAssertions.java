package com.bzawadzki.pages.assertions;

import static com.bzawadzki.pages.locators.AccountCreationPageLocators.EMAIL_INPUT_LOCATOR;
import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class AccountCreationPageAssertions {

  public void emailInFormIsCorrect(String emailUsedForRegistration) {
    $(EMAIL_INPUT_LOCATOR).should(have(value(emailUsedForRegistration)));
  }

}
