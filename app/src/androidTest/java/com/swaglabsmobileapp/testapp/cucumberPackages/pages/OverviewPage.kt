package com.swaglabsmobileapp.testapp.cucumberPackages.pages

import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Helper
import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Hooks
import org.junit.Assert.assertTrue

/**
 * Page Object for the Checkout Overview screen.
 */
class OverviewPage {
    private val helper: Helper

    constructor() {
        // Initialize the helper with the locators for the Overview page
        this.helper = Helper(Hooks.device, "locators/Overview.json")
    }

    /**
     * Verifies that the Checkout Overview page header is visible.
     */
    fun verifyOverviewPageIsDisplayed() {
        assertTrue("The Checkout Overview header is not visible", helper.isElementVisible("OverviewHeader"))
    }

    /**
     * Clicks on the Finish button to complete the order.
     */
    fun clickFinish() {
        helper.clickOnElement("FinishButton")
    }

    /**
     * Clicks on the Cancel button to return to the previous page.
     */
    fun clickCancel() {
        helper.clickOnElement("CancelButton")
    }
}
