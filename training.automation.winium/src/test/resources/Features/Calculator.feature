@Calculator
Feature: Calculator

Background: Make sure the calculator is in standard mode

Given the calculator is in standard mode

@2+4
Scenario: 2+2

Given the calculator is open
When I enter the calculation
Then the answer will be four

@ScientificLog10
Scenario: Change the calculator to scientific and do log(10)

Given I change the calculator to scientific
When I enter log ten
Then the answer will be one