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
import com.appium.pages.ShopPage;
import com.appium.pages.HomePage;

import com.appium.utils.TestUtils;

public class ShopTests extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;
	ShopPage shopPage;
	JSONObject loginUsers;

	@BeforeMethod
	public void beforeMethod(Method method) {
		loginPage = new LoginPage();
		shopPage = new ShopPage();

//		TestUtils.log().debug("---------------------------------------------------");
//		TestUtils.log().debug("******************* Test started: " + method.getName() + "*******************");

	}

	@AfterMethod
	public void afterMethod(Method method) {
//		TestUtils.log().debug("******************* Test ended: " + method.getName() + "*******************");
//		TestUtils.log().debug("---------------------------------------------------");
	}

	@FrameworkAnnotation(author = { AuthorType.RUDRA }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 1, description = "")
	public void closeIconOfWelcome() {
//		homepage.pressCloseIcon();

	}

	@FrameworkAnnotation(author = { AuthorType.RUDRA }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 2, dependsOnMethods = { "closeIconOfWelcome" })
	public void allTestCasesRelated_Promotedcoins() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  *******************");

		shopPage.ClickOn_Menu_ShopIcon();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  *******************");

		shopPage.swipingRight_promotedCoinsCarousel();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:   *******************");

		shopPage.checkNavigation_of_promoteCoinscarousel_AllCards();
	}

	@FrameworkAnnotation(author = { AuthorType.RUDRA }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 3, dependsOnMethods = { "allTestCasesRelated_Promotedcoins" })
	public void allTestCasesRelated_ReleaseCalendar() throws InterruptedException {

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  *******************");

		shopPage.checkNavigation_ReleaseCalendar();

	}

	@FrameworkAnnotation(author = { AuthorType.RUDRA }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 4, dependsOnMethods = { "allTestCasesRelated_ReleaseCalendar" })

	public void allTestCasesRelated_MostLikedCoins() throws InterruptedException {

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  *******************");

		shopPage.ScrollDown_To_MostLikedCoins_Section().check_navigation_Of_ViewAllButton();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  *******************");

		shopPage.swipingRight__MostLikedCoins_Section_Carousel();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  *******************");

		shopPage.check_navigation_Of_MostLikedCoinsSection_Carousel();

	}

	@FrameworkAnnotation(author = { AuthorType.RUDRA }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 5)
	public void allTestCasesRelated_Categories() throws InterruptedException {

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  *******************");

		shopPage.ScrollDown_To_Categories_Section().check_navigation_Of_ViewAllButtonOfCategories();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  *******************");

		shopPage.check_navigation_Of_CategoriesCarousel();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started:  *******************");

		shopPage.swipingRight_Categories_Section_Carousel();

	}

}
