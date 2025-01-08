package com.itlearn.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;


public class LoginTestDriveData extends BaseTest{
	
	//String fileName = System.getProperty("user.dir")+"\\TestData\\LogInTestData.xlsx";
	String fileName = "D:\\New_Eclipse_Workspace\\RealTimeProj_Frame1\\src\\test\\resources\\TestData\\LogInTestData.xlsx";

	
	@Test(priority =1,dataProvider="LogInDataProvider")
	public void verifylogin(String username1,String password1) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
//		String username = "Demo12";
//		String password = "Test123456$";
		lp.logInPortal(username1, password1);
		
		if(username1.equals("Demo12") && password1.equals("Test123456$"))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			lp.logout();
		}
		else
		{
			captureScreenShots(driver,"verifylogin");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	@DataProvider(name="LogInDataProvider")
	public String[][] LoginDataProvider()
	{
		
		
		int totalNoRows = ReadExcelFile.getRowCount(fileName,"LogInData");
		int totalNoColumn = ReadExcelFile.getColoumnCount(fileName,"LogInData");
		System.out.println(totalNoRows);
		String data[][] = new String[totalNoRows-1][totalNoColumn];
		
		for(int i=1;i<totalNoRows;i++)
		{
			for(int j=0;j<totalNoColumn;j++)
			{
				data[i-1][j] = ReadExcelFile.getCellValue(fileName, "LogInData", i, j);
			}
		}
		
		return data;
		
	}

}
