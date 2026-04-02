package com.swaglabsmobileapp.testapp.cucumberPackages.pages

import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Helper
import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Hooks
import org.junit.Assert.assertTrue

/**
 * Page Object for the Products screen.
 * Handles interactions and validations for the main product listing.
 */
class ProductsPage {
    private val helper: Helper

    /**
     * Initializes the page with the specific locators for products.
     */
    constructor() {
        // Initialize the helper with the locators for the Products page
        this.helper = Helper(Hooks.device, "locators/Products.json")
    }

    /**
     * Verifies that the Products page is correctly displayed by checking the header.
     */
    fun verifyProductsPageIsDisplayed() {
        assertTrue("The products header is not visible", helper.isElementVisible("ProductsHeader"))
    }
    
    /**
     * Adds the first product item in the list to the shopping cart.
     */
    fun addToCartFirstItem() {
        helper.clickOnElement("AddToCartButton")
    }
    
    /**
     * Clicks on the shopping cart icon to navigate to the cart screen.
     */
    fun clickCartIcon() {
        helper.clickOnElement("CartButton")
    }
}
