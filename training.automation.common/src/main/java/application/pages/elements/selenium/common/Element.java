package application.pages.elements.selenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.TestLogger;
import utilities.TestHelper;
import utilities.SeleniumDriverHelper;

import static org.hamcrest.Matchers.*;

public class Element 
{
	protected By locator;
	protected String name;
	protected String pageName;
	
	private String frame;
	
	public Element(By locator, String elementName, String pageName)
	{		
		this(locator, elementName, pageName, "");
	}
	
	public Element(By locator, String elementName, String pageName, String frame)
	{		
		this.frame = frame;
		this.locator = locator;
		name = elementName;
		this.pageName = pageName;
	}
	
	public void assertElementIsClickable()
	{
		String assertionDescription = String.format("Assert Element '%1$s' on page '%2$s' is clickable", name, pageName);
		
		TestLogger.createTestStep("Assert Element is Clickable,", name, pageName);
		
		WebElement element = null;
		
		try		
		{
			element = getWebElement(true, false);					
		}
		catch (Exception e)
		{
			handleException("Assert Element is Clickable", e);
		}
		finally
		{
			TestHelper.assertThat(element, is(notNullValue()), assertionDescription);	
		}
	}
	
	public Boolean assertElementIsNotDisplayed()
	{
		WebElement element = null;
		
		element = getWebElement(false, false);
		
		if(element != null)
		{
			String error = String.format("%1$s is still displayed. Whoops.", name);
			System.out.println(error);
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void assertElementIsDisplayed()
	{
		String assertionDescription = String.format("Assert Element '%1$s' on page '%2$s' is displayed", name, pageName);
		
		TestLogger.createTestStep("Assert Element is Displayed,", name, pageName);
		
		WebElement element = null;
		
		try		
		{
			element = getWebElement(false, true);					
		}
		catch (Exception e)
		{
			handleException("Assert Element is Displayed", e);
		}
		finally
		{
			TestHelper.assertThat(element, is(notNullValue()), assertionDescription);	
		}
	}
	
	public void assertElementTextContains(String containsText)
	{
	
		String assertionDescription = String.format("Assert Element Text Contains '%1$s'", containsText);
	
		TestLogger.createTestStep(assertionDescription, name, pageName);
		
		try
		{
			String fullText = getElementText();					
			TestHelper.assertThat(fullText, containsString(containsText), assertionDescription);
		}
		catch (Exception e)
		{
			handleException(assertionDescription, e);
		}
	}
	
	public void click()
	{
		TestLogger.createTestStep("Click", name, pageName);
		
		try
		{
			getWebElement(true, true).click();
		}
		catch (Exception e)
		{
			handleException("Click", e);
		}
	}
	
	public void clickNoWait()
	{
		try
		{
			getWebElement(false, false).click();
		}
		catch (Exception e)
		{
			handleException("Click", e);
		}
	}
	
	public Boolean Exists()
	{
		return SeleniumDriverHelper.getElements(locator).size() > 0;
	}
	
	public String getElementAttribute(String attributeName)
	{
		String assertionDescription = String.format("Getting attribute '%1$s' from element '%2$s' on page '%3$s'", attributeName.toUpperCase(), name, pageName);
			
		TestLogger.createTestStep(assertionDescription, name, pageName);
		
		WebElement element = getWebElement(false, true);
		
		return element.getAttribute(attributeName);
	}
	
	public int getElementCount()
	{
		return SeleniumDriverHelper.getWebDriver().findElements(locator).size();
	}
	
	public String getElementText()
	{
		String elementText = null;
		
		try
		{
			elementText = getWebElement(false, true).getText();
		}
		catch (Exception e)
		{
			handleException("Get Element Text", e);
		}
		
		return elementText;
	}
	
	public String getElementValue()
	{
		WebElement element = getWebElement(false, true);
		return element.getAttribute("value");
	}
	
	public String getName()
	{
		return name;
	}
	
	public void jsClick()
	{		
		TestLogger.createTestStep("Javascript Click", name, pageName);
		
		JavascriptExecutor executor = (JavascriptExecutor) SeleniumDriverHelper.getWebDriver();
		executor.executeScript("arguments[0].click();", getWebElement(true, true));
	}
	
	public void waitForElementToBeClickable()
	{
		try
		{
			waitUntilElementToBeClickable();
		}
		catch (Exception e)
		{
			handleException("Wait For Element To Be Clickable", e);
		}
	}
	
	public void waitForElementToVisible()
	{
		try
		{
			waitUntilElementToBeVisible();
		}
		catch (Exception e)
		{
			handleException("Wait For Element To Be Visible", e);
		}
	}
	
	protected WebElement getWebElement(Boolean waitUntilClickable, Boolean waitUntilVisible) 
	{			
		switchToFrame();
		
		if (waitUntilClickable)
		{
			waitUntilElementToBeClickable();
		}
		else if(waitUntilVisible)
		{
			waitUntilElementToBeVisible();			
		}
		
		return SeleniumDriverHelper.getWebDriver().findElement(locator);	
	}
	
	protected void handleException(String actionName, Exception ex)
	{			
		String errorMessage = String.format("%1$s failed on element \"%2$s\" on page \"%3$s\"", actionName, name, pageName);        
		TestHelper.handleException(errorMessage, ex, true);
	}
	
	private void switchToFrame()
	{				
		WebDriver driver = SeleniumDriverHelper.getWebDriver();
		
		//Switch to default frame, most elements will be on the default iframe of the page
		driver.switchTo().defaultContent();
		
		if (frame.length() > 0)
		{
			if (frame.startsWith("//"))
			{
				driver.switchTo().frame(driver.findElement(By.xpath(frame)).toString());
			}
			else
			{				
				//Try to avoid using NAME or ID to identify a frame. XPath is faster
				//Web driver has to search through the entire DOM when we use ID or class (This is very slow)
				driver.switchTo().frame(frame);
			}
		}		
	}
	
	private void waitUntilElementToBeClickable()
	{
		WebDriverWait wait = new WebDriverWait(SeleniumDriverHelper.getWebDriver(), SeleniumDriverHelper.DEFAULT_TIMEOUT);		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	private void waitUntilElementToBeVisible() 
	{
		WebDriverWait wait = new WebDriverWait(SeleniumDriverHelper.getWebDriver(), SeleniumDriverHelper.DEFAULT_TIMEOUT);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
