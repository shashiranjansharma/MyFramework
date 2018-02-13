package com.myFramework.DataProvider;

import org.testng.annotations.DataProvider;

public class MyDataProvider {
	
	@DataProvider(name="dummydata")
	public static Object[][] example(){
	 Object[][] myData = new Object[3][2];
	 myData[0][0] = "";
	 myData[0][1] = "";
	 
	 myData[1][0] = "";
	 myData[1][1] = "";
	 
	 myData[2][0] = "";
	 myData[2][1] = "";
	 
	 return myData;	
	}
	
	//Creating data provider for searchInGoogle test.
	@DataProvider(name="searchTerm")
	public static Object[][] mySearchterm(){
		Object[][] myData = new Object[3][2];
		myData[0][0] = "how to prepare food?";
		myData[0][1] = "search1";
		
		myData[1][0] = "How to comb your hair?";
		myData[1][1] = "search2";
		
		myData[2][0] = "How to take bath?";
		myData[2][1] = "search3";
		
		return myData;
	}
}

/*
 * @Test(dataProvider = "create", dataProviderClass = MyDataProvider.class)
 */
