package application.pages.calculator;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.winium.Button;
import application.pages.elements.winium.Container;

public class MainPage extends Page
{
    public Container calculatorResults;
	public Button equals;
    public Button log;
    public Button one;
    public Button openNavigation;
    public Button plus;
    public Button positiveNegative;
    public Button scientificCalculator;
    public Button standardCalculator;
    public Button two;
    public Button zero;
		
	public MainPage()
	{
		super("MainPage");
		buildPage();
	}
	
	private void buildPage()
	{
		calculatorResults = new Container(By.id("CalculatorResults"), "Results Display", name);
		equals = new Button(By.id("equalButton"), "= Button", name);
		log = new Button(By.id("logBase10Button"), "Log Button", name);
		one = new Button(By.id("num1Button"), "1 Button", name);
		openNavigation = new Button(By.id("TogglePaneButton"), "Open Navigation", name);
		plus = new Button(By.id("plusButton"), "+ Button", name);
		positiveNegative = new Button(By.id("negateButton"), "Positive Negative Button", name);
		scientificCalculator = new Button(By.id("Scientific"), "Scientific Calculator option in Navigation Pane", name);
		standardCalculator = new Button(By.id("Standard"), "Standard Calculator option in Navigation Pane", name);
		two = new Button(By.id("num2Button"), "2 Button", name);
		zero = new Button(By.id("num0Button"), "0 Button", name);
	}
}
