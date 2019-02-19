package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFileWithFireFox 
{
	public WebDriver driver;
	public static String downloadPath= System.getProperty("user.dir")+"\\Downloads";

	/*FireFox options:
	 * The Next method is how to customize the options of download from firefox
	 */
	public static FirefoxOptions firefoxOption()
	{

		FirefoxOptions option= new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);

		/*option.setAcceptInsecureCerts(true);
		
		//where to save the file= custom path
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.helperApps.alwaysAsk.force", false);
		// 0 : means default path
		  2 : means custom path that will be defined in the next line
		 
		// adding the customized path 
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.download.defaultFolder",downloadPath); 

		// tell the browser to make save for all types of files that will be download
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("browser.helperApps.neverAsk.saveToDesk", "application/octet-stream");
		//to not show the screen of options when downloading files
		
		//option.addPreference("browser.download.manager.showWhenStarting", true);
		*/
		return option;
	}

	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir")+"\\resources\\geckodriver.exe");
		driver = new FirefoxDriver(firefoxOption());
		driver.navigate().to("https://the-internet.herokuapp.com/download");	
		driver.manage().window().maximize();
	}

	@Test
	public void testDownloadFireFox() throws InterruptedException
	{
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(3000);
		System.out.println(downloadPath);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
