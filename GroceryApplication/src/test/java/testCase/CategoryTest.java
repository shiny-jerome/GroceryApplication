package testCase;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Adminpage;
import elementRepository.CategoryPage;
import elementRepository.LoginPage;

public class CategoryTest extends BaseClass {
	LoginPage lp;
	Adminpage ap;
	CategoryPage cp;

	@Test(priority=1)
	public void verifyUserIsSearchedAndDisplayedSuccessfully() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		cp = ap.clickonCategoryPage();
		cp.categorySearch();
		String actualSearch = cp.isSearchSuccessful();
		String expectedSearch = "grocery";
		boolean b = actualSearch.contains(expectedSearch);
		Assert.assertTrue(b,Constant.cp_verifyUserIsSearchedAndDisplayedSuccessfully );

	}

	@Test(priority=2)
	public void verifyStatusMsgSWhileStatusChangedSuccessfully() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.login(groceryData(1, 0), groceryData(1, 1));
		cp = ap.clickonCategoryPage();
		cp.statusChange();
		String actualSearch = cp.isStatusChangedsuccessfully();
		String expectedSearch = "Category Status Changed Successfully";
		boolean b = actualSearch.contains(expectedSearch);
		Assert.assertTrue(b, Constant.cp_verifyStatusMsgSWhileStatusChangedSuccessfully);

	}
}
