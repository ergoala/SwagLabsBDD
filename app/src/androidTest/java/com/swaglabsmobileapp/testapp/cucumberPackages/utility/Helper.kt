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

    fun clickOnElement(elementKey: String, timeout: Long = 10000) {
        val locator = getLocator(elementKey)
        assertNotNull("Locator for '$elementKey' not found in '$locatorResourcePath'", locator)

        val selector = getSelector(locator!!)
        
        var element = device.wait(Until.findObject(selector), timeout)
        if (element == null) {
            scrollToElement(selector)
            element = device.wait(Until.findObject(selector), timeout)
        }
        
        assertNotNull("Element '$elementKey' not found on screen after $timeout ms. Locator: $locator", element)
        element!!.click()
    }

    fun setText(elementKey: String, text: String, timeout: Long = 10000) {
        val locator = getLocator(elementKey)
        assertNotNull("Locator for '$elementKey' not found", locator)

        val selector = getSelector(locator!!)
        val element = device.wait(Until.findObject(selector), timeout)
        assertNotNull("Element '$elementKey' not found for typing. Locator: $locator", element)
        
        element!!.setText(text)
    }

    fun isElementVisible(elementKey: String, timeout: Long = 10000): Boolean {
        val locator = getLocator(elementKey) ?: return false
        val selector = getSelector(locator)
        return device.wait(Until.hasObject(selector), timeout)
    }

    fun isTextVisible(text: String, timeout: Long = 10000): Boolean {
        return device.wait(Until.hasObject(By.text(text)), timeout) || 
               device.wait(Until.hasObject(By.desc(text)), timeout) ||
               device.wait(Until.hasObject(By.textContains(text)), timeout)
    }

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

    private fun scrollToElement(selector: BySelector) {
        device.swipe(500, 1500, 500, 800, 20)
    }
}
