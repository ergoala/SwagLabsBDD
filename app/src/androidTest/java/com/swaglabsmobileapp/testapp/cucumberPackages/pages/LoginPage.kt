package com.swaglabsmobileapp.testapp.cucumberPackages.pages

import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Helper
import com.swaglabsmobileapp.testapp.cucumberPackages.utility.Hooks
import org.junit.Assert.assertTrue

/**
 * Page Object for the Login screen.
 */
class LoginPage {
    private val helper: Helper

    constructor() {
        // Initialize the helper with the locators for the Login page
        this.helper = Helper(Hooks.device, "locators/Login.json")
    }

    /**
     * Enters the provided username and password into the corresponding fields.
     */
    fun enterCredentials(username: String, password: String) {
        helper.setText("UsernameField", username)
        helper.setText("PasswordField", password)
    }

    /**
     * Clicks on the Login button.
     */
    fun clickLogin() {
        helper.clickOnElement("LoginButton")
    }
    
    /**
     * Verifies that the Login page is currently displayed.
     */
    fun verifyIsDisplayed() {
        assertTrue("Login page was not found", helper.isElementVisible("UsernameField"))
    }

    /**
     * Verifies that the expected error message is displayed on the screen.
     */
    fun verifyErrorMessage(expectedMessage: String) {
        assertTrue("Error message '$expectedMessage' is not visible", helper.isTextVisible(expectedMessage))
    }
}
