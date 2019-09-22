package com.bzawadzki.pages;

import com.bzawadzki.model.LoginData;
import com.codeborne.selenide.Condition;

import static com.bzawadzki.pages.locators.AuthenticationPageLocators.*;
import static com.codeborne.selenide.Selenide.$;

public class AuthenticationPage {

  public AuthenticationPage() {
    $(PAGE_HEADER_TEXT_LOCATOR).should(Condition.have(Condition.text("Authentication")));
  }

  public AccountCreationPage createAnAccount(String email) {
    $(CREATE_ACCOUNT_EMAIL_INPUT_LOCATOR).shouldBe(Condition.visible).setValue(email);
    $(CREATE_ACCOUNT_BUTTON_LOCATOR).shouldBe(Condition.visible).click();
    return new AccountCreationPage();
  }

  public MyAccountPage login(LoginData loginData){
    $("#email").setValue(loginData.getEmail());
    $("#passwd").setValue(loginData.getPassword());
    $("#SubmitLogin").click();
    return new MyAccountPage();
  }
}
