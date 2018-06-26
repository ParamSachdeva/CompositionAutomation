package testNG;

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

public class testNG1_Test1 {
	@Test(dataProvider = "dp",timeOut = 60000, description = "Test1 - @Test", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
			
	public void f(Integer n, String s) {
		System.out.println("Inside Data Provider");
	}
	
	@Test(dataProvider = "ff",timeOut = 60000, description = "Test1 - @Test", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
			
	public void f1(Integer n, String s) {
		System.out.println("Inside Data Provider");
	}

	@BeforeMethod(timeOut = 60000, description = "Test1 - @BeforeMethod", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod(timeOut = 60000, description = "Test1 - @AfterMethod", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
	public void afterMethod() {
		System.out.println("After Method");
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" },
				new Object[] { 2, "b" }, };
	}
@DataProvider
	public Object[] [] ff(){
		return new Object[] [] {new Object[] {2,"b"},new Object[]{2,"c"}};
		
	}
	@BeforeClass(timeOut = 60000, description = "Test1 - @BeforeBeforeClass", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass(timeOut = 60000, description = "Test1 - @AfterClass", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
	public void afterClass() {
		System.out.println("After Class");
	}

	@BeforeTest(timeOut = 60000, description = "Test1 - @AfterClass", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest(timeOut = 60000, description = "Test1 - @AfterTest", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
	public void afterTest() {
		System.out.println("After Test");
	}

	@BeforeSuite(timeOut = 60000, description = "Test1 - @BeforeSuite", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite(timeOut = 60000, description = "Test1 - @AfterSuite", enabled = true,
			groups = { "TEST1","ANNOTATIONS"})
	public void afterSuite() {
		System.out.println("After Suite");
	}

}