package com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.factory.ParserFactory;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.model.Request;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.parser.Parser;

public abstract class HttpClient  {
	public abstract Object execute(Request request) throws Exception; 
	
	protected Parser getParser(String type){
		return ParserFactory.getParser(type);
	}
	
	protected String getResponseBody(CloseableHttpResponse httpResponse) throws IllegalStateException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));
		String temp;
		StringBuffer responseBody = new StringBuffer();
		while ((temp = reader.readLine()) != null) {
			responseBody.append(temp);
		}
		reader.close();
		httpResponse.close();
		return responseBody.toString();
	}
}
