@regression
  Feature: this feature allow to user to change has own account details and be aware with order state
    @smoke
    Scenario: Verify that registered user could edit has registered information (customerInfo)
      Given registered user navigate to myAccountPage
      When registered user edit has gender
      And registered user edit has first and lastname
      And registered user edit has email
      And  registered user edit has company
      And registered user clcik on news letter
      And registered user click save
      Then has account details has been successfully edited
@smoke
Scenario: Verify that user could add a new addresses (addresses)
  Given  registered user navigate to myAccountPage
  And    user click on addresses tab
  When   user click on add new
  And    user enter has new first and last name
  And    user enter email
  And    user enter company name
  And    user enter country and state and city
  And    user enter addresses1 and addresses2
  And    user enter postal code and phone number and fax number
  And    user click on save button
  Then   successfully new address message is displayed

