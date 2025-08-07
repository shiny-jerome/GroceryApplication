package testCase;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Adminpage;
import elementRepository.LoginPage;
import elementRepository.ManageNewsPage;

public class ManageNewsTest extends BaseClass {
	LoginPage lp;
	Adminpage ap;
	ManageNewsPage mp;

	@Test(priority = 1,groups="smoke")
	public void verifyAlertMsgWhileNewsIsCreatedSuccessfully() throws InvalidFormatException, IOException {

		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		mp = ap.clickOnManageNewsTab();
		mp.createNewMessage();
		String actualCreateMessage = mp.getAlertMessage();
		String expectedCreateMessage = "News Created Successfully";
		// boolean actual = actualCreateMessage.contains(expectedCreateMessage);
		Assert.assertEquals(actualCreateMessage, expectedCreateMessage, Constant.mp_verifyAlertMsgWhileNewsIsCreatedSuccessfully);
	}

	@Test(priority = 2)
	public void verifyAlertMsgWhileNewsIsUpdatedSuccessfully() throws InvalidFormatException, IOException {
 
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		mp = ap.clickOnManageNewsTab();
		mp.updateCreatedMessage();
		String actualUpdateMessage = mp.getUpdateAlertMessage();
		String expectedUpdateMessage = "News Updated Successfully";
		boolean actual = actualUpdateMessage.contains(expectedUpdateMessage);
		Assert.assertTrue(actual, Constant.mp_verifyAlertMsgWhileNewsIsUpdatedSuccessfully);
	}

	@Test(priority = 3)
	public void verifyAlertMsgWhileNewsIsDeletedSuccessfully() throws InvalidFormatException, IOException {
		// ap = new Adminpage(driver);
		// mp = new ManageNewsPage(driver);
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		mp = ap.clickOnManageNewsTab();
		mp.deleteCreateMessage();
		String actualDeleteMessage = mp.getDeleteAlertMessage();
		String expectedDeleteMessage = "News Deleted Successfully";
		boolean actual = actualDeleteMessage.contains(expectedDeleteMessage);
		Assert.assertTrue(actual, Constant.mp_verifyAlertMsgWhileNewsIsDeletedSuccessfully);
	}

	@Test(priority = 4)
	public void verifyAlertMsgWhileNewsIsSearchedSuccessfully() throws InvalidFormatException, IOException {
		// ap = new Adminpage(driver);
		// mp = new ManageNewsPage(driver);
		// ap.clickOnManageNewsTab();
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		mp = ap.clickOnManageNewsTab();
		mp.searchMeassage();
		String actualSearchMessage = mp.getSearchMessage();
		String expectedSearchMessage = "good bad ugly";
		boolean actual = actualSearchMessage.contains(expectedSearchMessage);
		Assert.assertTrue(actual, Constant.mp_verifyAlertMsgWhileNewsIsSearchedSuccessfully);

	}

}
