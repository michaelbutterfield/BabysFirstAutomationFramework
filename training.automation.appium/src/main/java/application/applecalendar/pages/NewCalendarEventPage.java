package application.applecalendar.pages;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.appium.Button;
import application.pages.elements.appium.InputBox;

public class NewCalendarEventPage extends Page
{
	public Button add;
	public InputBox notesInput;	//used to actually send keys to the notes input box
	public InputBox location;
	public InputBox locationSpecific;
	public Button starts;
	public InputBox title;
	public Button repeats;
	public Button repeatEveryWeek;
	
	public NewCalendarEventPage()
	{
		super("AddPage");
		buildPage();
	}
	
	private void buildPage()
	{
		add = new Button(By.name("add"), "Add Button", name);
		notesInput = new InputBox(By.name("Notes"), "Notes Send Keys Input", name);
		location = new InputBox(By.name("Location"), "Location Button", name);
		locationSpecific = new InputBox(By.name("Preston, England"), "Location Input Box - Preston, England", name);
		repeats = new Button(By.name("Repeat"), "Repeats Button", name);
		repeatEveryWeek = new Button(By.name("Every Week"), "Repeat Every Week", name);
		title = new InputBox(By.name("Title"), "Title Input Box", name);
	}
}