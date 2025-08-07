package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;

public class Adminpage {
	// GeneralUtility gu=new GeneralUtility(); obj created for general utility
	WebDriver driver;

	public Adminpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboardText;
	@FindBy(xpath = "//a//p[text()='Manage News']")
	WebElement manageNewsTab;
	@FindBy(xpath = "//a//p[text()='Manage Footer Text']")
	WebElement manageFooterTab;
	@FindBy(xpath = "//li[4]/a[@class=' nav-link']")
	WebElement manageContactTab;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[1]/div/a")
	WebElement manageAdminUserTab;
	@FindBy(xpath = "//section/div/div/div[4]/div/a")
	WebElement manageSubCategoryTab;
	@FindBy(xpath="//section/div/div/div[3]/div/a")
	WebElement manageCategoryTab;
 
	public String getDashboardString() {
		return dashboardText.getText();
	}

	public ManageNewsPage clickOnManageNewsTab() {
		// gu.selectDropdownWithIndex(dashboardText, 2); general utility
		manageNewsTab.click();
		return new ManageNewsPage(driver);
	}

	public ManageFooterPage clickOnManageFooterTab() {
		manageFooterTab.click();
		return new ManageFooterPage(driver);
	}

	public ManageContactPage clickOnManageContactPage() {
		manageContactTab.click();
		return new ManageContactPage(driver);
	}

	public AdminUserPage clickonAdminUserPage() {
		manageAdminUserTab.click();
		return new AdminUserPage(driver);

	}
	public CategoryPage clickonCategoryPage() {
		manageCategoryTab.click();
		return new CategoryPage(driver);
	}

	public Sub_CategoryPage clickOnSubCategoryPage() {
		manageSubCategoryTab.click();
		return new Sub_CategoryPage(driver);
	}
}
