package ofc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.ProxySelector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.AssertJUnit;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import ofc.Composition_API_Testing_Steps;
import ofc.PropertyReader;
import static com.jayway.restassured.RestAssured.given;

public class Composition_API_Testing_Objects  {	
	static String strSSOVal;
	static String strPatternID;
	static int intResponseCode;
	static String strSearchResult;
	static String response;
	protected static String responseExpected;
	protected static String status;
	static String exceldata;
	static String ResponseDataFile;
	static String RequestDataFile;
	static String steplevel;
	static String Reuesttoembeddinreport;
	protected static String Compositiontype;
	protected static String TradeRefID;
	protected static String ExecutionResponseData = "";
	protected static String insNum =null;
	protected static String contractId = null;
	protected static String tranNum = null;
	protected static String tradeLinkId ;
	protected static String detailedResponse;
	static String TestCaseNumber;
	static String TestStepNumber;
	static String TestCaseDescription;
	static String comparewholeresponse ;
	static String Headerpart;
	static String envdetails;
	static String Result;
	protected static String ValidationStatus = "Validation ignored!";
	protected static String NodeName;
	protected static String ActualNodeResponse = null;
	static HashMap<String,String> mifidatavalues;
	static HashMap<String,String> expecteddatavalues;
	static int previousdataRowNum =0;
	protected static String siteCode;
	protected static String testcasesheetTag;
	static String portfolio;
	static String HeaderCoposition;
	static protected Scenario scenario;


	@Before
	public void intialization(Scenario scenario) throws Exception {
		Composition_API_Testing_Objects.scenario = scenario;
	}	

	//********************************** SERVICE REQUEST PATTERN *********************************************
	public static void serviceRequestS(String testcaseid,String teststepid,String testcasedescription,String testcasefile,String testcasesheet,String tradeentrytype,String tag) throws Exception{
		siteCode  = new PropertyReader().readProperty("CopositionRequestURL");
		
		if (testcasefile.equals("Broker"))
		{
			testcasesheetTag = new PropertyReader().readProperty("region")
							+ new PropertyReader().readProperty("testcasesheettag");
			
		}else
		{
			testcasesheetTag = new PropertyReader().readProperty("testcasesheettag");
		}
		
		String SSO = "FOSSO";
		strSSOVal = GetSSOToken.funGetSSOTokenRT(SSO);

		/*if (tradeentrytype.contains("Book") || tradeentrytype.contains("Clone"))
		{
			SSO = "FOSSO";
		}
		else if (tradeentrytype.contains("Amend"))
		{
			SSO = "MOSSO";			
		}*/

		try {			
			FileInputStream fileInputStream = new FileInputStream(new PropertyReader().readProperty(testcasefile));			
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet(testcasesheet + testcasesheetTag);
			XSSFCell cell;
			String []compositiontype = testcasedescription.split(":");			
			Compositiontype = compositiontype[0].toLowerCase();
			NodeName = tag;
			int rownHeader = findRow(worksheet, "TestCase","TestSteps");
			int rownValue = findRow(worksheet, testcaseid,teststepid);	


			Row rowObjHeader = worksheet.getRow(rownHeader);
			Row rowObjValue  = worksheet.getRow(rownValue);

			int noOfColumn = rowObjHeader.getLastCellNum();			

			if (testcasefile.equals("Broker"))
			{
				HeaderCoposition = new PropertyReader().readProperty("GetHeaderBroker");
			}else
			{
				HeaderCoposition = new PropertyReader().readProperty("GetHeaderCoposition");
			}

			envdetails = new PropertyReader().readProperty("envdetails");
			File headerObj = new File(HeaderCoposition);
			Headerpart = FileUtils.readFileToString(headerObj);

			//Code to avoid service hit multiple times
			if (rownValue != previousdataRowNum)
			{	
				expecteddatavalues = new HashMap();			
				for (int i =0;i <noOfColumn-1;i++)
				{						
					expecteddatavalues.put(rowObjHeader.getCell(i).getStringCellValue(), rowObjValue.getCell(i).getStringCellValue());
				}
				Result = CallServiceComposition(expecteddatavalues.get("Request"),new PropertyReader().readProperty("CopositionRequestURL"));
				previousdataRowNum = rownValue;
			}
			else
			{
				Result =Result;
			}
			//System.out.println(Result);
			responseExpected = expecteddatavalues.get(tag);

			//System.out.println(Result);
			//File headerObj1 = new File("\\\\delmw29009\\PreTradeAutomation\\ExecutionService\\Book_Amendment\\test.xml");
			//Result = FileUtils.readFileToString(headerObj1);
			//Result = Result.replaceAll("odc:", "");			
			//String Actual = GetNodeValueFromXML(Result,"/legalStartDate");
			//String Actual = GetNodeValueFromXML(Result,"/initialPrincipal/value");


			String Actual = GetNodeValueFromXML(Result,tag);
			if(responseExpected.equals("skip")){
				//if (Actual.equals(""))
				//{
				status = "PASS";
				//}
				//else
				//{
				//	status = "FAIL";
				//}
			}
			else{
				//if (Actual.equals(expecteddatavalues.get(tag)))
				if (Actual.equals(responseExpected))				
				{
					status = "PASS";
				}
				else
				{
					status = "FAIL";
				}
			}				

			if (Compositiontype.equals("execution")){
				String []refrence = Result.split("Execution.Invocation");
				refrence = refrence[1].split("message");
				ExecutionResponseData = refrence[1].replace("</", "").replace(">", "");
			}

			NodeName = tag;
			ActualNodeResponse = Actual;	
			cell = (XSSFCell) rowObjValue.createCell(noOfColumn-1);						
			cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue("");//Clear previous values in excel
			cell.setCellValue(status);		
			FileOutputStream fos=new FileOutputStream(new PropertyReader().readProperty(testcasefile));
			workbook.write(fos);
			fos.flush();
			fos.close();	
			//AssertJUnit.assertEquals("PASS",status);
			workbook.close();

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e)
		{	e.printStackTrace();
		}

	}

