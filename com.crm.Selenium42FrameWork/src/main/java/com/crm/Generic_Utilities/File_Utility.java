package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility 
{
	public String getpropertyKeyValue1(String Key) throws Throwable
	{
		/*
		 * this method is used to launch the application
		 * @param key
		 * @return
		 * @throw Throwable
		 * @author Lohith
		 */
		FileInputStream fis=new FileInputStream("./Common_Data.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
				
	}
}
