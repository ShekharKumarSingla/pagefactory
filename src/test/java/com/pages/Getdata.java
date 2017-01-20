package com.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Getdata {

	public static FileInputStream file;
	public static Properties prop;
	
	public static String geturl(String property) throws IOException
	{
		prop = new Properties();
		file = new FileInputStream(System.getProperty("user.dir")+"/src/main/Generic.xml");
		prop.load(file);
		
		return prop.getProperty(property);
	}
	
}
