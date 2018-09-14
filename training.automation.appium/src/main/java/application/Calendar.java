package application;

import application.applecalendar.pages.MainPage;
import application.applecalendar.pages.NewEventPage;
import application.applecalendar.sections.TopNavigationBar;

public class Calendar
{
	public static TopNavigationBar topNavigationBar;
	public static NewEventPage newEventPage;
	public static MainPage mainPage;
	
	static
	{
		buildPages();
		buildSections();
	}
	
	public static void buildPages()
	{
		newEventPage = new NewEventPage();
		mainPage = new MainPage();
	}
	
	private static void buildSections()
	{
		//Calendar
		topNavigationBar = new TopNavigationBar();
	}
}
