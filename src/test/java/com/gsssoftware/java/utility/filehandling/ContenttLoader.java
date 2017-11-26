package com.gsssoftware.java.utility.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;
import org.apache.commons.io.IOUtils;


public class ContenttLoader {
	
	public static String readFile(String fileName) throws IOException{
		String fileContent = "";
		ClassLoader classLoader = new ContenttLoader().getClass().getClassLoader();
        fileContent = IOUtils.toString(classLoader.getResourceAsStream(fileName));
		return fileContent;
	}

}
