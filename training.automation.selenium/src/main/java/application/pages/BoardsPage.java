package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.pages.elements.selenium.Label;

public class BoardsPage extends Page
{
	public Label boardNotFound;
	public Button createNewBoardButton;
	public Button favouriteButton;
	public Button userBoardButton;
		
	public BoardsPage()
	{
		super("Boards Page");
		buildPage();
	}
	
	private void buildPage()
	{
		boardNotFound 			= new Label(By.xpath("//h1[contains(text(),'Board not found.')]"), "Board not found. message", name);
		createNewBoardButton	= new Button(By.xpath("//a[@class=\"js-new-board\"]"), "Create Board... Button", name);
		favouriteButton 		= new Button(By.xpath("//span[@class='icon-sm icon-star board-tile-options-star-icon']"), "Favourite Button", name);
		userBoardButton 		= new Button(By.xpath("//div[@title='TestBoard']"), "User Created Board", name);
	}
}
