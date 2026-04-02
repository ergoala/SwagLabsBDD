package com.swaglabsmobileapp.testapp.cucumberPackages.utility

import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert.assertNotNull

class Helper(private val device: UiDevice, private val locatorResourcePath: String) {
    
    private val locatorStore = JsonLocators()

    fun getLocator(elementKey: String): String? {
        return locatorStore.getLocator(locatorResourcePath, elementKey)
    }

    /**
     * Generic method to click on an element based on its JSON key.
     * @param elementKey Key of the element in the JSON file.
     * @param timeout Maximum wait time in milliseconds.
     */
    fun clickOnElement(elementKey: String, timeout: Long = 5000) {
        val locator = getLocator(elementKey)
        assertNotNull("Locator for '$elementKey' not found in '$locatorResourcePath'", locator)

        val selector = getSelector(locator!!)
        
        // Try to find the object, if not visible, attempt to scroll
        var element = device.wait(Until.findObject(selector), timeout)
        if (element == null) {
            scrollToElement(selector)
            element = device.wait(Until.findObject(selector), timeout)
        }
        
        assertNotNull("Element '$elementKey' not found on screen after $timeout ms", element)
        element!!.click()
    }

    /**
     * Generic method to set text in an input field.
     * @param elementKey Key of the element in the JSON file.
     * @param text Text to be entered.
     */
    fun setText(elementKey: String, text: String, timeout: Long = 5000) {
        val locator = getLocator(elementKey)
        assertNotNull("Locator for '$elementKey' not found", locator)

        val selector = getSelector(locator!!)
        val element = device.wait(Until.findObject(selector), timeout)
        assertNotNull("Element '$elementKey' not found for typing", element)
        
        element!!.setText(text)
    }

    /**
     * Validates if a specific element from JSON is visible.
     */
    fun isElementVisible(elementKey: String, timeout: Long = 5000): Boolean {
        val locator = getLocator(elementKey) ?: return false
        val selector = getSelector(locator)
        return device.wait(Until.hasObject(selector), timeout)
    }

    /**
     * Validates if a specific text is visible on screen.
     */
    fun isTextVisible(text: String, timeout: Long = 5000): Boolean {
        return device.wait(Until.hasObject(By.text(text)), timeout) || 
               device.wait(Until.hasObject(By.desc(text)), timeout)
    }

    /**
     * Converts a locator string (simplified XPath) to a UI Automator BySelector.
     */
    private fun getSelector(locator: String): BySelector {
        return when {
            locator.contains("@content-desc='") -> {
                val value = locator.substringAfter("@content-desc='").substringBefore("'")
                By.desc(value)
            }
            locator.contains("@text='") -> {
                val value = locator.substringAfter("@text='").substringBefore("'")
                By.text(value)
            }
            else -> By.desc(locator)
        }
    }

    /**
     * Basic implementation of scroll down to find elements.
     */
    private fun scrollToElement(selector: BySelector) {
        device.swipe(500, 1500, 500, 500, 20)
    }
}
