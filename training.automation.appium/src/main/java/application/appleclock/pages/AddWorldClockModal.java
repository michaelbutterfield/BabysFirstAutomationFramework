package application.appleclock.pages;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.appium.Button;
import application.pages.elements.appium.InputBox;

public class AddWorldClockModal extends Page
{
	public Button cancel;
	public Button city;
	public InputBox search;
	
	public AddWorldClockModal()
	{
		super("AddWorldClockModal");
		buildPage();
	}
	
	private void buildPage()
	{
		cancel = new Button(By.name("Cancel"), "World Clock Add Modal Cancel Button", name);
		city = new Button(By.name("London, England"), "World Clock Add Modal City", name);
		search = new InputBox(By.name("Search"), "World Clock Add Modal Search Box", name);
	}
}
