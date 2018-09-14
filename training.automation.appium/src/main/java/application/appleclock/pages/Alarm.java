package application.appleclock.pages;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.appium.Button;
import application.pages.elements.appium.Container;
import application.pages.elements.appium.InputBox;

public class Alarm extends Page
{
	public Button add;
	public Button cancel;
	public Button save;
	
	public Container timeWheelHour;
	
	public Button repeat;
	public Button label;
	public InputBox labelInput;
	
	
	public Alarm()
	{
		super("Alarm");
		buildPage();
	}
	
	public void buildPage()
	{
		add = 		new Button(By.name("Add"), "Alarm Add Button", name);
		cancel =	new Button(By.name("Cancel"), "Add Alarm Cancel Button", name);
		save =		new Button(By.name("Save"), "Add Alarm Save Button", name);
		
		timeWheelHour =	new Container(By.name("02"), "Add Alarm Time Wheel", name);
		
		repeat =	new Button(By.name("Repeat"), "Alarm Repeat Button", name);
		label =		new Button(By.name("Label"), "Add Alarm Label Button", name);
		labelInput =	new InputBox(By.name(""), "Add Alarm Label Name Input", name);
	}
}
