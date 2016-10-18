package com.sears.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import com.google.common.base.Function;
import com.sears.logger.Logger;
import com.sears.utils.PropertiesUtil;

public class BasePage {

	public int DefaultTimeOut = Integer.parseInt(PropertiesUtil.getProperty("DefaultTimeOut"));
	protected WebDriver driver;

	public void getElementClickable(WebDriver driver, By WebElement) {
		this.driver = driver;
		WebDriverWait myWait = new WebDriverWait(driver, DefaultTimeOut);
		myWait.until(ExpectedConditions.elementToBeClickable(WebElement));
	}

	public WebElement elementReadyForOperation(WebDriver driver, final By by) {
		Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver).withTimeout(DefaultTimeOut, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement element = myWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}

		});
		return element;

	}
	
	public void waitForElement(WebDriver driver, WebElement WebElement){
		this.driver = driver;
		WebDriverWait myWait = new WebDriverWait(driver, DefaultTimeOut);
		myWait.until(ExpectedConditions.visibilityOf(WebElement));
	}
	
	public boolean waitForElementToBeDisappeared(WebDriver driver, By webElement){
		boolean booleanValue = false;
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		booleanValue = myWait.until(ExpectedConditions.invisibilityOfElementLocated(webElement));
		System.out.println(booleanValue);
		return booleanValue;
	}
	 
	public void getscreenshot() 
     {
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+ File.separator + "failedScreenshot.png"));
			} catch (IOException e) {
				Logger.log("Exception while capturing screenshot");
				e.printStackTrace();
			}
             Logger.log("Screenshot was captured");
     }

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

}
