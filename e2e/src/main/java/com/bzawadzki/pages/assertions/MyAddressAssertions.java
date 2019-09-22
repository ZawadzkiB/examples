package com.bzawadzki.pages.assertions;

import com.bzawadzki.model.AddressData;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class MyAddressAssertions {

  public void checkAddressData(AddressData addressData, String alias) {
    AddressData savedAddressData = $$(".address").stream()
            .filter(it -> it.find(".page-subheading").getText().equalsIgnoreCase(alias))
            .map(it ->
                    new AddressData()
                            .setFirstName(it.findAll(".address_name").get(0).getText().trim())
                            .setLastName(it.findAll(".address_name").get(1).getText().trim())
                            .setCompany(it.find(".address_company").getText().trim())
                            .setAddressFirstLine(it.find(".address_address1").getText().trim())
                            .setAddressSecondLine(it.find(".address_address2").getText().trim())
                            .setMobilePhone(it.find(".address_phone_mobile").getText().trim())
                            .setHomePhone(it.find(".address_phone").getText().trim())
                            .setCity(it.find(By.xpath(".//li[5]/span[1]")).getText().replace(",","").trim())
                            .setState(it.find(By.xpath(".//li[5]/span[2]")).getText().trim())
                            .setZipCode(it.find(By.xpath(".//li[5]/span[3]")).getText().trim())
                            .setCountry(it.find(By.xpath(".//li[6]/span[1]")).getText().trim()))
            .findFirst()
            .orElse(new AddressData());

    Assertions.assertThat(addressData).isEqualToComparingOnlyGivenFields(savedAddressData,
            "firstName", "lastName", "company", "addressFirstLine",
            "addressSecondLine", "mobilePhone", "homePhone", "city", "state", "zipCode", "country");
  }

}
