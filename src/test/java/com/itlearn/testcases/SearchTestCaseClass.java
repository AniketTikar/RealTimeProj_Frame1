package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itlearn.pages.SearchPage;
import com.itlearn.utility.ReadExcelFile;

public class SearchTestCaseClass extends BaseTest{
	
	String fileName = "D:\\New_Eclipse_Workspace\\RealTimeProj_Frame1\\src\\test\\resources\\TestData\\LogInTestData.xlsx";
	
	@Test
	public void searchCourseTest() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		String username = ReadExcelFile.getCellValue(fileName, "LogInData", 1, 0);
		String password = ReadExcelFile.getCellValue(fileName, "LogInData", 1, 1);
		
		lp.logInPortal(username, password);
		
		SearchPage sp = new SearchPage(driver);
		
		String courseName = ReadExcelFile.getCellValue(fileName, "CourseName", 0, 0);
		sp.searchCourse(courseName);
		
	}

}
