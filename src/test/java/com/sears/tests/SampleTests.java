package com.sears.tests;

import org.testng.annotations.Test;

import com.sears.logger.Logger;
import com.sears.pages.HomePage;
import com.sears.pages.SearchResultsPage;
import com.sears.utils.DataProviderUtil;
import com.sears.webdriver.BaseTest;

public class SampleTests extends BaseTest {
	
	@Test(priority = 2)
	public void searchResultsValidations(){
		Logger.log("-------Test Started------");
		HomePage homePage = this.gotoSearsHomePage();
		SearchResultsPage SearchResultsPage = homePage.searchFor("Refrigerator");
		SearchResultsPage.validateSearchUrl();
		SearchResultsPage.validateSearchResults();
		Logger.log("-------Test Ended------");
	}
	
	@Test(dataProvider = "empDetails", dataProviderClass = DataProviderUtil.class, priority = 1)
	public void LoginTest(String username, String password){
		Logger.log("-------Test Started------");
		HomePage homePage = this.gotoSearsHomePage();
		homePage.SignIn(username,password);
		Logger.log("-------Test Ended------");
	}
}
