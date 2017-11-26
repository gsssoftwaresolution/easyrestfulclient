package com.gsssoftware.java.utility.restfulservices.easyrestfulclient.tasks;

import java.util.concurrent.Callable;

import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.factory.HttpClientFactory;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.httpclient.HttpClient;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.model.Request;

public class RequestTask implements Callable<Object>{
	
	Request request;
		
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Object call() throws Exception {
		HttpClient httpClient=HttpClientFactory.getHttpClient(request.getHttpMethod());		
		return httpClient.execute(request);
	}

}
