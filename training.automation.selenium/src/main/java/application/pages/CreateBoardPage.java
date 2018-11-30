package application.pages;

import org.openqa.selenium.By;

import application.pages.elements.selenium.Button;
import application.pages.elements.selenium.InputBox;

public class CreateBoardPage extends Page
{
    public Button backgroundSelectionButton;
    public Button createBoardButton;
    public InputBox nameInput;

    public CreateBoardPage()
	{
		super("Create Board Page");
		buildPage();
	}
    
    private void buildPage()
    {
        backgroundSelectionButton 	= new Button(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/div/ul/li[2]/button"), "Board Background Selection", name);
        createBoardButton			= new Button(By.xpath("//button[@class=\"primary\"][@type=\"submit\"]"), "Create Board Button", name);
        nameInput 					= new InputBox(By.xpath("//input[@placeholder='Add board title']"), "Board Name Input Box", name);
    }
}
