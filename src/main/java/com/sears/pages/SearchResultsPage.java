package com.sears.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sears.logger.Logger;
import com.sears.utils.PropertiesUtil;

public class SearchResultsPage extends BasePage{
	
	 String searchedProduct = null;
	 
	 By SearchResultItem = By.xpath(PropertiesUtil.getProperty("SearchResultsPage.Product"));
	 By SearchResultsPageProductTitle = By.xpath(PropertiesUtil.getProperty("SearchResultsPage.Product.Title"));
	
	public SearchResultsPage(WebDriver driver, String product){
		this.driver = driver;
		searchedProduct = product;
		PageFactory.initElements(this.driver, this);
	}
	
	public void validateSearchUrl(){
		String url = PropertiesUtil.getProperty("sears.homepage.url");
		url = url.concat("/search=");
		url = url.concat(searchedProduct);
		Assert.assertEquals(url, driver.getCurrentUrl(),"Url is not loaded as expected");
	}
	
	public void validateSearchResults(){
		WebElement element = elementReadyForOperation(this.driver,SearchResultItem);
		List<WebElement> itemList = driver.findElements(SearchResultsPageProductTitle);
		Iterator<WebElement> Iterator = itemList.iterator(); 
		while(Iterator.hasNext()){
			WebElement elementOne = Iterator.next();
			Assert.assertTrue(elementOne.getText().contains(searchedProduct), "SearchProducts are not displayed as expected");
			Logger.log("Search Results Matched!! Search term: "+searchedProduct+" was found in the product title: "+elementOne.getText());
		}
	}

}
