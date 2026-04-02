Feature: Login Functionality

  Background:
    Given User is on the login page

  @positive_test
  Scenario Outline: Successful login with valid credentials
    When User enters username "<username>" and password "<password>"
    And User clicks on the login button
    Then User should be redirected to the products page
    And the products title "PRODUCTS" should be displayed

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @negative_test
  Scenario: Unsuccessful login with invalid credentials
    When User enters username "invalid_user" and password "wrong_password"
    And User clicks on the login button
    Then User should see an error message "Username and password do not match any user in this service"

  @negative_test
  Scenario: Unsuccessful login with locked out user
    When User enters username "locked_out_user" and password "secret_sauce"
    And User clicks on the login button
    Then User should see an error message "Sorry, this user has been locked out"
