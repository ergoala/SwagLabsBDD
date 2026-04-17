package com.swaglabsmobileapp.testapp.test

import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = ["features"],
    glue = ["com.swaglabsmobileapp.testapp.cucumberPackages"],
    tags = "@E2E",
    plugin = ["pretty"]
)

class TestRunner : CucumberAndroidJUnitRunner()
