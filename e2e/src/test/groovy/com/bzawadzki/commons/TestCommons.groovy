package com.bzawadzki.commons

import com.bzawadzki.pages.AuthenticationPage
import com.bzawadzki.pages.HomePage

import static com.codeborne.selenide.Selenide.open

class TestCommons {

    private static final BASE_URL = 'http://automationpractice.com/index.php'

    enum Places { REGISTRATION_PAGE, HOME_PAGE }

    def static open(Places places) {
        switch(places) {
            case Places.HOME_PAGE: open(BASE_URL)
                return new HomePage()
            case Places.REGISTRATION_PAGE: open("$BASE_URL?controller=authentication&back=my-account")
                return new AuthenticationPage()
        }

    }
}
