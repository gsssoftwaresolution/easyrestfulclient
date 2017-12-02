package com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.parser;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlParser implements Parser {
	
	XmlMapper xmlMapper = new XmlMapper();

	@Override
	public String serialize(Object object) throws Exception {
		return xmlMapper.writeValueAsString(object);
	}

	@Override
	public Object deserialize(String xml, Class type) throws Exception {
		return xmlMapper.readValue(xml, type);
	}

}
