package application;

import application.pages.*;
import application.sections.*;

public final class DesktopWebsite
{	
	public static BoardsPage boardsPage;
	public static Header header;
	public static SplashPage splashPage;
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
		splashPage = new SplashPage();
		logInPage = new LogInPage();
		specificBoardsPage = new SpecificBoardsPage();
	}
	
	private static void buildSections()
	{
		header = new Header();
	}
}
