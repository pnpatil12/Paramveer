package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerothaLoginPage {

	@FindBy (xpath="//input[@id='userid']")
	private WebElement userid;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement loginbutton;
	
	
	
	WebDriver driver;
	public ZerothaLoginPage (WebDriver driver)   
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}

	public void senduserid(String Id)
	{
		userid.sendKeys(Id);
	}
	
	public void sendpassword(String pass)
	{
		password.sendKeys(pass);
	}

	public boolean verifyLoginText()
	{
		String expected= "Login";
		String actual = loginbutton.getText();
		boolean result = expected.equals(actual);
		System.out.println(result);
		return result;
	
	}
	public boolean verifyloginbutton() throws InterruptedException
	{
		boolean result1 =loginbutton.isEnabled();
		System.out.println(result1);
        loginbutton.click();
		return result1;
	}
	
}