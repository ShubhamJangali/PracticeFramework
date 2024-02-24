package com.vtiger.stepdifinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseStepDefinitions {
	public static WebDriver driver;
	public static Properties prop;
	public static Map<String,Map<String,String>> dt;
	public static ExtentHtmlReporter htmlreporter ;
	public static ExtentReports extent;
	public static String TC_Name;
	public static ExtentTest logger;
	
	public void initiate() {
		if(prop==null);
		prop = readproperties();
		if(dt==null)
		dt = JsonReader();
		if(extent==null)
		ExtentReporting();
	}

	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitwait"))));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Appurl"));
	}
	
	public Properties readproperties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Settings/Config.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	public static Map<String,Map<String,String>> JsonReader() {
		Map<String,Map<String,String>> userData=null;
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/Data/TestData.json");	
		try {
			userData = mapper.readValue(file, new TypeReference<Map<String,Map<String,String>>>() {	
			});
			
			//System.out.println(userData.get("Valid_Login1_TC01").get("Userid"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return userData;
	}
	
	public void ExtentReporting() {
		Date date = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyymmss");
		String filename = ft.format(date);
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/ExtentReport"+filename+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("HostName", "Automation Test Hub");
		extent.setSystemInfo("UserName", "Shubham");
		htmlreporter.config().setTheme(Theme.STANDARD);
	}
}
