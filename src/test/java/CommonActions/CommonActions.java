package CommonActions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CommonActions {
	WebDriver driver;
	WebDriverWait wait;
	public static ExtentTest logger;
	
	public CommonActions(WebDriver driver,ExtentTest logger) {
		this.driver = driver;
		this.logger=logger;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void InputText(WebElement ele, String value,String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(value);
			logger.pass(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.fail("Failed due to error"+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void ClickElement(WebElement ele,String msg) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			logger.pass(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.fail("Failed due to error"+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void ElementExist(WebElement ele,String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.isDisplayed();
			logger.pass(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.fail("Failed due to error"+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public String getscreenshot() {
		Date date = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyymmss");
		String filename = ft.format(date);
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File src = srcShot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/ScreenShots/image"+filename+".png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}


