package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingwithDropDownList {
	ChromeDriver driver;
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

	}
	@Test
	public void testDropdownList()
	{
		WebElement optionList= driver.findElement(By.id("dropdown"));
		Select selectoption= new Select(optionList);
		//doesn't allow multiple selection
		Assert.assertFalse(selectoption.isMultiple());
		Assert.assertEquals(3, selectoption.getOptions().size());
		//selectoption.deselectByVisibleText("Option 2");
		selectoption.selectByValue("1");
	}
	
@AfterTest
public void closeDriver()
{
	driver.close();
}

}
