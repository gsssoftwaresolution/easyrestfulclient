package com.gsssoftware.java.utility.restfulservices.easyrestfulclient.factory;

import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.common.Constant;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.httpclient.HttpClient;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.httpclient.HttpGetClient;
import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.httpclient.HttpPostClient;

public class HttpClientFactory {
	
	private static HttpGetClient httpGetClient=new HttpGetClient();
	private static HttpPostClient httppostClient=new HttpPostClient();
	
	public static HttpClient getHttpClient(String type){
		switch(type){
			case Constant.GET_METHOD:return httpGetClient;
			case Constant.POST_METHOD:return httppostClient;
			default: return httpGetClient;
		}
	}

}
