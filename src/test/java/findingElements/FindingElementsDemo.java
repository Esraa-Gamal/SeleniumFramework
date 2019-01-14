package findingElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindingElementsDemo 
{

	ChromeDriver driver;
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
	}
	@Test
	public void testFindElements()
	{
		//get all links displayed on page
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Verify there are Links displayed on the page
		Assert.assertEquals(links.size(), 41);
		//for each
		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));
		}
	}

	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}


}
