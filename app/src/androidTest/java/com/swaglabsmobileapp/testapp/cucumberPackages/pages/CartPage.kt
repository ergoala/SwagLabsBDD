package com.swaglabsmobileapp.testapp.cucumberPackages.pages

import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Helper
import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Hooks
import org.junit.Assert.assertTrue

/**
 * Page Object for the Shopping Cart screen.
 */
class CartPage {
    private val helper: Helper

    constructor() {
        // Initialize the helper with the locators for the Cart page
        this.helper = Helper(Hooks.device, "locators/Cart.json")
    }

    /**
     * Verifies that the Cart page is correctly displayed by checking the header.
     */
    fun verifyCartPageIsDisplayed() {
        assertTrue("The cart header is not visible", helper.isElementVisible("CartHeader"))
    }

    /**
     * Clicks on the Checkout button to proceed to the next step.
     */
    fun clickCheckout() {
        helper.clickOnElement("CheckoutButton")
    }

    /**
     * Clicks on the Remove button for a product in the cart.
     */
    fun clickRemove() {
        helper.clickOnElement("RemoveButton")
    }
}
