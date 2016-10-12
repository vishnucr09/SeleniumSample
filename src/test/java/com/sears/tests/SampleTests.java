package com.sears.tests;

import org.testng.annotations.Test;

import com.sears.logger.Logger;
import com.sears.pages.HomePage;
import com.sears.pages.SearchResultsPage;
import com.sears.webdriver.BaseTest;

public class SampleTests extends BaseTest {
	
	@Test
	public void searchResultsValidations(){
		Logger.log("-------Test Started------");
		this.gotoSearsHomePage();
		HomePage HomePage = new HomePage(this.driver);
		SearchResultsPage SearchResultsPage = HomePage.searchFor("Refrigerator");
		SearchResultsPage.validateSearchUrl();
		SearchResultsPage.validateSearchResults();
		Logger.log("-------Test Ended------");
	}
	
	@Test
	public void LoginTest(){
		Logger.log("-------Test Started------");
		this.gotoSearsHomePage();
		HomePage HomePage = new HomePage(this.driver);
		HomePage.SignIn("searstest999@automation.com", "password");
		Logger.log("-------Test Ended------");
	}
}
