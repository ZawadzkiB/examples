package com.bzawadzki.tests

import com.bzawadzki.commons.TestCommons
import com.bzawadzki.model.LoginData
import com.bzawadzki.pages.AuthenticationPage
import com.bzawadzki.pages.MyAccountPage
import com.bzawadzki.utils.TestDataReader
import io.github.bonigarcia.wdm.WebDriverManager
import spock.lang.Specification

import static com.bzawadzki.commons.TestCommons.Places.REGISTRATION_PAGE
import static com.codeborne.selenide.Selenide.close

class LoginTest extends Specification {

    LoginData loginData

    def setup() {
        WebDriverManager.chromedriver().setup()
        loginData = TestDataReader.getInstance().readData(LoginData.class)
    }

    def cleanup() {
        close()
    }

    def "login with user"() {

        given: "open registration page"
        AuthenticationPage authenticationPage = TestCommons.open(REGISTRATION_PAGE)

        when: "fill login form and accept"
        MyAccountPage myAccountPage = authenticationPage.login(loginData)

        then: "user should be logged in"
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
                it.checkUsername("$loginData.firstName $loginData.lastName")
            })
        })
    }
}
