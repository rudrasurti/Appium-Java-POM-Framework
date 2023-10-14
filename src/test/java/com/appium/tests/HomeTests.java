/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.tests;

import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.base.BaseTest;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.appium.pages.HomePage;
import com.appium.pages.LoginPage;
import com.appium.utils.TestUtils;

public class HomeTests extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;

	JSONObject loginUsers;

	@AfterClass
	public void afterClass() {
//		closeApp();
//		launchApp();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: " + method.getName() + "*******************");

		// productsPage = new ProductsPage();
		homepage = new HomePage();
	}

	@AfterMethod
	public void afterMethod(Method method) {

		TestUtils.log().debug("******************* Test ended: " + method.getName() + "*******************");
		TestUtils.log().debug("---------------------------------------------------");
		// closeApp();
		// launchApp();
	}

	@FrameworkAnnotation(author = { AuthorType.NISHANT, AuthorType.GAUTAM }, category = { CategoryType.SMOKE,
			CategoryType.REGRESSION })
	@Test(groups = { "SMOKE", "REGRESSION" })
	public void validateProductCardScrollOnHomePage() {

		homepage.pressCloseIcon().swipeProductscards();

	}

}
