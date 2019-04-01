package com.web.testing.SatTesting;

import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ReporUtils {

	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest logger;

	public static void initializeReport() {
		extentHtmlReporter = new ExtentHtmlReporter("./report/testReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}
	public static void testCreate(String testName) {
		System.out.println(testName);
		 logger = extentReports.createTest(testName);
	}
	
	public static void logMessage(String info) {
		logger.log(Status.INFO, info);
	}
	
	public static void logTestAsPass() {
		logger.log(Status.PASS, "Test Passed");
	}

	public static void logTestAsFail() {
		logger.log(Status.FAIL, "Test Failed");
	}
	
	public static void logTestAsSkip() {
		logger.log(Status.SKIP, "Test Skipped");
	}
	
	public static void logError(String errorMessage) {
		logger.log(Status.ERROR, errorMessage);
	}
	
	public static void logScreenShot(String screenShotPath) throws IOException {
		//logger.log(Status.INFO, (Markup) logger.addScreenCaptureFromPath(screenShotPath));
		logger.addScreenCaptureFromPath(screenShotPath);
	}
	
	public static void flushReport() {
		extentReports.flush();
	}
	
	public static void setTestResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
		      logTestAsFail();
		   }
		if (result.getStatus() == ITestResult.SUCCESS) {
		      logTestAsPass();
		   }
		if (result.getStatus() == ITestResult.SKIP) {
		      logTestAsSkip();
		   } 
		
	}
}
