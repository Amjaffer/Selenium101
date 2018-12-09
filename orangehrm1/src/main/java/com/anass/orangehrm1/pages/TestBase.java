package com.anass.orangehrm1.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.anass.orangehrm1.listeners.ListenerTest;
import org.testng.annotations.Parameters;

@Listeners(ListenerTest.class)
public class TestBase {

	private static Logger log=Logger.getLogger(TestBase.class);
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setupDriver(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("chrome Browser is invoked");
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			log.info("Firefox Browser is invoked");
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
		}
		else
		{
			System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			log.info("IE Browser is invoked");
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
		}
	}
		
		
		@AfterMethod
		public void tearDown()
		{
			driver.close();
			log.info("Driver is closed");
		}


		public WebDriver getDriver() {
			// TODO Auto-generated method stub
			return driver;
		}

}
