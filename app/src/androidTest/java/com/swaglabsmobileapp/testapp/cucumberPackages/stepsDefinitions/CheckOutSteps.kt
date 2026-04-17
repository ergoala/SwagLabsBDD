package com.swaglabsmobileapp.testapp.cucumberPackages.stepsDefinitions

import com.swaglabsmobileapp.testapp.cucumberPackages.pages.CheckoutPage
import io.cucumber.java.en.When

class CheckOutSteps {

    private val checkoutPage = CheckoutPage()


    @When("User clicks on the {string} button in Checkout page")
    fun user_clicks_on_action_button(buttonName: String) {
        when (buttonName.uppercase()) {
            "CONTINUE" -> checkoutPage.clickContinue()

        }
    }

    @When("User enters checkout information with first name {string}, last name {string} and zip code {string}")
    fun user_enters_checkout_info(first: String, last: String, zip: String) {
        checkoutPage.enterCheckoutInfo(first, last, zip)
    }


}