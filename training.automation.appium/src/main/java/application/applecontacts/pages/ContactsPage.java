package application.applecontacts.pages;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.appium.Button;
import application.pages.elements.appium.Text;

public class ContactsPage extends Page
{
	public Button add;
	public Button contactName;
	public Button deleteContact;
	public Button edit;
	public Text assertContact;

	public ContactsPage()
	{
		super ("Contacts Page");
		buildPage();
	}

	private void buildPage()
	{
		add = 			new Button	(By.name("Add"), "Add new contact button", name);
		assertContact = new Text	(By.name("Contacts"), "Contacts text at the top of the app", name);
		contactName = 	new Button	(By.name("firstname lastname"), "First Name Last Name", name);
		deleteContact = new Button	(By.name("Delete Contact"), "Delete Contact", name);
		edit = 			new Button	(By.name("Edit"), "Edit", name);

	}

}
