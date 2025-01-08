package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.DashBoardPage;
import com.itlearn.pages.LoginPage;
import com.itlearn.pages.PaymentPage;
import com.itlearn.utility.ReadExcelFile;

public class PaymentTestCase extends BaseTest {
	
	String fileName = "D:\\New_Eclipse_Workspace\\RealTimeProj_Frame1\\src\\test\\resources\\TestData\\LogInTestData.xlsx";
	
	@Test
	public void testCourses() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		String username = ReadExcelFile.getCellValue(fileName, "LogInData", 1, 0);
		String password = ReadExcelFile.getCellValue(fileName, "LogInData", 1, 1);
		
		lp.logInPortal(username, password);
		
		DashBoardPage dp = new DashBoardPage(driver);
		
		dp.dashBoardClick();
		
		PaymentPage pp = new PaymentPage();
		pp.PaymentPage(driver);
		
		String cardNum = ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 0);
		String expDate = ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 1);
		String cvcNum = ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 2);
		
		pp.paymentOption(cardNum, expDate, cvcNum);
		
	}

}
