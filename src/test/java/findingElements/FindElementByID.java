package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByID 
{
	ChromeDriver driver;
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");


	}

	@Test
	public void findelement()
	{
		WebElement usernameTxt=	driver.findElement(By.id("username"));
		WebElement passwordTxt=	driver.findElement(By.id("password"));	
		System.out.println(usernameTxt.getTagName());
		System.out.println(passwordTxt.getTagName());

	}

	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}

}
