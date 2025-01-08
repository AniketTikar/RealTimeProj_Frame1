package com.itlearn.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

public class LogInTest extends BaseTest {
	
	//String fileName = System.getProperty("D:\\New_Eclipse_Workspace\\RealTimeProj_Frame1\\src\\test\\resources\\TestData\\LogInTestData.xlsx");
	
	@Test
	public void verifylogin() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		String username = "Demo12";
		String password = "Test123456$";
		lp.logInPortal(username, password);
	}
	
	
	
		
	
	

}
