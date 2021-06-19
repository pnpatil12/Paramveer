package com.pom.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
public static Workbook openWorkbook (String path) throws EncryptedDocumentException, IOException, InvalidFormatException 
{
	FileInputStream file = new FileInputStream(path);
	Workbook a= WorkbookFactory.create(file);
	return a;
}
	
public static String fetchdata(Workbook a ,String sheetname, int row, int cell)
{
	String value = a.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return value;
}

public static  void captureScreenshot1(WebDriver driver , int testID) throws IOException
{
	 Date currentdate = new Date();
    System.out.println(currentdate);
	 String Screenshotfilename = currentdate.toString().replace(" ", " ").replace(":", " -");
	 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 File dest = new File ("D:\\Shree Swami Samarth\\Screenshots"+Screenshotfilename+".jpeg");
	 FileHandler.copy(source, dest);
}
}

