package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelUtility;
import utilities.ScreenShotCapture;

public class BaseClass {
	WebDriver driver; // driver declared as instance variable
	ScreenShotCapture sc;
	LoginPage lp;
	
	public static Properties pro;

	public static void testBasic() throws IOException {
		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		pro.load(fp);
	}

	public static String groceryData(int row, int column) throws IOException, InvalidFormatException {
		String data = ExcelUtility.readDataFromExcel(row, column,
				"\\src\\test\\resources\\excel\\login.xlsx", "sheet1");
		return data;  
	} 

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browserName) throws IOException {
		testBasic();
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		
		driver.get(pro.getProperty("baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constant.implicitwaitTIMEOUT));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

	
}
