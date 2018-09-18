package utilities;

import org.json.simple.JSONObject;
import org.testng.Assert;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiHelper
{
	private static RequestSpecification httpRequest;
	private static Response response;
	private static Integer correctStatusCode = 200;
	
	private RestApiHelper()
	{
		//misuse
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
	
	public static void extractJsonNodeText(String Key)
	{
		JsonPath jsonPathEval = response.jsonPath();
		
		String get = jsonPathEval.get(Key);
		
		System.out.println("Value received from response: " + get);
	}
	
	public String getApiKey()
	{
		return apiKey;
	}

	public String getApiToken()
	{
		return apiToken;
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
	
	private String apiKey = "96bbf073f2a868d51a65f7eb91aa77ec";
	private String apiToken = "bddf308320d934366e1dba02c60b9c0aa1bc64f12cadc478c47eb9657b0e3677";
}
