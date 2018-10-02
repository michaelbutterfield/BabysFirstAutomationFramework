package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import application.DesktopWebsite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import utilities.SeleniumDriverHelper;

public class SpecificBoardPageSteps
{
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
		
//		try
//		{
//			Thread.sleep(10000);
//		}
//		catch(Exception e)
//		{
//			//eat exception
//		}
	}
	
	@When ("^I create three new lists called \"(.*?)\", \"(.*?)\" and \"(.*?)\" and add several cards to each$")
	public void iCreateThreeNewListsCalledToDoDoingAndDoneAndAddSeveralCardsToEach(String toDo, String doing, String done)
	{
		//To do
		
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
	
}
