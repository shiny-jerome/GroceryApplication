package elementRepository;

import java.util.List;

import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	WebDriver driver;
	WaitUtility wu = new WaitUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']//i[@class='fas fa-edit']")
	WebElement newButton;
	@FindBy(id = "news")
	WebElement news;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlertMessage;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlertMessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement searchNews;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement search;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	WebElement firstRow;

	public void createNewMessage() {
		newButton.click();
		news.sendKeys("hard work");
		saveButton.click();
	}

	public String getAlertMessage() {
		return alertMessage.getText();
	}

	public void updateCreatedMessage() {
		List<WebElement> messageCells = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		String message = "hard work";
		for (int i = 0; i < messageCells.size(); i++) {
			if (messageCells.get(i).getText().equals(message)) {
				String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[2]//a//i[@class='fas fa-edit']";
				WebElement element = driver.findElement(By.xpath(locator));
				wu.waitForElementToBeClickable(driver, element, 10);
				element.click();
				break;
			}
		}
		news.clear();
		news.sendKeys("hard work pays off");
		updateButton.click();
	}

	public String getUpdateAlertMessage() {
		return updateAlertMessage.getText();
	}

	public void deleteCreateMessage() {
		List<WebElement> messageCells = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		String message = "hard work pays off";
		for (int i = 0; i < messageCells.size(); i++) {
			if (messageCells.get(i).getText().equals(message)) {
				String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[2]//a//i[@class='fas fa-trash-alt']";
				WebElement element = driver.findElement(By.xpath(locator));
				element.click();
				driver.switchTo().alert().accept();
				break;
			}
		}
	}

	public String getDeleteAlertMessage() {
		return deleteAlertMessage.getText();
	}

	public void searchMeassage() {
		searchButton.click();
		searchNews.sendKeys("good bad ugly");
		search.click();
	}

	public String getSearchMessage() {
		return firstRow.getText();
	}
}
