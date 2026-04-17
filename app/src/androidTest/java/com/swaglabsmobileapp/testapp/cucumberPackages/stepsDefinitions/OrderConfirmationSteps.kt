package com.swaglabsmobileapp.testapp.cucumberPackages.stepsDefinitions

import com.swaglabsmobileapp.testapp.cucumberPackages.pages.OrderConfirmationPage
import io.cucumber.java.en.Then


class OrderConfirmationSteps {

    private val confirmationPage = OrderConfirmationPage()


    @Then("User should see the {string} confirmation message")
    fun user_should_see_confirmation_message(expectedMsg: String) {
        confirmationPage.verifyConfirmationIsDisplayed()
    }

}