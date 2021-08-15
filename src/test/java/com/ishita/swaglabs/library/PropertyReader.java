package com.ishita.swaglabs.library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String configReader(String key) throws IOException {
		File f = new File("./ConfigReader/configReader.properties");
		FileReader fr = new FileReader(f);
		Properties prop = new Properties();
		prop.load(fr);
		return prop.get(key).toString();
	}	
}
