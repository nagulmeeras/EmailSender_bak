package com.pramati.emailsender.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

<<<<<<< HEAD
import org.springframework.cglib.core.GeneratorStrategy;

=======
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
public class PropertiesUtil {
	private static Properties properties;
	public PropertiesUtil() throws IOException{
		loadPropertyFile();
	}
	public static void loadPropertyFile() throws IOException{
<<<<<<< HEAD
		String fileName = "dl.properties";
		
		File file = new File(fileName);
		
=======
		String fileName = "src/main/resources/dl.properties";
		
		File file = new File(fileName);
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
			fis.close();
<<<<<<< HEAD
		}else{
			System.out.println("propertie not found");
=======
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		}
	}
	public static String getPropertyValue(String key){
		String value = properties.getProperty(key);
		return value;
	}
}
