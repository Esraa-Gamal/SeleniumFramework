package workingWithElements;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingMultipleWindows 
{
ChromeDriver driver;
	
	@BeforeTest
	public void openURl()
	{
		System.setProperty("webdriver.chrome.driver",
				 System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");	
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	public void TestWindowUsingTitle()
	{
		// Store window Handle of parent windows
		String currentWindowID = driver.getWindowHandle();
		driver.findElement(By.id("visitbutton")).click();
		
		for (String windowID: driver.getWindowHandles())
		{	
			String title= driver.switchTo().window(windowID).getTitle();
			if (title.equals("Visit Us"))
			{
				assertEquals("Visit Us", driver.getTitle());
				System.out.println(driver.getTitle());
				driver.close();
				break;
			}
		}
		driver.switchTo().window(currentWindowID);
	}
	
	@Test (priority=2)
	public void TestWindowUsingName()
	{
		// store WindowHandle of parent window
		String currentWindowID = driver.getWindowHandle();
		driver.findElement(By.id("helpbutton")).click();
		
		driver.switchTo().window("HelpWindow");
		
		assertEquals("Help", driver.getTitle());
		System.out.println(driver.getTitle());
		// Code inside help window
		
		driver.close();
		driver.switchTo().window(currentWindowID);
	}
	@AfterTest
	public void closeURL()
	{
		driver.quit();
	}
	
}
