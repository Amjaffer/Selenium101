package com.anass.orangehrm1.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.anass.orangehrm1.pages.TestBase;

public class ListenerTest implements ISuiteListener,ITestListener,IInvokedMethodListener{
	
private static Logger log=Logger.getLogger(ListenerTest.class);
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("---Test method Started---" +result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("---Test method Success---" +result.getName());
		takeScreenShot(result);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("---Test method failed---" +result.getName());
		takeScreenShot(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("---Test method skipped---" +result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		log.info("----Suite Started---" +suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		log.info("---Suite completed-----" +suite.getName());
	}
	public void takeScreenShot(ITestResult result) {
    	//get the driver
		Object currentclass=result.getMethod().getInstance();
    	WebDriver driver=((TestBase) currentclass).getDriver();

		String status="failed";
		if(result.isSuccess())
		{
			status="passed";
		}
    	String methodName=result.getName().toString().trim();
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
            	String workingDir = System.getProperty("user.dir");// + "\\target\\surefire-reports\\html";
            	String path=workingDir+"\\target\\surefire-reports\\Screenshots\\"+status+"\\"+methodName+"-"+timeStamp+".png";
				FileUtils.copyFile(scrFile, new File(path));
				String html = "<div style=\"height:650px;width:1000px;overflow:scroll\"><a target='_blank' href='" + path + "'> <img src=\""+ path +"\"></a></div>";
				Reporter.log("screenshot for " + path + " url=" + driver.getCurrentUrl() + html, true);
				log.info(new File(workingDir+"\\Screenshots\\"+status+"\\"+methodName+"-"+timeStamp+".png"));
				
		} catch (IOException e) {
				e.printStackTrace();
		}
    }

	
	}
