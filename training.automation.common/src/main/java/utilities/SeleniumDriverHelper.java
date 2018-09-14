package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriverHelper
{
	private static WebDriver driver = null;
	
	private static final String CHROME_PATH = System.getProperty( "user.dir" ) + "\\Drivers\\chromedriver.exe";
	private static final String EDGE_PATH = System.getProperty( "user.dir" ) + "\\Drivers\\MicrosoftWebDriver.exe";
	private static final String FIREFOX_PATH = System.getProperty( "user.dir" ) + "\\Drivers\\geckodriver.exe";
	private static final String IE_PATH = System.getProperty( "user.dir" ) + "\\Drivers\\IEDriverServer.exe";

	public static final long DEFAULT_TIMEOUT = 10;
	
	private SeleniumDriverHelper()
	{
		//Stop misuse
	}
	
	public static void destroyDriver()
	{
		driver.quit();
		driver = null; //Garbage collection
	}
	
	public static String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public static WebDriver getWebDriver()
	{
		return driver;
	}
	
	public static void goToUrl( String url )
	{
		driver.navigate().to( url );
	}
	
	public static void initialise( String browser )
	{
		browser = browser.toLowerCase();
		
		switch ( browser )
		{
			case "chrome":
				System.setProperty( "webdriver.chrome.driver", CHROME_PATH );
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty( "webdriver.gecko.driver", FIREFOX_PATH );
				driver = new FirefoxDriver();
				break;
			case "internet explorer":
				System.setProperty( "webdriver.ie.driver", IE_PATH );
				driver = new InternetExplorerDriver();
				break;
			case "edge":
				System.setProperty( "webdriver.edge.driver", EDGE_PATH );
				driver = new EdgeDriver();
				break;
			default:
				throw new RuntimeException( "Browser choise not set or choice incorrect: " + browser );
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
	}
	
	public static void waitForElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(getWebDriver(), DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToBeVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(getWebDriver(), DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
