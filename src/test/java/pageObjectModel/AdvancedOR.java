package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedOR {

	private static WebElement element = null;


	public static WebElement Locator(WebDriver driver,String by, String locator)
	{

		by = by.toLowerCase();
		
		switch(by)
		{
		case "xpath":
			element = driver.findElement(By.xpath(locator));
			return element;
		case "id":
			element = driver.findElement(By.id(locator));
			return element;
		case "css":
			element = driver.findElement(By.cssSelector(locator));
			return element;
		case "name":
			element = driver.findElement(By.name(locator));
			return element;
		case "linktext":
			element = driver.findElement(By.linkText(locator));
			return element;
		case "tagname":
			element = driver.findElement(By.tagName(locator));
			return element;
		case "partiallinktext" :
			element = driver.findElement(By.partialLinkText(locator));
			return element;
		default:
			element = driver.findElement(By.xpath(locator));
			return element;
		}
		
	}

}
