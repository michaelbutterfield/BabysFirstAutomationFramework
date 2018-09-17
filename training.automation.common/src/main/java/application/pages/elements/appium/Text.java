package application.pages.elements.appium;

import org.openqa.selenium.By;

import application.pages.elements.appium.common.Element;

public class Text extends Element
{
	public Text(By locator, String elementName, String pageName)
	{		
		super(locator, elementName, pageName, "");
	}
	
	public Text(By locator, String elementName, String pageName, String frame)
	{		
		super(locator, elementName, pageName, frame);
	}
}
