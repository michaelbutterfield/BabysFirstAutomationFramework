package application;

import application.pages.*;
import application.sections.*;

public final class DesktopWebsite
{	
	public static BoardsPage boardsPage;
	public static CreateBoardPage createBoardPage;
	public static Header header;
	public static LogInPage logInPage;
	public static SpecificBoardsPage specificBoardsPage;
	public static SplashPage splashPage;

	
	static
	{
		buildPages();
		buildSections();
	}
	
	private static void buildPages()
	{
		boardsPage = new BoardsPage();
		createBoardPage = new CreateBoardPage();
		logInPage = new LogInPage();
		specificBoardsPage = new SpecificBoardsPage();
		splashPage = new SplashPage();
	}
	
	private static void buildSections()
	{
		header = new Header();
	}
}
