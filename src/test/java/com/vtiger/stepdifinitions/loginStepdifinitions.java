package com.vtiger.stepdifinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.Pages.HomePage;
import com.vtiger.Pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStepdifinitions extends BaseStepDefinitions{
	LoginPage lp;
	
	@Before
	public void setup(Scenario scenario) {
		initiate();
		TC_Name = scenario.getName();
		logger = extent.createTest(TC_Name);
	}
	
	@After
	public void teardown() {
		extent.flush();
		driver.quit();
	}

	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		launch();
		lp = new LoginPage(driver,logger);
	}

	@When("user enters valid user name")
	public void user_enters_valid_user_name() {
		lp.SetUserName(dt.get(TC_Name).get("Userid"));
	}

	@When("and valid password")
	public void and_password() {
		lp.SetUserPassword(dt.get(TC_Name).get("Password"));
	}

	@Then("click on Login button")
	public void click_on_login_button() {
		lp.ClickLogin();
	}
	
	@When("user enters Invalid user name")
	public void user_enters_invalid_user_name() {
	    lp.SetUserName("Admin");
	}
	@Then("error massage should be displayed")
	public void error_massage_should_be_displayed() {
	   lp.VerifyErrMsg();
	}
}
