package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithFrames 
{
	ChromeDriver driver;

	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");	
		driver.manage().window().maximize();
	}
	@Test
	public void testFramesWithIdORName() 
	{
		driver.switchTo().frame("left");
		WebElement msg = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This is Left Frame", msg.getText());

		/*the next step 34an yrg3 ll default "main" content lw m3mltsh l 5twa de hyfdl gwa l left frame
	 w kol ma a2olo 3la ay 7aga bra l frame msh hy2dr ywslha*/
		System.out.println(msg.getText());
		driver.switchTo().defaultContent();

		driver.switchTo().frame("right");
		WebElement msg2= driver.findElement(By.tagName("p"));
		Assert.assertEquals("This is Right Frame", msg2.getText());
		System.out.println(msg2.getText());
		driver.switchTo().defaultContent();

		/*// not working why?!
		driver.switchTo().frame(1);
		WebElement msg3= driver.findElement(By.tagName("p"));
		Assert.assertEquals("This Frame doesn't have id or name", msg3.getText());
		System.out.println(msg2.getText());
		driver.switchTo().defaultContent();
		 */

	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
