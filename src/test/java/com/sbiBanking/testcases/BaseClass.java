package com.sbiBanking.testcases;

//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.sbiBanking.utilities.readConfig;

public class BaseClass {

	readConfig rc = new readConfig();
	
	public String baseUrl = rc.getApplicationUrl();
	public String userid = rc.getUsername();
	public String password = rc.getUserPassword();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver=new ChromeDriver();

		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			driver=new FirefoxDriver();

		}
		else if(br.equals("ie")){
			System.setProperty("webdriver.ie.driver", rc.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	
}

