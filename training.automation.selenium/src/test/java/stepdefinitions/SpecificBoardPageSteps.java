package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import application.DesktopWebsite;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.SeleniumDriverHelper;
import utilities.TestHelper;

import static org.hamcrest.Matchers.is;

import java.util.List;

public class SpecificBoardPageSteps
{
	@When ("^I click and drag three cards from To Do to Doing$")
	public void iClickAndDragThreeCardsFromToDoToDoing()
	{
		//Move 0 to Doing
		WebElement From = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[1]/div/div[2]/a[1]/div[3]/span"));
		WebElement To = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[1]/div[1]"));
		Actions act = new Actions(SeleniumDriverHelper.getWebDriver());
		act.dragAndDrop(From, To).build().perform();
		
		//Move 2 to Doing
		From = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[1]/div/div[2]/a[2]/div[3]/span"));
		act.dragAndDrop(From, To).build().perform();
		
		From = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[1]/div/div[2]/a[2]"));
		act.dragAndDrop(From, To).build().perform();
	}
	
	@When ("^I click More in the side menu$")
	public static void iClickMoreInTheSideMenu()
	{
		DesktopWebsite.specificBoardsPage.moreSideMenu.click();
	}
	
	@When ("^I create a new list called \"(.*?)\"$")
	public void iCreateANewListCalled(String passedName)
	{
		if (DesktopWebsite.specificBoardsPage.addAList.Exists())
		{
			DesktopWebsite.specificBoardsPage.addAList.click();
		}
		
		DesktopWebsite.specificBoardsPage.enterListTitle.inputText(passedName);
		DesktopWebsite.specificBoardsPage.addList.click();
	}
	
	@And ("^I add five cards to the new list$")
	public static void iAddFiveCardsToTheNewList(DataTable tab)
	{
		List<String> list = tab.asList(String.class); 
		
		for (int i = 0; i < list.size(); i++)
		{
			if (DesktopWebsite.specificBoardsPage.addACard.Exists())
			{
				DesktopWebsite.specificBoardsPage.addACard.click();	
			}
			
			DesktopWebsite.specificBoardsPage.enterCardTitle.inputText(list.get(i));
			DesktopWebsite.specificBoardsPage.addCard.click();			
		}
	}
	
	@And ("^I click and drag three cards from Done to Doing$")
	public void iClickAndDragThreeCardsFromDoneToDoing()
	{
		//Move 0 to Doing
		WebElement From = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[3]/div/div[2]/a[2]/div[3]/span"));
		WebElement To = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[1]/div[1]"));
		Actions act = new Actions(SeleniumDriverHelper.getWebDriver());
		act.dragAndDrop(From, To).build().perform();
		
		//Move 2 to Doing
		From = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[3]/div/div[2]/a[2]/div[3]/span"));
		act.dragAndDrop(From, To).build().perform();
		
		From = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[3]/div/div[2]/a[2]/div[3]/span"));
		act.dragAndDrop(From, To).build().perform();
	}
	
	@And ("^I click close board$")
	public static void iClickCloseBoard()
	{
		DesktopWebsite.specificBoardsPage.closeBoard.click();
	}
	
	@And ("^I click the close board confirmation$")
	public static void iClickTheCloseBoardConfirmation()
	{
		DesktopWebsite.specificBoardsPage.closeBoardConfirmation.click();
	}
	
	@And ("^I confirm the permanent deletion of the board$")
	public static void iConfirmThePermanentDeletionOfTheBoard()
	{
		DesktopWebsite.specificBoardsPage.permDeleteBoard.click();
		DesktopWebsite.specificBoardsPage.permDeleteBoardConfirm.click();
	}
	
	@Then ("^the cards are in their new lists$")
	public void theCardsAreInTheirNewLists()
	{
		String topCardMiddleList = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[2]/a[1]/div[3]/span")).getText();
		String secondCardMiddleList = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[2]/a[2]/div[3]/span")).getText();
		String thirdCardMiddleList = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[2]/a[3]/div[3]/span")).getText();
		String fourthCardMiddleList = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[2]/a[4]/div[3]/span")).getText();
		String fifthCardMiddleList = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[2]/a[5]/div[3]/span")).getText();
		String sixthCardMiddleList = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[2]/a[6]/div[3]/span")).getText();
		
		TestHelper.assertThat(topCardMiddleList, is("Test Text Placeholder 13"),	"Assert that 'Test Text Placeholder 13' is the top card in the middle list and has moved successfully");
		TestHelper.assertThat(secondCardMiddleList, is("Test Text Placeholder 12"),	"Assert that 'Test Text Placeholder 12' is the second card in the middle list and has moved successfully");
		TestHelper.assertThat(thirdCardMiddleList, is("Test Text Placeholder 11"),	"Assert that 'Test Text Placeholder 11' is the third card in the middle list and has moved successfully");
		TestHelper.assertThat(fourthCardMiddleList, is("Test Text Placeholder 3"),	"Assert that 'Test Text Placeholder 3' is the fourth card in the middle list and has moved successfully");
		TestHelper.assertThat(fifthCardMiddleList, is("Test Text Placeholder 2"),	"Assert that 'Test Text Placeholder 2' is the fifth card in the middle list and has moved successfully");
		TestHelper.assertThat(sixthCardMiddleList, is("Test Text Placeholder 0"),	"Assert that 'Test Text Placeholder 0' is the sixth card in the middle list and has moved successfully");
		
		DesktopWebsite.header.backToHome.jsClick();
	}
	
	@Then ("^the three boards lists and contents will be created$")
	public void theThreeBoardsListsAndContentsWillBeCreated()
	{
		String toDoLabel = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input'][@aria-label='To Do']")).getAttribute("aria-label");
		String doingLabel = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input'][@aria-label='Doing']")).getAttribute("aria-label");
		String doneLabel = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input'][@aria-label='Done']")).getAttribute("aria-label");
		
		TestHelper.assertThat(toDoLabel, is("To Do"), "Assert that 'To Do' is created and visible");
		TestHelper.assertThat(doingLabel, is("Doing"), "Assert that 'Doing' is created and visible");
		TestHelper.assertThat(doneLabel, is("Done"), "Assert that 'Done' is created and visible");
		
		String toDoFinalCard = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//span[@class='list-card-title js-card-name'][text()='Test Text Placeholder 4']")).getText();
		String doingFinalCard = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//span[@class='list-card-title js-card-name'][text()='Test Text Placeholder 9']")).getText();
		String doneFinalCard = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//span[@class='list-card-title js-card-name'][text()='Test Text Placeholder 14']")).getText();
		
		TestHelper.assertThat(toDoFinalCard, is("Test Text Placeholder 4"), "Assert that 'Test Text Placeholder 4' is created and visible/clickable - all cards in the first list have been created successfully");
		TestHelper.assertThat(doingFinalCard, is("Test Text Placeholder 9"), "Assert that 'Test Text Placeholder 9' is created and visible/clickable - all cards in the first list have been created successfully");
		TestHelper.assertThat(doneFinalCard, is("Test Text Placeholder 14"), "Assert that 'Test Text Placeholder 14' is created and visible/clickable - all cards in the first list have been created successfully");
		
		DesktopWebsite.header.backToHome.jsClick();
	}
}
