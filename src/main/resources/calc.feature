Feature: Addito
  in order to avoid using + - / *
  As a math idiot
  I want to create a software calculator
  Scenario:
    Given I have my software calculator
    When I have entered 10 as first operand
    And I have entered 20 as second operand
    And I press 'Add'
    Then The result should be 30