package tests;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import utilities.TestHelper;

public class ScenarioHooks
{
	@Before(order = 100)
	public static void scenarioSetup(Scenario scenario)
	{
		TestHelper.setScenario(scenario);
	}
}
