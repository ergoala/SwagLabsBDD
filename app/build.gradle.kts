plugins {
    alias(libs.plugins.android.application)
    id("jacoco")
}

android {
    namespace = "com.swaglabsmobileapp.testapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.swaglabsmobileapp.testapp"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.swaglabsmobileapp.testapp.test.TestRunner"
    }

    buildTypes {
        debug {
            enableUnitTestCoverage = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        buildConfig = true
    }
    
    sourceSets {
        getByName("androidTest") {
            assets.srcDirs("src/androidTest/assets")
        }
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.3.0")
    
    androidTestImplementation(libs.cucumber.android)
    androidTestImplementation(libs.cucumber.picocontainer)
    androidTestImplementation(libs.cucumber.junit)
}
