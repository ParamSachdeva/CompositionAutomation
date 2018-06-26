package ofc;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@RunWith(ExtendedCucumber.class)

@CucumberOptions(plugin = {		
		"junit:target/json/cucumber-results.xml",
		"json:target/json/cucumber.json",
		"html:target/cucumber-html-report"
},
features = { "classpath:features" },
monochrome = false,
dryRun = false,//
tags = {"@BookCloneAmmendement"}
		)

//clean package -Dcucumber.options="--tags @CMCClearingRegressionBucket2" -Djavax.net.ssl.trustStore="C:\Param\SeprateQAProject\TestNGRegressionSuite\stopit-qa-automation\trust.jks"

public class RunCukesTest{	
	
}