package workingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithAlerts 
{
	ChromeDriver driver;
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	
	@Test
	public void alertsTest()
	{
		WebElement alertBtn = driver.findElement(By.id("simple"));
		alertBtn.click();
		
		Alert alert = driver.switchTo().alert();
		String alertText= alert.getText();
		
		Assert.assertEquals("Hello! I am an alert box!", alertText);
		alert.accept();
	}
	
	
	@AfterTest
	public void closeUrl()
	{
		driver.close();
	}
}
