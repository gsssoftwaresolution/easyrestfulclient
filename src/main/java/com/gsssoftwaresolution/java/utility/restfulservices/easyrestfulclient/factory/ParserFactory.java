package com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.factory;

import java.util.Map;

import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.common.Constant;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.parser.JsonParser;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.parser.Parser;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.parser.XmlParser;

public class ParserFactory {
	
	private static JsonParser jsonParser=new JsonParser();
	private static XmlParser xmlParser=new XmlParser();
	
	public static Parser getParser(String type){
		switch(type){
			case Constant.MEDIATYPE_JSON:return jsonParser;
			case Constant.MEDIATYPE_XML:return xmlParser;
		    default: return jsonParser;
		}
	}

}
