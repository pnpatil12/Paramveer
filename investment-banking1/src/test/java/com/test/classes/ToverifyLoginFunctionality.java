package com.test.classes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pom.classes.Logoutpage;
import com.pom.classes.UtilityClass;
import com.pom.classes.Watchlist;
import com.pom.classes.ZerothaDashboardPage;
import com.pom.classes.ZerothaLoginPage;
import com.pom.classes.ZerothaPinPage;



public class ToverifyLoginFunctionality {
	int testID;
	private WebDriver driver;
private ZerothaLoginPage zerothaloginpage;
private ZerothaPinPage zerothapinpage;
private ZerothaDashboardPage zerothadashboardpage;
private Watchlist watchlist;
private Logoutpage logoutpage;
Workbook a;
@BeforeSuite
public void openexcelsheet() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	a=com.pom.classes.UtilityClass.openWorkbook("D:\\Shree Swami Samarth\\admin.xlsx\\");

}
@BeforeTest
public void browserlaunch() throws InterruptedException
{
	System.out.println("Launch browser and enter Zerotha url");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swami\\Automation class\\chromedriver.exe");
    driver= new ChromeDriver();   
}
@BeforeClass
public void Lauchapllication() throws InterruptedException
{
    driver.get("https://kite.zerodha.com/");
}
@Test (priority=1)
	public void verifykitelogin() throws InterruptedException
	{
	testID=100;
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	zerothaloginpage = new ZerothaLoginPage(driver);
	zerothaloginpage.senduserid(com.pom.classes.UtilityClass.fetchdata(a, "Sheet2", 0, 0));
	zerothaloginpage.sendpassword(UtilityClass.fetchdata(a, "Sheet2", 0, 1));
	zerothaloginpage.verifyLoginText();
	Assert.assertTrue(zerothaloginpage.verifyLoginText());
	zerothaloginpage.verifyloginbutton();
	zerothapinpage = new ZerothaPinPage(driver);
	Thread.sleep(5000);
	zerothapinpage.sendpin("117177");
	zerothapinpage.clicktoncontinuebutton();
	driver.manage().window().maximize();
	String url = driver.getCurrentUrl();
	System.out.println(url);
	Assert.assertEquals(url, "https://kite.zerodha.com/dashboard");
  }
@AfterMethod
public void screenshot(ITestResult result) throws InterruptedException, IOException
{
	 if(ITestResult.FAILURE==result.getStatus())
	 {
		 UtilityClass.captureScreenshot1(driver, testID);
	 }
}

   @AfterClass
   public void browserclose() throws InterruptedException
   {
     driver.close();
   }
}
