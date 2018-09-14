package utilities;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class WiniumDriverHelper
{
	private static WiniumDriver driver = null;
	
	private WiniumDriverHelper()
	{
		//prevent misuse
	}
	
	public static WiniumDriver getWiniumDriver()
	{
		return driver;
	}
	
	public static void destroyDriver()
	{
		driver = null;
		
		System.out.println("Driver nulled");
	}
	
	public static WebElement getElement(By locator)
	{		
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator)
	{		
		return driver.findElements(locator);
	}
	
	public static void initialise(String applicationPath, String winiumPath, Integer winiumPort)
	{	
		File winiumDriverPathFile = new File(System.getProperty("user.dir") + "\\Drivers\\Winium.Desktop.Driver.exe");
		
		WiniumDriverService service = new WiniumDriverService.Builder()
															 .usingDriverExecutable(winiumDriverPathFile)
															 .usingPort(winiumPort)
															 .withVerbose(true)
															 .withSilent(true)
															 .buildDesktopService();
		
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath(applicationPath);
				
		try
		{
			driver = new WiniumDriver(service, options);
			System.out.println("started winium driver");
		}
		catch(Exception e)
		{
			if(service.isRunning())
			{
				System.out.println("service was running");
				service.stop();
			}
			String errorMessage = "Failed to launch Winium Driver";
			TestHelper.handleException(errorMessage, e, false);
		}
	}
}
