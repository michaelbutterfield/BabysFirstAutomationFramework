package appium;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import utilities.TestHelper;

public class AppiumServerManager
{
	private static final int OK_RESPONSE = 200;
	private static String serverIpAddress;
	private static String serverPort;
	private static String appiumPort;

	public static void setAppiumServerDetails(String iP, String port)
	{
		serverIpAddress = iP;
		serverPort = port;
	}

	public static void setAppiumPort(String aPort)
	{
		appiumPort = aPort;
	}

	public static String getAppiumServerIp()
	{
		return serverIpAddress;
	}

	public static String getAppiumPort()
	{
		return appiumPort;
	}

	public static void start()
	{
		sendStartStopCommand("start");
	}

	public static void stop()
	{
		sendStartStopCommand("stop");
	}

	private static String getStatusFromResponse(HttpURLConnection request)
			throws JsonIOException, JsonSyntaxException, IOException
	{
		JsonParser jsonParser = new JsonParser();
		JsonElement root = jsonParser.parse(new InputStreamReader((InputStream) request.getContent())); // Convert the
																										// input stream
																										// to a json
																										// element

		return root.getAsJsonObject().get("status").getAsString();
	}

	private static String pollAppiumStatus()
	{
		String statusResponse = "";
		HttpURLConnection request = null;

		try 
		{
			String address = String.format("http://%1$s:%2$s/wd/hub", serverIpAddress, appiumPort);
			request = sendRequest(address + "/status");
		}
		catch (Exception e) 
		{
			return "Appium is not ready or the port is not open";
		}

		try 
		{
			statusResponse = getStatusFromResponse(request);
		} 
		catch (Exception e) 
		{
			String exceptionMessage = "Could not parse the appium status from the JSON response";
			TestHelper.handleException(exceptionMessage, e, false);
		}

		return statusResponse;
	}

	private static HttpURLConnection sendRequest(String requestUrl)
	{
		HttpURLConnection request = null;

		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try 
		{
			URL url = new URL(requestUrl);

			request = (HttpURLConnection) url.openConnection();
			request.connect();
		} 
		catch (Exception e)
		{
			String exceptionMessage = "Web request failed";
			TestHelper.handleException(exceptionMessage, e, false);
		}

		return request;
	}

	private static void sendStartStopCommand(String command)
	{
		try 
		{
			String address = String.format("http://%1$s:%2$s", serverIpAddress, serverPort);

			String requestString = address + "/" + command + "appium/" + appiumPort;
			requestString = String.format(requestString, command);

			HttpURLConnection request = sendRequest(requestString);

			if (request.getResponseCode() == OK_RESPONSE) 
			{
				if (command.equals("start")) 
				{
					waitForAppiumStatusReady();
				}
			} 
			else 
			{
				String exceptionMessage = "Appium server manager did not return a 200 respond code. Response code: " + request.getResponseCode();
				System.out.println(exceptionMessage);
			}
		} 
		catch (Exception e) 
		{
			String exceptionMessage = "Appium did not %s";
			exceptionMessage = String.format(exceptionMessage, command);
		}
	}

	private static void waitForAppiumStatusReady()
	{
		int maxRetries = 10;
		int retries = 0;
		int waitSeconds = 2;

		while (retries < maxRetries) 
		{
			String appiumStatus = pollAppiumStatus();

			if (appiumStatus.equals("0")) 
			{
				return;
			} 
			else 
			{
				TestHelper.sleepInSeconds(waitSeconds);

				if (retries == maxRetries) 
				{
					String exceptionMessage = "Appium server was not ready to accept commands - timeout exception";
					System.out.println(exceptionMessage);
				}

				retries++;
			}
		}
	}
}