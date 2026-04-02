package com.swaglabsmobileapp.testapp.cucumberPackages.pages

import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Helper
import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Hooks
import org.junit.Assert.assertTrue

/**
 * Page Object for the Checkout Information screen.
 */
class CheckoutPage {
    private val helper: Helper

    constructor() {
        // Initialize the helper with the locators for the Checkout page
        this.helper = Helper(Hooks.device, "locators/Checkout.json")
    }

    /**
     * Verifies that the Checkout Information page header is visible.
     */
    fun verifyCheckoutPageIsDisplayed() {
        assertTrue("The Checkout Information header is not visible", helper.isElementVisible("CheckoutInfoHeader"))
    }

    /**
     * Enters the user information required for checkout.
     * @param firstName User's first name
     * @param lastName User's last name
     * @param zipCode User's postal code
     */
    fun enterCheckoutInfo(firstName: String, lastName: String, zipCode: String) {
        helper.setText("FirstNameField", firstName)
        helper.setText("LastNameField", lastName)
        helper.setText("ZipCodeField", zipCode)
    }

    /**
     * Clicks on the Continue button to proceed to the overview page.
     */
    fun clickContinue() {
        helper.clickOnElement("ContinueButton")
    }

    /**
     * Clicks on the Cancel button to return to the cart.
     */
    fun clickCancel() {
        helper.clickOnElement("CancelButton")
    }
}
