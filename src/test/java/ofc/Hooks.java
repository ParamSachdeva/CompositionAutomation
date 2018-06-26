package ofc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import ofc.Composition_API_Testing_Objects;


public class Hooks extends Composition_API_Testing_Objects{

	public static WebDriver driver;


	@Before
	public void intialization(Scenario scenario) throws Exception {		
			/*String builddetails = new PropertyReader().readProperty("builddetails");
			scenario.write("Execution Environment: " + testcasesheetTag + "\n" 			
					+ "Rates Trader build version: " + builddetails );*/
	}	
}