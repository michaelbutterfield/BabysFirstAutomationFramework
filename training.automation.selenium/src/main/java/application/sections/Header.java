package application.sections;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.pages.elements.selenium.Image;

public class Header extends Section
{
	public Button accountAvatar;
	public Button addButton;
	public Image backToHome;
	public Button logOutButton;
	public Image trelloLogoHome;
	
	public Header()
	{
		super("Header");
		buildSections();
	}
	
	private void buildSections()
	{
		accountAvatar	= new Button(By.xpath("//span[@class='member-initials']"), "Account Avatar button", name);
		addButton 		= new Button(By.xpath("//span[@class=\"header-btn-icon icon-lg icon-add light\"]"), "Add Button", name);
		backToHome		= new Image(By.xpath("//span[@class='header-btn-icon icon-lg icon-house light']"), "Home Icon in Top Left", name);
		logOutButton 	= new Button(By.xpath("//a[@class='js-logout']"), "Log Out Button", name);
		trelloLogoHome	= new Image(By.xpath("//span[@class='header-logo-default']"), "Trello Logo Home Button", name);
	}
}
