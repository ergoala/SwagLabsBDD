package com.swaglabsmobileapp.testapp.cucumberPackages.pages

import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Helper
import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Hooks
import org.junit.Assert.assertTrue

/**
 * Page Object for the Order Confirmation screen.
 */
class OrderConfirmationPage {
    private val helper: Helper

    constructor() {
        // Initialize the helper with the locators for the Order Confirmation page
        this.helper = Helper(Hooks.device, "locators/OrderConfirmation.json")
    }

    /**
     * Verifies that the order confirmation message is visible.
     */
    fun verifyConfirmationIsDisplayed() {
        assertTrue("The order confirmation message is not visible", helper.isElementVisible("ThankYouMessage"))
    }

    /**
     * Clicks on the Back Home button to return to the products screen.
     */
    fun clickBackHome() {
        helper.clickOnElement("BackHomeButton")
    }
}
