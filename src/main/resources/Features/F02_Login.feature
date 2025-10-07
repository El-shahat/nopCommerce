@regression
  Feature: Login-this feature allow to user to login to his own account

    Background: shared steps for login page
      Given user click on login button
    @sc1
    Scenario Outline: user could login to his account with valid credentials login
        When user enter a valid email
        And user enter a valid password
        And click on remember me checkbox"<role>"
        And click on login button
        Then user could login successfully
      Examples:
      |   role    |
      |   click   |
      |don`t click|