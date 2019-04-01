package com.web.testing.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.web.testing.SatTesting.ReporUtils;

public class BaseCase {

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		ReporUtils.initializeReport();
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		ReporUtils.flushReport();
	}
	
}
