package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerothaDashboardPage {

	@FindBy (xpath="//span[@class='nickname']")
	private WebElement msg;
	
	WebDriver driver;
	public ZerothaDashboardPage (WebDriver driver)   
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}

	public boolean textverification()
	{
		String expected = "Paramveer";
		String actual = msg.getText();
		boolean result = expected.equals(actual);
    	System.out.println(result);
		return result;
	}
}
