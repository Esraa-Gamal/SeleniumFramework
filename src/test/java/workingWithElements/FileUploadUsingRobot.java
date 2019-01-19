package workingWithElements;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadUsingRobot 
{
	ChromeDriver driver;

	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");	
		driver.manage().window().maximize();
	}
	
	@Test
	public void uploadFilesWithRobot() throws AWTException
	{
		String imageName= "11.jpg";
		String imagePath= System.getProperty("user.dir")+"\\Uploads\\"+imageName;	
		
		WebElement fileUploader=driver.findElement(By.id("file-upload"));
		fileUploader.click();
		// Code for using robot class for upload
		Robot robot= new Robot();
		//StringSelection act as a simulation for copying the path of img
		StringSelection selection= new StringSelection(imagePath);
		//the next line is to get the last copied thing
		Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		//null because we don't have owner value
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		//KeyPress = Pressing on the button
		//Key Release = takes hands off 
		//ctrl+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//Due to error "No Such Element"
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement submitBtn=driver.findElement(By.id("file-submit"));
		submitBtn.click();
		WebElement uploadedFiles= driver.findElement(By.id("uploaded-files"));		
		System.out.println(uploadedFiles.getText());
		Assert.assertEquals(imageName, uploadedFiles.getText());
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
