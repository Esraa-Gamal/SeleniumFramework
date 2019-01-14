package workingWithElements;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingSessionCookies 
{
	ChromeDriver driver;

	@BeforeTest
	public void openURl()
	{
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://magento-demo.lexiconn.com/");	
	}

	@Test
	public void testCookies()
	{
		WebElement languageSelect= driver.findElement(By.id("select-language"));
		Select select= new Select(languageSelect);
		Assert.assertEquals("English", select.getFirstSelectedOption().getText());

		//Store cookies should be null
		Cookie storeCookie= driver.manage().getCookieNamed("store");
		Assert.assertEquals(null, storeCookie);

		// select German language
		select.selectByVisibleText("German");

		// Store Cookie should be populated with selected country
		storeCookie  = driver.manage().getCookieNamed("store");
		Assert.assertEquals("german", storeCookie.getValue());
		System.out.println(storeCookie.getValue());

		// how to get all cookies on web site?
		/* getCookies: returen list of cookies; 34an a2dr en ana at7km aw read these cookies;
		lazm a7ot-ha fe variable leh nfs no3 l data type aw nfs no3 l signature
		lly mwgod beha l cookies de */
		/* */
		//	driver.manage().getCookies(); // hgebha a7ot-ha fen?? lazm a7otha f set
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Number of cookies:" + cookies.size());
		Iterator<Cookie> itr = cookies.iterator();
		while (itr.hasNext())
		{
			Cookie cookie= itr.next();
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getPath());
			System.out.println(cookie.getExpiry());
		}

	}

	@AfterTest
	public void closeURL()
	{
		driver.quit();
	}
}
