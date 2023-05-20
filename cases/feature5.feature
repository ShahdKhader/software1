Feature: Track the orders for customer
  user should be asked for the his order number
  Scenario: empty information
    When user click on insert order and flag is 'true'
    Then the field 'Order Number' should be with error


  Scenario: a successful Information
    When user click on insert order and flag is 'true'
    And he fill in x 'Order Number' with '9'
    And he presses 'search' and flag is 'true'
    Then show massage x 'the information has been entered successfully'

  Scenario: errors with input
    When user click on insert order and flag is a 'true'
    And he fill in 'Name' with a '-1'
    And he presses 'search' and flag is a 'true'
    Then the user should see a 'Order Number must be positive integer'