	private static int findRow(XSSFSheet sheet, String cellContentTC, String cellContentTS) {
		int RowIndex1 ;
		int RowIndex2 ;
		try{
			for (Row row : sheet) {			
				for (Cell cell : row) {
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {					
						if (cell.getRichStringCellValue().getString().trim().equals(cellContentTS)) {						
							RowIndex1 =  cell.getRowIndex();
							for (Row row1 : sheet) {	
								for (Cell cell1 : row1) {									
									if (cell1.getRichStringCellValue().getString().trim().equals(cellContentTC)) {						
										RowIndex2 = cell1.getRowIndex();
										if (RowIndex1 == RowIndex2)
										{
											return RowIndex1;
										}										
									}
								}
							}

						}
					}
				}
			}	
		}
		catch (IllegalStateException e)
		{
			e.getMessage();
		}
		return 0;
	}
	public static String readExcel()
	{
		return exceldata;
	}

	public static String GetNodeValueFromXMLTagNAme(String XMLResponse,String NodeName) throws Exception
	{
		String NodeValue = null;
		String[] XMLResponse1 = XMLResponse.split("<CompositeResponse>");
		XMLResponse = "<CompositeResponse>" + XMLResponse1[1];
		Document xmlDoc = loadXMLString(XMLResponse);
		NodeList nodeList = xmlDoc.getElementsByTagName(NodeName);	
		List<String> ids = new ArrayList<String>(nodeList.getLength());		
		Node x = nodeList.item(0);
		NodeValue = x.getFirstChild().getNodeValue();		
		return  NodeValue ;
	}

	public static String GetNodeValueFromXML(String XMLResponse,String NodeName) throws Exception
	{		
		//FileInputStream file = new FileInputStream(new File("\\\\delmw29009\\PreTradeAutomation\\ExecutionService\\Book_Amendment\\test.xml"));
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  builderFactory.newDocumentBuilder();		
		Document xmlDocument = loadXMLString(XMLResponse);
		//Document xmlDocument = builder.parse(file);		
		XPath xPath =  XPathFactory.newInstance().newXPath();
		String expression = "/" + NodeName;
		//System.out.println(expression);		
		String NodeValue = xPath.compile(expression).evaluate(xmlDocument);
		//System.out.println(NodeValue);
		return NodeValue;		
	}		 


