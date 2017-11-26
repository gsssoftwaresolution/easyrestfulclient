package com.gsssoftware.java.utility.restfulservices.easyrestfulclient.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.common.Constant;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.factory.ParserFactory;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.model.Request;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.parser.Parser;

public class HttpGetClient extends HttpClient{

	@Override
	public Object execute(Request request) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(request.getResource_uri());
		Map<String,String>header=request.getHeaders();
		for(String key:header.keySet()){
			httpGet.addHeader(key, header.get(key));
		}
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        Parser parser=getParser(request.getHeaders().get(Constant.ACCEPT));        
		return parser.deserialize(getResponseBody(httpResponse), request.getResponseClass());
	}
	
	

}
