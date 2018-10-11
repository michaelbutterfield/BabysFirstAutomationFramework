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
		logIn =		new Button(By.xpath( "/html/body/div[1]/div[2]/a[1]" ), "Login Button", name);
		signUp =	new Button(By.xpath( "/html/body/div[1]/div[2]/a[2]" ), "Sign Up Button", name);
	}
}
