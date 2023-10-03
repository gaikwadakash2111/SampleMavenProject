package testCase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.LoginPageObjects;
import resorces.BaseClass;

public class VerifyLogin extends BaseClass{
	
	@Test
	public void login() throws IOException, InterruptedException
	{
        FileInputStream fs=new FileInputStream("C:\\Users\\user\\Desktop\\data.xlsx");
		
		XSSFWorkbook  workbook=new XSSFWorkbook(fs);
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		XSSFRow row=sheet.getRow(0);
		
		XSSFCell cell1=row.getCell(0);
		
		String c1=cell1.toString();
		
		XSSFCell cell2=row.getCell(1);
		
		String c2=cell2.toString();
		
		//System.out.println(sheet.getRow(0).getCell(0));
		
		//System.out.println(sheet.getRow(0).getCell(1));
		
		driverInitialize();
		
		driver.get("https://login.salesforce.com/?locale=in");
		
		driver.manage().window().maximize();
		
        Thread.sleep(2000);
		
		LoginPageObjects lpo=new LoginPageObjects(driver);
		
		lpo.enterUsername().sendKeys(c1);
		
		Thread.sleep(1000);
		
		lpo.enterPassword().sendKeys(c2);
		
		Thread.sleep(1000);
		
		lpo.clickOnLogin().click();
		
		Thread.sleep(1000);
		
		String actual=lpo.getErrorMessage().getText();
		
		String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		// this is hard assertion
		//Assert.assertEquals(actual, expected,"something went wrong");
		
		//for soft assertion
		
		SoftAssert a=new SoftAssert();
		
		a.assertEquals(actual, expected);
		
		System.out.println("some remainig code");
		
		a.assertAll();
		
		driver.close();
	}

}
