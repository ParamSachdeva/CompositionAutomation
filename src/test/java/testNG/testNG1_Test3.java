package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testNG1_Test3 {
	WebDriver driver = new FirefoxDriver();
	
	@Test(timeOut = 60000, description = "Test3 - HelloTest", enabled = true,
			groups = { "TEST3","WEB"})
	public void OpenandClose() {
		driver.get("http://Hai.com");
		driver.close();
		
	}
	
	
}
