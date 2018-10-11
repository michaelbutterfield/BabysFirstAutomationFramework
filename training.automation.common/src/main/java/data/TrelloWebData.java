package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import utilities.TestHelper;

public class TrelloWebData
{
	private static String username;
	private static String password;
		
	static
	{
		try
		{
			readUserPass();
		}
		catch (Exception e)
		{
			String errorMessage = ("Could not do static read API Key and Token");
			TestHelper.handleException(errorMessage, e, false);
		}
	}

	public static String getUsername()
	{
		return username;
	}

	public static String getPassword()
	{
		return password;
	}	
	
	private static void readUserPass() throws IOException
	{
		//file to read from
		String sourceFile = "C:\\Users\\michael.butterfield\\Desktop\\trellouserpass.txt";
		
		BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
		
		//String to put each line read into
		String line;
		
		//Looping read block until EOF (end of file)
		try
		{
			while ((line = reader.readLine()) != null)
			{
				String dataValue[] = line.split("\t");
				username = dataValue[0];
				password = dataValue[1];
			}
		}
		catch (Exception e)
		{
			String errorMessage = String.format("Could not read username and password from file: %1$s", sourceFile);
			
			TestHelper.handleException(errorMessage, e, false);
		}
		
		reader.close();
	}
}
