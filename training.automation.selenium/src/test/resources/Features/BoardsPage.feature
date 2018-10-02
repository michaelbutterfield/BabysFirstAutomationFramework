@BoardsPage
Feature: Boards Page

@AddingListsAndCards
Scenario: Clicking on the user board, adding lists (to do, doing, done) and adding cards

Given I click on the user created board
When I create three new lists called "To Do", "Doing" and "Done" and add several cards to each
Then the three boards lists and contents will be created

@DragAndDropCard
Scenario: Drag and drop a card to a new list

Given I click on the user created board
When I click and drag three cards from To Do to Doing
And I click and drag three cards from Done to Doing
Then the cards are in their new lists

@FavouriteBoard
Scenario: Favourite a board

Given I am on the boards page
When I click the favourite board star
Then The board will be favourited