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
import com.appium.pages.ProfilePage;
import com.appium.utils.TestUtils;

import io.appium.java_client.MobileElement;

public class ProfileTest extends BaseTest {

	LoginPage loginPage;
	HomePage home;
	JSONObject loginUsers;
	ProfilePage profilePage;

	@BeforeMethod
	public void beforeMethod(Method method) {
		loginPage = new LoginPage();
		home = new HomePage();
		profilePage = new ProfilePage();

//		TestUtils.log().debug("---------------------------------------------------");
//		TestUtils.log().debug("******************* Test started: " + method.getName() + "*******************");

	}

	@AfterMethod
	public void afterMethod(Method method) {
//		TestUtils.log().debug("******************* Test ended: " + method.getName() + "*******************");
//		TestUtils.log().debug("---------------------------------------------------");
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 1, description = "Set Profile Public :")
	public void setProfilePublic() throws InterruptedException, IOException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T126  *******************");
		
		profilePage.check_Navigation_ProfileIcon();
		profilePage.check_Navigation_OfEditBox();

		Thread.sleep(3000);
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T127  *******************");

		profilePage.check_Navigation_OfToggleButton();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T132 *******************");
		
		profilePage.check_NavigationAnd_EnterDescription("Testing");

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T128 T133  *******************");
	
		
		profilePage.scrollDown_ToNameText();
		profilePage.click_OnUpdateButton();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 2, description = "Enter Name:", dependsOnMethods = {"setProfilePublic" })
	public void verifyNameBox() throws InterruptedException {
		
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T134 *******************");
		
		profilePage.check_NavigationAnd_EnterName("Testing");
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 3, description = "Change Email:", dependsOnMethods = {"verifyNameBox" })
	public void verifyEmailBox() throws InterruptedException {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T138 *******************");
		profilePage.check_NavigationAnd_EnterEmail("tesing@.com", "tesing@gmail.com");
		profilePage.click_OnEmailCloseIcon();
//		profilePage.click_OnChangeButton();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 4, description = "App Langauge Change:", dependsOnMethods = {"verifyEmailBox" })
	public void appLanguageChange() throws InterruptedException {
		
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T136 *******************");
		
		profilePage.scrollDown_ToAppLangauge();
		profilePage.check_NavigationAnd_ChangeAppLanguage("Suomi");
		profilePage.click_updateButtonButtonForAppLagauage();
		profilePage.check_NavigationAnd_ChangeAppLanguage("English");
		profilePage.click_updateButtonButtonForAppLagauage();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T137 *******************");
		
		profilePage.click_PushNotificationToggleButton();
		profilePage.click_OnUpdateButton();
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR }, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 5, description = "Passeord Change:", dependsOnMethods = {
	"appLanguageChange" })
	public void verifyChangePasswordBox() throws InterruptedException {
		
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T135 *******************");
		
		profilePage.scrollDown_ToChangePassword();
		profilePage.check_NavigationAnd_EnterPassword("tT246246!", "test@123", "test@1234");
//		profilePage.click_OnChangeButton();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T139 *******************");
		
		profilePage.scrollDown_ToLogoutButton();
		profilePage.click_OnLogOutButton();
//		profilePage.click_Navigation_ConfirmLogoutButton();

	}

}
