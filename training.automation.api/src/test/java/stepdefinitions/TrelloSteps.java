package stepdefinitions;

import cucumber.api.java.en.Given;
import utilities.ApiHelper;

public class TrelloSteps
{
	@Given ("^the API call response is correct$")
	public static void theApiCallResponseIsCorrect()
	{
		ApiHelper.createTrelloBoard("my Api Test Board", "Created using the Trello API calls");
		ApiHelper.deleteTrelloBoard(ApiHelper.getTrelloBoardId("my Api Test Board"));
	}
}