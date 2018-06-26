package RestAssured;

import org.junit.BeforeClass;

public class FunctionalTest {

	private static Integer port;
	private static String basePath;
	private static String baseURI;

	@BeforeClass

	public static void setup() {
		String port = System.getProperty("server.port");
		if (port == null) {
			FunctionalTest.port = Integer.valueOf(8080);
		}
		else{
			FunctionalTest.port = Integer.valueOf(port);
		}


		String basePath = System.getProperty("server.base");
		if(basePath==null){
			basePath = "/rest-garage-sample/";
		}
		FunctionalTest.basePath = basePath;

		String baseHost = System.getProperty("server.host");
		if(baseHost==null){
			baseHost = "http://localhost";
		}
		FunctionalTest.baseURI = baseHost;

	}

}