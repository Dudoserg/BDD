Feature: gamesina
  in order to avoid failing "verification"
  As a programmer idiot
  decided to make game 2048
  Scenario:
    Given I have my Game class
    When I have entered 2 as first operand
    And I have entered 2 as second operand
    And I use 'add' method
    Then The result should be 4
    
  Scenario:
    Given  I have my Game class
    When I use 'generateNumber' method
    Then The result  2 or 4

  Scenario:
    Given  I have my Game class
    When I use 'generateNumber' method
    Then The result  2 or 4 with probability 90 and 10