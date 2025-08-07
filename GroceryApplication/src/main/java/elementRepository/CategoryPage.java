package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;
import utilities.WaitUtility;

public class CategoryPage {
	WebDriver driver;
	WaitUtility wu = new WaitUtility();
	GeneralUtility gu = new GeneralUtility();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[1]/section/div[1]/a[2]")
	WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement categoryField;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchCategory;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	WebElement firstRow;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	WebElement CategoryCell;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement statusAlert;

	public void categorySearch() {
		searchButton.click();
		categoryField.sendKeys("grocery");
		gu.pageScroll(0, 500, driver);
		searchCategory.click();
	}

	public String isSearchSuccessful() {
		return firstRow.getText();
	}

	public CategoryPage statusChange() {
		List<WebElement> CategoryCell = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		String Categoryname = "Luella";
		for (int i = 0; i < CategoryCell.size(); i++) {
			if (CategoryCell.get(i).getText().equals(Categoryname)) {
				String locator = "//table/tbody/tr[" + (i + 1) + "]/td/a/span[contains(@class, 'badge')]";
				WebElement element = driver.findElement(By.xpath(locator));
				gu.pageScroll(0, 500, driver);
				wu.waitForElementVisible(driver, element, 5);
				element.click();
				break;
			}
		}
		return this;
	}

	public String isStatusChangedsuccessfully() {
		return statusAlert.getText();
	}
}
