@LogIn
Feature: Testing of Log in facilities

Background: Make sure on Trello Splash page
Given I was on the Trello splash page

@LogInValid
Scenario: I can log in with the correct credentials

Given I clicked the log in button on the splash page
When I enter valid credentials
Then I will be on the Trello user boards page

@LogInInvalid
Scenario: I will be denied when trying to log in with invalid credentials

Given I clicked the log in button on the splash page
When I enter invalid credentials
Then I will still be on the log in page