package com.web.testing.testcases;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.testing.SatTesting.ReporUtils;

public class SWSprint3 {

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		Test test = method.getAnnotation(Test.class);
		System.out.println(test.description());
		ReporUtils.testCreate(test.description());
	}
	
	@Test(groups = {"functional", "smoke"}, description="Checking Login Function Test")
	public void sprint3Test() {
		ReporUtils.logMessage("sprint3Test");
		ReporUtils.logMessage("sprint3Test");
	}
	
	@Test(groups = {"functional", "smoke"}, description="Checking Login Function Test")
	public void sprint3Test1() {
		ReporUtils.logMessage("sprint3Test");
		ReporUtils.logMessage("sprint3Test");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		ReporUtils.setTestResult(result);
		
	}
	
	
}
