package com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.parser;

public interface Parser {
	
	public String serialize(Object object) throws Exception;
	public Object deserialize(String object,Class type) throws Exception;

}
