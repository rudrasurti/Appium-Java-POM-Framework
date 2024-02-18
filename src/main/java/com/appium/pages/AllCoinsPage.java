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

public class AllCoinsPage extends BasePage {

	private static final String MobileElement = null;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"collection_all_coins_screen_view_23\"]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.ImageView")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement closeIcon;
	private String closeIconText = "Close Icon";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='coin_details_screen_touchable_opacity_12']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement adToCollectionButton;
	private String addToCollectionButtonText = "Add to collection";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button_add_to_collection_modal_32']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/X CUIElementTypeOther[not(@name)]")
	private MobileElement adToCollectionModelButton;
	private String addToWishlistModelText = "Model > Add to collection";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='navbar_collapsed_4_coin_regular_screen_navbar_collapsed_11']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement backIcon;
	private String backIconText = "< Back Icon";

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='button_coin_browse_list_card_2_coin_regular_screen_coin_browser_list_card_0_2'])[1]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement firstCoin;
	private String firstCoinText = "Explore Page > First Coin";

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='button_coin_section_list_card_3_collection_all_coins_screen_coin_section_list_card_121_default'])[1]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement myConisPagefirstCoin;
	private String myConisPagefirstCoinText = "My conis Page > First Coin";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='collection_all_coins_screen_image_18']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement showAllButon;
	private String showAllButonText = "Show All";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='collection_all_coins_screen_image_18']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement closeAllButon;
	private String closeAllButonText = "Close All";

	// Sort
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_list_header_actions_21_navbar_collapsed_22_collection_all_coins_screen_navbar_collapsed_24']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement sortButton;
	private String sortButtonText = "Sort";
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_sort_selection_modal_0_4']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement yearNewToOld;
	private String yearNewToOldText = "Sort - Year: New to old";
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_sort_selection_modal_1_4']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement yearOldToNew;
	private String yearOldToNewText = "Sort - Year: Old to new";
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_sort_selection_modal_1_4']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement faceHighToLow;
	private String faceHighToLowText = "Sort - Face value: High to low";
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_sort_selection_modal_3_4']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement faceLowToHigh;
	private String faceLowToHighText = "Sort - Face value: Low to high";
	
	

	// Filter Xpath
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_list_tab_selector_3_navbar_collapsed_22_collection_all_coins_screen_navbar_collapsed_24']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement filterButton;
	private String filterButonText = "Filter";

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='icon_button_3_filter_modal_23'])[1]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement yearButton;
	private String yearText = "Filter - Year";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='filter_modal_10']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement yearInput;
	private String yearInputText = "Year or time period";

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='icon_button_3_filter_modal_23'])[2]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement faceValueButton;
	private String faceValueButtonText = "Filter - Face value";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='filter_modal_14']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement faceValueInput;
	private String faceValueInputText = "Face value";

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='icon_button_3_filter_modal_23'])[3]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement coinTypeButton;
	private String coinTypeButtonText = "Filter - Coin type";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_icon_button_filter_modal_3_default']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement regularButton;
	private String regularButtonText = "Coin type - Regular";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_icon_button_filter_modal_3_1']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement commemorativeButton;
	private String commemorativeButtonText = "Coin type - Commemorative";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_filter_modal_42']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement showresultsButton;
	private String showresultsButtonText = "Show results";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_icon_button_navbar_collapsed_10_collection_all_coins_screen_navbar_collapsed_24']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement clearFliter;
	private String clearFlitersButtonText = "Clear Fliter";

	private MenuPage menuPage;

	public AllCoinsPage() {
		super();
		// Composition
		menuPage = new MenuPage();
	}

	public MenuPage getMenuPage() {
		return menuPage;
	}

	public AllCoinsPage click_CloseIcon() {
		clickIfDisplayedWithRetry(closeIcon, closeIconText, 2);
		return this;
	}

	public AllCoinsPage click_CountryName(String countryName) {
		MobileElement elementName = (MobileElement) DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'" + countryName + "')]"));
		scrollToElement(elementName, 3, countryName, "down");
		click(elementName, countryName);
		return this;
	}

	public AllCoinsPage click_BackIcon() {
		click(backIcon, backIconText);
		return this;
	}

	public AllCoinsPage click_FirstCoin() {
		click(firstCoin, firstCoinText);
		return this;
	}

	public AllCoinsPage click_FirstCoinsOfMyCoinPage() {
		click(myConisPagefirstCoin, myConisPagefirstCoinText);
		return this;
	}

	public AllCoinsPage check_ShowAllAndCloseAll() {
		click(showAllButon, showAllButonText);
		sleep(3);
		click(closeAllButon, closeAllButonText);
		return this;
	}
	
	//Sort
	public AllCoinsPage check_Sort_YearNewToOld() {
		click(sortButton,sortButtonText);
		click(yearNewToOld,yearNewToOldText);
		return this;
	}

	public AllCoinsPage check_Sort_YearOldToNew() {
		click(sortButton,sortButtonText);
		click(yearOldToNew, yearOldToNewText);
		return this;
	}

	public AllCoinsPage check_Sort_FaceValueHighToLow() {
		click(sortButton,sortButtonText);
		click(faceHighToLow,faceHighToLowText);
		return this;
	}

	public AllCoinsPage check_Sort_FaceValueLowToHigh() {
		click(sortButton,sortButtonText);
		click(faceLowToHigh, faceLowToHighText);
		return this;
	}
	
	// Filter
	public AllCoinsPage check_FilterWithYear(String year) {
		click(filterButton, filterButonText);
		click(yearButton, yearText);
		sendKeys(yearInput, yearInputText, year);
		click(showAllButon, showAllButonText);
		click(clearFliter, clearFlitersButtonText);
		navigateBack();
		return this;
	}

	public AllCoinsPage check_FilterWithFaceValue(String faceValue) {
		click(filterButton, filterButonText);
		click(faceValueButton, faceValueButtonText);
		sendKeys(faceValueInput, faceValueInputText, faceValue);
		click(showAllButon, showAllButonText);
		click(clearFliter, clearFlitersButtonText);
		navigateBack();
		return this;
	}

	public AllCoinsPage check_FilterWithCoinTypeWithRegular() {
		click(filterButton, filterButonText);
		click(coinTypeButton, coinTypeButtonText);
		click(regularButton, regularButtonText);
		click(showresultsButton, showresultsButtonText);
		click(showAllButon, showAllButonText);
		click(clearFliter, clearFlitersButtonText);
		navigateBack();
		return this;
	}

	public AllCoinsPage check_FilterWithCoinTypeWithCommemorative() {
		click(filterButton, filterButonText);
		click(coinTypeButton, coinTypeButtonText);
		click(commemorativeButton, commemorativeButtonText);
		click(showresultsButton, showresultsButtonText);
		click(showAllButon, showAllButonText);
		click(clearFliter, clearFlitersButtonText);
		navigateBack();
		return this;
	}

}