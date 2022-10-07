package com.sbiBanking.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.sbiBanking.pageObjects.LoginPage;

public class TC_CheckLoginTest_01 extends BaseClass {

	public static Logger logger;
	
	@Test
	public void CheckloginTest() {
		
		
		logger = LogManager.getLogger(TC_CheckLoginTest_01.class);
		PropertyConfigurator.configure("log4j2.properties");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userid);
		logger.info("User id is entered...");
		lp.setPassword(password);
		logger.info("Password is entered...");
		
		lp.clickSubmit();
		logger.info("Login button is clicked...");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Assert statement is true...");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Assert statement is false...");
		}
	}
	
}
