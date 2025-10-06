Feature: this feature allow to user to add his own products in a cart

  Scenario: Verify that user could find has own chosen product in the cart page
    Given user click on book item in main menu
    When  user click on first prize pies book
    And navigate to cart page
    Then the product has been added successfully in the cart

    Scenario Outline: Verify that Quantity functionality
      Given user click on book item in main menu
      When  user click on first prize pies book
      And navigate to cart page
      And user click on increase and decrease arrow of quantity"<role>"
      Then the quantity of product and total price is changed
      Examples:
      |role|
      | up |
      |down|

      Scenario: Verify that user could remove item by click on remove button
        Given user click on book item in main menu
        When  user click on first prize pies book
        And click on another book item
        And navigate to cart page
        And click on remove button
        Then item is deleted from the cart