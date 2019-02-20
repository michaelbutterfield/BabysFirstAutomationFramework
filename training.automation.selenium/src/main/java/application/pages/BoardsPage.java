package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.pages.elements.selenium.Label;

public class BoardsPage extends Page
{
	public Label boardNotFound;
	public Button createNewBoard; //TODO get rid of button createNewBoard
	public Button favourite;
	public Button userBoard;
		
	public BoardsPage()
	{
		super("Boards"); //TODO get rid of page suffix
		buildPage();
	}
	
	private void buildPage()
	{
		boardNotFound 	= new Label(By.xpath("//h1[contains(text(),'Board not found.')]"), "Board not found. message", name);
		createNewBoard	= new Button(By.xpath("//a[@class=\"js-new-board\"]"), "Create Board... Button", name);
		favourite 		= new Button(By.xpath("//span[@class='icon-sm icon-star board-tile-options-star-icon']"), "Favourite Button", name);
		userBoard		= new Button(By.xpath("//div[@title='TestBoard']"), "User Created Board", name);
	}
}
