package com.bzawadzki.tests

import com.bzawadzki.commons.TestCommons
import com.bzawadzki.model.RegistrationData
import com.bzawadzki.pages.AccountCreationPage
import com.bzawadzki.pages.MyAccountPage
import com.bzawadzki.utils.TestDataReader
import io.github.bonigarcia.wdm.WebDriverManager
import spock.lang.Specification

import static com.bzawadzki.commons.TestCommons.Places.REGISTRATION_PAGE
import static com.codeborne.selenide.Selenide.close

class RegistrationTest extends Specification {

    RegistrationData registrationData

    def setup() {
        WebDriverManager.chromedriver().setup()
        registrationData = TestDataReader.getInstance().readData(RegistrationData.class)
    }

    def cleanup() {
        close()
    }

    def "registering a new user"() {

        given: "open registration page with new random email"
        String email = UUID.randomUUID().toString()+"@mailinator.com"
        AccountCreationPage accountCreationPage = TestCommons.open(REGISTRATION_PAGE)
                .createAnAccount(email)
                .assertThat { it.emailInFormIsCorrect(email) }

        when: "fill form with default data and send"
        MyAccountPage myAccountPage = accountCreationPage
                .fillFormAndSkipEmail(registrationData)
                .register()

        then: "account should be created"
        myAccountPage.assertThat( {
            it.cartShouldBeVisible()
            it.accountLinkListShouldContains(
                    "ORDER HISTORY AND DETAILS",
                    "MY CREDIT SLIPS",
                    "MY ADDRESSES",
                    "MY PERSONAL INFORMATION",
                    "MY WISHLISTS"
            )
        }).onPageHeader({
            it.assertThat({
                it.checkUsername("$registrationData.personalData.firstName $registrationData.personalData.lastName")
            })
        })
    }

}
