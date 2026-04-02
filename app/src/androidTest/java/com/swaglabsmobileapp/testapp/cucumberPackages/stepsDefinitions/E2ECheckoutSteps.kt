package com.swaglabsmobileapp.testapp.cucumberPackages.stepsDefinitions

import com.swaglabsmobileapp.testapp.cucumberPackages.pages.*
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class E2ECheckoutSteps {

    private val loginPage = LoginPage()
    private val productsPage = ProductsPage()
    private val cartPage = CartPage()
    private val checkoutPage = CheckoutPage()
    private val overviewPage = OverviewPage()
    private val confirmationPage = OrderConfirmationPage()

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

    @Then("User should be redirected to the products page")
    fun user_should_be_redirected_to_the_products_page() {
        productsPage.verifyProductsPageIsDisplayed()
    }

    @Given("the products title {string} should be displayed")
    fun the_products_title_should_be_displayed(title: String) {
        productsPage.verifyProductsPageIsDisplayed()
    }

    @When("User adds the first product to the cart")
    fun user_adds_the_first_product_to_the_cart() {
        productsPage.addToCartFirstItem()
    }

    @When("User clicks on the shopping cart icon")
    fun user_clicks_on_the_shopping_cart_icon() {
        productsPage.clickCartIcon()
    }

    @Then("User should see the product in the cart")
    fun user_should_see_the_product_in_the_cart() {
        cartPage.verifyCartPageIsDisplayed()
    }

    @When("User clicks on the {string} button")
    fun user_clicks_on_action_button(buttonName: String) {
        when (buttonName.uppercase()) {
            "CHECKOUT" -> cartPage.clickCheckout()
            "CONTINUE" -> checkoutPage.clickContinue()
            "FINISH" -> overviewPage.clickFinish()
        }
    }

    @When("User enters checkout information with first name {string}, last name {string} and zip code {string}")
    fun user_enters_checkout_info(first: String, last: String, zip: String) {
        checkoutPage.enterCheckoutInfo(first, last, zip)
    }

    @Then("User should see the {string} page")
    fun user_should_see_page(pageTitle: String) {
        when (pageTitle.uppercase()) {
            "CHECKOUT: OVERVIEW" -> overviewPage.verifyOverviewPageIsDisplayed()
        }
    }

    @Then("User should see the {string} confirmation message")
    fun user_should_see_confirmation_message(expectedMsg: String) {
        confirmationPage.verifyConfirmationIsDisplayed()
    }

    @Then("User should see an error message {string}")
    fun user_should_see_an_error_message(errorMessage: String) {
        loginPage.verifyErrorMessage(errorMessage)
    }
}
