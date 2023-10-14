/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login with email\"]/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Login with email']")
	private MobileElement loginWithEmail;
	private String loginWithEmailTxt = "Login with email";

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	private MobileElement txtFldUsername;
	private String txtFldUsernameTxt = "Username Textbox";

	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	private MobileElement txtFldPassword;
	private String txtFldPasswordTxt = "Password Textbox";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Login']")
	private MobileElement btnLogin;
	private String btnLoginTxt = "Login button";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Username and password do not match any user in this service.']")
	private MobileElement msgErrorTxt;

	public LoginPage pressLoginWithEmail() {
		// click(btnLogin);
		click(loginWithEmail, loginWithEmailTxt);
		return this;
	}

	public LoginPage enterUsername(String userName) {
		// txtFldUsername.sendKeys(userName);
		// sendKeys(txtFldUsername, userName);
		sendKeys(txtFldUsername, userName, txtFldUsernameTxt);
		// hideKeyboard();
		return this;
	}

	public LoginPage enterPassword(String password) {
		// sendKeys(txtFldPassword, password);
		sendKeys(txtFldPassword, password, txtFldPasswordTxt);
		if (isAndroid())
			hideKeyboard();
		return this;
	}

	public HomePage pressLoginBtn() {
		if (isIos()) {
			(DriverManager.getMobileDriver()).getKeyboard().pressKey(Keys.RETURN);
		} else {
			click(btnLogin, btnLoginTxt);
		}
		return new HomePage();
	}

	public HomePage login(String username, String password) {
		pressLoginWithEmail().enterUsername(username).enterPassword(password).pressLoginBtn();
		return new HomePage();
	}

	public String getErrorTxt() {
		// return getAttribute(msgErrorTxt, TEXT);
		return getElementText(msgErrorTxt);
	}

}
