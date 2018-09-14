package data;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DeviceDetails
{		
	public static DesiredCapabilities getCapabilities(String iPadName, String bundleId)
	{
		switch (iPadName.toLowerCase()) 
		{
			case "ipadone":
				return getCapabilitiesForiPadOne(bundleId);
			case "ipadtwo":
				return getCapabilitiesForiPadTwo(bundleId);
			default: 
				return null;
		}
	}
	
	// ROQiPad
	private static DesiredCapabilities getCapabilitiesForiPadOne(String bundleId)
	{
		DesiredCapabilities desiredCapabilities = getCommonCapabilities();
		
		desiredCapabilities.setCapability("udid", "0464173d5acf9c1c5375ddf6d447b72c111d6ff4");
		desiredCapabilities.setCapability("deviceName", "RoqIT Ipad");
		desiredCapabilities.setCapability("platformVersion", "10.2.1");
		desiredCapabilities.setCapability("bundleId", bundleId);
		
		return desiredCapabilities;
	}

	// JuliansiPad
	private static DesiredCapabilities getCapabilitiesForiPadTwo(String bundleId)
	{
		DesiredCapabilities desiredCapabilities = getCommonCapabilities();
		
		desiredCapabilities.setCapability("platformVersion", "9.3.5");
		desiredCapabilities.setCapability("udid", "6d2158b232322826f47990fb5f7f73d2617ea6d1");
		desiredCapabilities.setCapability("deviceName", "Ben's iPad");
		desiredCapabilities.setCapability("bundleId", bundleId);
		
		return desiredCapabilities;
	}

	private static DesiredCapabilities getCommonCapabilities()
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		desiredCapabilities.setCapability("automationName","XCUITest");
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("updatedWDABundleId", "com.roq.WebDriverAgentRunner");
		
		return desiredCapabilities;
	}
}
