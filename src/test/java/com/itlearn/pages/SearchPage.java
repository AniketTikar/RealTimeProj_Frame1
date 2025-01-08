package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name = "search_course") WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\"primary_menu\"]/nav[1]/form/button") WebElement searchbtn;
	
	public void searchCourse(String courseName)
	{
		searchBox.sendKeys(courseName);
		searchbtn.click();
	}

}
