package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithSubmit 
{
	ChromeDriver driver;
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com");

	}
	@Test
	public void testSubmit()
	{
		WebElement txtSearch= driver.findElement(By.name("q"));
		txtSearch.clear();
		txtSearch.sendKeys("Selenium web driver");
		txtSearch.submit();
		txtSearch= driver.findElement(By.name("q"));
		txtSearch.clear();
		txtSearch.sendKeys("Selenium web driver book");
		txtSearch.submit();

	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
