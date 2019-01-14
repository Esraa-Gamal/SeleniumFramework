package workingWithElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestJavaScriptCalls 
{
	ChromeDriver driver;

	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");	
		driver.manage().window().maximize();
	}
	@Test
	public void testJavaScript()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// get title from java script not html
		String title= (String) js.executeScript("return document.title");
		assertEquals("Google", title);
		
		long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
		System.out.println(links);
		assertEquals(links, 39);
	}
	

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
