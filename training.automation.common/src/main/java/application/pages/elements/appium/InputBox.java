package application.pages.elements.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import application.pages.elements.appium.common.Element;
import utilities.TestHelper;


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
			WebElement element = getElement(true);
			element.clear();
		}
		catch (Exception e)
		{
			TestHelper.handleException("Clear Text", e, false);
		}
	}
	
	public void inputText(String text)
	{
        String testStepDescription = String.format("'Input Text' \"%1$s\" into element '%2$s' on page '%3$s' ", text, name, pageName);        

        System.out.println(testStepDescription);
        
		try
		{
			WebElement element = getElement(true);
			element.sendKeys(text);
		}
		catch (Exception e)
		{
			TestHelper.handleException("Input Text", e, false);
		}
	}
}