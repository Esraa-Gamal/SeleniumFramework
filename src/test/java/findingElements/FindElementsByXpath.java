package findingElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsByXpath 
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
	@Test (enabled=false)
	public void testByActualXpath()
	{
		WebElement usernameTxt=driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement passowrdTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
		System.out.println(usernameTxt.getTagName());
		System.out.println(passowrdTxt.getTagName());
		System.out.println(loginBtn.getText());

		
	}
	@Test
	public void testByRelativeXpath()
	{
		WebElement usernameTxt=driver.findElement(By.xpath("//input"));
		WebElement passowrdTxt = driver.findElement(By.xpath("//input[1]"));
		WebElement loginBtn = driver.findElement(By.xpath("//button"));
		System.out.println(usernameTxt.getTagName());
		System.out.println(passowrdTxt.getTagName());
		System.out.println(loginBtn.getText());

		
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}

}
