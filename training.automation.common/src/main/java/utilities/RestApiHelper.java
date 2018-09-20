package utilities;

import org.json.simple.JSONObject;
import org.testng.Assert;

import data.TrelloData;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestApiHelper
{
	private static RequestSpecification httpRequest;
	private static Response response;
	private static Integer correctStatusCode = 200;
	
	private RestApiHelper()
	{
		//bleh
	}
	
	@SuppressWarnings("unchecked")
	public static void createNewJsonData(String k, String v)
	{
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put(k, v);
		
		request.header("Content-Type", "application/json");
		
		request.body(requestParams.toJSONString());
		
		try
		{
			response = request.post("/register");	
		}
		catch(Exception e)
		{
			String errorMessage = String.format("Failed to post request to create new JSON data: %1$s", response);
			
			TestHelper.handleException(errorMessage, e, false);
		}
			
		successfulPost();
	}
	
	public static String extractJsonNodeText(String Key)
	{
		JsonPath jsonPathEval = response.jsonPath();
		
		String get = jsonPathEval.get(Key);
		
		System.out.println("Value received from response: " + get);
		
		return get;
	}
	
	public static String getTrelloBoardId(String boardName)
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		String getBoards = String.format("/1/search?query=%1$s&modelTypes=boards&board_fields=id&key=%2$s&token=%3$s", boardName, TrelloData.getApiKey(), TrelloData.getApiToken());
		
		Response boardResponse = RestAssured.get(getBoards);

		ArrayList board = boardResponse.getBody().jsonPath().get("boards");
		
		String boardString = board.toString();
		
		String strippedBoardId = boardString.substring(5, 29);
		
		return strippedBoardId;
	}
	
	public static void createTrelloBoard(String boardName, String boardDesc)
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		String encodedBoardName = "";
		
		String encodedBoardDesc = "";
		
		try
		{
			encodedBoardName = URLEncoder.encode(boardName, "UTF-8");
			encodedBoardDesc = URLEncoder.encode(boardDesc, "UTF-8");
		}
		catch (Exception e)
		{
			String errorMessage = String.format("Could not encode create board url");
			TestHelper.handleException(errorMessage, e, false);
		}
		
		String create = String.format("/1/boards/?name=%1$s&desc=%2$s&key=%3$s&token=%4$s", encodedBoardName, encodedBoardDesc, TrelloData.getApiKey(), TrelloData.getApiToken());
		
		System.out.println(create);
		
		Response createResponse = RestAssured.post(create);
		
		createResponse.prettyPrint();
	}
	
	public static String getBaseURI()
	{
		return RestAssured.baseURI;
	}

	public static Response getResponse(String request)
	{
		return httpRequest.get(request);
	}
	
	public static Integer getStatusCode()
	{
		return response.getStatusCode();
	}
	
	public static void initialise(String givenBaseUri)
	{
		setBaseURI(givenBaseUri);
	}
	
	public static void setBaseURI(String givenBaseUri)
	{
		RestAssured.baseURI = givenBaseUri;
		httpRequest = RestAssured.given();
	}
	
	private static void successfulPost()
	{
		Integer statusCode = response.getStatusCode();
		
		Integer passCode = 201;
		
		String stepDescription = String.format("Assert that code reply from post (%1$s) is equal to expected response (%2$s).", statusCode, "201");

		TestHelper.assertThat(statusCode, is(equalTo((passCode))), stepDescription, false);		
	}
	
	public static void validateStatusCode()
	{
		try
		{
			Assert.assertEquals(/*Actual*/ getStatusCode(),
								/*Expected*/ correctStatusCode);
		}
		catch(Exception e)
		{
			String exceptionMessage = String.format("Status code returned was %1$s, not the expected 200 status code", getStatusCode());
			TestHelper.handleException(exceptionMessage, e, false);
		}
	}
}
