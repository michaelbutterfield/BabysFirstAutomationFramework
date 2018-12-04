package trello;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ApiHelper;
import utilities.TestHelper;

public class TrelloApiHelper extends ApiHelper
{
	private TrelloApiHelper()
	{
		
	}
	
	public static void createTrelloBoard(String boardName, String boardDesc)
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		/*
			Thought it would fail due to spaces being in the API post request so tried replacing
			it with +'s and %20's but when posting with the spaces left in it handles it fine
		
		String encodedBoardName = "";
		String encodedBoardDesc = "";
		encodedBoardName = URLEncoder.encode(boardName, "UTF-8").replaceAll("\\+", "%20");
		encodedBoardDesc = URLEncoder.encode(boardDesc, "UTF-8").replaceAll("\\+", "%20");
		
		*/
		
		String create = String.format("/1/boards/?name=%1$s&desc=%2$s&key=%3$s&token=%4$s", boardName, boardDesc, TrelloApiData.getApiKey(), TrelloApiData.getApiToken());
		
		Response createResponse = RestAssured.given().contentType("application/json\r\n").post(create);
		
		System.out.println("Assert that board was created successfully: " + createResponse.statusCode() + " = " + "200");
		
		TestHelper.assertThat(createResponse.statusCode(), is(equalTo(200)), ("Assert that board was created successfully: " + createResponse.statusCode() + " = " + "200"));
	}
	
	public static void deleteTrelloBoard(String boardId)
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		String delete = String.format("/1/boards/%1$s?key=%2$s&token=%3$s", boardId, TrelloApiData.getApiKey(), TrelloApiData.getApiToken());
		
		Response deleteResponse = RestAssured.delete(delete);
		
		System.out.println("Assert that board was deleted successfully: " + deleteResponse.statusCode() + " = " + "200");
		
		TestHelper.assertThat(deleteResponse.statusCode(), is(equalTo(200)), ("Assert that board was deleted successfully: " + deleteResponse.statusCode() + " = " + "200"));
	}
	
	public static String getTrelloBoardId(String boardName)
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		String getBoards = String.format("/1/search?query=%1$s&modelTypes=boards&board_fields=id&key=%2$s&token=%3$s", boardName, TrelloApiData.getApiKey(), TrelloApiData.getApiToken());
		
		Response boardResponse = RestAssured.get(getBoards);

		List<Object> board = boardResponse.getBody().jsonPath().getList("boards.id");
		
		return board.toString().replaceAll("\\[", "").replaceAll("\\]", "");
	}
}
