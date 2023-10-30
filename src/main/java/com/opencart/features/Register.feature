Feature: Register Flow Test Suite
  Scenario: Register Page can be accessed from the Home Page
    Given HomePage is displayed
    When registerLink from Header menu is clicked
    Then The current url contains "route=account/register" keyword


    Scenario: The Account Page Url is opened when the registration is successful
      Given HomePage is displayed
      And registerLink from Header menu is clicked
      When the register form is populated with valid random data
      And Continue button is clicked
      Then The current url contains "route=account/success" keyword

      Scenario: User remains on the registerPage when the continue button is not clicked
        Given "/" endpoint is accessed
        And registerLink from Header menu is clicked
        When the register form is populated with valid random data
        Then The current url contains "route=account/register" keyword
