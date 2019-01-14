package workingWithElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClick
{
	ChromeDriver driver;
	
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}
	
	@Test
	public void DoubleClickTest()
	{
		WebElement message= driver.findElement(By.id("message"));
	
		//System.out.println(message.getCssValue("background-color"));
		//rgba(0, 0, 255, 1) blue
		//Assert.assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));
		Assert.assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));
		Actions builder= new Actions(driver);
		builder.doubleClick(message).perform();
		System.out.println(message.getCssValue("background-color"));
		//rgba(255, 255, 0, 1) yellow

		Assert.assertEquals("rgba(255, 255,0 , 1)", message.getCssValue("background-color"));
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
	
	@AfterTest
	public void closeURl()
	{
		driver.close();
	}
}
