package testCase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01 {
	 WebDriver driver;

	@Test
	 public void login() throws IOException
	 {
		driver=new ChromeDriver();
	        driver.findElement(By.name("username")).sendKeys("admin");
		    driver.findElement(By.name("password")).sendKeys("admin");
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("screenshot.png"));
			String actualTitle = driver.findElement(By.linkText("Admin")).getText();
			System.out.println(actualTitle);
			String expectedTitle = "Admin";
	        assertEquals(actualTitle, expectedTitle, "Page title does not match the expected value");
}
	
}
