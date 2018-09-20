package stepdefinitions;

import cucumber.api.java.en.Given;
import utilities.RestApiHelper;

public class TrelloSteps
{
	@Given ("^the API call response is correct$")
	public static void theApiCallResponseIsCorrect()
	{
		RestApiHelper.createTrelloBoard("my Api Test Board", "Created using the Trello API calls");
	}
}