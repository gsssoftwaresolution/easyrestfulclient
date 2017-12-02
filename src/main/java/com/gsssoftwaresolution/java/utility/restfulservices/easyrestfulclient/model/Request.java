package com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.model;

import java.util.Map;

import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.common.Constant;

public abstract class Request {
	
	protected Map<String,String> headers;
	protected String resource_uri;
	protected int timeout;
	protected Object body;
	protected String httpMethod;
	protected Class responseClass;
	
	public Request(String resourceUrl,String httpMethod,Map<String,String>headers,Object requestBody,Class responseClass){
     this.resource_uri=resourceUrl;
     this.httpMethod=httpMethod;
     this.headers=headers;
     this.body=requestBody;
     this.responseClass=responseClass;
		
	}
	
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public String getResource_uri() {
		return resource_uri;
	}
	public void setResource_uri(String resource_uri) {
		this.resource_uri = resource_uri;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public Class getResponseClass() {
		return responseClass;
	}
	public void setResponseClass(Class responseClass) {
		this.responseClass = responseClass;
	}

}
