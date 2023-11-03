@run
Feature: Register Flow Test Suite

  Background:
    Given "/index.php?route=account/register" endpoint is accessed

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

    And registerLink from Header menu is clicked
    When the register form is populated with valid random data
    Then The current url contains "route=account/register" keyword

  @run
  Scenario Outline: An error message is displayed when invalid <impacted attribute> is used for register flow

    And  the register form is populated with the following data:
      | firstName | <firstName>    |
      | lastName  | <lastName>     |
      | email     | <emailData>    |
      | password  | <passwordData> |
    When   Continue button is clicked
    Then the following list of error messages is displayed
      | <impacted attribute> must be between 1 and 32 characters! |
    Examples:
      | impacted attribute | firstName                      | lastName                       | emailData | passwordData |
      | First Name         | 3212312312 3213123123123122131 | Random                         | Random    | Random       |
      | Last Name          | Random                         | 3212312312 3213123123123122131 | Random    | Random       |
