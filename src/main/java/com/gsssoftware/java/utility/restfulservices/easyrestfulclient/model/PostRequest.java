package com.gsssoftware.java.utility.restfulservices.easyrestfulclient.model;

import java.util.Map;

import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.common.Constant;

public class PostRequest extends Request {
	public PostRequest(String resourceUrl,Map<String,String>headers,Object requestBody,Class responseClass){
		super( resourceUrl,Constant.POST_METHOD,headers,requestBody,responseClass);	    			
	}

}
