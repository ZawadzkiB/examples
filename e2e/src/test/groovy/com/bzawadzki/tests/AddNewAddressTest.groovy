package com.bzawadzki.tests

import com.bzawadzki.commons.TestCommons
import com.bzawadzki.model.LoginData
import com.bzawadzki.model.RegistrationData
import com.bzawadzki.pages.MyAccountPage
import com.bzawadzki.pages.MyAddressPage
import com.bzawadzki.utils.TestDataReader
import io.github.bonigarcia.wdm.WebDriverManager
import spock.lang.Specification

import static com.bzawadzki.commons.TestCommons.Places.REGISTRATION_PAGE
import static com.codeborne.selenide.Selenide.close

class AddNewAddressTest extends Specification{

    LoginData loginData
    RegistrationData registrationData

    def setup() {
        WebDriverManager.chromedriver().setup()
        loginData = TestDataReader.getInstance().readData(LoginData.class)
        registrationData = TestDataReader.getInstance().readData(RegistrationData.class)
    }

    def cleanup() {
        close()
    }

    def "add new address test"() {

        given: "logged in user"
        MyAccountPage myAccountPage = TestCommons.open(REGISTRATION_PAGE)
                .login(loginData)

        when: "new address is added"
        String alias = UUID.randomUUID().toString().substring(4)
        MyAddressPage myAddressPage = myAccountPage
                .openMyAddress()
                .addNewAddress(registrationData.addressData, alias)

        then: "new address should be visible and have correct data"
        myAddressPage.assertThat({
            it.checkAddressData(registrationData.addressData, alias)
        }).removeAddress(alias)
    }
}
