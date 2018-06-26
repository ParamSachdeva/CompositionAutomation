package testNG;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridtestNG2 {


	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	@Parameters("browser")
	@BeforeTest
	public void launchapp(String browser) throws MalformedURLException
	{
		String URL = "http://www.ifsccodebank.com";

		if (browser.equalsIgnoreCase("firefox"))
		{
			System.out.println(" Executing on FireFox");
			String Node = "http://192.168.1.66:5555/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");

			driver = new RemoteWebDriver(new URL(Node), cap);
			// Puts an Implicit wait, Will wait for 10 seconds before throwing exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			System.out.println(" Executing on CHROME");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			String Node = "http://192.168.1.66:5557/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.out.println(" Executing on IE");
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("ie");
			String Node = "http://192.168.1.66:5558/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		}
		else
		{
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void calculatepercent()
	{
		WebElement bank = driver.findElement(By.id("BC_ddlBank"));		
		Select ban = new Select(bank);
		ban.selectByValue("2");
		WebElement state = driver.findElement(By.id("BC_ddlState"));		
		Select stat = new Select(state);
		stat.selectByVisibleText("Karnataka");
		WebElement disst = driver.findElement(By.id("BC_ddlDistrict"));		
		Select diss = new Select(disst);
		diss.selectByIndex(1);
	}

	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}



/*
java -jar C:\Users\paramjeet.singh\workspace\Trial\Resources\selenium-server-standalone-2.48.2.jar -port 4444 -role hub -nodeTimeout 1000

java -Dwebdriver.chrome.driver=C:\Users\paramjeet.singh\workspace\Trial\Resources\chromedriver.exe -jar C:\Users\paramjeet.singh\workspaceTrial\Resources\selenium-server-standalone-2.48.2.jar -role webdriver -hub http://192.168.0.7:4444/grid/register -browser browserName=chrome -port 5557

java -Dwebdriver.chrome.driver=C:\Users\paramjeet.singh\workspace\Trial\Resources\chromedriver.exe -jar C:\Users\paramjeet.singh\workspaceTrial\Resources\selenium-server-standalone-2.48.2.jar -role webdriver -hub http://192.168.0.7:4444/grid/register -browser browserName=chrome -port 5557
*/