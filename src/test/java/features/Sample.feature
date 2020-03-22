Feature: As a user
  I want to have an ability verify components and modules on Login Page

  Scenario: Login into account with incorrect credentials
    Given User navigated to Login Page
    When User clicks on Login button on Homepage
    And User enters the invalid Username
    And User enters the invalid Password
    And User clicks on the Login button
    Then User should sees the error message with text bellow:
      """
      The email is not a valid email address.
      """