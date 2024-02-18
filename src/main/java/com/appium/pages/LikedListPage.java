/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.pages;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

import com.appium.base.BasePage;
import com.appium.components.MenuPage;
import com.appium.manager.DriverManager;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LikedListPage extends BasePage {

	private static final String MobileElement = null;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement removeConfirmation;
	private String removeConfirmationText = "Confirmation > remove Button";


	private MenuPage menuPage;

	public LikedListPage() {
		super();
		// Composition
		menuPage = new MenuPage();
	}

	public MenuPage getMenuPage() {
		return menuPage;
	}
	
	public LikedListPage click_RemoveCoinFromLikes(String countryName) {
	    MobileElement elementName = (MobileElement) DriverManager.getDriver().findElement(By.xpath("(//android.view.ViewGroup[*[contains(@text, '"+countryName.toUpperCase()+"')]]/parent::*/following-sibling::android.view.ViewGroup)[1]/(.//android.widget.ImageView)[last()]/.."));
		scrollToElement(elementName, 2, countryName,"down");
	    click(elementName, countryName);
		click(removeConfirmation, removeConfirmationText);
		return this;
	}


}
