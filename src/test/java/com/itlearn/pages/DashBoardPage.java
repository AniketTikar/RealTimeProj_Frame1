package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	WebDriver driver;
	
	public DashBoardPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"login-list\"]/li[1]/a") WebElement dashboardBtn;
	
	@FindBy(xpath = "//*[@id=\"learn-press-user-profile\"]/ul/li[3]") WebElement offerAcdm;
	
	@FindBy(xpath = "//*[@id=\"tab-academies\"]/div/div/ul/li[4]/form/div/button") WebElement subscribeBtn;
	
	public void dashBoardClick()
	{
		dashboardBtn.click();
		offerAcdm.click();
		subscribeBtn.click();
	}

}
