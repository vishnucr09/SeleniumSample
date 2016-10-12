package com.sears.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	@DataProvider(name="empDetails")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData("D:/sampledoc.xls","Sheet1", 2);
		return arrayObject;
	}
	
	public String[][] getExcelData(String FilePath,String SheetName, int instances){
		String[][] userData = null;
		try {
			FileInputStream file = new FileInputStream(new File("D:\\BookOne.xls"));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheet(SheetName);
			userData = new String[instances][2];
			for(int i=0;i<instances;i++){
				Row row = sheet.getRow(i);
				userData[i][0] = row.getCell(0).toString();
				userData[i][1] = row.getCell(1).toString();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userData;
	}
}
