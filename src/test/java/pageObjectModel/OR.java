package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OR {

	 private static WebElement element = null;
	 
	   
	   public static WebElement UserName(WebDriver driver)
	   {
	      element = driver.findElement(By.id("email"));
	      return element;
	   }
	   
	   public static WebElement Password(WebDriver driver)
	   {
	      element = driver.findElement(By.id("pass"));
	      return element;
	   }
	   
	   public static WebElement Login(WebDriver driver)
	   {
	      element = driver.findElement(By.id("u_0_v"));
	      return element;
	   }
	   
	   public static WebElement Coach(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//input[@value='Coach']"));
	      return element;
	   }
	   
	   public static WebElement Buisness(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//input[@value='Business']"));
	      return element;
	   }   
	   
	   
}
