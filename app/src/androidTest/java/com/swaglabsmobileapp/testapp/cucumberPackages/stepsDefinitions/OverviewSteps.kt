package com.swaglabsmobileapp.testapp.cucumberPackages.stepsDefinitions

import com.swaglabsmobileapp.testapp.cucumberPackages.pages.OverviewPage
import io.cucumber.java.en.Then
import io.cucumber.java.en.When


class OverviewSteps {

    private val overviewPage = OverviewPage()

    @Then("User should see the {string} page")
    fun user_should_see_page(pageTitle: String) {
        when (pageTitle.uppercase()) {
            "CHECKOUT: OVERVIEW" -> overviewPage.verifyOverviewPageIsDisplayed()
        }
    }


    @When("User clicks on the {string} button in Overview page")
    fun user_clicks_on_action_button(buttonName: String) {
        when (buttonName.uppercase()) {
            "FINISH" -> overviewPage.clickFinish()
        }
    }

}