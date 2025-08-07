package testCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample {
  @Test
  @Parameters("browser")
  public void f(String browsername) {
	  WebDriver driver=new ChromeDriver();
		 driver.get("https://www.google.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		 
		 System.out.println("Page source="+driver.getPageSource()); 
		 System.out.println("Page title="+driver.getTitle()); 
		 System.out.println("Current url="+driver.getCurrentUrl()); 
  }
}
