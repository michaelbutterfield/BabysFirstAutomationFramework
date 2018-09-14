package application.pages.elements.appium;

import org.openqa.selenium.By;

import application.pages.elements.appium.common.Element;

public class Button extends Element
{	
	public Button(By locator, String elementName, String pageName)
	{		
		super(locator, elementName, pageName, "");
	}
	
	public Button(By locator, String elementName, String pageName, String frame)
	{		
		super(locator, elementName, pageName, frame);
	}
}