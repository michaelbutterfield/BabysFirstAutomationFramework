package application.appleclock.sections;

import org.openqa.selenium.By;

import application.pages.elements.appium.Button;
import application.sections.Section;

public class BottomNavigationBar extends Section
{
	public Button worldClock;
	public Button alarm;
	public Button stopwatch;
	public Button timer;
	
	public BottomNavigationBar()
	{
		super("BottomNavigationBar");
		buildSection();
	}
	
	private void buildSection()
	{
		worldClock =	new Button(By.name("World Clock"), "World Clock Navigation Button", name);
		alarm =			new Button(By.name("Alarm"), "Alarm Navigation Button", name);
		stopwatch = 	new Button(By.name("Stopwatch"), "Stopwatch Navigation Button", name);
		timer = 		new Button(By.name("Timer"), "Timer Navigation Button", name);
	}
}
