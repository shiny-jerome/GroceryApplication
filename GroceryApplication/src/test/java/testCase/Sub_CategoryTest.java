package testCase;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Adminpage;
import elementRepository.LoginPage;
import elementRepository.Sub_CategoryPage;

public class Sub_CategoryTest extends BaseClass {
	LoginPage lp;
	Adminpage ap;
	Sub_CategoryPage scp;

	@Test(priority=1)
	public void verifyUserIsAbleToAddSubCategory() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		scp = ap.clickOnSubCategoryPage();
		scp.addSubCategory();
		String actualAddAlert = scp.subcategoryUpdatedSuccessfully();
		String expectedAddAlert = "Sub Category Created Successfully";
		boolean actual = actualAddAlert.contains(expectedAddAlert);
		Assert.assertTrue(actual,Constant.scp_verifyUserIsAbleToAddSubCategory );
	}

	@Test(priority=2)
	public void verifyUserIsAbleToUpateSubCategory() throws IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		scp = ap.clickOnSubCategoryPage();
		scp.updateSubCategory();
		String actualAddAlert = scp.subcategoryAddedSuccessfully();
		String expectedAddAlert = "Sub Category Updated Successfully";
		boolean actual = actualAddAlert.contains(expectedAddAlert);
		Assert.assertTrue(actual, Constant.scp_verifyUserIsAbleToUpateSubCategory);
	}

	@Test(priority=3)
	public void verifyUserIsAbleToSearchSubCategory() throws  IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		scp = ap.clickOnSubCategoryPage();
		scp.searchSubCategory();
		String actualSearch = scp.subcategorySearchedSuccessfully();
		String expectedSearch = "Grayson";
		boolean actual = actualSearch.contains(expectedSearch);
		Assert.assertTrue(actual, Constant.scp_verifyUserIsAbleToSearchSubCategory);
	}

	@Test(priority=4)
	public void verifyUserIsAbleToDeleteSubCategory() throws  IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		scp = ap.clickOnSubCategoryPage();
		scp.deleteSubCategory();
		String actualDeleteMessage = scp.subcategoryDeletedSuccessfully();
		String expectedDeleteMessage = "Sub Category Deleted Successfully";
		boolean actual = actualDeleteMessage.contains(expectedDeleteMessage);
		Assert.assertTrue(actual, Constant.scp_verifyUserIsAbleToDeleteSubCategory);
	}
}
