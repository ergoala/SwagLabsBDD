package com.swaglabsmobileapp.testapp.cucumberPackages.stepsDefinitions

import com.swaglabsmobileapp.testapp.cucumberPackages.pages.LoginPage
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class LoginSteps {

    private val loginPage = LoginPage()


    @Given("User is on the login page")
    fun user_is_on_the_login_page() {
        loginPage.verifyIsDisplayed()
    }

    @When("User enters username {string} and password {string}")
    fun user_enters_username_and_password(user: String, pass: String) {
        loginPage.enterCredentials(user, pass)
    }

    @When("User clicks on the login button")
    fun user_clicks_on_the_login_button() {
        loginPage.clickLogin()
    }


    @Then("User should see an error message {string}")
    fun user_should_see_an_error_message(errorMessage: String) {
        loginPage.verifyErrorMessage(errorMessage)
    }
}
