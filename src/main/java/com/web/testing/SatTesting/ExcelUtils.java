package com.web.testing.SatTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private XSSFWorkbook excelWBook;
	private XSSFSheet excelWSheet;
	private XSSFCell cell;
	private XSSFRow row;
	public int numOfRow;
	public int numOfColumn;

	public Object[][] readData(String fileName, String sheetName) throws IOException {

		FileInputStream excelFile = new FileInputStream(new File("./src/main/resources/" + fileName + ".xlsx"));
		excelWBook = new XSSFWorkbook(excelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
        
        numOfRow = excelWSheet.getLastRowNum();
        numOfColumn = excelWSheet.getRow(0).getLastCellNum();
        
        System.out.println("Row: " + numOfRow);
        System.out.println("Column: " + numOfColumn);
        
        Object[][] testData = new Object[numOfRow][numOfColumn];
        
        for (int i=1; i<=numOfRow; i++) {
            row = excelWSheet.getRow(i);
            for (int j=0; j<numOfColumn; j++) {
                cell = row.getCell(j);
                String value = String.valueOf(cell);
                testData[i-1][j] = value;
            }   
        }
        System.out.println("Data read finish");
		return testData;
	}

}
