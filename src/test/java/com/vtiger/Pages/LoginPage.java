package com.vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import CommonActions.CommonActions;

public class LoginPage extends CommonActions {
	
	public LoginPage(WebDriver driver, ExtentTest logger) {
		super(driver,logger);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	WebElement tb_name;

	@FindBy(name = "user_password")
	WebElement tb_password;

	@FindBy(name = "Login123")
	WebElement btn_login;

	@FindBy(name = "login_theme")
	WebElement dd_theme;
	
	@FindBy(xpath = "//img[@src=\"include/images/vtiger-crm.gif\"]")
	WebElement img_logo;
	
	@FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement txt_ErrMsg;

	public void login(String username, String password) {
//		tb_name.clear();
//		tb_name.sendKeys(username);
//		tb_password.clear();
//		tb_password.sendKeys(password);
//		btn_login.click();

		SetUserName(username);
		SetUserPassword(password);
		ClickLogin();
	}

	public void login(String username, String password, String theme) {
//		tb_name.clear();
//		tb_name.sendKeys(username);
//		tb_password.clear();
//		tb_password.sendKeys(password);
//		dd_theme.sendKeys(theme);
//		btn_login.click();

		SetUserName(username);
		SetUserPassword(password);
		SetTheme(theme);
		ClickLogin();

	}

	public void SetUserName(String username) {
//		tb_name.clear();
//		tb_name.sendKeys(username);

		InputText(tb_name, username,username+" entered successfully");
	}

	public void SetUserPassword(String password) {
//		tb_password.clear();
//		tb_password.sendKeys(password);

		InputText(tb_password, password,password+" entered successfully");
	}

	public void ClickLogin() {
//		btn_login.click();

		ClickElement(btn_login,"Login button clicked Successfully");
	}

	public void SetTheme(String theme) {
//		dd_theme.sendKeys(theme);
		
		InputText(dd_theme, theme,theme+"is selected");
	}
	
	public void VerifyLogo() {
		ElementExist(img_logo,"Logo verified");
	}
	
	public void VerifyErrMsg() {
		ElementExist(txt_ErrMsg,"Logo verified");
	}
}
