@ContactPage
Feature: Contact Page

@AddContact
Scenario: Add new contact to contacts

Given I am on the contacts page
When I click add contact
And I enter a first name
And I enter a last name
And I enter a phone number
And I click done
Then A new contact will be added

@DeleteContact
Scenario: Delete a contact from contacts

Given I am on the contacts page
When I select a contact
And I click edit
And I scroll down
And I click delete contact
And I confirm the deletion
Then The contact is deleted