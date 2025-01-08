package com.itlearn.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{
		File f = new File("D:\\New_Eclipse_Workspace\\RealTimeProj_Frame1\\src\\test\\resources\\configuration\\config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(f);
			pro = new Properties();
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("Not able to load config file"+e.getMessage());
		}
		
		
	}
	
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	
	public String getStaggingUrl()
	{
		return pro.getProperty("testurl");
	}

}
