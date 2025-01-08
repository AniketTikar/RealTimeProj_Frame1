package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	WebDriver driver;
	
	public void PaymentPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"learn-press-payment\"]/ul/li/label") WebElement payBtn;
	
	@FindBy(id = "learn-press-checkout-place-order") WebElement placeBtn;
	
	@FindBy(xpath = "//*[@id=\"card-element\"]/div/iframe") WebElement frameElement;
	
	@FindBy(name = "cardnumber") WebElement crdnum;
	
	@FindBy(name = "exp-date") WebElement expdate;
	
	@FindBy(name = "cvc") WebElement CVSnum;
	
	@FindBy(id = "payment-button") WebElement paymentbtn;
	
	public void paymentOption(String cardNumber,String expireDate,String cvc)
	{
		payBtn.click();
		placeBtn.submit();
		
		driver.switchTo().frame(frameElement);
		
		crdnum.sendKeys(cardNumber);
		expdate.sendKeys(expireDate);
		CVSnum.sendKeys(cvc);
		
		driver.switchTo().defaultContent();
		
		paymentbtn.click();
	}

}
