package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Test
public class testNG2_Test1 {
	static WebDriver driver = new FirefoxDriver();
	@BeforeClass
	public void beforeClass() throws Exception {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}

	@Parameters("browser")
	@Test(timeOut = 36000000, description = "Open Paytm Site and Click Login", enabled = true, groups = { "PAYTM", "LOGIN", "OPENURL"})
	public void TestNG2_Open_ClickLogin(@Optional("firefox")  String browser ) throws Exception
	{
		driver.get("https://paytm.com/");
		WebElement logbtn = driver.findElement(By.linkText("Log In / Sign Up"));
		logbtn.click();
	}
	@Test(timeOut = 36000000, description = "Switch Frame", enabled = true, dependsOnMethods = {
	"TestNG2_Open_ClickLogin" }, groups = { "PAYTM","SWITCH"})	
	public static void TestNG2_SwitchFrame() throws Exception
	{
		driver.switchTo().frame(2);	
	}
	
	@Test(timeOut = 36000000, description = "Sign In with Credentials", enabled = true, dependsOnMethods = {
	"TestNG2_SwitchFrame" }, groups = { "PAYTM","SIGNIN"})	
	
	public void TestNG2_SignIn() throws Exception
	{
		WebElement usrInput = driver.findElement(By.id("input_0"));
		WebElement passInput = driver.findElement(By.id("input_1"));
		WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usrInput.sendKeys("hello");
		passInput.sendKeys("helllo");
		loginbtn.click();
	}
	
	@Test(timeOut = 36000000, description = "Verify Login Successfull", enabled = true, dependsOnMethods = {
	"TestNG2_SignIn" }, groups = { "PAYTM","VERIFY"})	
		public void TestNG2_VerifyLogin() throws Exception
	{
		WebElement errorText = driver.findElement(By.xpath("//span[@class='error']"));
		Assert.assertEquals(errorText.getText(), "Email incorrect.");
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void TestNG2_Closedriver() throws Exception
	{
		driver.close();
	}

}