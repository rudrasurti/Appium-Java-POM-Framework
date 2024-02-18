/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.components;

import com.appium.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MenuPage extends BasePage {

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@resource-id, 'auth_stack_view_2')])[1]")
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement home;
	private String homeTxt = "Home";

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@resource-id, 'auth_stack_view_2')])[2]")
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement Explore;
	private String ExploreTxt = "Explore";
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@resource-id, 'auth_stack_view_2')])[3]")
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement myCoins;
	private String myCoinsTxt = "My Coins";

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@resource-id, 'auth_stack_view_2')])[4]")
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement shop;
	private String shopTxt = "Shop";

	
	public MenuPage() {
		super();
		// Composition
	}
	
	public MobileElement getHome() {
		return home;
	}

	public String getHomeTxt() {
		return homeTxt;
	}

	public void setHomeTxt(String homeTxt) {
		this.homeTxt = homeTxt;
	}

	public MenuPage click_OnTheHome(){
		click(getHome(), homeTxt);
		return this;
	}
	
	public MenuPage click_OnTheExplore()  {
		click(Explore, ExploreTxt);
		return this;
	}

	
	public MenuPage click_OnTheMyCoins() {
		click(myCoins, myCoinsTxt);
		return this;
	}
	
	public MenuPage click_OnTheShop(){
		click(shop, shopTxt);
		return this;
	}

	
}
