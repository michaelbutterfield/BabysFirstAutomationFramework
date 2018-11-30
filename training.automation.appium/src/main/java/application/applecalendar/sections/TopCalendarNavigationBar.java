package application.applecalendar.sections;

import org.openqa.selenium.By;

import application.pages.elements.appium.Button;
import application.sections.Section;

public class TopCalendarNavigationBar extends Section
{
	public Button add;
	public Button day;
	public Button month;
	public Button search;
	public Button week;
	public Button year;
	
	public TopCalendarNavigationBar()
	{
		super("TopNavigationBar");
		buildSection();
	}
	
	private void buildSection()
	{
		add =			new Button(By.name("Add"), "Add Button", name);
		day =			new Button(By.name("Day"), "Day Button", name);
		month =			new Button(By.name("Month"), "Month Button", name);
		search =		new Button(By.name("Search"), "Search Button", name);
		week =			new Button(By.name("Week"), "Week Button", name);
		year =			new Button(By.name("Year"), "Year Button", name);
	}
}