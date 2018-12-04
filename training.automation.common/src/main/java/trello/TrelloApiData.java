package trello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import utilities.TestHelper;

public class TrelloApiData
{
	private static String apiKey;
	private static String apiToken;
		
	static
	{
		try
		{
			readApiKeyToken();
		}
		catch (Exception e)
		{
			String errorMessage = ("Could not do static read API Key and Token");
			TestHelper.handleException(errorMessage, e, false);
		}
	}

	public static String getApiKey()
	{
		return apiKey;
	}

	public static String getApiToken()
	{
		return apiToken;
	}	
	
	private static void readApiKeyToken() throws IOException
	{
		//file to read from
		String sourceFile = "C:\\Users\\michael.butterfield\\Desktop\\trello.txt";
		
		BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
		
		//String to put each line read into
		String line;
		
		//Looping read block until EOF (end of file)
		try
		{
			while ((line = reader.readLine()) != null)
			{
				String dataValue[] = line.split("\t");
				apiKey = dataValue[0];
				apiToken = dataValue[1];
			}
		}
		catch (Exception e)
		{
			String errorMessage = String.format("Could not read API Key and Token from file: %1$s", sourceFile);
			
			TestHelper.handleException(errorMessage, e, false);
		}
		
		reader.close();
	}
}
