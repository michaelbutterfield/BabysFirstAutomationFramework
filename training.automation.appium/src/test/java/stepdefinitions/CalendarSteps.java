package stepdefinitions;

import application.MobileApp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.TouchAction;
import utilities.AppiumDriverHelper;

public class CalendarSteps
{
	@Given("^I am in the calendar$")
	public void iAmInTheCalendar()
	{
		MobileApp.topCalendarNavigationBar.add.assertElementExists();
	}

	@When("^I click the new event button$")
	public void iClickTheNewEventButton()
	{
		MobileApp.topCalendarNavigationBar.add.assertElementExists();
		
		MobileApp.topCalendarNavigationBar.add.click();
	}

	@And("^I enter a title$")
	public void iEnterATitle()
	{
		MobileApp.newCalendarEventPage.title.assertElementExists();
		
		MobileApp.newCalendarEventPage.title.inputText("test test 123");
	}
	
	@And("^I enter a location")
	public void iEnterALocation()
	{
		MobileApp.newCalendarEventPage.location.assertElementExists();
		
		MobileApp.newCalendarEventPage.location.click();
		
		MobileApp.newCalendarEventPage.location.inputText("Preston, England");
		
		MobileApp.newCalendarEventPage.locationSpecific.assertElementExists();
		
		MobileApp.newCalendarEventPage.locationSpecific.click();
	}
	
	@And("^I enter a repeat")
	public void iEnterARepeat()
	{
		MobileApp.newCalendarEventPage.repeats.assertElementExists();
		
		MobileApp.newCalendarEventPage.repeats.click();
		
		MobileApp.newCalendarEventPage.repeatEveryWeek.assertElementExists();
		
		MobileApp.newCalendarEventPage.repeatEveryWeek.click();
	}

	@And("^I enter a note")
	public void iEnterANote()
	{
		TouchAction ta = new TouchAction(AppiumDriverHelper.getDriver());
		
		ta.longPress(422, 363).moveTo(422, 63).release().perform();
		
		MobileApp.newCalendarEventPage.notesInput.inputText("john sucks lol");
		
		MobileApp.newCalendarEventPage.add.click();
	}
	
	@Then("^the event will be created$")
	public void theEventWillBeCreated()
	{
		MobileApp.mainCalendarPage.createdEvent.assertElementExists();
	}
}
