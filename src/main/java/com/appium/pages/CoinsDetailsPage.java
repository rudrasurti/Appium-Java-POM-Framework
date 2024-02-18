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

import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class CoinsDetailsPage extends BasePage {

	private static final String MobileElement = null;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='coin_details_screen_touchable_opacity_12']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement adToCollectionButton;
	private String addToCollectionButtonText = "Add to collection";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='like_button_3']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement likeButton;
	private String likeButtonText = "Like";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='wishlist_button_2']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement addToWishlist;
	private String addToWishlistText = "Add to wishlist";

	// model xpath
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_dropdown_single_picker_13_add_to_collection_modal_20']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement selectCollectionDropdownArrow;
	private String selectCollectionDropdownArrowText = "Model - select Collection Dropdown Arrow";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='dropdown_single_picker_27_add_to_collection_modal_20']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement selectCollectionInput;
	private String selectCollectionInputText = "Model - Select Collection";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button_add_to_collection_modal_32']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement modelAddToCollection;
	private String modelAddToCollectionText = "Model - Add To Collection";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_icon_button_navbar_collapsed_5_coin_details_screen_navbar_119']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement backIcon;
	private String backIconText = "< Back Icon";

	// my coins page > Coins details page
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@content-desc,'button_icon_button_coin_details_screen_render_my_collection_icon_button')])[last()]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement meatballsMenu;
	private String meatballsMenuText = "Meatballs Menu";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button_dialog_modal_5_coin_details_screen_dialog_modal_button_117_2']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement removeCoin;
	private String removeCoinText = "Remove Coin";

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement dailogRemoveButton;
	private String dailogDeleteButtonText = "Dialogue box > Remove Button";

	private MenuPage menuPage;
	private ExplorePage explorePage;
	private AllCoinsPage allCoinsPage;
	private MyCoinsPage myCoinsPage;
	private WishlistPage wishlistPage;
	private LikedListPage likedListPage;

	public CoinsDetailsPage() {
		super();
		menuPage = new MenuPage();
	}

	public MenuPage getMenuPage() {
		return menuPage;
	}

	public ExplorePage getExplorePage() {
		if (explorePage == null)
			explorePage = new ExplorePage();
		return explorePage;
	}

	public AllCoinsPage getallCoinsPage() {
		if (allCoinsPage == null)
			allCoinsPage = new AllCoinsPage();
		return allCoinsPage;
	}

	public MyCoinsPage getMyCoinsPage() {
		if (myCoinsPage == null)
			myCoinsPage = new MyCoinsPage();
		return myCoinsPage;
	}

	public WishlistPage getWishlistPage() {
		if (wishlistPage == null)
			wishlistPage = new WishlistPage();
		return wishlistPage;
	}

	public LikedListPage getLikedListPage() {
		if (likedListPage == null)
			likedListPage = new LikedListPage();
		return likedListPage;
	}

	public CoinsDetailsPage click_AddToCollectionButton() {
		click(adToCollectionButton, addToCollectionButtonText);
		return this;
	}

	// Select collection
	public CoinsDetailsPage click_Model_AddToCollectionButton() {
		click(modelAddToCollection, modelAddToCollectionText);
		return this;
	}

	public CoinsDetailsPage click_Model_AddToCollectionButton(String colloctionName) {
		click(selectCollectionDropdownArrow, selectCollectionDropdownArrowText);
		sendKeys(selectCollectionInput, selectCollectionInputText, colloctionName);
		sleep(3);
		MobileElement elementName = (MobileElement) DriverManager.getDriver()
				.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + colloctionName + "')]"));

		click(elementName, colloctionName);
		click_Model_AddToCollectionButton();
		hideKeyboard();
		return this;
	}

	public CoinsDetailsPage click_BackIcon() {
		click(backIcon, backIconText);
		return this;
	}

	// wishlistButton
	public CoinsDetailsPage click_Wishlist() {
		click(addToWishlist, addToWishlistText);
		return this;
	}

	// Like Button
	public CoinsDetailsPage click_Like() {
		click(likeButton, likeButtonText);
		return this;
	}

	// my coins page > Coins details page
	public CoinsDetailsPage click_MeatballsMenu() {
		scrollToElement(meatballsMenu, 3, meatballsMenuText, "down");
		click(meatballsMenu, meatballsMenuText);
		return this;
	}

	public CoinsDetailsPage click_removeCoin() {
		click(removeCoin, removeCoinText);
		return this;
	}

	public CoinsDetailsPage click_dailogRemoveButton() {
		click(dailogRemoveButton, dailogDeleteButtonText);
		return this;
	}

	// Wishlist
	public CoinsDetailsPage check_AddAndRemoveCoinFromWishlist(String courtyName) {
		getExplorePage().check_Navigate_ExploreScreen();
		getExplorePage().AddCoinToWishlist(courtyName);
		menuPage.click_OnTheMyCoins();
		getMyCoinsPage().scrollDown_Wishlist().click_Navigate_Wishlist();
		getWishlistPage().click_RemoveFromwishlist(courtyName);
		return this;
	}

	// Link
	public CoinsDetailsPage click_AddAndRemoveCoinFromLinks(String courtyName){
		getExplorePage().check_Navigate_ExploreScreen();
		getExplorePage().AddCoinToLikes(courtyName);
		menuPage.click_OnTheMyCoins();
		getMyCoinsPage().scrollDown_Likes().click_Navigate_Likes();
		getLikedListPage().click_RemoveCoinFromLikes(courtyName);
		return this;
	}

	// Add and remove coin to specific Collection Button
	public CoinsDetailsPage AddCoinToContryWithCollectionName(String collectionName, String CollectionDescription,
			String countyName) throws InterruptedException {
		getExplorePage().AddAndRemoveCoinsFromCollection(collectionName, CollectionDescription, countyName);
		return this;
	}

	// Activate And Deactivate Ready template
	public CoinsDetailsPage check_ActivateAndDeactiveReadytemplate() {
		getMyCoinsPage().scrollDown_BrowseTemplatesSection();
		getMyCoinsPage().check_ActivateAndDeactiveReadytemplate();
		return this;
	}

	public CoinsDetailsPage check_ShowAllAndCloseAllOnAllCoinPage() {
		menuPage.click_OnTheMyCoins();
		getMyCoinsPage().click_ShowAllAndCloseAll();
		return this;
	}

	// Filter
	public CoinsDetailsPage check_Filter_CoinTypeWithRegular() {
		menuPage.click_OnTheMyCoins();
		getMyCoinsPage().scrollDown_MyCoins().click_Navigate_MycoinsCarousel();
		getallCoinsPage().check_FilterWithCoinTypeWithRegular();
		return this;
	}

	public CoinsDetailsPage check_Filter_CoinTypeWithCommemorative() {
		menuPage.click_OnTheMyCoins();
		getMyCoinsPage().scrollDown_MyCoins().click_Navigate_MycoinsCarousel();
		getallCoinsPage().check_FilterWithCoinTypeWithCommemorative();
		return this;
	}
}
