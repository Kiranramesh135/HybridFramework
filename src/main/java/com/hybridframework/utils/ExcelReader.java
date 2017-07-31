package com.hybridframework.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public static void main(String[] args) {
		readData("Sheet1");
	}

	public static Object[][] readData(String sheetName) {
		Object[][] data = null;
		FileInputStream ExcelFile;
		try {
			String excelPath = System.getProperty("user.dir") + Utilities.getPropertyValue("testData"); 
			ExcelFile = new FileInputStream(new File(excelPath));
			System.out.println(excelPath);
			Workbook workbook = WorkbookFactory.create(ExcelFile);
			Sheet sheet = workbook.getSheet(sheetName);
			System.out.println(sheet);
			Cell cell = null;
			int rowLength = sheet.getLastRowNum();
			int columnLength = sheet.getRow(0).getLastCellNum();
			System.out.println("Row length : " + rowLength);
			System.out.println("Column length : " + columnLength);
			data = new Object[rowLength][columnLength];
			// First row will be header row, test data will be present from 2nd
			// row
			for (int i = 1; i <= rowLength; i++) {
				System.out.println();
				for (int j = 0; j < columnLength; j++) {
					System.out.print(sheet.getRow(i).getCell(j));
					System.out.print(",");
					cell = sheet.getRow(i).getCell(j);
					data[i - 1][j] = "" + cell;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return data;
	}
}
