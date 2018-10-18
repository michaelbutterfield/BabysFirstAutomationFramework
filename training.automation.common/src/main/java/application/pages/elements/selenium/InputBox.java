package application.pages.elements.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import application.pages.elements.selenium.common.Element;
import tests.TestLogger;

public class InputBox extends Element
{
	public InputBox(By locator, String elementName, String pageName)
	{		
		super(locator, elementName, pageName, "");
	}
	
	public InputBox(By locator, String elementName, String pageName, String frame)
	{		
		super(locator, elementName, pageName, frame);
	}
	
	public void clearText()
	{
		try
		{
			WebElement element = getWebElement(true, true);
			element.clear();
		}
		catch (Exception e)
		{
			handleException("Clear Text", e);
		}
	}
	
	public void inputText(String text)
	{
        String testStepDescription = String.format("Input Text '%1$s' into", text);        

        TestLogger.createTestStep(testStepDescription, name, pageName);
        
		try
		{
			WebElement element = getWebElement(true, true);
			element.sendKeys(text);
		}
		catch (Exception e)
		{
			handleException("Input Text", e);
		}
	}
}