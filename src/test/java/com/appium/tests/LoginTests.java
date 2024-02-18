/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.tests;

import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_FILE;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_INVALID_PASSWORD;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_VALID_USER;
import static com.appium.constants.FrameworkConstants.EXPECTED_DATA_KEY_HOME_TITLE;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_INVALID_USER;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_PASSWORD;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_USERNAME;
import static com.appium.constants.FrameworkConstants.EXPECTED_DATA_KEY_ERR_INAVLID_CREDENTIALS;

import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.appium.reports.ExtentLogger;
import com.appium.utils.TestUtils;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.base.BaseTest;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.appium.manager.StringsManager;
import com.appium.pages.LoginPage;
import com.appium.pages.HomePage;
import com.appium.utils.JSONUtils;
import com.appium.utils.TestUtils;
import com.appium.utils.VerificationUtils;

public class LoginTests extends BaseTest {

	LoginPage loginPage;
	HomePage home;
	JSONObject loginUsers;

	@AfterClass
	public void afterClass() {
		// closeApp();
		// launchApp();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		// TestUtils.log().debug("---------------------------------------------------");
		// TestUtils.log().debug("******************* Test started: " + method.getName()
		// + "*******************");

		loginPage = new LoginPage();
	}

	@AfterMethod
	public void afterMethod(Method method) {
		// TestUtils.log().debug("******************* Test ended: " + method.getName() +
		// "*******************");
		// TestUtils.log().debug("---------------------------------------------------");
	}

	@FrameworkAnnotation(author = { AuthorType.AMAR, AuthorType.PANKAJ }, category = { CategoryType.SANITY,CategoryType.BVT, CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION" }, priority = 0)
	public void successfulLogin() {
		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T101 *******************");

		JSONObject jsonObject_InvalidUser = new JSONUtils().getJSONObject(TEST_DATA_JSON_FILE).getJSONObject(TEST_DATA_JSON_VALID_USER);

		String username = jsonObject_InvalidUser.getString(TEST_DATA_JSON_USERNAME).toString();
		String password = jsonObject_InvalidUser.getString(TEST_DATA_JSON_PASSWORD).toString();

		loginPage.pressLoginWithEmail().enterUsername(username).enterPassword(password).pressLoginBtn();

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: T1255 *******************");
		
		loginPage.click_On_WelcoemScreen_CloseIcon();

		// String actualProductTitle = home.getTitle();
		// String expectedProductTitle = StringsManager.getStrings().get(EXPECTED_DATA_KEY_HOME_TITLE);

		// VerificationUtils.validate(actualProductTitle, expectedProductTitle, "Product Title");
	}

}
