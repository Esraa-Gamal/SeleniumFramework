package workingWithElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTextBoxAndButton 
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
	public void logineScreen()
	{
		try {
			WebElement txtUsername= driver.findElement(By.id("username"));
			WebElement txtpassword= driver.findElement(By.id("password"));
			WebElement loginbtn= driver.findElement(By.className("radius"));

			txtUsername.clear();
			txtUsername.sendKeys("tomsmith");
			txtpassword.clear();
			txtpassword.sendKeys("SuperSecretPassword!");

			loginbtn.click();
			
			WebElement successNotification= driver.findElement(By.id("flash"));
			System.out.println(successNotification.getText());
			Assert.assertTrue(successNotification.getText().contains("You logged into a secure area"));

		}
		catch(NoSuchElementException e)
		{

		}
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
