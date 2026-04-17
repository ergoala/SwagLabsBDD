package com.swaglabsmobileapp.testapp.cucumberPackages.stepsDefinitions

import com.swaglabsmobileapp.testapp.cucumberPackages.pages.ProductsPage
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class ProductsSteps {

    private val productsPage = ProductsPage()

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



}