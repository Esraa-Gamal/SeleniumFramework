package workingWithElements;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfirmAlerts 
{
	ChromeDriver driver;
	
	@BeforeTest
	public void openURl()
	{
		System.setProperty("webdriver.chrome.driver",
				 System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
		
	}
	//Accept test
	@Test
	public void confirmTest()
	{
		WebElement confirmBtn= driver.findElement(By.id("confirm"));
		confirmBtn.click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		WebElement comfirmMsg= driver.findElement(By.id("demo"));
		Assert.assertEquals("You Accepted Alert!", comfirmMsg.getText()); 
		confirmBtn.click();
		Alert dismissBtn=driver.switchTo().alert();
		dismissBtn.dismiss();
		WebElement dismissMsg= driver.findElement(By.id("demo"));
		Assert.assertEquals("You Dismissed Alert!", dismissMsg.getText()); 
		
	}
	@Test(enabled=false)
	public void dismissTest()
	{
		WebElement confirmBtn= driver.findElement(By.id("confirm"));
		confirmBtn.click();
		Alert dismissBtn=driver.switchTo().alert();
		dismissBtn.dismiss();
		WebElement dismissMsg= driver.findElement(By.id("demo"));
		Assert.assertEquals("You Dismissed Alert!", dismissMsg.getText()); 
	}
	
	@AfterTest
	public void closeURL()
	{
		driver.close();
	}

}
