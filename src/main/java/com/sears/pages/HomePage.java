package com.sears.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sears.logger.Logger;
import com.sears.utils.PropertiesUtil;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	By NavigateToUSSite = By.id(PropertiesUtil.getProperty("HomePage.NavigateToUSSite"));
	By SearchBar = By.xpath(PropertiesUtil.getProperty("HomePage.SearchBar"));
	
	public HomePage NavigateToUSSite(){
		getElementClickable(driver, NavigateToUSSite);
		driver.findElement(NavigateToUSSite).click();
		Logger.log("NavigateToUSSite link was clicked");
		return this;
	}
	
	public SearchResultsPage searchFor(String product){
		WebElement element = elementReadyForOperation(this.driver,SearchBar);
		element.sendKeys(product);
		element.submit();
		Logger.log("Searched for "+product);
		return new SearchResultsPage(this.driver, product);
	}
}
