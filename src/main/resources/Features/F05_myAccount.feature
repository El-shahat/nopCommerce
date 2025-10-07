@regression
  Feature: this feature allow to user to change has own account details and be aware with order state
    @smoke
    Scenario: Verify that registered user could edit has registered information
      Given registered user navigate to myAccountPage
      When registered user edit has gender
      And registered user edit has first and lastname
      And registered user edit has email
      And  registered user edit has company
      And registered user clcik on news letter
      And registered user click save
      Then has account details has been successfully edited
