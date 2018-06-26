package pageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvancedExecution {

	 	  
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");


		AdvancedOR.Locator(driver,"id","email").sendKeys("qqqq");
		AdvancedOR.Locator(driver,"name","pass").sendKeys("qqqq");
		AdvancedOR.Locator(driver,"xpath","//label[@id='loginbutton']").click();
		AdvancedOR.Locator(driver,"id","email").sendKeys("qqqq");
		AdvancedOR.Locator(driver,"name","pass").sendKeys("qqqq");

	}
}
