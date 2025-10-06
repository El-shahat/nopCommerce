@regression
Feature: SignUp: this feature allow to guest users to create a new account

  Background: shared steps

    Given user click on register button

#Positive Scenario
  @signUp
  Scenario Outline:guest user could create a valid account P
    When user enter genderType "<type>"
    And user enter first and last name
    And user enter an email "<email>"
    And user enter company name "<Company name>"
    And user click on Newsletter checkBox "<role>"
    And user enter a password
    And user enter a confirm password
    And user click on SignUp
    Then new account is created successfully
    Examples:
    |Company name|    type   |   role     |email|
    |    AMIT    |    male   |  dont click|     |
    |     Null   |   female  |  click     |     |
@negative
  Scenario Outline:guest user could not create an invalid account N
    When user enter genderType "<type>"
    And user enter first and last name
    And user enter an email "<invalid email>"
    And user enter company name "<Company name>"
    And user click on Newsletter checkBox "<role>"
    And user enter an invalid password "<invalid password>"
    And user enter an invalid confirm password "<invalid confirm password>"
    And user click on SignUp
    Then user couldn`t create an invalid account
    Examples:
      |Company name|    type   |   role     |  invalid email  |    invalid password                                                   |invalid confirm password    |
      |    AMIT    |    male   |  dont click|  ahmedgmail.com |      12345                                                            |    round1                  |
      |            |   female  |  click     |  ahmed@gmail    |      1234567891234567891234567891234567891234567891234567891234567891 |    round2                  |
      |            |    none   |            |      @gmail.com |      blank password field                                             |    round 3                 |
