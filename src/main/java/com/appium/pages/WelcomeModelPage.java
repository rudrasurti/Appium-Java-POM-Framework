/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.pages;

import java.util.List;

import com.appium.base.BasePage;
import com.appium.components.MenuPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WelcomeModelPage extends BasePage {

	private static final String MobileElement = null;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='fi.rahapaja.coiniverse.qa:id/buttonCloseTemplate']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement closeIcon;
	private String closeIconTxt = "Popup Close Icon";

	public WelcomeModelPage click_On_CloseIcon() {
		clickIfDisplayedWithRetry(closeIcon, closeIconTxt,2);
		return this;
	}

}
