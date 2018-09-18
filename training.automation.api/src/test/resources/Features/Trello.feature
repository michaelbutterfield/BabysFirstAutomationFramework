@TrelloApi
Feature: Automating Trello through API calls

@GetBoards
Scenario: Get all members boards

Given the API call response is correct
When I get all member boards
Then the correct borads should be fetched