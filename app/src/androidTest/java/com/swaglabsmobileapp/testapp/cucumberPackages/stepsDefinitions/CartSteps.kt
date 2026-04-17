package com.swaglabsmobileapp.testapp.cucumberPackages.stepsDefinitions

import com.swaglabsmobileapp.testapp.cucumberPackages.pages.CartPage
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class CartSteps {

    private val cartPage = CartPage()

    @Then("User should see the product in the cart")
    fun user_should_see_the_product_in_the_cart() {
        cartPage.verifyCartPageIsDisplayed()
    }

    @When("User clicks on the {string} button")
    fun user_clicks_on_action_button(buttonName: String) {
        when (buttonName.uppercase()) {
            "CHECKOUT" -> cartPage.clickCheckout()
        }
    }

}