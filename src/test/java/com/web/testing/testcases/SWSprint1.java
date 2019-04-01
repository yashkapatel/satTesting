package com.web.testing.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.web.testing.SatTesting.DataBaseUtils;
import com.web.testing.SatTesting.ExcelUtils;
import com.web.testing.SatTesting.ReporUtils;

public class SWSprint1 {
	
	DataBaseUtils connect;
	ExcelUtils readExcel = new ExcelUtils();
	String filePath = "learnExcelReadTest";
	String sheetName = null;
	

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		Test test = method.getAnnotation(Test.class);
		ReporUtils.testCreate(test.description());
	}
	
	@Test(groups = { "smoke", "functional" }, description="Read Database Test")
	public void learnDatabase() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			System.out.println("Try to connect Database");
			connect = new DataBaseUtils("jdbc:mysql://localhost:3306/dbacp", "root", "");
			connect.doConnectToDatabase();
			String[][] queryData = connect.executeReadQuery("SELECT * FROM yash_grade_table");
			ReporUtils.logMessage("data read complete");
			System.out.println("Database connected");
	}
	
	@Test(dataProvider = "readExcelTest", groups = { "smoke", "functional" }, description="Read Excel Test")
	public void learnExcelRead(String p1, String p2, String p3, String p4, String p5) {
		ReporUtils.logMessage("data");
		ReporUtils.logMessage(p1);
		ReporUtils.logMessage(p2);
		ReporUtils.logMessage(p3);
		ReporUtils.logMessage(p4);
		ReporUtils.logMessage(p5);
	}
	
	
	@DataProvider(name = "readExcelTest")
    public Object[][] dataProviderMethod() throws IOException {
		sheetName = "TestData";
		return readExcel.readData(filePath, sheetName);
    }
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		ReporUtils.setTestResult(result);
		
	}
}
