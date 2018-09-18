package utilities;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestHelper
{
	private String baseURI = null;
	
	public void initialise(String baseURI, Method method, String path)
	{
		RestAssured.baseURI = baseURI;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(method, path);
		
		String responseBody = response.getBody().asString();
		
		System.out.println(responseBody);
	}	
}
