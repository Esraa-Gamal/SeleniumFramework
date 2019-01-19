package workingWithElements;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CheckAllBrokenImages 
{
	ChromeDriver driver;
	private int invalidImagesCount;

	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/broken_images");	
		driver.manage().window().maximize();
	}

	@Test
	public void testBrokenImages()
	{
		invalidImagesCount =0;
		List<WebElement> imgList= driver.findElements(By.tagName("img"));
		for(WebElement imgElement: imgList)
		{
			if(imgElement!= null)
			{
				verifyImageActive(imgElement);
			}
		}
		System.out.println("Total No. of invalid Images are : "+ invalidImagesCount);
	}

	public void verifyImageActive(WebElement imgElement)
	{
		HttpClient client= HttpClientBuilder.create().build();
		HttpGet request= new HttpGet(imgElement.getAttribute("src"));
		try {
			HttpResponse response =client.execute(request);
			if(response.getStatusLine().getStatusCode() !=200)
			{
				invalidImagesCount ++;
			}
		} 
		catch (ClientProtocolException e) 
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
