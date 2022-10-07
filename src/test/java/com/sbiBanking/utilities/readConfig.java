package com.sbiBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readConfig {

	Properties obj;
	
	public readConfig() {
		
		File src = new File("./Configuration/config.properties");
		try {
				FileInputStream fis = new FileInputStream(src);
				obj = new Properties();
				obj.load(fis);
		} catch (IOException e) {
			System.out.println("Exception is: "+e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String url = obj.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername() {
		String userid = obj.getProperty("userid");
		return userid;
	}
	
	public String getUserPassword() {
		String password = obj.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chroPath = obj.getProperty("chromeDriverPath");
		return chroPath;
	}
	
	public String getFirefoxPath() {
		String ffoxPath = obj.getProperty("fireFoxDriverPath");
		return ffoxPath;
	}
	
	public String getIEPath() {
		String IEPath = obj.getProperty("IEDriverPath");
		return IEPath;
	}
	
}
