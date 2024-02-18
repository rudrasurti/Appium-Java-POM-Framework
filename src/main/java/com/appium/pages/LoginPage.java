/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.pages;

import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_FILE;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_PASSWORD;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_USERNAME;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_VALID_USER;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.appium.base.BasePage;
import com.appium.components.MenuPage;
import com.appium.manager.DriverManager;
import com.appium.utils.JSONUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import com.appium.pages.HomePage;

public class LoginPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='login_screen_text_31']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Login with email']")
	private MobileElement loginWithEmail;
	private String loginWithEmailTxt = "Login with email";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='login_screen_mintage_text_input_12']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	private MobileElement txtFldUsername;
	private String txtFldUsernameTxt = "User Name";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='login_screen_mintage_text_input_13']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	private MobileElement txtFldPassword;
	private String txtFldPasswordTxt = "Password";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='spinner_button_10']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Login']")
	private MobileElement btnLogin;
	private String btnLoginTxt = "Login button";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Username and password do not match any user in this service.']")
	private MobileElement msgErrorTxt;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Hello Testi Testi!')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Username and password do not match any user in this service.']")
	private MobileElement homeText;
	
	private WelcomeModelPage welcomeModelPage;

	public WelcomeModelPage getwelcomePage() {
		if (welcomeModelPage == null)
			welcomeModelPage = new WelcomeModelPage();
		return welcomeModelPage;
	}

	public LoginPage pressLoginWithEmail() {
		click(loginWithEmail, loginWithEmailTxt);
		return this;
	}

	public LoginPage enterUsername(String userName) {
		sendKeys(txtFldUsername,txtFldUsernameTxt, userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		// sendKeys(txtFldPassword, password);
		sendKeys(txtFldPassword, txtFldPasswordTxt,password);
		if (isAndroid())
			hideKeyboard();
		return this;
	}

	public LoginPage pressLoginBtn() {
		if (isIos()) {
			(DriverManager.getMobileDriver()).getKeyboard().pressKey(Keys.RETURN);
		} else {
			click(btnLogin, btnLoginTxt);
		}
		return this;
	}

	public HomePage click_On_WelcoemScreen_CloseIcon() {
		getwelcomePage().click_On_CloseIcon();
		return new HomePage();
	}

	
}
