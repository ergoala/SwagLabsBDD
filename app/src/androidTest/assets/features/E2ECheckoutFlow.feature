Feature: End-to-End Checkout Flow

  Background:
    Given User is on the login page
    When User enters username "standard_user" and password "secret_sauce"
    And User clicks on the login button
    Then User should be redirected to the products page

  Scenario: Complete a purchase from product selection to confirmation
    Given the products title "PRODUCTS" should be displayed
    When User adds the first product to the cart
    And User clicks on the shopping cart icon
    Then User should see the product in the cart
    When User clicks on the "CHECKOUT" button
    And User enters checkout information with first name "John", last name "Doe" and zip code "12345"
    And User clicks on the "CONTINUE" button
    Then User should see the "CHECKOUT: OVERVIEW" page
    When User clicks on the "FINISH" button
    Then User should see the "THANK YOU FOR YOU ORDER" confirmation message
