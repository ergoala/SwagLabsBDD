package com.swaglabsmobileapp.testapp.cucumberPackages.utility

import androidx.test.platform.app.InstrumentationRegistry
import org.json.JSONObject
import java.io.InputStream

class JsonLocators {

    fun getLocator(filePath: String, elementKey: String, locatorType: String = "xpath"): String? {
        return try {
            val jsonString = readJsonFromAssets(filePath)
            if (jsonString.isEmpty()) return null
            val jsonObject = JSONObject(jsonString)
            
            if (jsonObject.has(elementKey)) {
                val elementObject = jsonObject.getJSONObject(elementKey)
                if (elementObject.has(locatorType)) {
                    elementObject.getString(locatorType)
                } else null
            } else null
        } catch (e: Exception) {
            null
        }
    }

    private fun readJsonFromAssets(filePath: String): String {
        return try {
            // Intentar con el contexto de instrumentación (donde suelen estar los assets de test)
            val testContext = InstrumentationRegistry.getInstrumentation().context
            testContext.assets.open(filePath).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            try {
                // Intentar con el contexto de la aplicación
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                targetContext.assets.open(filePath).bufferedReader().use { it.readText() }
            } catch (e2: Exception) {
                ""
            }
        }
    }
}
