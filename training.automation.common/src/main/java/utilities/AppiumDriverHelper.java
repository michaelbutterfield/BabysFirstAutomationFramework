package utilities;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class AppiumDriverHelper
{
	private static IOSDriver<MobileElement> driver = null;

	public static int DEFAULT_TIMEOUT = 10;

	public static IOSDriver<MobileElement> getDriver()
	{
		return driver;
	}

	public static void closeApplication()
	{
		driver.closeApp();
	}

	public static void launchApplication(String serverIp, String appiumPort, DesiredCapabilities capabilities)
	{
		String url = String.format("http://%1$s:%2$s/wd/hub", serverIp, appiumPort);
		
		try
		{
			driver = new IOSDriver<MobileElement>(new URL(url), capabilities);
		}
		catch (Exception e)
		{
			String errorMessage = "Failed to launch Appium Driver";
			TestHelper.handleException(errorMessage, e, true);
		}		
	}

	public static void resetApplication()
	{
		driver.resetApp();
	}
}
