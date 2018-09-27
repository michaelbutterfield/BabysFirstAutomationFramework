package application.sections;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Image;

public class Header extends Section
{
	public Image backToHome;
	public Image trelloLogoHome;
	
	public Header()
	{
		super("Header");
		buildSections();
	}
	
	private void buildSections()
	{
		backToHome = new Image(By.xpath("//*[@id=\"header\"]/div[1]/a"), "Back to Home button in Top Left", name);
		trelloLogoHome = new Image(By.xpath("//*[@id=\"header\"]/a/span[2]"), "Trello Logo Home Button", name);
	}
}
