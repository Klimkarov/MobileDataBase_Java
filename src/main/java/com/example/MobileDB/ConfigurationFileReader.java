package com.example.MobileDB;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationFileReader {

	private Properties configFile;

	public ConfigurationFileReader() {

		configFile = new Properties();

		try {

			configFile.load(new FileInputStream(new File("config/config.properties")));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public String getProperty(String key) {

		return this.configFile.getProperty(key);
	}

}
