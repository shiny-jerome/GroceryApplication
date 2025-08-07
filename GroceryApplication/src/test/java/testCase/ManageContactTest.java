package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Adminpage;
import elementRepository.LoginPage;
import elementRepository.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends BaseClass {
	LoginPage lp;
	Adminpage ap;
	ManageContactPage mcp;

	@Test(groups="smoke")
	public void verifyUpdateMsgWhileContactIsUpdatedSuccessfully() throws IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		mcp = ap.clickOnManageContactPage();
		String phone = ExcelUtility.readDataFromExcel(1, 2, "\\src\\test\\resources\\excel\\login.xlsx", "sheet3");
		String email = ExcelUtility.readDataFromExcel(1, 1, "\\src\\test\\resources\\excel\\login.xlsx", "sheet3");
		String address = ExcelUtility.readDataFromExcel(1, 0, "\\src\\test\\resources\\excel\\login.xlsx", "sheet3");
		String deliverytime = ExcelUtility.readDataFromExcel(1, 4, "\\src\\test\\resources\\excel\\login.xlsx",
				"sheet3");
		String deliverycharge = ExcelUtility.readDataFromExcel(1, 5, "\\src\\test\\resources\\excel\\login.xlsx",
				"sheet3");
		mcp.clickEdit().addPhone(phone).addEmail(email).addAddress(address).addDeliveryTime(deliverytime)
				.addDelChrgLimit(deliverycharge).clickUpdate();
		Assert.assertTrue(mcp.isManageContactUpdatedSuccessfully(), Constant.mcp_verifyUpdateMsgWhileContactIsUpdatedSuccessfully);

	}
}
