package com.web.testing.SatTesting;

import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SWSprint1 {
	
	DataBaseUtils connect;
	ExcelUtils readExcel = new ExcelUtils();
	String fileName = "Sprint1Data";
	String sheetName = null;
	

	//@Test
	public void learnDatabase() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			System.out.println("Try to connect Database");
			connect = new DataBaseUtils("jdbc:mysql://localhost:3306/dbacp", "root", "");
			connect.doConnectToDatabase();
			connect.executeReadQuery("SELECT * FROM f_yash_tst_jdb");
			System.out.println("Database connected");
	}
	
	@Test(dataProvider = "readExcelTest")
	public void learnExcelRead(String p1, String p2, String p3, String p4, String p5) {
		System.out.println("data");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
	}
	
	@DataProvider(name = "readExcelTest")
    public Object[][] dataProviderMethod() {
		sheetName = "learnExcelReadTest";
		return null;
    }
}
