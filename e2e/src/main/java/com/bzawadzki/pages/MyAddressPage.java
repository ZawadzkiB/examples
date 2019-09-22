package com.bzawadzki.pages;

import com.bzawadzki.model.AddressData;
import com.bzawadzki.pages.assertions.MyAddressAssertions;
import com.bzawadzki.pages.helpers.RegistrationFiller;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import java.util.function.Consumer;

import static com.bzawadzki.pages.locators.MyAddressPageLocators.ADD_ADDRESS_LOCATOR;
import static com.bzawadzki.pages.locators.MyAddressPageLocators.SUBMIT_ADDRESS_BUTTON_LOCATOR;
import static com.codeborne.selenide.Selenide.*;

public class MyAddressPage extends BasePage {

  public MyAddressPage addNewAddress(AddressData addressData, String alias){
    $(ADD_ADDRESS_LOCATOR).click();
    fillAddressDataForm(it -> {
      it.fillAddressData(addressData);
      it.setAddressAlias(alias);
    });
    $(SUBMIT_ADDRESS_BUTTON_LOCATOR).click();
    return this;
  }

  public MyAddressPage removeAddress(String alias){
    $$(".address").stream()
            .filter(it -> it.find(".page-subheading").getText().equalsIgnoreCase(alias))
            .findFirst().orElseThrow(NotFoundException::new).find(By.xpath(".//a[@title='Delete']")).click();
    confirm();
    return this;
  }

  private MyAddressPage fillAddressDataForm(Consumer<RegistrationFiller> fill){
    fill.accept(new RegistrationFiller());
    return this;
  }

  public MyAddressPage assertThat(Consumer<MyAddressAssertions> asertThat){
    asertThat.accept(new MyAddressAssertions());
    return this;
  }
}
