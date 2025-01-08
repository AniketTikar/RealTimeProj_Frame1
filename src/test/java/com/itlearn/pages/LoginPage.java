package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	//Constructor
	public LoginPage(WebDriver lDriver)
	{
		this.driver=lDriver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id=\"loginlabel\"]") WebElement logInBtn;

	@FindBy(id = "user_login") WebElement uname;

	@FindBy(id = "user_pass") WebElement pass;

	@FindBy(id = "wp-submit") WebElement submitBtn;

	@FindBy(xpath="//*[@id=\"gk-login-toggle\"]/i") WebElement logoutimage;

	@FindBy(xpath="//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a") WebElement logoutclick;

	public void logInPortal(String username,String password) throws InterruptedException
	{
		logInBtn.click();
		uname.sendKeys(username);
		pass.sendKeys(password);
		
		Thread.sleep(2000);
		submitBtn.click();
	}
	
	public void logout()
	{
		logoutimage.click();
		logoutclick.click();
	}


}
