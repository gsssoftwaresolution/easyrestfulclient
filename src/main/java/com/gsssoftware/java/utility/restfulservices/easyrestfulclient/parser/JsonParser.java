package com.gsssoftware.java.utility.restfulservices.easyrestfulclient.parser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser implements Parser{
	private ObjectMapper objectMapper=new ObjectMapper();

	public String serialize(Object object) throws JsonProcessingException {
		// TODO Auto-generated method stub
		return objectMapper.writeValueAsString(object);
	}

	public Object deserialize(String value,Class type) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		return objectMapper.readValue(value, type);
	}

}
