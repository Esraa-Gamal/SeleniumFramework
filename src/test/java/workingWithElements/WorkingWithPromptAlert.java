package workingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithPromptAlert 
{
	ChromeDriver driver;
	 @BeforeTest
	 public void openURL()
	 {
		 System.setProperty("webdriver.chrome.driver",
				 System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		 
		 driver= new ChromeDriver();
		 driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	 }
	 
	 @Test
	  public void testPromptAlert()
	  {
		 WebElement promptBtn= driver.findElement(By.id("prompt"));
		 promptBtn.click();
		 
		 Alert alert= driver.switchTo().alert();
		 alert.sendKeys("Esraa");
		 
		 alert.accept();
		 WebElement message=driver.findElement(By.id("prompt_demo"));
		 Assert.assertEquals("Hello Esraa! How are you today?", message.getText());
	  }
	 
}
