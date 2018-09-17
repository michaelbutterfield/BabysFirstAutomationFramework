package application.applecontacts.pages;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.appium.Button;
import application.pages.elements.appium.InputBox;

public class NewContactPage extends Page
{
	public InputBox firstName;
	public InputBox lastName;
	public InputBox phoneNumber;
	public Button done;

	public NewContactPage()
	{
		super ("New Contacts Page");
		buildPage();
	}

	private void buildPage()
	{
		firstName = new InputBox(By.name("First name"), "First Name", name);
		lastName = new InputBox(By.name("Last name"), "name", "Last Name", name);
		phoneNumber = new InputBox(By.name("add phone"), "name", "Phone", name);
		done = new Button(By.name("Done"), "Done", name);
	}
}
