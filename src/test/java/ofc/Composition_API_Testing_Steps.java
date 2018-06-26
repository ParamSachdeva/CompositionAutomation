package ofc;

import java.util.Map;
import org.testng.AssertJUnit;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ofc.Composition_API_Testing_Objects;


public class Composition_API_Testing_Steps extends Composition_API_Testing_Objects{

	static protected Scenario scenario;


	@Before
	public void intialization(Scenario scenario) throws Exception {
		Composition_API_Testing_Steps.scenario = scenario;
	}	

	@When("^\"(.*?)\" trade with given set of data,instrument type \"(.*?)\"_\"(.*?)\"_\"(.*?)\"_\"(.*?)\"$")
	public void trade_with_given_set_of_data(String arg1,String arg2,String arg3,String arg4,String arg5) throws Throwable {
		String builddetails = new PropertyReader().readProperty("builddetails");
		if (arg3.trim().toLowerCase().equals("linked"))
		{
			scenario.write("Trade booked with component trades linked, "
					+ "Trade link Id : "+ tradeLinkId + "\n" 				
					+ "Trade Booking URL : " + siteCode+ "\n"
					+ "Execution Environment: " + testcasesheetTag + "\n" 			
					+ "Rates Trader build version: " + builddetails);
		}
		else
		{
			Composition_API_Testing_Objects.booktrade(arg1,arg2,arg3,arg4,arg5); 	
			if(!tradeLinkId.equals("blank")){
				scenario.write("Trade link Id : "+ tradeLinkId + "\n" 	
						+ "Contract ID: " + contractId + "\n"
						+ "Insturment Number : "+ insNum + "\n" 
						+ "Trade Ref ID: "+ TradeRefID + "\n"
						+ "Trade Booking URL : " + siteCode + "\n"
						+ "Trade Validation Status: " + ValidationStatus + "\n"
						+ "Execution Environment: " + testcasesheetTag + "\n" 			
						+ "Rates Trader build version: " + builddetails );

				if (contractId.equals("0"))
				{
					//AssertJUnit.assertEquals("Contract ID should return some proper value",contractId);
					AssertJUnit.assertEquals("Trade Booking failed, Error:",detailedResponse);

				}
			}
			else{
				scenario.write("Insturment Number : "+ insNum + "\n" 	
						+ "Contract ID: " + contractId + "\n"
						+ "Trade Ref ID: "+ TradeRefID + "\n"
						+ "Trade Booking URL : " + siteCode + "\n"
						+ "Trade Validation Status: " + ValidationStatus + "\n"
						+ "Execution Environment: " + testcasesheetTag + "\n" 			
						+ "Rates Trader build version: " + builddetails );
				if (contractId.equals("0"))
				{
					//AssertJUnit.assertEquals("Contract ID should return some proper value",contractId);
					AssertJUnit.assertEquals("Trade Booking failed, Error:",detailedResponse);
				}
			}
		}

	}

	@Then("^\"(.*?)\"_\"(.*?)\" \"(.*?)\",\"(.*?)\"_\"(.*?)\"_\"(.*?)\" tag name - \"(.*?)\"$")
	public void __tag_name(String arg1, String arg2, String arg3, String arg4,String arg5,String arg6,String arg7) throws Throwable {
		String builddetails = new PropertyReader().readProperty("builddetails");	
		Composition_API_Testing_Objects.serviceRequestS(arg1,arg2,arg3,arg4,arg5,arg6,arg7);
		if (Compositiontype.equals("execution"))	
		{
			String ResponseURPrint = "<a href=" + "\"" + ExecutionResponseData + "\"" + " target=" + "\"" + "_blank" + "\"" + ">Click to View</a>";
			scenario.write("Execution Response URL : " + ResponseURPrint + "\n" 	
					+ "Actual Response: " + NodeName + " = " + ActualNodeResponse + "\n"
					+ "Expected Response: " + NodeName + " = "  + responseExpected + "\n"
					+ "Composition Service URL: " + siteCode + "\n"
					+ "Execution Environment: " + testcasesheetTag + "\n" 			
					+ "Rates Trader build version: " + builddetails );
		}
		else{
			scenario.write("Actual Response: " + NodeName + " = " + ActualNodeResponse + "\n"
					+ "Expected Response: " + NodeName + " = "  + responseExpected + "\n"
					+ "Composition Service URL: " + siteCode + "\n"
					+ "Execution Environment: " + testcasesheetTag + "\n" 			
					+ "Rates Trader build version: " + builddetails );
		}
		//AssertJUnit.assertEquals("PASS",status);
		if(responseExpected.equals("skip")){
			AssertJUnit.assertEquals(responseExpected,"skip");
		}
		else{
			AssertJUnit.assertEquals(responseExpected,ActualNodeResponse);
		}		
	}
}
