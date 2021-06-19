package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Watchlist {

	@FindBy (xpath="//div[@class='search']//input")
	private WebElement inputshare;
	
	@FindBy (xpath="//span[@class='tradingsymbol']")
	private WebElement searchshareresult;
	
	WebDriver driver;
	public Watchlist (WebDriver driver)   
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	public void sendsharename(String sharename) throws InterruptedException
	{
		inputshare.sendKeys(sharename);
		Actions a = new Actions (driver);
		Thread.sleep(5000);
		a.moveToElement(searchshareresult).click().build().perform();
	}
	
}
