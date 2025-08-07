package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Adminpage;
import elementRepository.LoginPage;
import elementRepository.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends BaseClass {
	Adminpage ap;
	LoginPage lp;
	ManageFooterPage mf;

	@Test(groups="smoke")
	public void verifyUpdateMsgWhileFooterTextIsUpdatedSuccessfully() throws IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		mf = ap.clickOnManageFooterTab();
		String address = ExcelUtility.readDataFromExcel(1, 0, "\\src\\test\\resources\\excel\\login.xlsx", "sheet2");
		String email = ExcelUtility.readDataFromExcel(1, 1, "\\src\\test\\resources\\excel\\login.xlsx", "sheet2");
		String phone = ExcelUtility.readDataFromExcel(1, 2, "\\src\\test\\resources\\excel\\login.xlsx", "sheet2");
		mf.clickEditButton().addAddress(address).addEmail(email).addPhone(phone).clickUpdate();
		Assert.assertTrue(mf.isFooterTextUpdatedSuccessfully(), Constant.mf_verifyUpdateMsgWhileFooterTextIsUpdatedSuccessfully);		
	}
}
