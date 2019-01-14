package workingWithElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTables
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
	public void TestWebTable()
	{
		WebElement webTable= driver.findElement(By.id("table1"));
		//get all rows
		List<WebElement> rows= webTable.findElements(By.tagName("tr"));
		Assert.assertEquals(5, rows.size());
		
		//get all cells data
		
		for (WebElement row : rows)
		{
			List<WebElement> cols= row.findElements(By.tagName("td"));
			for (WebElement col : cols) 
			{
				System.out.println(col.getText());
			}
			System.out.println();
		}
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}

}
