package com.web.testing.testcases;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.testing.SatTesting.ReporUtils;

public class SWSprint2 {
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		Test test = method.getAnnotation(Test.class);
		System.out.println(test.description());
		ReporUtils.testCreate(test.description());
	}
	
	@Test(groups = { "smoke", "functional" }, description="Checking Login Function Test")
	public void chekinLogin() {
		ReporUtils.logMessage("I am SWSprint2");
		ReporUtils.logMessage("finish test");
	}
	
	@Test(groups = {"functional" }, description="Checking Login Function Test")
	public void chekinList() {
		ReporUtils.logMessage("I am SWSprint2");
		ReporUtils.logMessage("finish test");
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		ReporUtils.setTestResult(result);
		
	}
}
