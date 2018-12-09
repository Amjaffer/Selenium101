package orangehrm1;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.anass.orangehrm1.pages.LoginPage;
import com.anass.orangehrm1.pages.TestBase;

public class InvalidLoginTest extends TestBase{
	
	
	
	@Test//(dataProvider="DataforInvalidLogin")
	public void InValidLogin1() throws InterruptedException
	{		
		LoginPage obj=new LoginPage(driver);
		obj.setusername("aaa");
		obj.setpwd("asd");
		obj.click();
		assertTrue(obj.getErrorMessage().contains("Invalid credentials"), "It seems like valid credential");
	}

	@Test//(dataProvider="DataforInvalidLogin")
	public void UserNameEmpty() throws InterruptedException
	{		
		LoginPage obj=new LoginPage(driver);
		obj.setusername("");
		obj.click();
		assertTrue(obj.getErrorMessage().contains("Username cannot be empty"), "It is accepting empty username");
}
	@Test//(dataProvider="DataforInvalidLogin")
	public void PasswordEmpty() throws InterruptedException
	{		
		LoginPage obj=new LoginPage(driver);
		obj.setusername("Admin");
		obj.setpwd("");
		obj.click();
		assertTrue(obj.getErrorMessage().contains("Password cannot be empty"), "It is accepting empty password");

	}
}