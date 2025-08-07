package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	WebDriver driver;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table/tbody/tr[1]/td[4]/a/i[@class='fas fa-edit']")
	WebElement editButton;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement address;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageFooterPage clickEditButton() {
		editButton.click();
		return this;
	}

	public ManageFooterPage addAddress(String addressfield) {
		address.sendKeys(addressfield);
		return this;
	}

	public ManageFooterPage addEmail(String emailfield) {
		email.sendKeys(emailfield);
		return this;
	}

	public ManageFooterPage addPhone(String phonefield) {
		phone.sendKeys(phonefield);
		return this;
	}

	public ManageFooterPage clickUpdate() {
		updateButton.click();
		return this;
	}

	public boolean isFooterTextUpdatedSuccessfully() {
		return alert.isDisplayed();
	}
}
