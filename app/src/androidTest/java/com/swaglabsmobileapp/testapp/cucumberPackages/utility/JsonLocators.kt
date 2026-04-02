package com.swaglabsmobileapp.testapp.cucumberPackages.utility

import androidx.test.platform.app.InstrumentationRegistry
import org.json.JSONObject
import java.io.InputStream

class JsonLocators {

    /**
     * Retrieves the locator value (e.g., xpath) from a JSON file in assets.
     * @param filePath Relative path to the file (e.g., "locators/Login.json")
     * @param elementKey Name of the element (e.g., "UsernameField")
     * @param locatorType Type of locator (defaults to "xpath")
     * @return The locator value or null if not found
     */
    fun getLocator(filePath: String, elementKey: String, locatorType: String = "xpath"): String? {
        return try {
            val jsonString = readJsonFromAssets(filePath)
            val jsonObject = JSONObject(jsonString)
            
            if (jsonObject.has(elementKey)) {
                val elementObject = jsonObject.getJSONObject(elementKey)
                if (elementObject.has(locatorType)) {
                    elementObject.getString(locatorType)
                } else null
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Reads a JSON file from the assets folder.
     */
    private fun readJsonFromAssets(filePath: String): String {
        return try {
            val context = InstrumentationRegistry.getInstrumentation().context
            val inputStream: InputStream = context.assets.open(filePath)
            inputStream.bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
}
