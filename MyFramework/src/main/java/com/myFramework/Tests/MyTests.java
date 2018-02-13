package com.myFramework.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.myFramework.CommonUtil.MyDriver;
import com.myFramework.DataProvider.MyDataProvider;

public class MyTests{
	WebDriver driver;
	MyDriver myDriver = new MyDriver(driver);
	
	//Calling the setupDriver method from MyDriver class to launch browser
	@BeforeSuite(alwaysRun = true)
	public WebDriver setupDriver() throws IOException{
		driver = myDriver.setupDriver();
		return driver;
	}
	
	//Write you code here to close or quit from your driver
	@AfterSuite(alwaysRun = true)
	public void closeDriver(){
		driver.quit();
	}
	
	
	//In this test we will get data from data provider and Web elements from different page objects
	@Test(dataProvider = "searchTerm", dataProviderClass = MyDataProvider.class, groups={"sanity", "regression"})
	public void searchInGoogle(String pss, String nameOfSc) throws Throwable{
		GooglePageObjects gpo = new GooglePageObjects(driver);
		driver.get("https://google.com");
		gpo.searchbox.sendKeys(pss);
		gpo.searchbox.sendKeys(Keys.ENTER);
		gpo.firstResult.click();
		myDriver.takeScreenshotAs(nameOfSc);
		myDriver.openNewTab();
	}
	
	
}
	
