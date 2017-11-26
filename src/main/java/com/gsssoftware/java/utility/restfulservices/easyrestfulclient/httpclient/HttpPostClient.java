package com.gsssoftware.java.utility.restfulservices.easyrestfulclient.httpclient;

import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.common.Constant;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.model.Request;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.parser.Parser;

public class HttpPostClient extends HttpClient{

	@Override
	public Object execute(Request request) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost  httpPost = new HttpPost (request.getResource_uri());
		Map<String,String>header=request.getHeaders();
		for(String key:header.keySet()){
			httpPost.addHeader(key, header.get(key));
		}
		if(request.getBody()!=null){
			Parser requestParser=getParser(request.getHeaders().get(Constant.CONTENT_TYPE));
			String requestBody = requestParser.serialize(request.getBody());
	        HttpEntity entity = new ByteArrayEntity(requestBody.getBytes("UTF-8"));
	        httpPost.setEntity(entity);
			
		}
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        Parser responseParser=getParser(request.getHeaders().get(Constant.ACCEPT));        
		return responseParser.deserialize(getResponseBody(httpResponse), request.getResponseClass());
	}
}
