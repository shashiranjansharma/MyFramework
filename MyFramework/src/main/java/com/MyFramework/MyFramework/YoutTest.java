package com.MyFramework.MyFramework;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class YoutTest {
	private WebDriver driver;
	@BeforeSuite(alwaysRun = true)
	public WebDriver setupDriver(){
		/*Write your code here to initiate your driver*/
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	@AfterSuite(alwaysRun = true)
	public void closeDriver(){
		/*
		 * Write you code here to close or quit from your driver
		 */
		driver.quit();
	}

	@Test(dataProvider="launchData", dataProviderClass = MyDataProvider.class, groups = {"sanity"})
	public void launch(String searchTearm){
		driver.get("https://google.com");
		MyDriver myDriver = new MyDriver(driver);
		myDriver.openNewTab();
		driver.get("https://amazon.in");
		myDriver.scrollToBottom();
		myDriver.switchToTab(1);
		driver.findElement(By.id("lst-ib")).sendKeys(searchTearm);
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		List<WebElement> searches = driver.findElements(By.className("rc"));
		List<WebElement> links = driver.findElements(By.className("r"));
		for(WebElement we: searches )
		{
			String Url = we.getText();
			if(Url.contains("https://www.mobiloud.com/blog/native-web-or-hybrid-apps/"))
			{
				System.out.println(Url);
				int p = searches.indexOf(we);
				myDriver.scrollToElement(we);
				links.get(p).click();
				break;
			}
			else
			{
				//System.out.println("Desired URL not found");
			}
		}
		Assert.assertEquals(driver.getTitle(), "Web, Hybrid Or Native Apps? What's The Difference?", "Failed");
	}

	@Test(groups = "sanity")
	public void openFulfilment() throws Exception{
		MyDriver myDriver = new MyDriver(driver);
		myDriver.switchToTab(2);
		driver.findElement(By.partialLinkText("Fulfilment by Amazon")).click();
		myDriver.mouseHoverOn(driver.findElement(By.linkText("Services")));
		myDriver.takeScreenshotAs("shashi");
	}

	@Test(dataProvider = "searchTerm", dataProviderClass = MyDataProvider.class, groups={"sanity", "regression"})
	public void searchOpen(String pss, String nameOfSc) throws Throwable{
		MyDriver myDriver = new MyDriver(driver);
		driver.get("https://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys(pss);
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		driver.findElement(By.className("r")).click();
		myDriver.takeScreenshotAs(nameOfSc);
		myDriver.openNewTab();
	}

}

