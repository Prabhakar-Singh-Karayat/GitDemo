package com.sbiBanking.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.sbiBanking.pageObjects.LoginPage;

public class TC_AssertTitleTest_02 extends BaseClass {

	public static Logger logger;
	
	@Test
	public void AssertTitle() {
		
		logger = LogManager.getLogger(TC_AssertTitleTest_02.class);
		PropertyConfigurator.configure("log4j2.properties");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userid);
		logger.info("User id is entered...");
		lp.setPassword(password);
		logger.info("Password is entered...");
		
		lp.clickSubmit();
		logger.info("Login button is clicked...");
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Guru99 Bank Manager");
		/*
			if(driver.getTitle().equals("Guru99 Bank Manager")) {
				Assert.assertTrue(true);
				logger.info("Assert statement is true...");
			}
			else {
				Assert.assertTrue(false);
				logger.info("Assert statement is false...");
			}
		*/
	}
}
