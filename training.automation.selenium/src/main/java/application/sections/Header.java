package application.sections;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.pages.elements.selenium.Image;

public class Header extends Section
{
	public Button accountAvatar;
	public Image backToHome;
	public Image trelloLogoHome;
	
	public Header()
	{
		super("Header");
		buildSections();
	}
	
	private void buildSections()
	{
		accountAvatar	= new Button(By.xpath("//*[@id=\"header\"]/div[5]/a[4]/span"), "Account Avatar button", name);
		backToHome		= new Image(By.xpath("//*[@id=\"header\"]/div[1]/a"), "Home Icon in Top Left", name);
		trelloLogoHome	= new Image(By.xpath("//*[@id=\"header\"]/a/span[2]"), "Trello Logo Home Button", name);
	}
}
