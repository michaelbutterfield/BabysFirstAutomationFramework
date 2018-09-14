package application.applecalendar.pages;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.appium.Button;

public class MainPage extends Page
{
	public Button createdEvent;
	
	
	public MainPage()
	{
		super("MainScreen");
		buildPage();
	}
	
	private void buildPage()
	{
		createdEvent = new Button(By.name("test test 123"), "User Created Event", name);
	}
}