	public static Document loadXMLString(String XMLResponse) throws Exception
	{
		DocumentBuilderFactory dbf;
		DocumentBuilder db = null;
		InputSource is = null ;

		try{
			dbf =DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			is = new InputSource(new StringReader(XMLResponse));
			return db.parse(is);
		}
		catch (SAXParseException e)
		{
			e.printStackTrace();
		}
		return db.parse(is);
	}

	//==================Call Services for Composition====================================
	public static String CallServiceComposition(String body,String url) throws Exception{

		String strRequesturl = url;	
		String serviceBody = null;

		if (Compositiontype.equals("regulatory"))
		{				
			serviceBody = body;
		}
		else
		{	
			if (body.contains(".xml"))
			{
				//if path is given instead of request, because of request length is too lengthy to fit in a cell  
				File bodyObj = new File(body);
				body = FileUtils.readFileToString(bodyObj);
			}

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");    	
			cal.add(Calendar.DATE, -1);  
			String env = "<environment>" + envdetails + "</environment>";
			String token = "<token>" + strSSOVal + "</token>";
			String datetime = "<dateTime>" + dateFormat.format(cal.getTime()) + "T14:22:12.1882766+05:30</dateTime>";
			serviceBody = Headerpart + env + token + datetime + "</header>" + body ;
		}		
		//System.out.println(serviceBody);

		try{	
			Response response;
			Request request;
			String responseBody;		
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/xml");


			RequestBody strbody = RequestBody.create(mediaType, serviceBody);
			request = new Request.Builder()
					.url(strRequesturl)					
					.post(strbody)
					.addHeader("content-type", "application/xml")
					.addHeader("Accept", "application/xml")					
					.build();

			responseBody = null;

			try{
				response = client.newCall(request).execute();
				//System.out.println(response.code());
				intResponseCode = response.code();			
				responseBody = response.body().string();			
				//System.out.println(responseBody);	
				return responseBody;
			}
			catch (ClientProtocolException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		catch (IndexOutOfBoundsException e)
		{			
			e.printStackTrace();
		}
		return serviceBody;
	}


	public static String booktrade(String TradeEntryType,String instrumentType,String TradeBookTemplate,String AmendField,String AmendValue) throws Exception{

		String bookXml = null;
		siteCode  = new PropertyReader().readProperty("TradeBookURL");
		portfolio = new PropertyReader().readProperty("portfolio");
		String tradebooktemplate = TradeBookTemplate;		
		String templateTradeBookingXmlPath 	= new PropertyReader().readProperty(tradebooktemplate);
		String templateTradeBookingPrefixXmlPath = new PropertyReader().readProperty("TradeBookingPrefix");	
		String docEvent = null;
		String reference = null ;
		String bookingUuid ;
		String bookidlinkedtrade;
		String bookidlinkedtrade1;
		String bookidlinkedtrade2;
		String executionId;
		Response response;
		Request request;
		String  responseBody = null;
		String transactionStatus = null;
		String SSO = "FOSSO";
		strSSOVal = GetSSOToken.funGetSSOTokenRT(SSO);
		tradeLinkId = "blank";

		if (TradeEntryType.contains("Book") || TradeEntryType.contains("Clone")){	
			//String SSO = "FOSSO";
			//strSSOVal = GetSSOToken.funGetSSOTokenRT(SSO);
			contractId = "0";
			docEvent = "New Trade";
			insNum = "0";
			tranNum = "0";			
			reference = "0";
			transactionStatus = "New";}
		//else if (TradeEntryType.contains("Amend") || TradeEntryType.contains("Clone")){
		else if (TradeEntryType.contains("Amend")){
			//String SSO = "MOSSO";
			//strSSOVal = GetSSOToken.funGetSSOTokenRT(SSO);
			contractId = contractId;
			docEvent = "Amend Trade";
			insNum = insNum;
			tranNum = tranNum;
			reference = TradeRefID;			
			transactionStatus = "Amended";
		}

		try{
			Random rand = new Random();
			int temp = rand.nextInt(9999999) + 1;
			executionId = Integer.toString(temp);			
			bookingUuid		  = "auto-" + UUID.randomUUID().toString();
			bookidlinkedtrade = "auto-" + UUID.randomUUID().toString();
			bookidlinkedtrade1= "auto-" + UUID.randomUUID().toString();
			bookidlinkedtrade2= "auto-" + UUID.randomUUID().toString();
			//System.out.println(bookingUuid);
			//System.out.println(bookidlinkedtrade);
			//System.out.println(bookidlinkedtrade1);
			File f = new File(templateTradeBookingXmlPath);
			String xmlInstance = FileUtils.readFileToString(f);
			String TradeBookbeforeReplace = xmlInstance;
			xmlInstance = xmlInstance.replaceAll("%sso-token%", strSSOVal);
			xmlInstance = xmlInstance.replaceAll("%booking-uuid%", bookingUuid);
			xmlInstance = xmlInstance.replaceAll("%bookid-linkedtrade%", bookidlinkedtrade);
			xmlInstance = xmlInstance.replaceAll("%bookid-linkedtrade1%", bookidlinkedtrade1);
			xmlInstance = xmlInstance.replaceAll("%bookid-linkedtrade2%", bookidlinkedtrade2);
			xmlInstance = xmlInstance.replaceAll("%contractId%", contractId);
			xmlInstance = xmlInstance.replaceAll("%insNum%", insNum);
			xmlInstance = xmlInstance.replaceAll("%docEvent%", docEvent);
			xmlInstance = xmlInstance.replaceAll("%reference%", reference);
			xmlInstance = xmlInstance.replaceAll("%tranNum%", contractId);
			xmlInstance = xmlInstance.replaceAll("%transactionStatus%", transactionStatus);
			xmlInstance = xmlInstance.replaceAll("%execution-id%", executionId);
			xmlInstance = xmlInstance.replaceAll("%portfolio%", portfolio);

			bookXml = xmlInstance;

/*
			if (TradeEntryType.contains("Amend"))
			{	
				templateTradeBookingPrefixXmlPath = new PropertyReader().readProperty("TradeAmendPrefix");
				File f1 = new File(templateTradeBookingPrefixXmlPath);
				String xmlInstancePrefix = FileUtils.readFileToString(f1);
				Pattern personPattern = Pattern.compile("<in2>.*?</in2>", Pattern.DOTALL);
				Matcher personMatcher = personPattern.matcher(xmlInstance);
				StringBuffer xmlBuffer = new StringBuffer();

				while(personMatcher.find()) {
					bookXml = personMatcher.group();

					Pattern idPattern = Pattern.compile("<bookingId>(.*)</bookingId>");
					Matcher idMatcher = idPattern.matcher(bookXml);
					idMatcher.find();
					String id = idMatcher.group(1);


					bookXml = bookXml.replaceFirst("<" + AmendField +">.*</" + AmendField + ">",					
							"<" + AmendField + ">" + AmendValue + "</" + AmendField + ">");

					if (AmendField.equals("counterparty"))
					{
						bookXml = bookXml.replaceFirst("<salesCounterpartyId>.*</salesCounterpartyId>",
								"<salesCounterpartyId>" + AmendValue + "</salesCounterpartyId>");						
					}
					bookXml =  xmlInstancePrefix + strSSOVal + "</ssoToken></in0><in1>GDSLDN</in1>" + bookXml + "<in3>true</in3></bookTrade></soap:Body></soap:Envelope>";
				}

			}*/

			//System.out.println(bookXml);
			String content = bookXml;
			/*OkHttpClient client = new OkHttpClient();				
			MediaType mediaType = MediaType.parse("text/xml");
			RequestBody body = RequestBody.create(mediaType, content);
			request = new Request.Builder()		         
					.url(siteCode)
					.post(body)
					.addHeader("content-type", "text/xml")
					.addHeader("Accept", "text/xml")	
					.build();*/


			try{	
				
				/*DefaultHttpClient httpclient = new DefaultHttpClient();
				ProxySelectorRoutePlanner routePlanner = new ProxySelectorRoutePlanner(
				            httpclient.getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
				httpclient.setRoutePlanner(routePlanner);*/
				
				
				String response1 = given().request()
						.contentType("application/xml;").body(content)
						.when().post(siteCode).andReturn().asString();
				responseBody = response1;

				/*	response = client.newCall(request).execute();						
				intResponseCode = response.code();	

				if (intResponseCode==200 || intResponseCode==400){
					status = "PASS";
					responseBody = response.body().string();					
				}
				else
				{
					status = "FAIL";
					responseBody = response.body().string();
				}*/


				//System.out.println(responseBody);

				//AssertJUnit.assertEquals("PASS",status);
				detailedResponse = responseBody;
				String []refrence = responseBody.split("ns1:reference");
				TradeRefID = refrence[1].replace("</", "").replace(">", "");
				System.out.println("TradeRefID: " + TradeRefID);

				String []contractId1 = responseBody.split("ns1:contractId");
				contractId = contractId1[1].replace("</", "").replace(">", "");
				System.out.println("contractId: " +contractId);

				String []insNum1 = responseBody.split("ns1:insNum");
				insNum = insNum1[1].replace("</", "").replace(">", "");
				System.out.println("insNum: "+ insNum);

				if (responseBody.contains("tradeLinkId"))
				{
					String []tradeLinkId1 = responseBody.split("ns2:tradeLinkId");
					tradeLinkId = tradeLinkId1[1].replace("</", "").replace(">", "");
					System.out.println("tradeLinkId: "+ tradeLinkId);
				}

				if (insNum.equals(0) ||contractId.equals(0) )
				{
					status = "FAIL";
				}
				else
				{
					status = "PASS";
				}

				AssertJUnit.assertEquals("PASS",status);

				if(!AmendField.equals("Broker")) 
				
				if (TradeEntryType.contains("Book") || TradeEntryType.contains("Clone"))						
				{
					String []TradeValidateTemplate = TradeBookTemplate.split("Book");
					ValidateTrade("Validate" + TradeValidateTemplate[1]);
				}
				else{
					String []TradeValidateTemplate = TradeBookTemplate.split("Amend");
					ValidateTrade("Validate" + TradeValidateTemplate[1]);
				}


			}
			/*catch (ClientProtocolException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}*/
			catch(Exception e){
				e.printStackTrace();
			}

		}catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBody;
	}


	//need to design with new method
	public static String ValidateTrade(String tradebooktemplate)  throws Exception{

		ValidationStatus = null;
		String templateTradeBookingXmlPath 	= new PropertyReader().readProperty(tradebooktemplate);
		String SSO = null;
		String	responseBody = null;
		String bookXml = null;
		SSO = "MOSSO";	
		strSSOVal = GetSSOToken.funGetSSOTokenRT(SSO);		
		String docEvent = "New Trade";		
		String reference = TradeRefID;
		String transactionStatus = "Validated";
		String bookingUuid = "auto-" + UUID.randomUUID().toString();
		File f1 = new File(templateTradeBookingXmlPath);	
		String xmlInstance = FileUtils.readFileToString(f1);		
		xmlInstance = xmlInstance.replaceAll("%sso-token%", strSSOVal);
		xmlInstance = xmlInstance.replaceAll("%booking-uuid%", bookingUuid);
		xmlInstance = xmlInstance.replaceAll("%contractId%", contractId);
		xmlInstance = xmlInstance.replaceAll("%insNum%", insNum);
		xmlInstance = xmlInstance.replaceAll("%docEvent%", docEvent);
		xmlInstance = xmlInstance.replaceAll("%reference%", reference);
		xmlInstance = xmlInstance.replaceAll("%tranNum%", contractId);
		xmlInstance = xmlInstance.replaceAll("%transactionStatus%", transactionStatus);
		xmlInstance = xmlInstance.replaceAll("%portfolio%", portfolio);
		bookXml = xmlInstance;
		//System.out.println("Validated trade xml: " + bookXml);

		try{		
			String response1 = given().request()
					.contentType("application/xml;").body(bookXml)
					.when().post(siteCode).andReturn().asString();
			responseBody = response1;
			
			//System.out.println(responseBody);
			if(responseBody.contains("<ns1:tranStatus>Validated</ns1:tranStatus>"))
			//if (insNum.equals(0) ||contractId.equals(0) )
			{
				//status = "PASS";
				ValidationStatus = "Trade Validated successfully";	
						
			}
			else
			{
				ValidationStatus = "<font color='red'>Failed to Validate Trade!</font>";
				//status = "FAIL";		
			}
			//AssertJUnit.assertEquals("PASS",status);
		}
		catch(Exception e){
			e.printStackTrace();
		}	
		return transactionStatus;

	}

	// previous method to book trade
	/*public static String booktrade_previous(String TradeEntryType,String instrumentType,String TradeBookTemplate,String AmendField,String AmendValue) throws Exception{
		String test  = new PropertyReader().readProperty("TestCases");
		System.out.println(test);
		String SSO = "FOSSO";
		strSSOVal = GetSSOToken.funGetSSOTokenRT(SSO);
		String bookXml = null;
		String instrument = instrumentType;
		String siteCode  = new PropertyReader().readProperty("TradeBookURL");
		String tradebooktemplate = TradeBookTemplate;
		String templateTradeBookingPrefixXmlPath = new PropertyReader().readProperty("TradeBookingPrefix");		 
		String templateTradeBookingXmlPath 	= new PropertyReader().readProperty(tradebooktemplate);
		Response response;
		Request request;
		String  responseBody = null;

		try {	
			String bookingUuid = UUID.randomUUID().toString();
			File f = new File(templateTradeBookingXmlPath);
			String xmlInstance = FileUtils.readFileToString(f);
			File f1 = new File(templateTradeBookingPrefixXmlPath);
			String xmlInstancePrefix = FileUtils.readFileToString(f1);
			Pattern personPattern = Pattern.compile("<in2>.*?</in2>", Pattern.DOTALL);
			Matcher personMatcher = personPattern.matcher(xmlInstance);
			StringBuffer xmlBuffer = new StringBuffer();

			while(personMatcher.find()) {
				bookXml = personMatcher.group();

				Pattern idPattern = Pattern.compile("<bookingId>(.*)</bookingId>");
				Matcher idMatcher = idPattern.matcher(bookXml);
				idMatcher.find();
				String id = idMatcher.group(1);

				bookXml = bookXml.replaceFirst("<bookingId>.*</bookingId>",
						"<bookingId>" + bookingUuid + "</bookingId>");

				bookXml = bookXml.replaceFirst("<insType>.*</insType>",
						"<insType>" + instrument + "</insType>");

				if (TradeEntryType.contains("Amend"))

				{
					bookXml = bookXml.replaceFirst("<" + AmendField +">.*</" + AmendField + ">",					
							"<" + AmendField + ">" + AmendValue + "</" + AmendField + ">");

					if (AmendField.equals("counterparty"))
					{
						bookXml = bookXml.replaceFirst("<salesCounterpartyId>.*</salesCounterpartyId>",
								"<salesCounterpartyId>" + AmendValue + "</salesCounterpartyId>");
					}
				}

				bookXml =  xmlInstancePrefix + strSSOVal + "</ssoToken></in0><in1>GDSLDN</in1>" + bookXml + "<in3>true</in3></bookTrade></soap:Body></soap:Envelope>";
				System.out.println(bookXml);

			}

			String content = bookXml;
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("text/xml");

			RequestBody body = RequestBody.create(mediaType, content);
			request = new Request.Builder()
					.url(siteCode)
					.post(body)
					.addHeader("content-type", "text/xml")
					.addHeader("Accept", "text/xml")
					//.addHeader("authorization", strSSOVal)
					.build();

			try{
				response = client.newCall(request).execute();

				System.out.println(response.code());				
				intResponseCode = response.code();			

				if (intResponseCode==200 || intResponseCode==400){
					status = "PASS";
					responseBody = response.body().string();					
				}
				else
				{
					status = "FAIL";
					responseBody = response.body().string();					
				}

				AssertJUnit.assertEquals("PASS",status);
				String []refrence = responseBody.split("ns1:reference");
				TradeRefID = refrence[1].replace("</", "").replace(">", "");
				System.out.println("TradeRefID: " + TradeRefID);

				String []contractId1 = responseBody.split("ns1:contractId");
				contractId = contractId1[1].replace("</", "").replace(">", "");
				System.out.println("contractId: " +contractId);

				String []insNum1 = responseBody.split("ns1:insNum");
				insNum = insNum1[1].replace("</", "").replace(">", "");
				System.out.println("insNum: "+ insNum);

			}
			catch (ClientProtocolException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e)
		{	e.printStackTrace();
		}catch (Exception e) 
		{	e.printStackTrace();
		}


		return responseBody;

	}*/

}
