package application.pages.elements.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import application.pages.elements.selenium.common.Element;

public class DropDown extends Element
{
	public DropDown(By locator, String elementName, String pageName)
	{		
		super(locator, elementName, pageName, "");
	}
	
	public DropDown(By locator, String elementName, String pageName, String frame)
	{		
		super(locator, elementName, pageName, frame);
	}
	
	public void selectOptionByIndex(int index)
	{
		String testStepDescription = String.format("Select '{0}' Drop Down Option '{1}' (By Index) ", getName(), index);		

		System.out.println(testStepDescription);
		
		try
		{
			Select dropdown = new Select(getWebElement(false, true));		
			dropdown.selectByIndex(index);
		}
		catch (Exception e)
		{
			handleException("Select Option (By Index)", e);
		}
	}
	
	public void selectOptionByText(String option) 
	{
		String testStepDescription = String.format("Select '{0}' Drop Down Option '{1}' (By Text) ", getName(), option);		

		System.out.println(testStepDescription);
		
		try
		{
			Select dropdown = new Select(getWebElement(false, true));		
			dropdown.selectByVisibleText(option);
		}
		catch (Exception e)
		{
			handleException("Select Option (By Text)", e);
		}		
	}
	
	public void selectOptionByValue(String option) 
	{
		String testStepDescription = String.format("Select '{0}' Drop Down Option '{1}' (By Value) ", getName(), option);		
		
		System.out.println(testStepDescription);
		
		try
		{
			Select dropdown = new Select(getWebElement(false, true));		
			dropdown.selectByValue(option);
		}
		catch (Exception e)
		{
			handleException("Select Option (By Value)", e);
		}
	}
}