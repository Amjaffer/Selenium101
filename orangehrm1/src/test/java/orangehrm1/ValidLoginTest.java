package orangehrm1;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.anass.orangehrm1.pages.Homepage;
import com.anass.orangehrm1.pages.LoginPage;
import com.anass.orangehrm1.pages.TestBase;

public class ValidLoginTest extends TestBase{
	
  //
		
	@Test//(dataProvider="DataforvalidLogin")
	public void ValidLogin() throws InterruptedException
	{		

		LoginPage obj=new LoginPage(driver);
		obj.setusername("Admin").setpwd("admin123").click();
		Homepage obj1=new Homepage(driver);
		assertTrue(obj1.getWelcomeMessage().contains("Welcome"),"It seems to be invalid credential");
	}

}
