package com.gsssoftware.java.utility.restfulservices.easyrestfulclient.model;

import java.util.Map;

import com.gsssoftware.java.utility.restfulservices.easyrestfulclient.common.Constant;

public class GetRequest extends Request {
	
	public GetRequest(String resourceUrl,Map<String,String>headers,Class responseClass){
		super( resourceUrl,Constant.GET_METHOD,headers,null,responseClass);	    			
	}

}
