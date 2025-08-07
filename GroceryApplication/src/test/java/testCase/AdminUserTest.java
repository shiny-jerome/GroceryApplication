package testCase;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminUserPage;
import elementRepository.Adminpage;
import elementRepository.LoginPage;

public class AdminUserTest extends BaseClass {
	LoginPage lp;
	Adminpage ap;
	AdminUserPage aup;

	@Test(priority = 1,groups="smoke")
	public void verifyCreateMsgWhileUserAddedSuccessfully() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		aup = ap.clickonAdminUserPage();
		aup.createNewAdminUser();
		Assert.assertTrue(aup.getAlertMessage(),"::User creation Failed");		
	}

	@Test(priority = 2)
	public void verifyStatusMsgSWhileStatusChangedSuccessfully() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		aup = ap.clickonAdminUserPage();
		aup.statusChange();
		String actualStatusMessage = aup.getStatusAlertMessage();
		String expectedStatusMessage = "User Status Changed Successfully";
		boolean actual = actualStatusMessage.contains(expectedStatusMessage);
		Assert.assertTrue(actual, Constant.aup_verifyUserStatusChangedSuccessfully);
	}

	@Test(priority = 3)
	public void verifyUpdateMsgWhileUpdatedSuccessfully() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		aup = ap.clickonAdminUserPage();
		aup.updateAdminUser();
		String actualUpdateMessage = aup.getupdateAlertMessage();
		String expectedUpdateMessage = "User Updated Successfully";
		boolean b = actualUpdateMessage.contains(expectedUpdateMessage);
		Assert.assertTrue(b, Constant.aup_verifyUserIsUpdatedSuccessfully);
	}

	@Test(priority = 4)
	public void verifyAlertMsgWhileDeletedSuccessfully() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		aup = ap.clickonAdminUserPage();
		aup.deleteAdminUser();
		String actualDeleteMessage = aup.getdeleteAlertMessage();
		String expectedDeleteMessage = "User Deleted Successfully";
		boolean actual = actualDeleteMessage.contains(expectedDeleteMessage);
		Assert.assertTrue(actual, Constant.aup_verifyUserIsDeletedSuccessfully);
	}

	@Test(priority = 5)
	public void verifyUserIsSearchedSuccessfullyAndDisplayed() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		aup = ap.clickonAdminUserPage();
		aup.searchAdminUser();
		String actualSearchMessage = aup.getSearchMessage();
		String expectedSearchMessage = "aswathi";
		boolean actual = actualSearchMessage.contains(expectedSearchMessage);
		Assert.assertEquals(actual, true, Constant.aup_verifyUserIsSearchedSuccessfully);
	}

	@Test(priority = 6)
	public void verifyResetToAdminUserPageSuccessfully() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		aup = ap.clickonAdminUserPage();
		aup.reset();
		String actualUrl = aup.resetAlert();
		String expectedUrl = "https://groceryapp.uniqassosiates.com/admin/list-admin";
		Assert.assertEquals(actualUrl, expectedUrl, Constant.aup_verifyResetToAdminUserPageSuccessfully);
	}
}