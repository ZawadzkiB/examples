package com.bzawadzki.pages;

import com.bzawadzki.model.AddressData;
import com.bzawadzki.model.PersonalData;
import com.bzawadzki.model.RegistrationData;
import com.bzawadzki.pages.assertions.AccountCreationPageAssertions;
import com.bzawadzki.pages.helpers.RegistrationFiller;

import java.util.function.Consumer;

import static com.bzawadzki.pages.locators.AccountCreationPageLocators.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AccountCreationPage {

  public AccountCreationPage() {
    $(PAGE_HEADER_TEXT_LOCATOR).should(have(text("Create an account")));
  }

  public AccountCreationPage fillFormAndSkipEmail(RegistrationData registrationData) {
    return this.fillForm(registrationData, true);
  }

  public MyAccountPage register() {
    $(REGISTER_BUTTON_LOCATOR).click();
    return new MyAccountPage();
  }

  private AccountCreationPage fillForm(RegistrationData registrationData, Boolean skipEmail) {
    PersonalData personalData = registrationData.getPersonalData();
    AddressData addressData = registrationData.getAddressData();
    fillForm(it -> {
      it.setTitle(personalData.getTitle());
      it.setFirstName(personalData.getFirstName());
      it.setLastName(personalData.getLastName());
      if (!skipEmail)
        it.setEmail(personalData.getEmail());
      it.setDateOfBirth(personalData.getDateOfBirth());
      it.setPassword(personalData.getPassword());
      it.setSignUps(
              personalData.getSignForNewsletter(),
              personalData.getSignForSpecialOffers());
      it.fillAddressData(addressData);
    });
    return this;
  }

  private AccountCreationPage fillForm(Consumer<RegistrationFiller> fillForm) {
    fillForm.accept(new RegistrationFiller());
    return this;
  }

  public AccountCreationPage assertThat(Consumer<AccountCreationPageAssertions> assertThat) {
    assertThat.accept(new AccountCreationPageAssertions());
    return this;
  }

}
