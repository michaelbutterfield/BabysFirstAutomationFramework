package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.pages.elements.selenium.InputBox;
import application.pages.elements.selenium.Link;

public class SpecificBoardsPage extends Page
{
	public Button addACard;
	public Button addAnotherList;
	public Button addAList;
	public Button addCardButton;
	public Button addCardCancel;
	public Button addCardFirstCol;
	public Button addCardSecondCol;
	public Button addCardThirdCol;
	public Button addListButton;
	public Button closeBoard;
	public Button closeBoardConfirmation;
	public InputBox enterListTitle;
	public InputBox enterCardTitle;
	public Button homeButton;
	public InputBox listTitle;
	public Button moreSideMenuButton;
	public Link permDeleteBoard;
	public Button permDeleteBoardConfirm;

	public SpecificBoardsPage()
	{
		super("Specific Boards Page");
		buildPage();
	}
	
	private void buildPage()
	{
		addACard 				= new Button(By.xpath("//span[@class='js-add-a-card']"), "Add a card", name);
		addAnotherList 			= new Button(By.xpath("//span[text()='Add another list']"), "Add another list (used for adding any list after the first one)", name);
		addAList 				= new Button(By.xpath("//span[text()='Add a list']"), "Add a list", name);
		addCardButton 			= new Button(By.xpath("//input[@class='primary confirm mod-compact js-add-card'][@type='submit']"), "Add Card Button", name);
		addCardCancel 			= new Button(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"), "Add a card", name);
		addListButton 			= new Button(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"), "Add List Confirmation Button", name);
		closeBoard 				= new Button(By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']"), "Close Board...", name);
		closeBoardConfirmation 	= new Button(By.xpath("//input[@class='js-confirm full negate']"), "Confirm Close Board", name);
		enterCardTitle 			= new InputBox(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"), "Entering card title", name);
		enterListTitle 			= new InputBox(By.xpath("//input[@class='list-name-input']"), "Entering the list title", name);
		moreSideMenuButton 		= new Button(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"), "More Button in Side Menu", name);
		permDeleteBoard 		= new Link(By.xpath("//a[@class='quiet js-delete']"), "Permanently Delete Board...", name);
		permDeleteBoardConfirm 	= new Button(By.xpath("//input[@class='js-confirm full negate']"), "Yes, Permanently Delete Board.", name);
	}
}
