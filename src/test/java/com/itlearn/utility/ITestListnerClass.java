package com.itlearn.utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.uncommons.reportng.HTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListnerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;                       //used for generation reports at particular Loc.
	ExtentReports report;                                 //Path that help to generate reports
	ExtentTest test;                                      //used to attached all reports or records

	public void configureReport()
	{
		htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);

		//add system information/environments info to reports
		report.setSystemInfo("Machine", "AniketPC");
		report.setSystemInfo("OS", "Windows11");

		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first Report");
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onTestStart(ITestResult result)
	{		

	}

	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Name of the test method successfully excuted "+result.getName());
		test=report.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the skip test case is: "+result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println("Name of test method failed:"+result.getName());
		test=report.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the skip test case is: "+result.getName(),ExtentColor.RED));

		String screenShotsPath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getName() + ".png";

		File screenShotsFile = new File(screenShotsPath);

		if(screenShotsFile.exists())
		{
			test.fail("Captured Screenshot is below:" +test.addScreenCaptureFromPath(screenShotsPath));
		}
	}


	public void onTestSkip(ITestResult result)
	{
		System.out.println("Name of test method skipped "+result.getName());
		test=report.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: "+result.getName(),ExtentColor.YELLOW));
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}


	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}


	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On start method invoked.....");
	}

	public void onFinish(ITestContext context) {
		System.out.println("On Finished method invoked.....");
		report.flush();// it is mandatory to call flush method to ensure information is written ti the started reporter. 
	}

}
