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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTestdata {
	
	public WebDriver driver;
	@DataProvider//(name="datadriven")
	public Object[][] getData()
	{
		String[][] credentials= {{"user1","pwd1"},{"user2","pwd2"},{"user3","pwd3"}};
		return credentials;
	}
	@Parameters("browser")
	@BeforeMethod
	public void setupDriver(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
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
//we can also use method name and donot give any name to DataProvider
	@Test(dataProvider="getData")
	//@Test(dataProvider="datadriven")
	public void ValidLogin1(String user,String pwd) throws InterruptedException
	{		
		WebElement txtUsername=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		txtUsername.clear();
		txtUsername.sendKeys(user);
		Thread.sleep(3000);

		
		WebElement txtPassword=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		Thread.sleep(3000);

		
		WebElement btnLogin=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		btnLogin.click();
		
		/*Thread.sleep(3000);
		WebElement message=driver.findElement(By.id("welcome"));
		String msg=message.getText();
		System.out.println(msg);*/
		
		//assertTrue(msg.equals("Welcome Admin"), "It seems like Invalid credential");
		
	}
	
	/*@Test
	public void ValidLogin2() throws InterruptedException
	{		
		WebElement txtUsername=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		txtUsername.clear();
		txtUsername.sendKeys("user1");
		Thread.sleep(3000);

		
		WebElement txtPassword=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		txtPassword.clear();
		txtPassword.sendKeys("pwd1");
		Thread.sleep(3000);
		
		WebElement btnLogin=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		btnLogin.click();
		
		Thread.sleep(3000);
		WebElement spanMessage=driver.findElement(By.id("spanMessage"));
		String message=spanMessage.getText();
		
		//assertTrue(message.equals("Invalid credentials"), "It seems to be a valid credential");

	}*/
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
