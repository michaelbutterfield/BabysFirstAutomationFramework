package application.pages.elements.winium.common;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import utilities.TestHelper;
import utilities.WiniumDriverHelper;

public class Element 
{
	protected By locator;
	protected String name;
	protected String pageName;
	
	public Element(By locator, String elementName, String pageName)
	{		
		this(locator, elementName, pageName, "");
	}
	
	public Element(By locator, String elementName, String pageName, String frame)
	{		
		this.locator = locator;
		name = elementName;
		this.pageName = pageName;
	}

	public void assertAttributeContains(String attribute, String expectedText)
	{
		String stepDescription = String.format("Assert Element '%1$s' Attribute '%2$s' Contains '%3$s'", name, attribute, expectedText);

		String actualText = getAttribute(attribute);
		TestHelper.assertThat(actualText, containsString(expectedText), stepDescription);
	}

	public void assertAttributeEquals(String attributeName, String expectedAttributeValue)
	{
		String stepDescription = String.format("Assert Element '%1$s' Attribute '%2$s' Equals '%3$s'", name, attributeName, expectedAttributeValue);
		
		String actualAttributeValue = getAttribute(attributeName);
		TestHelper.assertThat(actualAttributeValue, is(equalTo(expectedAttributeValue)), stepDescription);
	}
		
	public void assertDoesNotExist()
	{
		String stepDescription = "Assert Element Does Not Exists";
		TestHelper.assertThat(exists(), is(false), stepDescription);
	}
	
	public void assertExists()
	{
		String stepDescription = "Assert Element Exists '%1$s' on page '%2$s'";
		stepDescription = String.format(stepDescription, name, pageName);
		WebElement element = null;
		
		try		
		{
			element = WiniumDriverHelper.getElement(locator);
		}
		catch (Exception e)
		{
			handleException(stepDescription, e);
		}
		finally
		{
			TestHelper.assertThat(element, is(notNullValue()), stepDescription);
		}
	}

	public void attemptClick(Boolean throwNoSuchElementException)
	{
		click("Attempt Click", 5, throwNoSuchElementException);
	}
	
	public void click()
	{
		click("Click", 5, false);
	}

	public Boolean exists()
	{
		return WiniumDriverHelper.getElements(locator).size() > 0;
	}

	public String getAttribute(String attribute)
	{
		//String actionName = "Get Attribute' '" + attribute;
		
		String attributeValue = "";
		
		try
		{
			attributeValue = WiniumDriverHelper.getElement(locator).getAttribute(attribute);
		}
		catch (Exception e)
		{
			handleException("Get Attribute", e);
		}
		
		return attributeValue;
	}

	public List<WebElement> getChildElements()
	{
		return getChildElementsByXpath("./*");
	}
	
	public List<WebElement> getChildElementsByXpath(String xpath)
	{
		return WiniumDriverHelper.getElement(locator).findElements(By.xpath(xpath));
	}
	
	public int getCount()
	{
		return WiniumDriverHelper.getElements(locator).size();
	}
	
	public void waitUntilDoesNotExist()
	{
		int maxRetry = 20;
		int retries = 0;
	
		while (retries++ < maxRetry)
		{
			if (!exists())
			{
				break;
			}
			
			if (retries == maxRetry)
			{
				String message = "";
				TestHelper.handleException(message, new Throwable(message), true);
			}
		}
	}
	
	public void waitUntilExists()
	{
		int maxRetry = 20;
		int retries = 0;
		
		while (retries++ < maxRetry)
		{
			try
			{			
				WiniumDriverHelper.getElement(locator);		
			}		
			catch (NoSuchElementException e)
			{
				if (retries == maxRetry)
				{
					handleException("Wait Until Exists", e);
				}
				else
				{
					TestHelper.sleepInSeconds(1);
					continue;
				}				
			}
			catch (Exception e)
			{
				handleException("Wait Until Exists", e);
			}
		}
	}

	protected void handleException(String action, Throwable e)
	{
		String errorMessage = "Action '%1$s' Failed";
		errorMessage = String.format(errorMessage, action, name, pageName);
		
		TestHelper.handleException(errorMessage, e, true);
	}
	
//	private void buildLocator()
//	{
//		locator = null;
//		
//		String locatorType = this.locatorType.toLowerCase();
//		
//		if (locatorType.equals("name"))
//		{
//			locator = By.name(locatorText);
//		}			
//		else if (locatorType.equals("id"))
//		{
//			locator = By.id(locatorText);
//		}
//		else if (locatorType.equals("xpath"))
//		{
//			locator = By.xpath(locatorText);
//		}
//		else
//		{
//			String exceptionMessage = "\"" + locatorType + "\" is not a valid locator type";
//			throw new RuntimeException(exceptionMessage);
//		}
//	}
	
	private void click(String clickType, int maxRetry, Boolean throwNoSuchElementException)
	{
		int retries = 0;
		
		while (retries++ < maxRetry)
		{
			try
			{			
				WiniumDriverHelper.getElement(locator).click();
				break;
			}		
			catch (NoSuchElementException e)
			{
				if (clickType.equals("Attempt Click"))
				{
					if (retries == maxRetry &&
						throwNoSuchElementException)
					{
						throw e;
					}
					else
					{
						TestHelper.sleepInSeconds(1);
						continue;
					}	
				}
				else
				{
					if (retries == maxRetry)
					{
						handleException(clickType, e);
					}
					else
					{		
						continue;
					}
				}
			}
			catch (WebDriverException e)
			{
				// added to try an swallow exception when element exists but is not currently intractable
				if (e.getMessage().contains("NOT CLICK") && retries < maxRetry)
				{
					TestHelper.sleepInSeconds(5);
					continue;
				}
				else
				{
					handleException(clickType, e);
				}
			}
			catch (Throwable e)
			{
				handleException(clickType, e);
			}
		}	
	}
}