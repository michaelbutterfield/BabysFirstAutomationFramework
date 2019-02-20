@BoardsPage
Feature: Boards Page

Background: Set up the environment ready for the scenarios to take place
Given I am on the splash page
And I log in
And I am on the boards page
When I create the user board
Then the environment will be set up


@AddingListsAndCards
Scenario: Clicking on the user board, adding lists (to do, doing, done) and adding cards

Given I clicked on the user created board
When I create a new list called "To Do"
And I add five cards to the new list
When I create a new list called "Doing"
And I add five cards to the new list
When I create a new list called "Done"
And I add five cards to the new list
Then the three boards lists and contents will be created


@DragAndDropCard
Scenario: Drag and drop a card to a new list

Given I clicked on the user created board
When I create a new list called "To Do"
And I add five cards to the new list
When I create a new list called "Doing"
And I add five cards to the new list
When I create a new list called "Done"
And I add five cards to the new list
When I click and drag three cards from To Do to Doing
And I click and drag three cards from Done to Doing
Then the cards are in their new lists


@FavouriteBoard
Scenario: Favourite a board

Given I am on the boards page
When I click the favourite board star
Then The board will be favourited