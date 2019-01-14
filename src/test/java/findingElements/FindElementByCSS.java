package findingElements;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByCSS 
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
	public void findelementByCSSSelector()
	{
		try
		{
			WebElement userNameTxt= driver.findElement(By.cssSelector("input#username"));
			WebElement loginBtn= driver.findElement(By.cssSelector("button.radius"));
			System.out.println(userNameTxt.getTagName());
			System.out.println(loginBtn.getText());
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
