package com.myFramework.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePageObjects {
	WebDriver driver;
	public GooglePageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "lst-ib") 
	WebElement searchbox;
	
	@FindBy(className = "r")
	WebElement firstResult;

	
}
