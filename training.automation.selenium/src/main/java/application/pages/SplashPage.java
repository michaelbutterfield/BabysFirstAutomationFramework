package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.*;

public class SplashPage extends Page
{
	public Button logIn;
	public Button signUp;
	
	public SplashPage()
	{
		super("Splash Page");
		buildPage();
	}
	
	private void buildPage()
	{
		logIn 	= new Button(By.xpath( "//a[@href='/login?returnUrl=%2F']" ), "Login Button", name);
		signUp 	= new Button(By.xpath( "//a[@href='/signup?returnUrl=%2F']" ), "Sign Up Button", name);
	}
}
