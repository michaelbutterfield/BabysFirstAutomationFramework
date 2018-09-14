package application.appleclock.pages;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.appium.Button;

public class WorldClock extends Page
{
	public Button add;
	public Button edit;
	public Button done;
	
	public WorldClock()
	{
		super("WorldClock");
		buildPage();
	}
	
	private void buildPage()
	{
		add = new Button(By.name("Add"), "World Clock Add Button", name);
		edit = new Button(By.name("Edit"), "World Clock Edit Button", name);
		done = new Button(By.name("Done"), "World Clock Done Button", name);
	}
}
