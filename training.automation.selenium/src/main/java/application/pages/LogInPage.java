package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.*;

public class LogInPage extends Page
{
	public Button logInButton;
	public Link createAnAccount;
	public InputBox emailAddress;
	public InputBox password;
	
	public LogInPage()
	{
		super("LogInPage");
		buildPage();
	}
	
	private void buildPage()
	{
		createAnAccount =	new Link(By.xpath("//*[@id=\"signup\"]"), "Create An Account Link", name);
		emailAddress =		new InputBox(By.xpath("//*[@id=\"user\"]"), "Email Address Input Box", name);
		logInButton =		new Button(By.xpath("//*[@id=\"login\"]"), "Log In Button", name);
		password =			new InputBox(By.xpath("//*[@id=\"password\"]"), "Password Input Box", name);
	}
}
