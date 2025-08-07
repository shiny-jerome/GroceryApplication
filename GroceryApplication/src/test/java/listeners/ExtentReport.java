package listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	ExtentSparkReporter sparkReporter;   //Generates the actual HTML report.
	ExtentReports reports;               // Main reporting class that manages the whole report.
	ExtentTest test;                     //Represents a single test in the report (used for logging status).

	public void configureReport() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss");  //gets the current date and time using simpleDareFormat
		String strDate = formatter.format(date);

		File reportPath = new File(System.getProperty("user.dir") + "//ExtentReport");

		if (!reportPath.exists()) {  //Creates a folder called ExtentReport inside your project if it doesn't exist
			reportPath.mkdir();      //Creates a folder called ExtentReport inside your project if it doesn't exist
		}
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//ExtentReport//" + "ExtentReport_" + strDate + ".html");  //Creates a new HTML report file with a timestamped name
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);        // initializing your ExtentReports system and telling it where and how to write the HTML report.

		reports.setSystemInfo("Project", "GroceryApplication");
		reports.setSystemInfo("PC Name", "Aswathi's PC");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Test Done By", "Aswathi");		 
		sparkReporter.config().setDocumentTitle("7rmart supermarket Report ");
		sparkReporter.config().setReportName("Report Summary");
		sparkReporter.config().setTheme(Theme.STANDARD);
	}	

	public void onTestSuccess(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));
	}
	
	public void onStart(ITestContext context) {   //This method runs before your test suite starts.
		configureReport();		
	}	

	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
