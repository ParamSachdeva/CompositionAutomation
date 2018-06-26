package pageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Execution {

	 	  
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");


		OR.UserName(driver).sendKeys("qqqq");
		OR.Password(driver).sendKeys("qqqq");
		OR.Login(driver).click();

	}
}
