package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testNG1_Test2 {
	WebDriver driver = new FirefoxDriver();
	
	@Test(timeOut = 60000, description = "Test2 - HelloTest", enabled = true,
			groups = { "TEST2","WEB"})
	public void OpenandClose() {
		driver.get("http://Hello.com");
		driver.close();
		
	}
}
