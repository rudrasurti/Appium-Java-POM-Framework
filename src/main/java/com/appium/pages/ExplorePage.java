/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.appium.base.BasePage;
import com.appium.components.MenuPage;
import com.appium.manager.DriverManager;
import com.appium.pages.ShopPage;
import com.appium.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class ExplorePage extends BasePage {

	private static final String MobileElement = null;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@resource-id, 'auth_stack_view_2')])[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement exploreIcon;
	private String exploreIconTxt = "Explore Icon";

	// By Location Section
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='browse_screen_flatlist_45']/android.view.ViewGroup/android.view.ViewGroup[position() >= 2]//*[contains(@class, 'android.widget.TextView')]")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> allPlaceNames;
	private String allPlaceNamesTxt = "All Location Name";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_country_list_card_1_browse_screen_country_list_card_2_1_2']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement ATOZ;
	private String ATOZTxt = "By Location > A-Z";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='browse_screen_view_1_0_0']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement europePage;
	private String europePageTxt = "Europe Page";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='coins_screen_text_10']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement europeHeder;
	private String europeHederTxt = "Europe Location";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='icon_button_3_coins_screen_icon_button_9']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement backButton;
	private String backButtonTxt = "Back Button";

	// Coin Value Section
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='spinner_button_small_8']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement exploreClub;
	private String exploreClubTxt = "Explore Club";

	// By Category Sections
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_browse_screen_button_header_bar_20']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement categorySection;
	private String categorySectionTxt = "By Category Section";

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='browse_screen_flatlist_50']/android.view.ViewGroup/android.view.ViewGroup[2]//*[contains(@class,'android.widget.TextView')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private List<MobileElement> bycategorySectionAllElement;
	private String bycategorySection = "By category Section Element";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='browse_screen_view_4_0_0']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement recentlyAdded;
	private String recentlyAddedTxt = "Recently Added ";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='browse_screen_time_text_8_0_0']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement selectAncient;
	private String selectAncientTxt = "Select Ancient";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_icon_button_coins_screen_icon_button_9']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement backButtonForTimePeriod;
	private String backButtonForTimePeriodTxt = "Back Button For Time Period";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_country_list_card_1_browse_screen_country_list_card_5_0_2']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement historicalRegions;
	private String historicalRegionsTxt = "Historical Regions";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='browse_screen_render_item_0_31']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement selectHistoricalRegionFirst;
	private String selectHistoricalRegionFirstTxt = "Select Historical Regions First";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='icon_button_3_coins_screen_icon_button_9']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement backIconOfHistoricalregions;
	private String backIconOfHistoricalregionsTxt = "Back <";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_country_list_card_1_browse_screen_country_list_card_5_0_1']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement timePeriod;
	private String timePeriodTxt = "Time Period";

	private MenuPage menuPage;
	private AllCoinsPage allCoinsPage;
	private CoinsDetailsPage coinsDetailsPage;
	private MyCoinsPage myCoinsPage;
	private AddToWishlistPage addToWishlistPage;

	public ExplorePage() {
		super();
		// Composition
		menuPage = new MenuPage();

	}

	public AllCoinsPage getAllCoinsPage() {
		if (allCoinsPage == null)
			allCoinsPage = new AllCoinsPage();
		return allCoinsPage;
	}

	public CoinsDetailsPage getCoinsDetailsPage() {
		if (coinsDetailsPage == null)
			coinsDetailsPage = new CoinsDetailsPage();
		return coinsDetailsPage;
	}

	public AddToWishlistPage getAddToWishlistPage() {
		if (addToWishlistPage == null)
			addToWishlistPage = new AddToWishlistPage();
		return addToWishlistPage;
	}
	
	public MyCoinsPage getMyCoinPage() {
		if (myCoinsPage == null)
			myCoinsPage = new MyCoinsPage();
		return myCoinsPage;
	}

	//  Explore Screen
	public ExplorePage check_Navigate_ExploreScreen() {
		menuPage.click_OnTheExplore();
		click(exploreIcon, exploreIconTxt);
		return this;
	}	

	// By Location Section
	public ExplorePage check_Navigation_EuropeLocation() {
		click(europePage, europePageTxt);
		scrollToElement(backButton, 2, backButtonTxt, "up");
		click(backButton, backButtonTxt);
		return this;
	}

	public ExplorePage getAllLocationNameAndValidate() {
		getTextValues(allPlaceNames, allPlaceNamesTxt);
		return new ExplorePage();
	}

	public ExplorePage click_byLocationATOZ_AndCountry(String countyName) {
		click(ATOZ, ATOZTxt);
		sleep(2);
		MobileElement elementName = (MobileElement) DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@text='" + countyName + "']"));
		click(elementName, countyName);
		return this;
	}

	// Coin Value Section
	public ExplorePage scrollDown_ToCoinValueSection() {
		scrollToElement(exploreClub, 2, exploreClubTxt, "down");
		return this;
	}

	public ExplorePage click_Navigation_ExploreClub() {
		clickElementAndBack(exploreClub, exploreClubTxt);
		return this;
	}

	// By Category Section
	public ExplorePage scrollDown_CategorySection() {
		scrollToElement(categorySection, 3, categorySectionTxt, "down");
		return this;
	}

	public ExplorePage getBycategorySectionAndValidate() {
		getTextValues(bycategorySectionAllElement, bycategorySection);
		return new ExplorePage();
	}

	public ExplorePage check_Navigate_RecentlyAddedCarousel_CategorySection() {
		clickElementAndBack(recentlyAdded, recentlyAddedTxt);
		return this;
	}
	
	public ExplorePage check_Navigate_TimePeriodCarousel_CategorySection(){
		click(timePeriod, timePeriodTxt);
		return this;
	}

	public ExplorePage check_Navigate_selectFirstTimePeriod_CategorySection() {
		clickElementAndBack(selectAncient, selectAncientTxt);
		scrollToElement(backButtonForTimePeriod, 3, backIconOfHistoricalregionsTxt, "up");
		click(backButtonForTimePeriod, backButtonForTimePeriodTxt);
		return this;
	}

	public ExplorePage check_Navigate_HistoricalRegions()  {
		click(historicalRegions, historicalRegionsTxt);
		return this;
	}

	public ExplorePage check_Navigation_SelectFirstHistoricalRegions()  {
		clickElementAndBack(selectHistoricalRegionFirst, selectHistoricalRegionFirstTxt);
		scrollToElement(backIconOfHistoricalregions, 3, backIconOfHistoricalregionsTxt, "up");
		click(backIconOfHistoricalregions, backIconOfHistoricalregionsTxt);
		return this;
	}

	// Add to Collection Button
	public ExplorePage AddCoinToContry(String countyName)  {
		click_byLocationATOZ_AndCountry(countyName);
		getAllCoinsPage().click_FirstCoin();
		getCoinsDetailsPage().click_AddToCollectionButton();
		sleep(5);
		getCoinsDetailsPage().click_Model_AddToCollectionButton();
		sleep(8);
		getCoinsDetailsPage().click_BackIcon();
		sleep(3);
		getAllCoinsPage().click_BackIcon();
		click(backButton, backButtonTxt);
		return this;
	}

	// Add and remove coin from specific Collection 
	public ExplorePage AddAndRemoveCoinsFromCollection(String collectionName,String collectionDescription, String countyName){
		menuPage.click_OnTheMyCoins();
		getMyCoinPage().scrollDown_AddNewCollectionSection();
		getMyCoinPage().createNew_CollectionName(collectionName, collectionDescription);
		menuPage.click_OnTheExplore();
		click_byLocationATOZ_AndCountry(countyName);
		getAllCoinsPage().click_FirstCoin();
		getCoinsDetailsPage().click_AddToCollectionButton();
		sleep(5);
		getCoinsDetailsPage().click_Model_AddToCollectionButton(collectionName);
		sleep(8);
		getCoinsDetailsPage().click_BackIcon();
		sleep(3);
		getAllCoinsPage().click_BackIcon();
		click(backButton, backButtonTxt);
		menuPage.click_OnTheMyCoins();
		getMyCoinPage().check_And_DeleteExistingCoinsFromCountry(countyName);
		getMyCoinPage().check_AndDeletetExitingCollection(collectionName);
		return this;
	}

	// Wishlist
	public ExplorePage AddCoinToWishlist(String countyName)  {
		click_byLocationATOZ_AndCountry(countyName);
		getAllCoinsPage().click_FirstCoin();
		getCoinsDetailsPage().click_Wishlist();
		getAddToWishlistPage().click_Add();
		sleep(8);
		getCoinsDetailsPage().click_BackIcon();
		getAllCoinsPage().click_BackIcon();
		click(backButton, backButtonTxt);
		return this;
	}

	// Likes
	public ExplorePage AddCoinToLikes(String countyName){
		click_byLocationATOZ_AndCountry(countyName);
		getAllCoinsPage().click_FirstCoin();
		getCoinsDetailsPage().click_Like();
		sleep(8);
		getCoinsDetailsPage().click_BackIcon();
		getAllCoinsPage().click_BackIcon();
		click(backButton, backButtonTxt);
		return this;
	}
}