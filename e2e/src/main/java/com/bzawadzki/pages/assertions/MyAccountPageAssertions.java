package com.bzawadzki.pages.assertions;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.bzawadzki.pages.locators.MyAccountPageLocators.MY_ACCOUNT_LINKS;
import static com.bzawadzki.pages.locators.MyAccountPageLocators.SHOPPING_CART_ELEMENT;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MyAccountPageAssertions {


  public void cartShouldBeVisible() {
    $(SHOPPING_CART_ELEMENT).shouldBe(visible);
  }

  public void accountLinkListShouldContains(String... elements) {
    List<String> linkElements = $$(MY_ACCOUNT_LINKS)
            .stream().map(SelenideElement::getText).collect(Collectors.toList());
    org.assertj.core.api.Assertions.assertThat(linkElements).contains(elements);
  }
}
