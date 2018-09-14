package application.pages.elements.appium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.AppiumDriverHelper;
import utilities.TestHelper;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class Element
{	
	protected By locator;
	protected String name;
	protected String pageName;
	
	//private String frame;
	
	public Element(By locator, String elementName, String pageName)
	{		
		this(locator, elementName, pageName, "");
	}
	
	public Element(By locator, String elementName, String pageName, String frame)
	{		
		//this.frame = frame;
		this.locator = locator;
		name = elementName;
		this.pageName = pageName;
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
//		else if (locatorType.equals("classname"))
//		{
//			locator = By.className(locatorText);
//		}
//		else
//		{
//			String exceptionMessage = "\"" + locatorType + "\" is not a valid locator type";
//			throw new RuntimeException(exceptionMessage);
//		}
//	}
	
//	public static void swipeLeftToRight(WebElement element)
//	{
//		performHorizontalSwipe(0.1, 0.9, element);
//	}
//	
//	public static void swipeRightToLeft(WebElement element)
//	{
//		performHorizontalSwipe(0.9, 0.1, element);
//	}
	
//	public static void swipeTopToBottom(WebElement element)
//	{
//		performVerticalSwipe(0.1, 0.6, element);
//	}
//	
//	public static void swipeBottomToTop(WebElement element)
//	{
//		performVerticalSwipe(0.6, 0.1, element);
//	}
	
	public void performSwipe(Integer startXValue, Integer endXValue, Integer startYValue, Integer endYValue, Integer duration)
	{	    
	    AppiumDriverHelper.getDriver().swipe(startXValue, startYValue, endXValue, endYValue, duration);
	}
	
//	private static void performVerticalSwipe(Double startValue, Double endValue, WebElement element)
//	{
//		int width = element.getSize().width;
//		int height = element.getSize().height;
//		
//		int yAxisStart = (int)(height * startValue);
//		int yAxisEnd = (int)(height * endValue);
//		
//		int xAxis = width / 2;
//		
//		AppiumDriverHelper.getDriver().swipe(xAxis, yAxisStart, xAxis, yAxisEnd, 500);
//	}
	
	public void click()
    {                      
		String assertionText = String.format("Clicking %1$s on page %2$s.", name, pageName);
		
		System.out.println(assertionText);
		
        try
        {
        	getElement(true).click();
        }
        catch (Exception e)
        {
        	TestHelper.handleException("Click", e, true);
        }
    }
	
	public void assertElementDoesNotExist()
    {
     	String actionDescription = String.format("Assert Element '%1$s' Does Not Exist on Page '%2$s'", name, pageName);
     	
     	System.out.println(actionDescription);
     	
    	TestHelper.assertThat(exists(), is(false), actionDescription);
    }
    
    public void assertElementExists()
    {              
    	String actionDescription = String.format("Assert Element '%1$s' Exists on Page '%2$s'", name, pageName);
    	
    	System.out.println(actionDescription);
    	
    	TestHelper.assertThat(getElement(false), is(notNullValue()), actionDescription);
    }
    
    public void assertElementTextContains(String expectedValue)
    {
    	String actionDescription = String.format("Assert Element '%1$s' Text Contains '%2$s' on Page '%3$s'", name, expectedValue, pageName);
    	
    	System.out.println(actionDescription);
    	
    	TestHelper.assertThat(getText(), containsString(expectedValue), actionDescription);
    }
    
    public void assertElementTextEquals(String expectedValue)
    {
    	String actionDescription = String.format("Assert Element '%1$s' Text Is '%2$s' on Page '%3$s'", name, expectedValue, pageName);
    	
    	System.out.println(actionDescription);
    	
    	TestHelper.assertThat(getText(), is(equalTo(expectedValue)), actionDescription);
    }
    
    public Boolean exists()
    {
    	return getElementCount() > 0;
    }
    
    protected WebElement findElement()
    {
    	return AppiumDriverHelper.getDriver().findElement(locator);            
    }
    
    public int getElementCount()
    {
    	return AppiumDriverHelper.getDriver().findElements(locator).size();
    }
    
    public String getText()
    {
    	return getElement(false).getText();
    }
    
    public By getLocator()
    {
    	return locator;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public String getPageName()
    {
    	return pageName;
    }
    
    public void waitForElementToBeClickable()
    {
    	WebDriverWait wait = new WebDriverWait(AppiumDriverHelper.getDriver(), AppiumDriverHelper.DEFAULT_TIMEOUT);
    	wait.until(ExpectedConditions.elementToBeClickable(findElement()));
    }
    
    public void waitForElementToBeDisplayed()
    {
    	WebDriverWait wait = new WebDriverWait(AppiumDriverHelper.getDriver(), AppiumDriverHelper.DEFAULT_TIMEOUT);
    	wait.until(ExpectedConditions.visibilityOf(findElement()));
    }
    
    protected WebElement getElement(Boolean waitUntilClickable)
    {
		int attempts = 0;
		
		while (attempts < 2) 
		{
			   
			try 
			{
				WebElement element = AppiumDriverHelper.getDriver().findElement(locator);
				return element;
			} 
			catch (StaleElementReferenceException e) 
			{
			   System.out.println("The element reference is stale");
			}
			
			attempts++;
		}
    
    	return null;
    }
}