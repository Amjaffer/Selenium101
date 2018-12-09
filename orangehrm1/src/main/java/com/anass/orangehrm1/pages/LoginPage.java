package com.anass.orangehrm1.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Util {
	
	private static Logger log=Logger.getLogger(LoginPage.class);
	
	public WebDriver driver;
	public WebDriverWait driverwait;
	
	@FindBy(id="txtUsername")
	private WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	private WebElement btnLogin;
	
	
	@FindBy(id="spanMessage")
	private WebElement spanerrormessage;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		driverwait=new WebDriverWait(driver, 30);
		log.info("LoginPage constructor is invoked");
    }
	
    public LoginPage setusername(String username)
    {
		/*driverwait.until(ExpectedConditions.visibilityOf(txtUsername));
		txtUsername.clear();
		txtUsername.sendKeys(username);*/
    	setText(driver, txtUsername, username);
		log.info("username is set:" +username);
		
		return this;
    }

	public LoginPage setpwd(String pwd)
	{
		/*driverwait.until(ExpectedConditions.visibilityOf(txtPassword));
		txtPassword.clear();
	    txtPassword.sendKeys(pwd);*/
		setText(driver, txtPassword, pwd);
	    log.info("password is set:" +pwd);
	    
	    return this;
	}

	public void clickValid()
	{
		/*driverwait.until(ExpectedConditions.visibilityOf(btnLogin));
		driverwait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();*/
		clickElement(driver, btnLogin);
		log.info("button is clicked");
	}
	
	public void click()
	{
		driverwait.until(ExpectedConditions.visibilityOf(btnLogin));
		driverwait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
		log.info("button is clicked");
	}

public String getErrorMessage()
{
	driverwait.until(ExpectedConditions.visibilityOf(spanerrormessage));
	log.info("Error Message is printed:"+spanerrormessage.getText());
	return spanerrormessage.getText();

	

}

}
