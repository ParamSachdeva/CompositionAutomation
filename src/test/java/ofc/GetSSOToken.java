package ofc;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import ofc.AESCrypt;
import ofc.PropertyReader;

public class GetSSOToken {

	//===================================SSO TOKEN Function For RT Composition Services==================================================
	public static String funGetSSOTokenRT(String SSO) throws IOException
	{
		String SSORequest = new PropertyReader().readProperty(SSO);
		File sso = new File(SSORequest);
		String ssoContent = FileUtils.readFileToString(sso);
		Response response;
		Request request;		
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("text/xml");


		RequestBody body = RequestBody.create(mediaType, ssoContent);
		request = new Request.Builder()
				.url("https://uatwebservices.fm.rbsgrp.net/SecurityServices/v3/AuthenticationService.asmx")
				.post(body)
				.addHeader("content-type", "text/xml")
				.build();

		String strSSOVal = null;

		try{
			response = client.newCall(request).execute();

			//System.out.println(response.code());
			int intResponseCode = response.code();

			if (intResponseCode==200 || intResponseCode==400){

				strSSOVal = response.body().string();
				if (strSSOVal.contains("\""));
				{
					strSSOVal = strSSOVal.replace("\"", "");
					String strSSOVal1[] = strSSOVal.split("AuthenticateUserResult");
					strSSOVal = strSSOVal1[1].replace("</", "").replace(">", "");					
				}

				//System.out.println(strSSOVal);
			}
			else
			{
				strSSOVal = response.body().string();
				if (strSSOVal.contains("\""));				{
					strSSOVal = strSSOVal.replace("\"", "");
					String strSSOVal1[] = strSSOVal.split("AuthenticateUserResult");
					strSSOVal = strSSOVal1[1].replace("</", "").replace(">", "");						
				}
				//System.out.println(strSSOVal);
			}

		}
		catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return strSSOVal;
	}


}
