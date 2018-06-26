package testNG;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNG4_Test1 {
	@Test(invocationCount = 5 , timeOut = 60000, description = "Test41_@Test", sequential = false, enabled = true,
			groups = { "TEST41","ANNOTATIONS"})
			
	public void f1() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.ifsccodebank.com");
		driver.close();
	}
	
	
	@Test(invocationCount = 5, timeOut = 60000, description = "Test42_@Test", sequential = false, enabled = true,
			groups = { "TEST42","ANNOTATIONS"})
			
	public void f2() {
		System.setProperty("webdriver.chrome.driver", "C://Users//paramjeet.singh//workspace//Trial//Resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.close();
	}
}