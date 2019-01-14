package findingElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByClassName 
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
	public void findelementByClassName()
	{
		try
		{
			WebElement usernameTxt=	driver.findElement(By.name("username"));
			WebElement passwordTxt=	driver.findElement(By.name("password"));
			WebElement loginbtn= driver.findElement(By.className("radius"));
			System.out.println(usernameTxt.getTagName());
			System.out.println(passwordTxt.getTagName());
			System.out.println(loginbtn.getTagName());

		}
		catch (NoSuchElementException e)
		{
			System.out.println("the element is not found");
		}


	}

	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
