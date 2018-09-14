package application.pages.elements.selenium;

import org.openqa.selenium.By;
import application.pages.elements.selenium.common.Element;

public class Label extends Element
{
	public Label(By locator, String elementName, String pageName)
	{		
		super(locator, elementName, pageName, "");
	}
	
	public Label(By locator, String elementName, String pageName, String frame)
	{		
		super(locator, elementName, pageName, frame);
	}
}