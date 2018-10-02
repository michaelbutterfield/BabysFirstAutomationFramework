package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.pages.elements.selenium.InputBox;
import application.pages.elements.selenium.Label;

public class BoardsPage extends Page
{
	
	public Button addButton;
	public Button backgroundSelectionButton;
	public Label boardNotFound;
	public Button boardsSideBarButton;
	public Button createBoardButton;
	public Button createNewBoardButton;
	public Button favouriteButton;
	public InputBox nameInput;
	public Button userBoardButton;
		
	public BoardsPage()
	{
		super("BoardsPage");
		buildPage();
	}
	
	private void buildPage()
	{
		addButton = 				new Button(By.xpath("//*[@id=\"header\"]/div[5]/a[1]/span"), "Add Button", name);
		backgroundSelectionButton =	new Button(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/div/ul/li[2]/button"),
														"Board Background Selection", name);
		boardNotFound = 			new Label(By.xpath("//h1[contains(text(),'Board not found.')]"), "Board not found. message", name);
		boardsSideBarButton = 		new Button(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div/div[1]/nav/div[1]/ul/li[1]/a/span[2]"),
														"Boards Side Bar Button", name);
		createBoardButton = 		new Button(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/button/span[2]"), "Create Board Button", name);
		createNewBoardButton = 		new Button(By.xpath("//*[@id=\"classic\"]/div[5]/div/div[2]/div/div/div/ul/li[1]/a"), "Create Board... Button", name);
		favouriteButton = 			new Button(By.xpath("//span[contains(@class, 'board-tile-options')]"), "Favourite Button", name);
		nameInput = 				new InputBox(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/div/div/div[1]/input"), "Board Name Input Box", name);
		userBoardButton = 			new Button(By.xpath("//div[contains(@title, 'TestBoard')]"), "User Created Board", name);
		
		
		
		
	}
}
