package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.GeneralUtility;

public class AdminUserPage {
	FakerUtility fu = new FakerUtility();
	GeneralUtility gu = new GeneralUtility();
	WebDriver driver;
 
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement adminUsername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement adminPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement adminUsertype;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newUserAlert;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement statusAlert;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	WebElement updateAlert;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;
	@FindBy(xpath = "//input[@id='password']")
	WebElement updatePassword;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchUser;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchUserButton;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	WebElement firstRow;
	@FindBy(xpath = "//form/div/div/a[@class='btn btn-default btn-fix']")
	WebElement reset;

	public AdminUserPage createNewAdminUser() {
		newButton.click();
		adminUsername.sendKeys(fu.generateName());
		adminPassword.sendKeys("Ash123");
		gu.selectDropdownByIndex(adminUsertype, 1);
		savebutton.click();
		return this;
		}

	public boolean getAlertMessage() {
		return newUserAlert.isDisplayed();
	}

	public void statusChange() {
		List<WebElement> userNameCell = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		String user = "tara";
		for (int i = 0; i < userNameCell.size(); i++) {
			if (userNameCell.get(i).getText().equals(user)) {
				WebElement element = driver
						.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[5]/a/i[@class='fa fa-unlock']"));
				element.click();
				break;
			}
		}
	}

	public String getStatusAlertMessage() {
		return statusAlert.getText();
	}

	public void updateAdminUser() {
		List<WebElement> userNameCell = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		String user = "tara";
		for (int i = 0; i < userNameCell.size(); i++) {
			if (userNameCell.get(i).getText().equals(user)) {
				WebElement element = driver
						.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[5]/a/i[@class='fas fa-edit']"));
				element.click();
				break;
			}
		}
		updatePassword.clear();
		updatePassword.sendKeys("vhghghgf");
		updateButton.click();
	}

	public String getupdateAlertMessage() {
		return updateAlert.getText();
	}

	public void deleteAdminUser() {
		List<WebElement> userNameCell = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		String user = "Arvel";
		for (int i = 0; i < userNameCell.size(); i++) {
			if (userNameCell.get(i).getText().equals(user)) {
				WebElement element = driver.findElement(
						By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[5]/a/i[@class='fas fa-trash-alt']"));
				element.click();
				driver.switchTo().alert().accept();
				break;
			}
		}
	}

	public String getdeleteAlertMessage() {
		return deleteAlert.getText();
	}

	public void searchAdminUser() {
		searchButton.click();
		searchUser.sendKeys("aswathi");
		searchUserButton.click();
	}

	public String getSearchMessage() {
		return firstRow.getText();
	}

	public void reset() {
		searchButton.click();
		searchUser.sendKeys("aswathi");
		searchUserButton.click();
		reset.click();
	}

	public String resetAlert() {
		return driver.getCurrentUrl();
	}
}
