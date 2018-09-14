package application.appleclock.pages;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.appium.Button;

public class Stopwatch extends Page
{
	public Button placeholder;
	
	public Stopwatch()
	{
		super("Stopwatch");
		buildPage();
	}
	
	private void buildPage()
	{
		placeholder = new Button(By.name("Resume"), "World Clock Add Modal Cancel Button", name);
	}
}
