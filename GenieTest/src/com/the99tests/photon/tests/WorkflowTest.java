/*
 * Copyright (c) 2017, Preenos Crowd Technologies Private Limited
 * 
 * Please read instructions below for writing your tests
 */

package com.the99tests.photon.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchShortcuts;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.the99tests.photon.PhotonSession;
import com.the99tests.photon.platforms.UnsupportedConfigException;

public class WorkflowTest {
	/*
	 * Test setup
	 */
	
	static RemoteWebDriver driver=null;

	@BeforeSuite
	public void init() throws IOException, TimeoutException, UnsupportedConfigException, InterruptedException {
		if(PhotonSession.isLocal()) {
			 
			
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			 
			 
			 
			// Optional
			 
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			 
			 
			// Specify the device name (any name)
			 
			capabilities.setCapability("deviceName", "My New Phone");
			 
			 
			// Platform version
			 
			capabilities.setCapability("platformVersion", "5.1.0");
			 
			 
			// platform name
			 
			capabilities.setCapability("platformName", "Android");
			 
			 
			// specify the application package that we copied from appium                
			 
			capabilities.setCapability("appPackage", "org.ekstep.genieservices");
			 
			 
			// specify the application activity that we copied from appium                   
			 
			capabilities.setCapability("appActivity", "org.ekstep.genie.ui.splash.SplashActivity");
			 
			
			// Start android driver I used 4727 port by default it will be 4723
			 
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			
			capabilities.setCapability("noReset", true);
			
			capabilities.setCapability("fullReset","false");
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			((AndroidDriver) driver).resetApp();
			((AndroidDriver) driver).closeApp();
			
			
			//((AppiumDriver) driver).removeApp("org.ekstep.genieservices");
			
			
			
			
		    PhotonSession.setupLocalSession(driver);
			
		} else {
			PhotonSession.setupPhotonSession();
			driver=PhotonSession.getNativeDriver();
		}	
	}
	
