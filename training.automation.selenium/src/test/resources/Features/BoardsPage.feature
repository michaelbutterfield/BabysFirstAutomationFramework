@BoardsPage
Feature: Boards Page

@CreateBoard
Scenario: Create a new board

Given I set up the environment with "michaelbutterf@gmail.com" and "automationtest23"
Given I click the add button in the top right
When I click the Create Board... option
And I create a new board with "TestBoard" and a background
And I click the Back to Home button
Then I confirm the board is created

@FavouriteBoard
Scenario: Favourite a board

Given I am on the boards page
When I click the favourite board star
Then The board will be favourited

@AddingListsAndCards
Scenario: Clicking on the user board, adding lists (to do, doing, done) and adding cards

Given I click on the user created board
When I create three new lists called "To Do", "Doing" and "Done" and add several cards to each
Then I click the Back to Home button

@DragAndDropCard
Scenario: Drag and drop a card to a new list

Given I click on the user created board
When I click and drag three cards from To Do to Doing
And I click and drag three cards from Done to Doing
Then I click the Trello Logo Home button

@DeleteBoard
Scenario: Delete a board

Given I click on the user created board
When I click More in the side menu
And I click close board
And I click the close board confirmation
And I confirm the permanent deletion of the board
And I confirm the board is no longer there
Then I click the Trello Logo Home button
