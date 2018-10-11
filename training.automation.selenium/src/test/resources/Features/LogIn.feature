@LogIn
Feature: Testing of Log in facilities

@LogInValid
Scenario: I can log in with the correct credentials

Given I am on the Trello splash page
When I click the log in button on the splash page
And I enter valid credentials
Then I will be on the Trello user boards page

@LogInInvalid
Scenario: I will be denied when trying to log in with invalid credentials

Given I am on the Trello splash page
When I click the log in button on the splash page
And I enter invalid credentials
Then I will still be on the log in page