package com.web.testing.SatTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtilities {
	
	public String getEnvParameter(String key) throws IOException {
		Properties prop = new Properties();
		InputStream input = null;

			input = new FileInputStream(System.getProperty("user.dir") + "/SatTesting/src/main/resources/"+System.getProperty("ENV")+"/config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and return it
			return prop.getProperty(key);
	}
	
	public <T> void print2DArray(T[][] array2D) {
		for (T[] x : array2D)
		{
		   for (T y : x)
		   {
		        System.out.print(y + " ");
		   }
		   System.out.println();
		}
	}
}
