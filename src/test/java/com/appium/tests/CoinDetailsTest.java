package com.appium.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.base.BaseTest;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.appium.pages.CoinsDetailsPage;
import com.appium.pages.ExplorePage;
import com.appium.pages.HomePage;
import com.appium.pages.LoginPage;
import com.appium.utils.TestUtils;

public class CoinDetailsTest extends BaseTest {
	LoginPage loginPage;
	HomePage home;
	ExplorePage explorePage;
	CoinsDetailsPage coinsDetailsPage;
	JSONObject loginUsers;

	@BeforeMethod
	public void beforeMethod(Method method) {

		loginPage = new LoginPage();
		home = new HomePage();
		explorePage = new ExplorePage();
		coinsDetailsPage = new CoinsDetailsPage();

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
	public void allTestCasesRelated_Mycoins() throws InterruptedException, IOException {
		coinsDetailsPage.check_Filter_CoinTypeWithRegular();
		coinsDetailsPage.check_Filter_CoinTypeWithCommemorative();
		

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T226  *******************");

		coinsDetailsPage.check_ShowAllAndCloseAllOnAllCoinPage();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 2, dependsOnMethods = { "allTestCasesRelated_Mycoins" })
	public void allTestCasesRelated_Wishlist() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("*******************  Test started: T220 *******************");

		coinsDetailsPage.check_AddAndRemoveCoinFromWishlist("Afghanistan");

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T223 *******************");

		coinsDetailsPage.AddCoinToContryWithCollectionName("Test Name", "Test", "Afghanistan");
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 2, dependsOnMethods = { "allTestCasesRelated_Wishlist" })
	public void allTestCasesRelated_Likes() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T221 *******************");

		coinsDetailsPage.click_AddAndRemoveCoinFromLinks("Afghanistan");
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 2, dependsOnMethods = { "allTestCasesRelated_Likes" })
	public void allTestCasesRelated_Templates() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T224 , T225 *******************");

		coinsDetailsPage.check_ActivateAndDeactiveReadytemplate();
	}
}