package stepdefinitions;

import application.MobileApp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.TouchAction;
import utilities.AppiumDriverHelper;

public class ContactsSteps
{
	@Given("^I am on the contacts page$")
	public static void iAmOnTheContactsPage()
	{
		MobileApp.contactsPage.assertContact.assertElementExists();
	}

	@When("^I click add contact$")
	public static void iClickAddContact()
	{
		MobileApp.contactsPage.add.click();
	}

	@And("^I enter a first name$")
	public static void iEnterAFirstName()
	{
		MobileApp.newContactPage.firstName.inputText("firstname");
	}

	@And("^I enter a last name$")
	public static void iEnterALastName()
	{
		MobileApp.newContactPage.lastName.inputText("lastname");
	}

	@And("^I enter a phone number$")
	public static void iEnterAPhoneNumber()
	{
		MobileApp.newContactPage.phoneNumber.inputText("1234");
	}

	@And("^I click done$")
	public static void iClickDone()
	{
		MobileApp.newContactPage.done.click();
	}

	@Then("^A new contact will be added$")
	public static void aNewContactWillBeAdded()
	{
		MobileApp.contactsPage.contactName.assertElementExists();
	}

	@When("^I select a contact$")
	public static void iSelectANewContact()
	{
		MobileApp.contactsPage.contactName.click();
	}

	@And("^I click edit$")
	public static void iClickEdit()
	{
		MobileApp.contactsPage.edit.click();
	}

	@And("^I scroll down$")
	public static void iScrollDown()
	{
		TouchAction ta = new TouchAction(AppiumDriverHelper.getDriver());
		ta.longPress(1000, 500).moveTo(1000, 0).release().perform();
	}

	@And("^I click delete contact$")
	public static void iClickDeleteContact()
	{
		MobileApp.contactsPage.deleteContact.click();
	}

	@And("^I confirm the deletion$")
	public static void iConfirmTheDeletion()
	{
		TouchAction ta = new TouchAction(AppiumDriverHelper.getDriver());
		ta.press(394, 910).perform();
	}

	@Then("^The contact is deleted$")
	public static void theContactIsDeleted()
	{
		MobileApp.contactsPage.contactName.assertElementDoesNotExist();
	}
}
