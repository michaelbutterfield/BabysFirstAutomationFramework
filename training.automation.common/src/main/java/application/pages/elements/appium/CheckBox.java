package application.pages.elements.appium;

import org.openqa.selenium.By;
import application.pages.elements.selenium.common.Element;

public class CheckBox extends Element
{
	public CheckBox(By locator, String elementName, String pageName)
	{		
		super(locator, elementName, pageName, "");
	}
	
	public CheckBox(By locator, String elementName, String pageName, String frame)
	{		
		super(locator, elementName, pageName, frame);
	}
	
	public Boolean isSelected()
	{
		return getWebElement(false, true).isSelected();
	}
}