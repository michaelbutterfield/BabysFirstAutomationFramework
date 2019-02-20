package stepdefinitions;

import cucumber.api.java.en.Given;
import trello.data.TrelloApiHelper;

public class TrelloSteps
{
	@Given ("^the API call response is correct$")
	public static void theApiCallResponseIsCorrect()
	{
		TrelloApiHelper.getTrelloBoardId("apitestboard");
		
		//ApiHelper.createTrelloBoard("my Api Test Board", "Created using the Trello API calls");
		//ApiHelper.deleteTrelloBoard(ApiHelper.getTrelloBoardId("my Api Test Board"));
	}
}