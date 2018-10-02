package application.sections.calculator;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.sections.Section;

public class NavigationPane extends Section
{
	public Button scientificCalculator;
	public Button standardCalculator;
	
	public NavigationPane()
	{
		super("NavigationPane");
		buildSections();
	}
	
	private void buildSections()
	{
		scientificCalculator = new Button(By.id("Scientific"), "Scientific Calculator option in Navigation Pane", name);
		standardCalculator = new Button(By.id("Standard"), "Standard Calculator option in Navigation Pane", name);
	}
}