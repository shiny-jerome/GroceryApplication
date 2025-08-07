package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table/tbody/tr/td[6]/a/i[@class='fas fa-edit']")
	WebElement edit;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement address;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliverytime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement delchrglimit;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageContactPage clickEdit() {
		edit.click();
		return this;
	}

	public ManageContactPage addPhone(String phonefield) {
		phone.sendKeys(phonefield);
		return this;
	}

	public ManageContactPage addEmail(String emailfield) {
		email.sendKeys(emailfield);
		return this;
	}

	public ManageContactPage addAddress(String addressfield) {
		address.sendKeys(addressfield);
		return this;
	}

	public ManageContactPage addDeliveryTime(String deliveryfield) {
		deliverytime.sendKeys(deliveryfield);
		return this;
	}

	public ManageContactPage addDelChrgLimit(String delchrgfield) {
		delchrglimit.sendKeys(delchrgfield);
		return this;
	}

	public ManageContactPage clickUpdate() {
		update.click();
		return this;
	}

	public boolean isManageContactUpdatedSuccessfully() {
		return alert.isDisplayed();
	}
}
