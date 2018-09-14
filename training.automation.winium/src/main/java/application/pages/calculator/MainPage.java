package application.pages.calculator;

import org.openqa.selenium.By;

import application.pages.Page;
import application.pages.elements.winium.Button;
import application.pages.elements.winium.Container;

public class MainPage extends Page
{
	public Button positiveNegative;
	public Button openNavigation;
	
	public Button zero;
	public Button one;
	public Button two;
	
	public Button plus;
	public Button equals;
	
	public Button log;
	
	public Container calculatorResults;
	
	public Button scientificCalculator;
	public Button standardCalculator;
	
	public MainPage()
	{
		super("MainPage");
		buildPage();
	}
	
	private void buildPage()
	{
		positiveNegative = new Button(By.id("negateButton"), "Positive Negative Button", name);
		openNavigation = new Button(By.id("TogglePaneButton"), "Open Navigation", name);
		
		zero = new Button(By.id("num0Button"), "0 Button", name);
		one = new Button(By.id("num1Button"), "1 Button", name);
		two = new Button(By.id("num2Button"), "2 Button", name);
		
		plus = new Button(By.id("plusButton"), "+ Button", name);
		equals = new Button(By.id("equalButton"), "= Button", name);
		
		log = new Button(By.id("logBase10Button"), "Log Button", name);
		
		calculatorResults = new Container(By.id("CalculatorResults"), "Results Display", name);
		
		scientificCalculator = new Button(By.id("Scientific"), "Scientific Calculator option in Navigation Pane", name);
		standardCalculator = new Button(By.id("Standard"), "Standard Calculator option in Navigation Pane", name);
	}
}
