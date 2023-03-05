Feature: customer
  this is the customer feature
  @tag1
  Scenario: unvalid name
    Given i am trying to sign in
    When press sign in and the name is unvalid
    Then open unvalid-sign-in-screen


