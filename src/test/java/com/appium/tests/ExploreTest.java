package com.appium.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.base.BaseTest;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.appium.manager.DriverManager;
import com.appium.pages.HomePage;
import com.appium.pages.LoginPage;
import com.appium.pages.ExplorePage;
import com.appium.utils.TestUtils;

public class ExploreTest extends BaseTest {

	LoginPage loginPage;
	HomePage home;
	ExplorePage explorePage;
	JSONObject loginUsers;

	@BeforeMethod
	public void beforeMethod(Method method) {
		loginPage = new LoginPage();
		home = new HomePage();
		explorePage = new ExplorePage();

//		TestUtils.log().debug("---------------------------------------------------");
//		TestUtils.log().debug("******************* Test started: " + method.getName() + "*******************");

	}

	@AfterMethod
	public void afterMethod(Method method) {
//		TestUtils.log().debug("******************* Test ended: " + method.getName() + "*******************");
//		TestUtils.log().debug("---------------------------------------------------");
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 1, description = "Explore Page :T301")
	public void allTestCasesRelated_ExploreScreen() throws InterruptedException, IOException {
	
//		explorePage.AddCoinToContry("Afghanistan");

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("*******************  Test started: T301 *******************");
		explorePage.check_Navigate_ExploreScreen();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T302 *******************");

		explorePage.getAllLocationNameAndValidate();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T303  *******************");

		explorePage.check_Navigation_EuropeLocation();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 2, dependsOnMethods = { "allTestCasesRelated_ExploreScreen" })
	public void allTestCasesRelated_CoinValue() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T315 T316 *******************");

		explorePage.scrollDown_ToCoinValueSection();
		explorePage.click_Navigation_ExploreClub();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 3, dependsOnMethods = { "allTestCasesRelated_CoinValue" })
	public void allTestCasesRelated_RecentlyAdded() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  T308 *******************");

		explorePage.scrollDown_CategorySection();
		explorePage.getBycategorySectionAndValidate();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  T309 *******************");
	
		explorePage.scrollDown_CategorySection().check_Navigate_RecentlyAddedCarousel_CategorySection();

	}


	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 4, dependsOnMethods = { "allTestCasesRelated_RecentlyAdded" })
	public void allTestCasesRelated_TimePeriod() throws InterruptedException {
		explorePage.scrollDown_CategorySection();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T310 *******************");

		explorePage.check_Navigate_TimePeriodCarousel_CategorySection();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T313 *******************");
		
		explorePage.check_Navigate_selectFirstTimePeriod_CategorySection();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 5, dependsOnMethods = { "allTestCasesRelated_TimePeriod" })
	public void allTestCasesRelated_HistoricalRegions() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T311 *******************");

		explorePage.scrollDown_CategorySection().check_Navigate_HistoricalRegions();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T312 T314 *******************");

		explorePage.check_Navigation_SelectFirstHistoricalRegions();
	}
}
