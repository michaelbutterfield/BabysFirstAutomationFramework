package application.pages.elements.selenium;

import org.openqa.selenium.By;
import application.pages.elements.selenium.common.Element;

public class Image extends Element
{
	public Image(By locator, String elementName, String pageName)
	{		
		super(locator, elementName, pageName, "");
	}
	
	public Image(By locator, String elementName, String pageName, String frame)
	{		
		super(locator, elementName, pageName, frame);
	}
}