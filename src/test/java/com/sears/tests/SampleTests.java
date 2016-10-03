package com.sears.tests;

import org.testng.annotations.Test;

import com.sears.logger.Logger;
import com.sears.pages.HomePage;
import com.sears.pages.SearchResultsPage;
import com.sears.webdriver.BaseTest;

public class SampleTests extends BaseTest {
	
	@Test
	public void sampleTestOne(){
		HomePage HomePage = new HomePage(this.driver);
		Logger.log("-------Test Started------");
		this.gotoSearsHomePage();
		HomePage.NavigateToUSSite();
		SearchResultsPage SearchResultsPage = HomePage.searchFor("refrigerators");
		SearchResultsPage.validateSearchUrl();
		SearchResultsPage.validateSearchResults();
	}

}
