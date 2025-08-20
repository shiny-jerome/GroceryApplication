package testCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Grocerrynew {
  @Test
  public void Grocery() {
	  WebDriver driver=new EdgeDriver();
		 driver.get("https://www.google.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	  
	  
  }
}
