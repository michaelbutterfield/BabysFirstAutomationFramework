package application.applecalendar.sections;

import org.openqa.selenium.By;

import application.pages.elements.appium.Button;
import application.sections.Section;

public class TopNavigationBar extends Section
{
	public Button search;
	public Button add;
	public Button day;
	public Button week;
	public Button month;
	public Button year;
	
	public TopNavigationBar()
	{
		super("TopNavigationBar");
		buildSection();
	}
	
	private void buildSection()
	{
		search =		new Button(By.name("Search"), "Search Button", name);
		add =			new Button(By.name("Add"), "Add Button", name);
		day =			new Button(By.name("Day"), "Day Button", name);
		week =			new Button(By.name("Week"), "Week Button", name);
		month =			new Button(By.name("Month"), "Month Button", name);
		year =			new Button(By.name("Year"), "Year Button", name);
	}
}