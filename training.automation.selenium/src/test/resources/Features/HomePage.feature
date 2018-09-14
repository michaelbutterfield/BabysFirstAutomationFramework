@HomePage
Feature: HomePage

Background: Test browser is set to the correct website
Given I am on the Trello home page

@NavigateToLogIn
Scenario: Navigate to the log in page on the Trello website
Given  I click on the Log In button
When I am navigated to the log in page
Then I will be on the log in page