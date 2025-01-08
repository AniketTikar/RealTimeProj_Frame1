package com.itlearn.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.itlearn.utility.BrowserFactory;
import com.itlearn.utility.ConfigDataProvider;

public class BaseTest {
	
	public WebDriver driver;
	public ConfigDataProvider config = new ConfigDataProvider();
	
	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStaggingUrl());
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	public void captureScreenShots(WebDriver driver,String testName) throws IOException
	{
		//convert Webdriver obj to TakeScreenshots Driver
		TakesScreenshot screeshots = (TakesScreenshot)driver;
		
		//S2: Call getScreenShotsAs Method to capture image file
		File file = screeshots.getScreenshotAs(OutputType.FILE);
		File srcPath = new File("."+"//Screenshots//"+testName+".png");
		System.out.println("This is Screenshots Section");
		
		//S3:copy img file to destination
		FileUtils.copyFile(file, srcPath);
	}

}
