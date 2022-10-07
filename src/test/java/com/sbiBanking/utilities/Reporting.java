package com.sbiBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testcontext) {
		
		try {
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());	//will give the particular time stamp
			String repname = "test-Report-"+ timestamp+ ".html";	//adding time stamp along with HTMl format
			
			reporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/Test-Output/"+repname);
			reporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");

			extent = new ExtentReports();
			
			extent.attachReporter(reporter);
			extent.setSystemInfo("Host name", "localhost");   // additional information on the extent report
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User", "Prabhakar");
			
			reporter.config().setDocumentTitle("SBI Banking Test Project");
			reporter.config().setReportName("Functional Test Report");
			reporter.config().setTheme(Theme.STANDARD);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		logger = extent.createTest(tr.getName()).assignAuthor("Prabhakar").assignCategory("Regression").assignDevice("Chrome 97");
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr){
		
		logger = extent.createTest(tr.getName()).assignAuthor("Prabh").assignCategory("Smoke").assignDevice("FireFox 64");
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotpath = System.getProperty("user.dir"+"\\Screenshots\\"+tr.getName()+".png");
		File f = new File(screenshotpath);
		
		if(f.exists()) {
			logger.fail("Screenshot is below: "+ MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath));
		} 
		
	}
	
	public void onTestSkipped(ITestResult tr) {
		
		logger = extent.createTest(tr.getName()).assignAuthor("Mystery").assignCategory("Smoke").assignDevice("Chrome 97");
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	
	}
	
	public void onFinish(ITestContext testcontext) {
		
		extent.flush();
	}
	
/*	public static String captureSceenshot(WebDriver driver, String screenshotName) throws Exception {
	
		String dateformat = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String screenshotpath = System.getProperty("user.dir"+"\\Screenshots\\" + screenshotName + dateformat +".png");

		File destination = new File(screenshotpath);
		FileUtils.copyFile(src, destination);
		
		return screenshotpath;
	}*/
	
}






