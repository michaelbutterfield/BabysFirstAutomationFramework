@Word
Feature: Microsoft Word

Scenario: Open word, create a new document and type a message

Given I open word
When I open a new document
And I type a message
Then the message will be displayed