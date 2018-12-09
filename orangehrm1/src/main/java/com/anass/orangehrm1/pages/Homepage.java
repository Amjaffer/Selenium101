package com.anass.orangehrm1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class Homepage {
	private static Logger log=Logger.getLogger(Homepage.class);

public WebDriver driver;
	
@FindBy(id="welcome")
private WebElement welcomemessage;

	public Homepage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	log.info("HomePage constructor is invoked");
    }
	
	public String getWelcomeMessage()
	{
		log.info("Welcome message is :" +welcomemessage.getText());
		return welcomemessage.getText();
		
	}

	
}
