@LogInPage
Feature: Log In

Background: I need to be on the log in page
Given I am on the Trello Log In page

@LogInToTrello
Scenario: Log in to trello

Given I enter "michaelbutterf@gmail.com" in the email field
When I enter "automationtest23" in the password field
And I click the log in button
Then I will be on the trello boards page