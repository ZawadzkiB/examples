package com.bzawadzki.pages.helpers;

import com.bzawadzki.model.AddressData;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

import static com.bzawadzki.pages.locators.AccountCreationPageLocators.*;
import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class RegistrationFiller {

  public void setTitle(String title) {
    switch (title) {
      case "Mr":
        $(TITLE_MR_RADIO_LOCATOR).click();
        break;
      case "Mrs":
        $(TITLE_MRS_RADIO_LOCATOR).click();
        break;
      default:
        log.info("Title should be Mr or Mrs none of those was selected");
    }
  }

  public void setFirstName(String firstName) {
    $(FIRST_NAME_INPUT_LOCATOR).setValue(firstName);
  }

  public void setLastName(String lastName) {
    $(LAST_NAME_INPUT_LOCATOR).setValue(lastName);
  }

  public void setEmail(String email) {
    if (!email.isBlank() || !email.equals($(EMAIL_INPUT_LOCATOR).getValue())) {
      $(EMAIL_INPUT_LOCATOR).setValue(email);
    }
  }

  public void setPassword(String password) {
    $(PASSWORD_INPUT_LOCATOR).setValue(password);
  }

  public void setDateOfBirth(LocalDate date) {
    $(DATE_DAY_INPUT_LOCATOR).selectOptionByValue(String.valueOf(date.getDayOfMonth()));
    $(DATE_MONTH_INPUT_LOCATOR).selectOptionByValue(String.valueOf(date.getMonthValue()));
    $(DATE_YEAR_INPUT_LOCATOR).selectOptionByValue(String.valueOf(date.getYear()));
  }

  public void setSignUps(Boolean newsletter, Boolean specialOffer) {
    if (newsletter)
      $(SIGN_FOR_NEWSLETTER_CHECK_BOX_LOCATOR).click();
    if (specialOffer)
      $(SIGN_FOR_SPECIAL_OFFER_CHECK_BOX_LOCATOR).click();
  }

  public void setAddressFirstName(String firstName) {
    $(FIRSTNAME_ADDRESS_INPUT_LOCATOR).setValue(firstName);
  }

  public void setAddressLastName(String lastName) {
    $(LASTNAME_ADDRESS_INPUT_LOCATOR).setValue(lastName);
  }

  public void setCompany(String company) {
    $(COMPANY_INPUT_LOCATOR).setValue(company);
  }

  public void setAddress(String address) {
    $(ADDRESS_LINE1_INPUT_LOCATOR).setValue(address);
  }

  public void setAddressLineTwo(String address) {
    $(ADDRESS_LINE2_INPUT_LOCATOR).setValue(address);
  }

  public void setCity(String city) {
    $(CITY_INPUT_LOCATOR).setValue(city);
  }

  public void setState(String state) {
    $(STATE_SELECT_LOCATOR).selectOptionContainingText(state);
  }

  public void setZipCode(String zipCode) {
    $(ZIP_CODE_INPUT_LOCATOR).setValue(zipCode);
  }

  public void setCountry(String country) {
    $(COUNTRY_SELECT_LOCATOR).selectOptionContainingText(country);
  }

  public void setAdditionalInfo(String additionalInfo) {
    $(ADDITIONAL_INFO_INPUT_LOCATOR).setValue(additionalInfo);
  }

  public void setHomePhone(String homePhone) {
    $(PHONE_INPUT_LOCATOR).setValue(homePhone);
  }

  public void setMobilePhone(String mobilePhone) {
    $(PHONE_MOBILE_INPUT_LOCATOR).setValue(mobilePhone);
  }

  public void setAddressAlias(String addressAlias) {
    $(ADDRESS_ALIAS_LOCATOR).setValue(addressAlias);
  }

  public void fillAddressData(AddressData addressData){
    setAddressFirstName(addressData.getFirstName());
    setAddressLastName(addressData.getLastName());
    setCompany(addressData.getCompany());
    setAddress(addressData.getAddressFirstLine());
    setAddressLineTwo(addressData.getAddressSecondLine());
    setCity(addressData.getCity());
    setState(addressData.getState());
    setZipCode(addressData.getZipCode());
    setCountry(addressData.getCountry());
    setAdditionalInfo(addressData.getAdditionalInformation());
    setHomePhone(addressData.getHomePhone());
    setMobilePhone(addressData.getMobilePhone());
    setAddressAlias(addressData.getAddressAlias());
  }
}