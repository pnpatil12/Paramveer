package com.test.classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pom.classes.Logoutpage;
import com.pom.classes.Watchlist;
import com.pom.classes.ZerothaLoginPage;
import com.pom.classes.ZerothaPinPage;

public class Watchlistadd {

	private WebDriver driver;
private ZerothaLoginPage zerothaloginpage;
private ZerothaPinPage zerothapinpage;
private Watchlist watchlist;
private Logoutpage logoutpage;
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
	zerothaloginpage = new ZerothaLoginPage(driver);
	zerothaloginpage.senduserid("BE4068");
	zerothaloginpage.sendpassword("Reset@123");
	zerothaloginpage.verifyLoginText();
	Assert.assertTrue(zerothaloginpage.verifyLoginText());
	zerothaloginpage.verifyloginbutton();
	zerothapinpage = new ZerothaPinPage(driver);
	Thread.sleep(5000);
	zerothapinpage.sendpin("117177");
	zerothapinpage.clicktoncontinuebutton();
	driver.manage().window().maximize();
}

@Test
    public void VerifyShareAddInWatchlist() throws InterruptedException
{
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    watchlist = new Watchlist(driver);
    watchlist.sendsharename("SBIN");
    watchlist.sendsharename("ICICIBANK");
    watchlist.sendsharename("AXISBANK");
    logoutpage= new Logoutpage(driver);
    Thread.sleep(5000);
    logoutpage.Clicktologout();
}
//   @AfterClass
//   public void browserclose() throws InterruptedException
//   {
//     driver.close();
//   }

}