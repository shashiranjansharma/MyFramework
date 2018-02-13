package com.myFramework.Tests;

import org.testng.annotations.Test;

import com.myFramework.DataProvider.TestDataFromExcel;

public class TestDataProviderFromExcel {

	
	@Test(dataProvider="searchTeam", dataProviderClass=TestDataFromExcel.class)
	public void test1(String How, String Are, String You){
		
		System.out.println(How + Are + You);
		
	}
	

}