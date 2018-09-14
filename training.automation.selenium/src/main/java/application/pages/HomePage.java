package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.*;

public class HomePage extends Page
{
	public Button logIn;
	public Button signUp;
	
	public HomePage()
	{
		super("HomePage");
		buildPage();
	}
	
	private void buildPage()
	{
		logIn = new Button(By.xpath( "/html/body/div[1]/div[2]/a[1]" ), "Login Button", name);
		signUp = new Button(By.xpath( "/html/body/div[1]/div[2]/a[2]" ), "Sign Up Button", name);
	}
}
