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
import com.appium.pages.MyCoinsPage;
import com.appium.pages.HomePage;

import com.appium.utils.TestUtils;

public class MyCoinsTests extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;
	JSONObject loginUsers;
	MyCoinsPage myCoins;

	@BeforeMethod
	public void beforeMethod(Method method) {
		loginPage = new LoginPage();
		homepage = new HomePage();
		myCoins = new MyCoinsPage();

//		TestUtils.log().debug("---------------------------------------------------");
//		TestUtils.log().debug("******************* Test started: " + method.getName() + "*******************");

	}

	@AfterMethod
	public void afterMethod(Method method) {
//		TestUtils.log().debug("******************* Test ended: " + method.getName() + "*******************");
//		TestUtils.log().debug("---------------------------------------------------");
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 1)
	public void allTestCaseRelated_BadgesSection() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T210  *******************");

		myCoins.check_Navigation_OfMyCoins();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T208  *******************");

		myCoins.check_Navigation_OfProfileIcon();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T201  *******************");

		myCoins.check_BadgesOneAndMore();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T203  *******************");

		myCoins.check_Navigation_OfBadges();

	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 2, dependsOnMethods = { "allTestCaseRelated_BadgesSection" })
	public void allTestCaseRelated_CuponeCode() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T204  *******************");

		myCoins.scrollDown_CodeSection();
		myCoins.check_And_ValidateCuponCode("MOFFRIENDS");
		myCoins.check_And_ValidateInvalidCuponCode("12345");

	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 3, dependsOnMethods = { "allTestCaseRelated_CuponeCode" })
	public void allTestCaseRelated_AllCarsoleCard() throws InterruptedException {

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T206  *******************");

		myCoins.scrollDown_StatisticsAndValues();
		myCoins.check_Navigation_OfStatisticsAndValuesExploreClub();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T205  *******************");

		myCoins.check_Navigation_OfStatisticsAndValuesMoreButton();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T207  *******************");

		myCoins.scrollDown_MyCoins();
		myCoins.validate_TotalNumberOfMyCoins();
		
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T209  *******************");

		myCoins.click_Navigate_MycoinsCarousel();

	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 3, dependsOnMethods = { "allTestCaseRelated_AllCarsoleCard" })
	public void allTestCaseRelated_AddNewCollection() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T202  *******************");

		myCoins.scrollDown_AddNewCollectionSection();
		myCoins.createNew_CollectionName("Test Collection Name", "Test Collection Decscription");
		myCoins.check_AndEdidtAddNewCollection("New");
//		myCoins.click_OnBackButton();
		myCoins.check_AndDeletetExitingCollection();
	}

}
