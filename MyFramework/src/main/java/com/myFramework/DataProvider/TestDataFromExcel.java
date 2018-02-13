package com.myFramework.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.myFramework.CommonUtil.ExcelReader;

public class TestDataFromExcel {
	
	static ExcelReader excelReader;
	
	@DataProvider(name="searchTeam")
	public static Iterator<Object[]> mySearchTerm(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			excelReader = new ExcelReader("test-input/MySheet.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int row=2; row <= excelReader.getRowCount("sheet1"); row++){
			String How = excelReader.getCellData("sheet1", 1, row);
			String Are = excelReader.getCellData("sheet1", 2, row);
			String You = excelReader.getCellData("sheet1", 2, row);
			
			Object obj[] = { How, Are, You };
			myData.add(obj);
			
		}
		
		return myData.iterator();
		
	}
   
}
