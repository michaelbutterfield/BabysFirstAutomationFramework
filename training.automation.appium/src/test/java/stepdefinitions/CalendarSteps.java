package stepdefinitions;

import application.Calendar;
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
		Calendar.topNavigationBar.add.assertElementExists();
	}

	@When("^I click the new event button$")
	public void iClickTheNewEventButton()
	{
		Calendar.topNavigationBar.add.assertElementExists();
		
		Calendar.topNavigationBar.add.click();
	}

	@And("^I enter a title$")
	public void iEnterATitle()
	{
		Calendar.newEventPage.title.assertElementExists();
		
		Calendar.newEventPage.title.inputText("test test 123");
	}
	
	@And("^I enter a location")
	public void iEnterALocation()
	{
		Calendar.newEventPage.location.assertElementExists();
		
		Calendar.newEventPage.location.click();
		
		Calendar.newEventPage.location.inputText("Preston, England");
		
		Calendar.newEventPage.locationSpecific.assertElementExists();
		
		Calendar.newEventPage.locationSpecific.click();
	}
	
	@And("^I enter a repeat")
	public void iEnterARepeat()
	{
		Calendar.newEventPage.repeats.assertElementExists();
		
		Calendar.newEventPage.repeats.click();
		
		Calendar.newEventPage.repeatEveryWeek.assertElementExists();
		
		Calendar.newEventPage.repeatEveryWeek.click();
	}

	@And("^I enter a note")
	public void iEnterANote()
	{
		TouchAction ta = new TouchAction(AppiumDriverHelper.getDriver());
		
		ta.longPress(422, 363).moveTo(422, 63).release().perform();
		
		Calendar.newEventPage.notesInput.inputText("john sucks lol");
		
		Calendar.newEventPage.add.click();
	}
	
	@Then("^the event will be created$")
	public void theEventWillBeCreated()
	{
		Calendar.mainPage.createdEvent.assertElementExists();
	}
}
