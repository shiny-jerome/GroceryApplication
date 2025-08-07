package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passWordField;
	@FindBy(xpath = "//button[text()='Sign In']") 
	WebElement signInButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;
	
	public Adminpage login(String userName, String passWord) {
		userNameField.sendKeys(userName);
		passWordField.sendKeys(passWord);
		signInButton.click(); 
		return new Adminpage(driver);
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
