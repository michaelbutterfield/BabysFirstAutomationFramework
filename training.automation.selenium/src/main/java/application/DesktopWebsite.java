package application;

import application.pages.*;
import application.sections.*;

public final class DesktopWebsite
{	
	public static BoardsPage boardsPage;
	public static Header header;
	public static HomePage homePage;
	public static LogInPage logInPage;
	public static SpecificBoardsPage specificBoardsPage;
	
	
	static
	{
		buildPages();
		buildSections();
	}
	
	private static void buildPages()
	{
		boardsPage = new BoardsPage();
		homePage = new HomePage();
		logInPage = new LogInPage();
		specificBoardsPage = new SpecificBoardsPage();
	}
	
	private static void buildSections()
	{
		header = new Header();
	}
}
