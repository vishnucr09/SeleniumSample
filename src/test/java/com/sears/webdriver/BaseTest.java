package com.sears.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.sears.logger.Logger;
import com.sears.utils.PropertiesUtil;

public abstract class BaseTest{
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setup(){
		Logger.log("-----------------------------Test Started");
		this.driver = getWebDriver();
	}
	
	public WebDriver getWebDriver(){
		String driverPath = "D:/Vishnu_Selenium/";
		String driverPathForChromeDriver = "D:/Vishnu_Selenium/chromedriver_win32/";
		String browser = PropertiesUtil.getProperty("Browser");
		if(browser.equals("FireFox")){
			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			Logger.log(PropertiesUtil.getProperty("Browser")+" browser was choose and opened");
		}
		else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", driverPathForChromeDriver+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public void gotoSearsHomePage(){
		Logger.log("Opening Sears Home Page with"+"\n"+"Url: "+PropertiesUtil.getProperty("sears.homepage.url"));
		driver.get(PropertiesUtil.getProperty("sears.homepage.url"));
	}
	
	@AfterTest
	public void close(){
		Logger.log("-----------------------------Test Ended");
		driver.close();
		driver.quit();
	}

}
