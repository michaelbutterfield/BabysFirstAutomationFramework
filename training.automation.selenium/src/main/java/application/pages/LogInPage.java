package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.*;

public class LogInPage extends Page
{
	public Link createAnAccount;
	public InputBox emailAddress;
	public Button giantTrelloImage;
	public Button logInButton;
	public InputBox password;
	
	public LogInPage()
	{
		super("Log In Page");
		buildPage();
	}
	
	private void buildPage()
	{
		createAnAccount = new Link(By.xpath("//*[@id=\"signup\"]"), "Create An Account Link", name);
		emailAddress = new InputBox(By.xpath("//*[@id=\"user\"]"), "Email Address Input Box", name);
		giantTrelloImage = new Button(By.xpath("//img[@alt='Home']"), "Giant Trello image", name);
		logInButton = new Button(By.xpath("//*[@id=\"login\"]"), "Log In Button", name);
		password = new InputBox(By.xpath("//*[@id=\"password\"]"), "Password Input Box", name);
	}
}
