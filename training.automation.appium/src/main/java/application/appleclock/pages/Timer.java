package application.appleclock.pages;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.appium.Button;

public class Timer extends Page
{
	public Button resume;
	
	public Timer()
	{
		super("Timer");
		buildPage();
	}
	
	private void buildPage()
	{
		resume = new Button(By.name("Resume"), "World Clock Add Modal Cancel Button", name);
	}
}
