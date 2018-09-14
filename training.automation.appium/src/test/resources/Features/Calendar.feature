@Calendar
Feature: iOS Calendar Test

@CreateEvent
Scenario: Create a new event

Given I am in the calendar
When I click the new event button
And I enter a title
And I enter a location
And I enter a repeat
And I enter a note
Then the event will be created

#Scenario: delete event