	@AfterSuite
	public void close() 
	{
		PhotonSession.closeSession();
		driver.quit();
	} 
	
	
	/*
	@Test(priority=0)
	public void InstallApp()
	{
		//Actually i am resetting app if already installed
		((AppiumDriver) driver).installApp("E:\\Softwares\\Garbage\\org.ekstep.genieservices.apk");
		
	}
	*/

	
	@Test(priority=1)
	public void Add_Child_Step_1_Valid_Input() 
	{
		
		   ((AppiumDriver) driver).launchApp();
		    WebDriverWait wait = new WebDriverWait(driver, 10);
		    driver.findElementByXPath("//android.widget.ImageView[@index='0']").click();
			driver.findElementByXPath("//android.widget.ImageView[@index='2']").click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("org.ekstep.genieservices:id/add_child_or_avatar_image")));
			driver.findElementById("org.ekstep.genieservices:id/add_child_or_avatar_image").click();
			PhotonSession.checkpoint("56_55_5455_25851_checkpoint_1");
			driver.findElementById("org.ekstep.genieservices:id/img_next").click();
			driver.findElementById("org.ekstep.genieservices:id/img_skip").click();
			driver.findElementById("org.ekstep.genieservices:id/edt_nickname").sendKeys("Shashi");
			PhotonSession.checkpoint("56_55_5455_25852_checkpoint_2");
			driver.findElementById("org.ekstep.genieservices:id/img_next").click();
			PhotonSession.checkpoint("56_55_5455_25853_checkpoint_3");
			((AndroidDriver) driver).closeApp();
			
	}
	
	@Test(priority=2)
	public void Add_Child_Step_2() throws Exception
	{
		((AppiumDriver) driver).launchApp();
		
		driver.findElementById("org.ekstep.genieservices:id/cover_image").click();
		driver.findElementById("org.ekstep.genieservices:id/language_ok_btn").click();
		driver.findElementById("org.ekstep.genieservices:id/dummy_add_child_or_avatar_image").click();	
		PhotonSession.checkpoint("56_55_5457_25857_checkpoint_1");
		driver.findElementById("org.ekstep.genieservices:id/img_next").click();
		driver.findElementById("org.ekstep.genieservices:id/img_skip").click();		
		driver.findElementById("org.ekstep.genieservices:id/edt_nickname").sendKeys("Shashi");
		driver.findElementById("org.ekstep.genieservices:id/img_next").click();
		PhotonSession.checkpoint("56_55_5457_25858_checkpoint_2");
		driver.findElementById("org.ekstep.genieservices:id/gender_boy_btn").click();
		driver.findElementByXPath("//android.widget.ImageView[@package='org.ekstep.genieservices']").click();
		PhotonSession.checkpoint("56_55_5457_25859_checkpoint_3");
		driver.findElementById("org.ekstep.genieservices:id/img_next").click();
		driver.findElementById("org.ekstep.genieservices:id/img_next").click();		
		PhotonSession.checkpoint("56_55_5457_25860_checkpoint_4");
		driver.findElementById("org.ekstep.genieservices:id/layout_age").click();
		driver.findElementByXPath("//android.widget.TextView[@text='7 Years']").click();
		driver.findElementById("org.ekstep.genieservices:id/class_3_btn").click();
		driver.findElementById("org.ekstep.genieservices:id/img_next").click();
		PhotonSession.checkpoint("56_55_5457_25861_checkpoint_5");
				
	}
	
	@Test(priority=3)
	public void Add_Child_Step_3()
	{
		PhotonSession.checkpoint("56_55_5458_25862_checkpoint_1");
		driver.findElement(By.id("org.ekstep.genieservices:id/txt_medium")).click();
		PhotonSession.checkpoint("56_55_5458_25863_checkpoint_2");
		driver.findElementById("org.ekstep.genieservices:id/item").click();
		driver.findElementById("org.ekstep.genieservices:id/img_next").click();
		PhotonSession.checkpoint("56_55_5458_25864_checkpoint_3");
		driver.findElementById("org.ekstep.genieservices:id/txt_board").click();
		driver.findElementById("org.ekstep.genieservices:id/item").click();
		driver.findElementById("org.ekstep.genieservices:id/img_next").click();
		PhotonSession.checkpoint("56_55_5458_25865_checkpoint_4");
	}
	@Test(priority=4)
	public void Add_Child_Step_4() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		PhotonSession.checkpoint("56_55_5459_25866_checkpoint_1");
		PhotonSession.checkpoint("56_55_5459_25867_checkpoint_2");
		driver.findElementById("org.ekstep.genieservices:id/img_skip").click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("org.ekstep.genieservices:id/img_next")));
		PhotonSession.checkpoint("56_55_5459_25868_checkpoint_3");
		driver.findElementById("org.ekstep.genieservices:id/img_next").click();
		//swipeVertical
		WebElement Avtar = driver.findElement(By.className("android.widget.Gallery"));
		int wide  = Avtar.getSize().width;
		int hgt = Avtar.getSize().height;
		
		int startx = (int) (wide * (0.8));
		int endx = (int)(wide *(0.2));
		int starty =  hgt /2 ;
	    int endy = hgt/2;
	    
	    //To move from Fav to all contacts, we need to swipe from right to left
	    ((AndroidDriver) driver).swipe(startx, starty, endx, endy, 1000);
        PhotonSession.checkpoint("56_55_5459_25869_checkpoint_4");
        
		driver.findElementById("org.ekstep.genieservices:id/cover_image").click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("org.ekstep.genieservices:id/layout_skip")));
		PhotonSession.checkpoint("56_55_5459_25870_checkpoint_5");
		
		
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
	}
		
	@SuppressWarnings("unchecked")
	@Test(priority=5)
	public void My_Lesson_To_Home() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		try 
		{
			((AppiumDriver) driver).runAppInBackground(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		driver.findElementById("org.ekstep.genieservices:id/layout_skip").click();
		PhotonSession.checkpoint("56_56_5476_25914_checkpoint_1");
		driver.findElementById("org.ekstep.genieservices:id/img_content").click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByClassName("android.webkit.WebView")));
		PhotonSession.checkpoint("56_56_5476_25915_checkpoint_2");
		driver.navigate().back();		
		PhotonSession.checkpoint("56_56_5476_25916_checkpoint_3");
		
		
	}
		
	
}

/* 
 * TODO: Submit your tests
 */
