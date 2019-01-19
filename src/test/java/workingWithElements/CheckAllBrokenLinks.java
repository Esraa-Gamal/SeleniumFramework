package workingWithElements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckAllBrokenLinks 
{
	ChromeDriver driver;

	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");	
		driver.manage().window().maximize();
	}

	@Test
	public void testALlLinks()
	{
		java.util.List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("Total Links are: "+ links.size());
		for(int i=0; i<links.size(); ++i)
		{
			WebElement element= links.get(i);
			String url= element.getAttribute("href");
			verifyLink(url);
		}
	}

	//method that serves the Test method
	public static void verifyLink(String urlLink)
	{

		try 
		{
			URL link= new URL(urlLink);
			//Create connection using URL object

			HttpURLConnection httpConnection= (HttpURLConnection) link.openConnection();
			httpConnection.setConnectTimeout(2000);
			httpConnection.connect();

			//use getresponseCode to get the response code
			if(httpConnection.getResponseCode()==200)
			{
				System.out.println(urlLink+" - "+httpConnection.getResponseMessage());
			}
			if(httpConnection.getResponseCode()==404)
			{
				System.out.println(urlLink+" - "+httpConnection.getResponseMessage());
			}	
		} 
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
