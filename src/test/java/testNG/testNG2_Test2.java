package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class testNG2_Test2 {

	@Test(timeOut = 36000000, description = "IFSC Test", enabled = true, groups = { "IFSC"})	
		public static void IFSC() throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.ifsccodebank.com");
		WebElement bank = driver.findElement(By.id("BC_ddlBank"));		
		Select ban = new Select(bank);
		ban.selectByValue("2");
		WebElement state = driver.findElement(By.id("BC_ddlState"));		
		Select stat = new Select(state);
		stat.selectByVisibleText("Karnataka");
		WebElement disst = driver.findElement(By.id("BC_ddlDistrict"));		
		Select diss = new Select(disst);
		diss.selectByIndex(1);
		Thread.sleep(9000);
		driver.close();
	}
}