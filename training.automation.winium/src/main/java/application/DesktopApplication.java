package application;

import application.pages.calculator.*;
import application.sections.calculator.NavigationPane;

public final class DesktopApplication
{
	public static MainPage mainPage;
	public static NavigationPane navigationPane;
	
	static
	{
		buildPages();
		buildSections();
	}
	
	private static void buildPages()
	{
		mainPage = new MainPage();
	}
	
	private static void buildSections()
	{
		navigationPane = new NavigationPane();
	}
}
