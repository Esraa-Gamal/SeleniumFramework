package findingElements;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElemmentByTagNameInTable 
{

	ChromeDriver driver;
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");


	}

	@Test
	public void findelementByTagName()
	{
		try
		{
			WebElement table= driver.findElement(By.id("table1"));
			List<WebElement> rows= table.findElements(By.tagName("tr"));
			System.out.println(rows.size());
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
