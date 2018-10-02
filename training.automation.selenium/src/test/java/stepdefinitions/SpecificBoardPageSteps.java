package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import application.DesktopWebsite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.SeleniumDriverHelper;
import utilities.TestHelper;

import static org.hamcrest.Matchers.is;

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
		DesktopWebsite.specificBoardsPage.moreSideMenuButton.click();
	}
	
	@When ("^I create three new lists called \"(.*?)\", \"(.*?)\" and \"(.*?)\" and add several cards to each$")
	public void iCreateThreeNewListsCalledToDoDoingAndDoneAndAddSeveralCardsToEach(String toDo, String doing, String done)
	{		
		DesktopWebsite.specificBoardsPage.addAList.click();
		
		DesktopWebsite.specificBoardsPage.enterListTitle.inputText(toDo);
		
		DesktopWebsite.specificBoardsPage.addListButton.click();
		
		DesktopWebsite.specificBoardsPage.addACard.click();
		
		for(int i = 0; i < 5; i++)
		{
			String testText = String.format("Test Text Placeholder %1$s", i);
			
			DesktopWebsite.specificBoardsPage.enterCardTitle.inputText(testText);
			
			DesktopWebsite.specificBoardsPage.addCardButton.click();
		}
		
		System.out.println("Successfully created To Do and tasks 0-4");
		
		//Doing
		
		DesktopWebsite.specificBoardsPage.enterListTitle.inputText(doing);
		
		DesktopWebsite.specificBoardsPage.addListButton.click();
		
		DesktopWebsite.specificBoardsPage.addCardSecondCol.click();
		
		for(int i = 5; i < 10; i++)
		{
			String testText = String.format("Test Text Placeholder %1$s", i);
			
			DesktopWebsite.specificBoardsPage.enterCardTitle.inputText(testText);
			
			DesktopWebsite.specificBoardsPage.addCardButton.click();
		}
		
		System.out.println("Successfully created 'Doing' and tasks 5-9");
		
		//Done
		
		DesktopWebsite.specificBoardsPage.enterListTitle.inputText(done);
		
		DesktopWebsite.specificBoardsPage.addListButton.click();
		
		DesktopWebsite.specificBoardsPage.addCardThirdCol.click();
		
		for(int i = 10; i < 15; i++)
		{
			String testText = String.format("Test Text Placeholder %1$s", i);
			
			DesktopWebsite.specificBoardsPage.enterCardTitle.inputText(testText);
			
			DesktopWebsite.specificBoardsPage.addCardButton.click();
		}
		
		System.out.println("Successfully created Done and tasks 10-14");
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
		String toDoLabel = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[1]/div/div[1]/textarea")).getAttribute("aria-label");
		String doingLabel = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[1]/textarea")).getAttribute("aria-label");
		String doneLabel = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[3]/div/div[1]/textarea")).getAttribute("aria-label");
		
		TestHelper.assertThat(toDoLabel, is("To Do"), "Assert that 'To Do' is created and visible");
		TestHelper.assertThat(doingLabel, is("Doing"), "Assert that 'Doing' is created and visible");
		TestHelper.assertThat(doneLabel, is("Done"), "Assert that 'Done' is created and visible");
		
		String toDoFinalCard = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[1]/div/div[2]/a[5]/div[3]/span")).getText();
		String doingFinalCard = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[2]/a[5]/div[3]/span")).getText();
		String doneFinalCard = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"board\"]/div[3]/div/div[2]/a[5]/div[3]/span")).getText();
		
		TestHelper.assertThat(toDoFinalCard, is("Test Text Placeholder 4"), "Assert that 'Test Text Placeholder 4' is created and visible/clickable - all cards in the first list have been created successfully");
		TestHelper.assertThat(doingFinalCard, is("Test Text Placeholder 9"), "Assert that 'Test Text Placeholder 9' is created and visible/clickable - all cards in the first list have been created successfully");
		TestHelper.assertThat(doneFinalCard, is("Test Text Placeholder 14"), "Assert that 'Test Text Placeholder 14' is created and visible/clickable - all cards in the first list have been created successfully");
		
		DesktopWebsite.header.backToHome.jsClick();
	}
}
