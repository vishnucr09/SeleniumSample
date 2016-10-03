package com.sears.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import com.google.common.base.Function;

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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(DefaultTimeOut, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}

		});
		return element;

	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

}
