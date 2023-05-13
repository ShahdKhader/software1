Feature: a user sign up
  I want to sign up on Shining Carpets
  Scenario: a successful signup
    When I click on sign up and flag is 'true'
    And he fills in 'ID' with '704123456'
    And he fills in 'Phone Number' with '0595014020'
    And he fills in 'BackUp Number' with '0599585810'
    And he fills in 'Adress' with 'nablus-rafidia'
    And he fills in 'Gmail' with 'shahd22@gmail.com'
    And he fills in 'user name' with 'shahd28'
    And he fills in 'Password' with '1234**Aa'
    And he presses 'sign up' and flag is 'true'
    Then there should be a user 'shahd28'

  Scenario Outline: errors with input
    When I click on sign up and flag is 'true'
    And he fills in 'ID' with '<ID>'
    And he fills in 'Phone Number' with '<Phone Number>'
    And he fills in 'BackUp Number' with '<BackUp Number>'
    And he fills in 'Adress' with '<Adress>'
    And he fills in 'Gmail' with '<Gmail>'
    And he fills in 'user name' with '<user name>'
    And he fills in 'Password' with '<Password>'
    And he presses 'sign up' and flag is 'true'
    Then the user should see '<massage>'
    Examples:
      | ID       |Phone Number | BackUp Number |Adress        | Gmail         | user name | Password | massage |
      |70412345  |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |ID must be 9 number not less |
      |7041234567|0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |ID must be 9 number not more|
      |70412345a |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |ID must not contain character |
      |704123456 |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |ID must be 9 number |
      |704123456 |059501402    |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |Phone Number must be 10 number not less |
      |704123456 |05950140200  |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |Phone Number must be 10 number not more |
      |704123456 |059501402a   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |Phone Number must not contain character |
      |704123456 |0595014020   |059958581      |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |Phone Number must be 10 number not less |
      |704123456 |0595014020   |05995858100    |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |Phone Number must be 10 number not more |
      |704123456 |0595014020   |059958581a     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |Phone Number must not contain character |
      |704123456 |0595014020   |0599585810     |nablus-rafidia|shahd22.com      |shahd28    |1234**Aa  |email must be at least 5 characters long |
      |704123456 |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234**Aa  |email must be at least 5 characters long |
      |704123456 |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234      |Password must be at least 5 characters long |
      |704123456 |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |12345678  |Password must contain character |
      |704123456 |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234567a  |Password must contain small and capital character |
      |704123456 |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234567A  |Password must contain small and capital character |
      |704123456 |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234567*  |Password must contain small and capital character |
      |704123456 |0595014020   |0599585810     |nablus-rafidia|shahd22@gmail.com|shahd28    |1234567aA |Password must contain spetial character |