package com.swaglabsmobileapp.testapp.cucumberPackages.utility

import android.graphics.Bitmap
import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import java.io.ByteArrayOutputStream

class Hooks {

    companion object {
        lateinit var device: UiDevice
        const val PACKAGE_NAME = "com.swaglabsmobileapp"
    }

    @Before(order = 0)
    fun setUp() {
        // Initialize the device
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        
        // Wake up the device and go to Home screen
        device.wakeUp()
        device.pressHome()
        
        // Launch the application using targetContext for stability
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = context.packageManager.getLaunchIntentForPackage(PACKAGE_NAME)?.apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        
        if (intent != null) {
            context.startActivity(intent)
        } else {
            throw RuntimeException("Application with package $PACKAGE_NAME is not installed.")
        }
        
        // Wait for the app to be in foreground
        device.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), 15000)
    }

    @After
    fun tearDown(scenario: Scenario) {
        // Capture screenshot if scenario fails
        if (scenario.isFailed) {
            try {
                val bitmap: Bitmap = InstrumentationRegistry.getInstrumentation().uiAutomation.takeScreenshot()
                val stream = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                scenario.attach(stream.toByteArray(), "image/png", "Error_${scenario.name}")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        
        // Force stop app for the next test
        device.executeShellCommand("am force-stop $PACKAGE_NAME")
        device.pressHome()
    }
}
