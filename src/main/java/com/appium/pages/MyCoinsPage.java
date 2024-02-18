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

public class MyCoinsPage extends BasePage {

	private static final String MobileElement = null;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='collection_my_profile_screen_image_34']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement editIcon;
	private String editIconText = "Profile > Edit Icon";

	// Badges Section
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='collection_my_profile_screen_image_47']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private List<MobileElement> badgeMoreIconList;
	private String badgeMoreIconListTxt = "Badge More Icon List";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='collection_my_profile_screen_image_47']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement badgeMoreIcon;
	private String badgeMoreIconTxt = "Badge More Button";

	// Add New Collection Sections
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_coin_collection_card_47_collection_my_profile_screen_coin_collection_card_72']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement addNewCollectionSections;
	private String addNewCollectionSectionsTxt = "Add New Collection";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='collection_form_screen_view_8']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement addCoverImage;
	private String addCoverImageTxt = "Add Cover Image";

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='collection_form_cover_selection_screen_fast_image_11'])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement addImage;
	private String addImageTxt = "Add Image";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='collection_form_screen_mintage_text_input_11']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement collectionName;
	private String collectionNameTxt = "Collection Name";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='collection_form_screen_mintage_text_input_12']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement description;
	private String descriptionTxt = "Description";

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='mintage_switch_3_collection_form_screen_mintage_switch_13']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement publicCollectionToggleButton;
	private String publicCollectionToggleButtonTxt = "Public Collection Toggle Button";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button_spinner_button_9_collection_form_screen_spinner_button_19']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement createButton;
	private String createButtonTxt = "Create Button";

	// Clam Code Card Section
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_collection_my_profile_screen_button_51']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement claimCodeCard;
	private String claimCodeCardTxt = "Clam Code Card";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='referral_code_modal_9']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement enterCupoonCode;
	private String enterCupoonCodeTxt = "Enter Cupon Code";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='spinner_button_10']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement submitButton;
	private String submitButtonTxt = "Submit Button";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='mintage_dropdown_alert_1']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private List<MobileElement> validMessageCouponCode;
	private String validMessageCouponCodeTxt = "Valid Message Shown";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button_collection_my_profile_screen_button_51']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private List<MobileElement> errorMessageCouponCode;
	private String errorMessageCouponCodeTxt = "Invalid Cupon Error Message Shown";

	// Statistics & Values Section
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='collection_value_free_user_1']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement statisticsAndValues;
	private String statisticsAndValuesTxt = "Statistics And Values";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='spinner_button_small_3_purchasely_component_2']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement statisticsAndValuesExploreClubCard;
	private String statisticsAndValuesExploreClubCardTxt = "Statistics And Values Explore Club Card";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='collection_value_subscribed_user_14']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement statisticsAndValuesMoreButton;
	private String statisticsAndValuesMoreButtonTxt = "Statistics And Values More Button";

	// My Coins Section
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='collection_my_profile_screen_touchable_opacity_61']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement myCoinsCarousel;
	private String myCoinsCarouselTxt = "My Coins Card";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='my_coins_screen_elements_9']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement myCoinsNumber;
	private String myCoinsNumberTxt = "Number of My Coins Count";

	// Wishlist Xpath
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='collection_my_profile_screen_touchable_opacity_63']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement Wishlist;
	private String WishlistTxt = "Wishlist Card";

	// Likes Xpath
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"collection_my_profile_screen_touchable_opacity_65\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement likes;
	private String likesText = "Likes Card";

	// Edit And Delete for new collection
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_coin_collection_card_1_collection_my_profile_screen_coin_collection_card_11_default']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement createdCollection;
	private String createdCollectionTxt = "Collection List";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='icon_button_3_navbar_collapsed_10_collection_coins_screen_navbar_collapsed_15']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement threeDotOfRightSide;
	private String threeDotOfRightSideTxt = "Three Dot Option On Right Side";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_dialog_modal_5_collection_coins_screen_dialog_modal_3_0']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement editCollection;
	private String editCollectionTxt = "Edit Collection";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_collection_form_screen_spinner_button_19']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement updateButton;
	private String updateButtonTxt = "Update Button ";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_collection_form_screen_button_17']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement deleteCollection;
	private String deleteCollectionTxt = "Delete Collection";

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement confirmDelete;
	private String confirmDeleteTxt = "Confirm Delete Button";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='icon_button_3_navbar_collapsed_5_collection_coins_screen_navbar_collapsed_15']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement backButton;
	private String backButtonTxt = "Back Button";

	// BROWSE TEMPLATES
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='collection_my_profile_screen_view_20']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement browseTemplatesSection;
	private String browseTemplatesSectionTxt = "Browse Templates Section";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button_coin_collection_card_52_collection_my_profile_screen_coin_collection_card_23_default']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement browseTemplatesFirst;
	private String browseTemplatesFirstTxt = "Browse Templates Section First";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_coin_collection_card_59_collection_my_profile_screen_coin_collection_card_23_default']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement browseTemplatesFirstActiveButton;
	private String browseTemplatesFirstActiveButtonTxt = "Browse Templates Section First > Active button";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button_icon_button_navbar_collapsed_10_collection_template_screen_navbar_collapsed_6']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement meatballsMenu;
	private String meatballsMenuTxt = "Meatballs Menu";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button_dialog_modal_5_collection_template_screen_dialog_modal_1_0']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement Deactivate;
	private String DeactivateButtonTxt = "Deactivate Button";

	private MenuPage menuPage;
	private AllCoinsPage allCoinsPage;
	private CoinsDetailsPage coinsDetailsPage;

	public MyCoinsPage() {
		super();
		// Composition
		menuPage = new MenuPage();
	}

	public MenuPage getMenuPage() {
		return menuPage;
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

	public MyCoinsPage check_Navigation_OfProfileIcon() {
		clickElementAndBack(editIcon, editIconText);
		return this;
	}

	// Badge Section
	public MyCoinsPage check_BadgesOneAndMore() {
		getTextValues(badgeMoreIconList, badgeMoreIconListTxt);
		return this;
	}

	public MyCoinsPage check_Navigation_OfMyCoins() {
		menuPage.click_OnTheMyCoins();
		return this;
	}

	public MyCoinsPage check_Navigation_OfBadges() {
		clickElementAndBack(badgeMoreIcon, badgeMoreIconTxt);
		return this;
	}

	// Add New Collection Section
	public MyCoinsPage scrollDown_AddNewCollectionSection() {
		scrollToElement(addNewCollectionSections, 6, addNewCollectionSectionsTxt, "down");
		return this;
	}

	public MyCoinsPage click_Navigate_AddNewCollection() {
		click(addNewCollectionSections, addNewCollectionSectionsTxt);
		return this;
	}

	public MyCoinsPage click_Navigate_AddCoverImage() {
		click(addCoverImage, addCoverImageTxt);
		return this;
	}

	public MyCoinsPage click_Navigate_AddImage() {
		click(addImage, addImageTxt);
		return this;
	}

	public MyCoinsPage enterCollectionName(String collectionValue) {
		click(collectionName, collectionNameTxt);
		sendKeys(collectionName, collectionNameTxt, collectionValue);
		hideKeyboard();
		return this;
	}

	public MyCoinsPage enter_Description(String descriptionValue) {
		click(description, descriptionTxt);
		sendKeys(description, descriptionTxt, descriptionValue);
		hideKeyboard();
		return this;
	}

	public MyCoinsPage click_PublicCollectionToggleButton() {
		click(publicCollectionToggleButton, publicCollectionToggleButtonTxt);
		return this;
	}

	public MyCoinsPage click_CreateButton() {
		sleep(2);
		click(createButton, createButtonTxt);
		return this;
	}

	/**
	 * Creates a new collection with the specified name and description.
	 *
	 * This method performs a sequence of actions, including navigating to add a new
	 * collection, adding a cover image, adding an image, entering the collection
	 * name and description, toggling the collection visibility to public, and
	 * finally, clicking the create button.
	 *
	 * @param collectionName        The name of the new collection.
	 * @param collectionDescription The description of the new collection.
	 * @return The MyCoinsPage representing the page after creating the new
	 *         collection.
	 * @throws InterruptedException If the execution is interrupted while waiting
	 *                              for an element to be present/visible.
	 */
	public MyCoinsPage createNew_CollectionName(String collectionName, String collectionDescription) {
		click_Navigate_AddNewCollection().click_Navigate_AddCoverImage().click_Navigate_AddImage()
				.enterCollectionName(collectionName).enter_Description(collectionDescription)
				.click_PublicCollectionToggleButton().click_CreateButton();
		return this;
	}

	// Clam Code Card Section
	public MyCoinsPage scrollDown_CodeSection() {
		sleep(2);
		scrollToElement(claimCodeCard, 2, claimCodeCardTxt, "down");
		return this;
	}

	public MyCoinsPage check_Navigation_ClamCodeCard() {
		click(claimCodeCard, claimCodeCardTxt);
		return this;
	}

	public MyCoinsPage enter_ValidCode(String validCode) {
		click(enterCupoonCode, enterCupoonCodeTxt);
		hideKeyboard();
		sendKeys(enterCupoonCode, enterCupoonCodeTxt, validCode);
		hideKeyboard();
		return this;
	}

	public MyCoinsPage pressSubmitButton() {
		sleep(2);
		click(submitButton, submitButtonTxt);
		return this;
	}

	public MyCoinsPage enter_InvalidCode(String invalidCode) {
		sendKeys(enterCupoonCode, enterCupoonCodeTxt, invalidCode);
		hideKeyboard();
		return this;
	}

	public MyCoinsPage validMessageShown() {
		getTextValues(validMessageCouponCode, validMessageCouponCodeTxt);
		return this;
	}

	public MyCoinsPage invalidMessageShown() {
		isDisplayed(errorMessageCouponCode, errorMessageCouponCodeTxt);
		return this;
	}

	/**
	 * Checks and validates a coupon code on the MyCoinsPage.
	 * 
	 * This method performs the following steps: 1. Navigates to the ClamCodeCard by
	 * invoking {@link #check_Navigation_ClamCodeCard()}. 2. Enters the provided
	 * valid coupon code using {@link #enter_ValidCode(String)}. 3. Presses the
	 * submit button to validate the coupon code.
	 * 
	 * @param validCouponCode The valid coupon code to be checked and validated.
	 * @return The MyCoinsPage instance after the coupon code validation.
	 * @throws InterruptedException If the execution is interrupted during the
	 *                              process.
	 */
	public MyCoinsPage check_And_ValidateCuponCode(String validCouponCode) {
		check_Navigation_ClamCodeCard().enter_ValidCode(validCouponCode).pressSubmitButton();
		return this;
	}

	/**
	 * Checks and validates an invalid coupon code on the MyCoinsPage.
	 * 
	 * This method performs the following steps: 1. Navigates to the ClamCodeCard by
	 * invoking {@link #check_Navigation_ClamCodeCard()}. 2. Enters the provided
	 * invalid coupon code using {@link #enter_InvalidCode(String)}. 3. Presses the
	 * submit button to validate the coupon code. 4. Verifies that the invalid
	 * message is shown on the page using {@link #invalidMessageShown()}.
	 * 
	 * @param invalidCode The invalid coupon code to be checked and validated.
	 * @return The MyCoinsPage instance after attempting to validate the invalid
	 *         coupon code.
	 * @throws InterruptedException If the execution is interrupted during the
	 *                              process.
	 */
	public MyCoinsPage check_And_ValidateInvalidCuponCode(String invalidCode) {
		check_Navigation_ClamCodeCard().enter_InvalidCode(invalidCode).pressSubmitButton().invalidMessageShown();
		return this;
	}

	// Statistics And Values Section
	public MyCoinsPage scrollDown_StatisticsAndValues() {
		scrollToElement(statisticsAndValues, 3, statisticsAndValuesTxt, "down");
		return this;
	}

	public MyCoinsPage check_Navigation_OfStatisticsAndValues() {
		clickElementAndBack(statisticsAndValues, statisticsAndValuesTxt);
		return this;
	}

	public MyCoinsPage check_Navigation_OfStatisticsAndValuesExploreClub() {
		clickElementAndBack(statisticsAndValuesExploreClubCard, statisticsAndValuesExploreClubCardTxt);
		return this;
	}

	public MyCoinsPage check_Navigation_OfStatisticsAndValuesMoreButton() {
		clickElementAndBack(statisticsAndValuesMoreButton, statisticsAndValuesMoreButtonTxt);
		return this;
	}

	// My Coins Carousel section
	public MyCoinsPage scrollDown_MyCoins() {
		scrollToElement(myCoinsCarousel, 4, myCoinsCarouselTxt, "down");
		return this;
	}

	public MyCoinsPage validate_TotalNumberOfMyCoins() {
		scrollToElement(myCoinsNumber, 2, myCoinsNumberTxt, "down");
		getText(myCoinsNumber, myCoinsNumberTxt);
		return this;
	}

	public MyCoinsPage click_Navigate_MycoinsCarousel() {
		click(myCoinsCarousel, myCoinsCarouselTxt);
		return this;
	}

	// Wishlist
	public MyCoinsPage scrollDown_Wishlist() {
		scrollToElement(Wishlist, 4, WishlistTxt, "down");
		return this;
	}

	public MyCoinsPage click_Navigate_Wishlist() {
		click(Wishlist, WishlistTxt);
		return this;
	}

	// Likes
	public MyCoinsPage scrollDown_Likes() {
		scrollToElement(likes, 4, likesText, "down");
		return this;
	}

	public MyCoinsPage click_Navigate_Likes() {
		click(likes, likesText);
		return this;
	}

	// Edit and Delete Collection Coins
	public MyCoinsPage click_OnExitingCollection() {
		click(createdCollection, createdCollectionTxt);
		return this;
	}

	public MyCoinsPage click_OnThreeDots() {
		click(threeDotOfRightSide, threeDotOfRightSideTxt);
		return this;
	}

	public MyCoinsPage click_OnEditCollection() {
		click(editCollection, editCollectionTxt);
		return this;
	}

	public MyCoinsPage click_UpadteButton() {
		click(updateButton, updateButtonTxt);
		return this;
	}

	public MyCoinsPage click_deleteButton() {
		click(deleteCollection, deleteCollectionTxt);
		return this;
	}

	public MyCoinsPage click_confirmDelete() {
		click(confirmDelete, confirmDeleteTxt);
		return this;
	}

	public MyCoinsPage click_OnBackButton() {
		click(backButton, backButtonTxt);
		return this;
	}

	// All Coin page show all and close all
	public MyCoinsPage click_ShowAllAndCloseAll() {
		scrollDown_MyCoins().click_Navigate_MycoinsCarousel();
		getAllCoinsPage().check_ShowAllAndCloseAll();
		navigateBack();
		return this;
	}

	// Collection
	public MyCoinsPage check_AndEdidtAddNewCollection(String collectionDescription) {
		scrollDown_AddNewCollectionSection().click_OnExitingCollection().click_OnThreeDots().click_OnEditCollection()
				.enter_Description(collectionDescription).click_UpadteButton().check_Navigation_OfMyCoins();
		return this;
	}

	public MyCoinsPage check_AndDeletetExitingCollection() {
		click_OnExitingCollection().click_OnThreeDots().click_OnEditCollection().click_deleteButton()
				.click_confirmDelete();
		return this;
	}

	public MyCoinsPage check_AndDeletetExitingCollection(String collectionName) {
		scrollToElement(addNewCollectionSections, 4, addNewCollectionSectionsTxt, "down");
		MobileElement elementName = (MobileElement) DriverManager.getDriver()
				.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + collectionName + "')]"));
		scrollToElement(elementName, 3, collectionName, "down");
		click(elementName, collectionName);
		click_OnThreeDots().click_OnEditCollection().click_deleteButton().click_confirmDelete();
		return this;
	}

	// My cards
	public MyCoinsPage check_And_DeleteExistingCoinsFromCountry(String countyName) {
		scrollDown_MyCoins();
		click_Navigate_MycoinsCarousel();
		getAllCoinsPage().click_CountryName(countyName);
		getAllCoinsPage().click_FirstCoinsOfMyCoinPage();
		sleep(2);
		getAllCoinsPage().click_CloseIcon();
		getCoinsDetailsPage().click_MeatballsMenu();
		sleep(2);
		getCoinsDetailsPage().click_removeCoin();
		getCoinsDetailsPage().click_dailogRemoveButton();
		navigateBack();
		sleep(2);
		navigateBack();
		return this;
	}

	// Wishlist
	public MyCoinsPage check_AddAndRemoveCoinFromWishlist() {
		scrollDown_Wishlist().click_Navigate_Wishlist();
		return this;
	}

	// Likes
	public MyCoinsPage check_AddAndRemoveCoinFromLike() {
		scrollDown_Likes().click_Navigate_Likes();
		return this;
	}

	// Browse Templates Section
	public MyCoinsPage scrollDown_BrowseTemplatesSection() {
		scrollToElement(browseTemplatesSection, 8, browseTemplatesSectionTxt, "down");
		return this;
	}

	public MyCoinsPage check_ActivateAndDeactiveReadytemplate() {
		click(browseTemplatesFirstActiveButton, browseTemplatesFirstActiveButtonTxt);
		sleep(3);
		scrollToElement(browseTemplatesFirst, 8, browseTemplatesFirstTxt, "down");
		click(browseTemplatesFirst, browseTemplatesFirstTxt);
		sleep(5);
		click(meatballsMenu, meatballsMenuTxt);
		sleep(5);
		click(Deactivate, DeactivateButtonTxt);
		return this;
	}
}
