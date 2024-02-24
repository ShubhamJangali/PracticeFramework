package com.vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import CommonActions.CommonActions;

public class HomePage extends CommonActions{

	public HomePage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[text()=\"Home\"])[1]")
	WebElement lnk_Home;
	
	@FindBy(xpath = "//a[text()=\"Logout\"]")
	WebElement lnk_Logout;
	
	public void ClickLogout() {
		ClickElement(lnk_Logout,"Clicked on Logout");
	}
	
	public void VerifyLogout() {
		ElementExist(lnk_Logout,"Logout Verified");
	}
	
	public void VerifyHome() {
		ElementExist(lnk_Home,"Home page Verified");
	}
}
