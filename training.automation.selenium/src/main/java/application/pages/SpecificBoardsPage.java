package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.pages.elements.selenium.InputBox;
import application.pages.elements.selenium.Link;

public class SpecificBoardsPage extends Page
{
	public Button addList;
	public Button moreSideMenuButton;
	public Button closeBoard;
	public Button closeBoardConfirmation;
	public Button homeButton;
	public Link permDeleteBoard;
	public Button permDeleteBoardConfirm;
	public InputBox listTitle;

	//General
	public Button addAList;
	public Button addAnotherList;
	
	public Button addListButton;
	public Button addACard;
	public Button addCardCancel;
	public Button addCardButton;
	
	public Button addCardFirstCol;
	public Button addCardSecondCol;
	public Button addCardThirdCol;
	
	public InputBox enterListTitle;
	public InputBox enterCardTitle;
	
	public SpecificBoardsPage()
	{
		super("SpecificBoardsPage");
		buildPage();
	}
	
	private void buildPage()
	{
		//Side Menu
		moreSideMenuButton = new Button(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div[2]/div/ul/li[5]/a"), "More Button in Side Menu", name);
		closeBoard = new Button(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div[2]/div/ul[3]/li/a"), "Close Board...", name);
		closeBoardConfirmation = new Button(By.xpath("//*[@id=\"classic\"]/div[5]/div/div[2]/div/div/div/input"), "Confirm Close Board", name);
		permDeleteBoard = new Link(By.xpath("//*[@id=\"content\"]/div/div/p[2]/a"), "Permanently Delete Board...", name);
		permDeleteBoardConfirm = new Button(By.xpath("//*[@id=\"classic\"]/div[5]/div/div[2]/div/div/div/input"), "Yes, Permanently Delete Board.", name);
		
		//General
		addAList = new Button(By.xpath("//span[contains(@class,'placeholder js-open-add-list')]"), "Add a list", name);
		addAnotherList = new Button(By.xpath("//div[contains(text(),'Add another list')]"), "Add another list (used for adding any list after the first one)", name);
		
		addListButton = new Button(By.xpath("//input[contains(@class,'primary mod-list-add-button js-save-edit')]"), "Add List Confirmation Button", name);
		addACard = new Button(By.xpath("//span[contains(@class,'js-add-a-card')]"), "Add a card", name);
		addCardCancel = new Button(By.xpath("//a[contains(@class,'icon-lg icon-close dark-hover js-cancel')]"), "Add a card", name);
		addCardButton = new Button(By.xpath("//input[contains(@class,'primary confirm mod-compact js-add-card')]"), "Add Card Button", name);
		
		addCardFirstCol = new Button(By.xpath("//*[@id=\"board\"]/div[1]/div/a/span[2]"), "Add a card (First column)", name);
		addCardSecondCol = new Button(By.xpath("//*[@id=\"board\"]/div[2]/div/a/span[2]"), "Add a card (Second column)", name);
		addCardThirdCol = new Button(By.xpath("//*[@id=\"board\"]/div[3]/div/a/span[2]"), "Add a card (Second column)", name);
		
		enterListTitle = new InputBox(By.xpath("//input[contains(@class,'list-name-input')]"), "Entering the list title", name);
		enterCardTitle = new InputBox(By.xpath("//textarea[contains(@class, 'list-card-composer-textarea js-card-title')]"), "Entering card title", name);
	}
}