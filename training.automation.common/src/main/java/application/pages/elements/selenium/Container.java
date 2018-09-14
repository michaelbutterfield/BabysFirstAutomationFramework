package application.pages.elements.selenium;

import org.openqa.selenium.By;
import application.pages.elements.selenium.common.Element;

public class Container extends Element
{
	public Container(By locator, String elementName, String pageName)
	{		
		super(locator, elementName, pageName, "");
	}
	
	public Container(By locator, String elementName, String pageName, String frame)
	{		
		super(locator, elementName, pageName, frame);
	}
}