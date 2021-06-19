package com.pom.classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {

	@FindBy (xpath="//span[text()='BE4068']")
	private WebElement uid;
	
	@FindBy (xpath="//span[@class='icon icon-exit']")
	private WebElement logoutbutton;
	
	WebDriver driver;
	public Logoutpage (WebDriver driver)   
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}

	public void Clicktologout() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		uid.click();
		Actions a = new Actions (driver);
		
		a.moveToElement(logoutbutton).click().build().perform();
	}
	
	
	

}
