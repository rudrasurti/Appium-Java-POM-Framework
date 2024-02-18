package com.appium.tests;

import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.base.BaseTest;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;

import com.appium.pages.LoginPage;
import com.appium.pages.HomePage;

import com.appium.utils.TestUtils;

public class HomeTests extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;
	JSONObject loginUsers;

	@BeforeMethod
	public void beforeMethod(Method method) {
		loginPage = new LoginPage();
		homepage = new HomePage();

//		TestUtils.log().debug("---------------------------------------------------");
//		TestUtils.log().debug("******************* Test started: " + method.getName() + "*******************");
 
	}

	@AfterMethod
	public void afterMethod(Method method) {
//		TestUtils.log().debug("******************* Test ended: " + method.getName() + "*******************");
//		TestUtils.log().debug("---------------------------------------------------");
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SANITY, CategoryType.BVT,
			CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION" }, priority = 1)
	public void allTestCasesRelated_HomepageTestcases() throws InterruptedException {
	
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T120  *******************");
		
		homepage.check_Navigation_OfNotification();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T121 *******************");
		
		homepage.check_Navigation_ProfileIcon();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T115 *******************");
		homepage.checkNavigation_CoinCollectionValue();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T116, T117 ,T118, T119 *******************");
		homepage.checkNavigation_AllQuickButtons();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SANITY, CategoryType.BVT,
			CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION" }, priority = 2, dependsOnMethods = {
			"allTestCasesRelated_HomepageTestcases" })
	public void allTestCasesRelated_ShopSectionTestcases() throws InterruptedException {
		
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T107 *******************");
		
		homepage.ScrollDown_ToThe_NewProductSection();
		homepage.check_NewProductsCarouselInsightAllCardsHeight();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T110 *******************");
		
		homepage.swipingRight_NewProductsCarousel();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T122 *******************");
		
		homepage.swipingRight_NewProductsCarousel();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T114 *******************");
		
		homepage.clickAndCheck_ViewAllButtonOfNewProductionSection();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T1252 *******************");
		
		homepage.swipingRight_UnderViewMoreNewProductsCarousel();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T1251 *******************");
		
		homepage.ScrollDown_ToThe_ReleaseCalendarSection();
		homepage.checkNavigation_ReleaseCalendar();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SANITY, CategoryType.BVT,
			CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION" }, priority = 3, dependsOnMethods = {
			"allTestCasesRelated_ShopSectionTestcases" })
	public void allestasesRelated_newsSectionTestcases() throws InterruptedException {
		
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T111  *******************");
		
		homepage.swipingRight_newAndHighlightCarouselOfShowAll();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T108 *******************");
		
		homepage.check_newsAndHighlightCarouselAllCardsHeight();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T125 *******************");
		
		homepage.clickOnClubCardUnder_newAndHighlightSection();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T1254  *******************");
		
		homepage.swipingRight_newAndHighlightCarouselOfShowAll();
		homepage.check_AndValidate_ClubTag();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T123  *******************");
		
		homepage.clickOnshowAllCard_newAndHighlightSection();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SANITY, CategoryType.BVT,
			CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION" }, priority = 4, dependsOnMethods = {
			"allestasesRelated_newsSectionTestcases" })
	public void allTestCasesRelated_NewCoinsInDatabaseSection() throws InterruptedException {
		
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T109 *******************");
		
		homepage.scrollDown_ToNewCoinsInDatabaseSection();
		homepage.check_newCoinsInDatabaseAllCardsHeight();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T1252 *******************");
		homepage.clickAndCheck_ViewAllButton_Of_NewCoinsInDatabase_Section();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T112 *******************");
		homepage.swipingRight_NewCoinsInDatabaseSectionCarousel();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T124 *******************");
		homepage.checkNavigation_OfAllConis_of_NewCoinsInDatabaseSection();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SANITY, CategoryType.BVT,CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION" }, priority = 5, dependsOnMethods = {
			"allTestCasesRelated_NewCoinsInDatabaseSection" })
	public void allTestCasesRelated_exploreCoiniverseMemberMintsSectionTestcases() throws InterruptedException {
		
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T113 *******************");

		homepage.scrollDown_ToExploreCoiniverseMemberMintsSection();
		homepage.checkNavigation_AllLinks_of_ExploreCoiniverseMemberMintsSection();

	}
}
