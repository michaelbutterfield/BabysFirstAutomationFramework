package utilities;

import io.restassured.RestAssured;


public class ApiHelper
{
	public ApiHelper()
	{
		//bleh
	}
	
	public static String getBaseURI()
	{
		return RestAssured.baseURI;
	}
}
