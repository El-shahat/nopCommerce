@regression
  Feature: this feature allow to registered user to confirm payment
    @sc1
    Scenario: Verify that a registered user can complete the checkout process successfully (don`t close the driver)
      Given the user selects "Cell phones" from the Electronics category
      And the user adds three different phone models to the cart
      And the user navigates to the shopping cart page
      When the user agrees to the terms of service and proceeds to checkout
      And the user enters valid billing and shipping details
      And the user selects a preferred shipping method
      And the user selects a payment method
      And the user verifies that the payment information for "Check / Money Order" is displayed correctly
      And the user clicks on Continue
      And the user clicks on Confirm order
      Then the order should be placed successfully
