package testCase;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Adminpage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass { 
	LoginPage lp;
	Adminpage ap;

	@Test(groups="smoke")
	public void verifyDashboardTextwhileLoginwithValidCredentials() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		String actual = ap.getDashboardString();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, Constant.lp_verifyDashboardTextwhileLoginwithValidCredentials);
	}
 
	@DataProvider(name = "invalid credentials")
	public Object[][] dpMethod() {
		return new Object[][] { { "Admin", "Admin" }, { "admin", "admin" }, { "Admin", "ad" } };
	}

	@Test(dataProvider = "invalid credentials", enabled = false)
	public void verifyErrorMessageWhileLoginWithInvalidCredentials(String userName, String Password) {
		lp = new LoginPage(driver);
		lp.login(userName, Password); 
		String actual = lp.getErrorMessage();
		String expected = "Invalid Username/password";
		Assert.assertEquals(actual, expected, Constant.lp_verifyErrorMessageWhileLoginWithInvalidCredentials);
	}

}