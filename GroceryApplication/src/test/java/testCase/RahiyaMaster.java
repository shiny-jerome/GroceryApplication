package testCase;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RahiyaMaster
{
WebDriver driver;
Properties prop;


	 @Test(priority = 3)
	  public void loginFail()
	  {
			WebElement txtUsername = driver.findElement(By.name("username")); //to get username
			txtUsername.sendKeys("admin");	 
			WebElement txtPassword = driver.findElement(By.name("password")); //to get password
			txtPassword.sendKeys("admin2");	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));  
	  }
	}


}
