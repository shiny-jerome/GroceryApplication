package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.GeneralUtility;
import utilities.WaitUtility;

public class Sub_CategoryPage {
	WebDriver driver;
	GeneralUtility gu = new GeneralUtility();
	FakerUtility fu = new FakerUtility();
	WaitUtility wu = new WaitUtility();

	public Sub_CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement category;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement image;
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement cancel;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement updateSubcategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//select[@id='un']")
	WebElement searchCategory;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchClick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement addAlert;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlert;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	WebElement firstRow;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;

	public void addSubCategory() {
		newButton.click();
		category.sendKeys("Vegetables");
		subcategory.sendKeys(fu.generateName());
		gu.uploadFile(image, "C:\\Users\\Acer\\passionfruit.jpeg");
		gu.pageScroll(0, 500, driver);
		save.click();
	}

	public String subcategoryAddedSuccessfully() {
		return addAlert.getText();
	}

	public void updateSubCategory() {
		List<WebElement> subCategoryCell = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		String subCategoryname = "LambertGermaine";
		for (int i = 0; i < subCategoryCell.size(); i++) {
			if (subCategoryCell.get(i).getText().equals(subCategoryname)) {
				WebElement element = driver
						.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td/a/i[@class='fas fa-edit']"));
				wu.waitForElementToBeClickable(driver, element, 10);
				element.click();
				break;
			}
		}
		updateSubcategory.clear();
		updateSubcategory.sendKeys(fu.generateName());
		gu.pageScroll(0, 500, driver);
		updateButton.click();
	}

	public String subcategoryUpdatedSuccessfully() {
		return updateAlert.getText();
	}

	public void searchSubCategory() {
		searchButton.click();
		gu.selectDropdownByIndex(searchCategory, 5);
		searchClick.click();
	}

	public String subcategorySearchedSuccessfully() {
		return firstRow.getText();
	}

	public void deleteSubCategory() {
		List<WebElement> subCategoryCell = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		String subCategoryname = "JosianneTre";
		for (int i = 0; i < subCategoryCell.size(); i++) {
			if (subCategoryCell.get(i).getText().equals(subCategoryname)) {
				WebElement element = driver
						.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td/a/i[@class='fas fa-trash-alt']"));
				gu.pageScroll(0, 500, driver);
				element.click();
				// wu.waitForAlert(driver);
				driver.switchTo().alert().accept();
				break;
			}
		}
	}

	public String subcategoryDeletedSuccessfully() {
		return deleteAlert.getText();
	}
}
