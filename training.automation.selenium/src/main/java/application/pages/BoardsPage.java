package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.pages.elements.selenium.InputBox;
import application.pages.elements.selenium.Label;

public class BoardsPage extends Page
{
	public Button boardsSideBarButton;
	public Button addButton;
	public Button createNewBoardButton;
	public InputBox nameInput;
	public Button backgroundSelectionButton;
	public Button createBoardButton;
	public Button userBoardButton;
	public Label boardNotFound;
	public Button favouriteButton;
	
	public BoardsPage()
	{
		super("BoardsPage");
		buildPage();
	}
	
	private void buildPage()
	{
		boardsSideBarButton = new Button(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div/div[1]/nav/div[1]/ul/li[1]/a/span[2]"),
										 "Boards Side Bar Button", name);
		
		addButton = new Button(By.xpath("//*[@id=\"header\"]/div[4]/a[1]/span"), "Add Button", name);
		
		createNewBoardButton = new Button(By.xpath("//*[@id=\"classic\"]/div[5]/div/div[2]/div/div/div/ul/li[1]/a"), "Create Board... Button", name);
		
		nameInput = new InputBox(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/div/div/div[1]/input"), "Board Name Input Box", name);
		
		backgroundSelectionButton = new Button(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/div/ul/li[2]/button"),
											   "Board Background Selection", name);
		
		createBoardButton = new Button(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/button/span[2]"), "Create Board Button", name);
		
		userBoardButton = new Button(By.xpath("//div[contains(text(),'TestBoard')]"), "User Created Board", name);
		
		boardNotFound = new Label(By.xpath("//h1[contains(text(),'Board not found.')]"), "Board not found. message", name);
		
		favouriteButton = new Button(By.xpath("//span[contains(@class, 'board-tile-options')]"), "Favourite Button", name);
	}
}
