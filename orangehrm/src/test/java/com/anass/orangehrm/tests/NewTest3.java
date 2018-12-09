package com.anass.orangehrm.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest3 {
  public WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void driversetup(String browser)
	{
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
		}
		else
		{
			System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
		}
	
	}
	@Test
  public void validlogin() throws InterruptedException
  {
			
		
		WebElement txtusername=driver.findElement(By.cssSelector("#txtUsername"));
		txtusername.clear();
		txtusername.sendKeys("Admin");
		Thread.sleep(5000);
		
		WebElement txtpassword=driver.findElement(By.cssSelector("#txtPassword"));
		txtpassword.clear();
		txtpassword.sendKeys("admin123");
		Thread.sleep(5000);

		WebElement btnlogin=driver.findElement(By.cssSelector("#btnLogin"));
		btnlogin.click();
		Thread.sleep(5000);
		
		/*WebElement spanmessage=driver.findElement(By.id("spanMessage"));
		String message=spanmessage.getText();
		
		assertTrue(message.equals("Invalid credentials"),"Its a valid credential");*/
		
		
		WebElement adminmsg=driver.findElement(By.id("welcome"));
		String msg=adminmsg.getText();
		
		assertTrue(msg.contains("Welcome"),"Its a invalid credential");

		
		

  }

		
	
	@Test
	 public void login1() throws InterruptedException
	  {
				
			
			WebElement txtusername=driver.findElement(By.cssSelector("#txtUsername"));
			txtusername.clear();
			txtusername.sendKeys("Admin");
			Thread.sleep(5000);

			
			WebElement txtpassword=driver.findElement(By.cssSelector("#txtPassword"));
			txtpassword.clear();
			txtpassword.sendKeys("admin123");
			Thread.sleep(5000);

			
			WebElement btnlogin=driver.findElement(By.cssSelector("#btnLogin"));
			btnlogin.click();
			Thread.sleep(5000);
			
			
			/*WebElement spanmessage=driver.findElement(By.id("spanMessage"));
			String message=spanmessage.getText();
			
			assertTrue(message.equals("Invalid credentials"),"Its a valid credential");
			
			
*/
			
			WebElement admin=driver.findElement(By.id("welcome"));
			String message=admin.getText();
			
			assertTrue(message.contains("Welcome"),"Its a invalid credential");
			
	  }

@AfterMethod
public void teardown()
{
	driver.close();
	
}
	
	
}
