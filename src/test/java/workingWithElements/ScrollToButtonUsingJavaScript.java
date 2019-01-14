package workingWithElements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollToButtonUsingJavaScript 
{
	//ChromeDriver driver;
	public WebDriver driver;
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com");
	}
	
	@Test
	public void testScrollWithJS()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000");
		
	}
	
	
	@AfterTest
	public void closeURl()
	{
		driver.quit();
	}
}
