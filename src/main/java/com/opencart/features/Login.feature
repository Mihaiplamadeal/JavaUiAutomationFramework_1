Feature: Login related Test Cases

  @run1
  Scenario: An error message is displayed when using invalid credentials for login flow
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
When the logic form is populated with following details:
  | andrei.secu@gmail.com |  |
  | ParolaGrea123!        |  |
    Then the following list of error messages is displayed
      | Warning: No match for E-Mail Address and/or Password. |  |


