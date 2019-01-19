package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUploadFile 
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
	public void testFileUpload() throws InterruptedException
	{
		String imageName= "11.jpg";
		String imagePath= System.getProperty("user.dir")+"/Uploads/"+imageName;
		WebElement fileUploader=driver.findElement(By.id("file-upload"));
		fileUploader.sendKeys(imagePath);
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
