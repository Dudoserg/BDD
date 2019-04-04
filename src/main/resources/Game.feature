Feature: gamesina
  in order to avoid failing "verification"
  As a programmer idiot
  decided to make game 2048]
#add
  Scenario:
    Given I have my Game class
    When I have entered 2 as first operand
    And I have entered 2 as second operand
    And I use 'add' method
    Then The result should be 4
#generateNumber
  Scenario:
    Given  I have my Game class
    When I use 'generateNumber' method
    Then The result  2 or 4
#generateNumber
  Scenario:
    Given  I have my Game class
    When I use 'generateNumber' method 100000 raz
    Then The result  2 or 4 with probability 90 and 10
#getSize
  Scenario:
    Given  I have my Game class with param 4
    When I get gameSize
    Then The gameSize should be 4
# initArray
  Scenario:
    Given  I have my Game class with param 4
    When I get array from Game
    Then The array should be null
#setElem #getElem
  Scenario:
    Given  I have my Game class with param 4
    When I set elem 4 with index 0 0
    And I get elem with index 0 0
    Then The result getElem should be 4
#findFreePlace
  Scenario:
    Given  I have my Game class with param 4
    When I set elem 4 with index 0 0
    And I call 'findFreePlace' method 100000 times
    Then Еhe result must not contain an element with index 0 0