package com.pom.classes;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerothaPinPage {

	@FindBy (xpath="//input[@id='pin']")
	private WebElement pin;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement continuebutton;

	
	WebDriver driver;
	public ZerothaPinPage (WebDriver driver)   
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}

	public void sendpin(String enterpin)
	{
		pin.sendKeys(enterpin);
	}

	public void clicktoncontinuebutton()
	{
		continuebutton.click();
	}
	
	public void captureScreenshot1(String screenshotName) throws IOException
	{
		 Date currentdate = new Date();
        System.out.println(currentdate);
		 String Screenshotfilename = currentdate.toString().replace(" ", " ").replace(":", " -");
		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	 File dest = new File ("D:\\Shree Swami Samarth\\Screenshots"+Screenshotfilename+".jpeg");
   	 FileHandler.copy(source, dest);
	}
	
	

}
