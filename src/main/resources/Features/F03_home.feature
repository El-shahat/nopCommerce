@regression
  Feature: this feature allow to registered user or guest to user to see and add different products and awares with new news

@smoke
  Scenario: user could find  some product
    Given user scroll down to see products
    When user click on his desired product
    Then the product page is displayed

  @smoke
  Scenario: guest user or registered user could add product to his own cart
    Given user scroll down to see products
    When user click on add to cart button
    Then product successfully added to his own cart


  @smoke
  Scenario: guest user could add product to compare list
    Given user scroll down to see products
    When user click on compare list button
    Then product has been added successfully to compare list

  @smoke
  Scenario: guest user could add product to wishlist
    Given user scroll down to see products
    When user click on wishlist button
    Then product has been added successfully to wishlist

  @smoke
  Scenario Outline: guest user could add build to order product to wish list
    Given user scroll down to see products
    When user click on wishlist button
    And select configuration of product "<RAM>" "<PROCESSOR>" "<HDD>"
    And click add to wish list
    Then the product has been added successfully
    Examples:
    | RAM  | PROCESSOR                                           |   HDD    |
    |   2  |    2.2 GHz Intel Pentium Dual-Core E2200            |   320    |
    |   4  |    2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]  |   400    |
    |   8  |      -----                                          |  ---     |
  @smoke
  Scenario Outline: guest user could add build to order product to his own cart
    Given user scroll down to see products
    When user click on add to cart  button
    And select configuration of product "<RAM>" "<PROCESSOR>" "<HDD>"
    And user click on add to cart
    Then the product has been added successfully
    Examples:
      | RAM  | PROCESSOR                                           |   HDD    |
      |   2  |    2.2 GHz Intel Pentium Dual-Core E2200            |   320    |
      |   4  |    2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]  |   400    |
      |   8  |      -----                                          |  ---     |

@smoke
Scenario: Verify that Main Menu is displayed and clickable when user navigate to nopCommerece.com
  Given user navigate to nopCommerce
  Then Main Menu is displayed

@smoke
Scenario Outline: Verify that each elements in Main Menu navigate to related page
  Given user navigate to nopCommerce
  When user click on menu item "<menu item>"
  Then related page is displayed
  Examples:
  |  menu item  |
  |  computer   |
  |  Electronics|
  |  Apparel    |
  |  Digital downloads|
  |  Books      |
  |Jewelry      |
  |Gift Cards   |
