/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.pages;

import com.appium.base.BasePage;
import com.appium.components.MenuPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProfilePage extends BasePage {
	private static final String MobileElement = null;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.ImageView)[last()]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement closeIcon;
	private String closeIconTxt = "Popup Close Icon";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='avatar_7']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement profileIcon;
	private String profileIconText = "Profile Icon";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='collection_my_profile_screen_image_34']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement editIcon;
	private String editIconText = "Edit Icon";

	// Set your profile visible to other users Toggle Button
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='profile_screen_22']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement profileVisibility;
	private String profileVisibilityText = "Profile Visibilty";

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='mintage_switch_3_profile_screen_23']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement setProfileToggle;
	private String setProfileToggleText = "Set Profile Icon";

	// UserName Text Field
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_profile_screen_39']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement userName;
	private String userNameText = "User Name";

	// Country Section
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='dropdown_single_picker_18']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement countryDropDown;
	private String countryDropDownText = "Country Drop Down";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id= 'dropdown_single_picker_27']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement countryTextBox;
	private String countryText = "Country Text";

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='button_1'])[3]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement countrySelect;
	private String countrySelectText = "Country Options";

	// Description Sections
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='mintage_text_input_3_profile_screen_27']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement descriptionTitle;
	private String descriptionTitleText = "Description Title ";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='profile_screen_27']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement descriptionBox;
	private String descriptionBoxText = "Enter the Description ";

	// Interests Section
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='icon_button_3'])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement forwardButton;
	private String forwardButtonIconText = "Forward Button";

	@AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='profile_screen_27']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement interstsList;
	private String interstsListText = "Select Intersts List Text";

	// Update Button
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_profile_screen_39']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement updateButton;
	private String updateButtonText = "Update Button Text";

	// Name Sections
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='profile_screen_41']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement nameBox;
	private String nameBoxText = "Name";

	// Email Section
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='mintage_text_input_6']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement changeEmail;
	private String changeEmailText = "Change Email";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='modify_email_modal_9']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement newEmailBox;
	private String newEmailBoxText = "New Email ";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='modify_email_modal_10']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement confirmEmailBox;
	private String confirmEmailBoxText = "Confirm Email";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='modify_email_modal_12']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement changeButton;
	private String changeButtonText = "Change Button For Email";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='icon_button_3_modify_email_modal_7']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement closeButton;
	private String closeButtonText = "Close Button On Email Popup";

	// App Language Section
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='language_selector_1']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement appLangauge;
	private String appLangaugeText = "App Language Heading";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='language_selector_1']//android.view.ViewGroup/android.widget.ImageView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement appLangaugeDropDown;
	private String appLangaugeDropDownText = "App Language";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='dropdown_single_picker_27_language_selector_2']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement appLangaugeFiled;
	private String appLangaugeFiledText = "App Language";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='dropdown_single_picker_0_4']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement selectRadioButton;
	private String selectRadioButtonText = "Select App Language";

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='mintage_switch_3_profile_screen_46']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement updateNewsEventFromCoinviverseToggle;
	private String updateNewsEventFromCoinviverseToggleText = "Toggle Button";

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='mintage_switch_3_profile_screen_47']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement pushNotificationToggle;
	private String pushNotificationToggleText = "Push Notification Toggle Button";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_profile_screen_48']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement updateButtonForOtherLangauge;
	private String updateButtonForOtherLangaugeText = "Update Button";

	// Password Section
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='profile_screen_52']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement currentPasswordBox;
	private String currentPasswordBoxTxt = "Current Password";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='profile_screen_53']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement newPasswordBox;
	private String newPasswordBoxText = "Change New Password";

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='profile_screen_54']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement confirmPasswordBox;
	private String confirmPasswordTxt = "Change Confirm Password";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_profile_screen_55']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement changeButtonForChangePassword;
	private String changeButtonForChangePasswordText = "Change Button";

	// FeedBack Section
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='profile_screen_58']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement giveFeedbackBox;
	private String giveFeedbackBoxText = "Feedback";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_profile_screen_59']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement sendButton;
	private String sendButtonText = "Send Button";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_profile_screen_2']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement logoutButton;
	private String logoutButtonTxt = "logout Button";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_spinner_button_9_profile_screen_2']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement confirmationLogoutButton;
	private String confirmationLogoutButtonText = "Confirm logout Button";

//   For Footer Section
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='link_with_tracking_transparency_3_profile_screen_8']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement termOfUse;
	private String termOfUseText = "Terns Of Use (EULA)";
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='ink_with_tracking_transparency_3_profile_screen_9']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement privacyPolicy;
	private String privacyPolicyText = "Privacy Policy";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='profile_screen_6']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement licenses;
	private String licensesText = "Licenses";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='profile_screen_11']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement cancellingPaidSubscription;
	private String cancellingPaidSubscriptionText = "Licenses";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='profile_screen_14']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement deleteAccount;
	private String deleteAccountText = "Delete Button";

	private MenuPage menuPage;
	private ShopPage shopPage;

	public ProfilePage() {
		super();
		// Composition
		menuPage = new MenuPage();
		shopPage = new ShopPage();
	}

	public MenuPage getMenuPage() {
		return menuPage;
	}

	public ShopPage getShopPage() {
		return shopPage;
	}

	// Profile Section
	public ProfilePage check_Navigation_ProfileIcon() {
		click(profileIcon, profileIconText);
		return this;
	}

	public ProfilePage check_Navigation_OfEditBox() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(editIcon, editIconText);
		return this;
	}

	// Profile Visibility Toggle Button
	public ProfilePage scrollUp_ToProfileVisibility() throws InterruptedException {
		scrollToElement(profileVisibility, 2, profileVisibilityText, "down");
		return this;
	}

	public ProfilePage check_Navigation_OfToggleButton() {
		click(setProfileToggle, setProfileToggleText);
		return this;
	}

	// Country Section
	// Description Section
	public ProfilePage scrollUp_ToDescriptionBox() throws InterruptedException {
		scrollToElement(descriptionTitle, 1, descriptionTitleText, "down");
		return this;
	}

	public ProfilePage check_NavigationAnd_EnterDescription(String descriptionValue) throws InterruptedException {
		sendKeys(descriptionBox, descriptionBoxText, descriptionValue);
		hideKeyboard();
		return this;
	}
	// Update Section

	public ProfilePage scrollDown_ToUpdateButton() throws InterruptedException {
		scrollDownWithTouch(100,"");
//		scrollToElement(updateButton, 3, updateButtonText, "down");
		return this;
	}

	public ProfilePage click_OnUpdateButton() throws InterruptedException {
		click(updateButton, updateButtonText);
		Thread.sleep(2000);
		return this;
	}

	// Name Filed
	public ProfilePage scrollDown_ToNameText() throws InterruptedException {
		scrollToElement(nameBox, 2, nameBoxText, "down");
		return this;
	}

	public ProfilePage check_NavigationAnd_EnterName(String nameValue) {
		sendKeys(nameBox, nameBoxText, nameValue);
		hideKeyboard();
		return this;
	}

	// Email Filed
	public ProfilePage check_NavigationAnd_EnterEmail(String newEmail, String confirmEmailEmail)throws InterruptedException {
		click(changeEmail, changeEmailText);
		sendKeys(newEmailBox, newEmailBoxText, newEmail);
		hideKeyboard();
		sleep(2);
		sendKeys(confirmEmailBox, confirmEmailBoxText, confirmEmailEmail);
		hideKeyboard();
		return this;
	}

	public ProfilePage click_OnEmailCloseIcon() {
		click(closeButton, closeButtonText);
		return this;
	}

	// App Language DropDown
	public ProfilePage scrollDown_ToAppLangauge() throws InterruptedException {
		scrollToElement(appLangauge, 2, appLangaugeText, "down");
		return this;
	}

	public ProfilePage check_NavigationAnd_ChangeAppLanguage(String appLangauge) throws InterruptedException {
		Thread.sleep(3000);
		click(appLangaugeDropDown, appLangaugeDropDownText);
		sendKeys(appLangaugeFiled, appLangaugeFiledText, appLangauge);
		click(selectRadioButton, selectRadioButtonText);
		return this;
	}

	public ProfilePage click_PushNotificationToggleButton() {
		click(pushNotificationToggle, pushNotificationToggleText);
		return this;
	}

	public ProfilePage click_updateButtonButtonForAppLagauage() {
		click(updateButtonForOtherLangauge, updateButtonForOtherLangaugeText);
		return this;
	}

	// Password Section
	public ProfilePage scrollDown_ToChangePassword() throws InterruptedException {
		scrollToElement(newPasswordBox, 1, newPasswordBoxText, "down");
		return this;
	}
	
	public ProfilePage check_NavigationAnd_EnterPassword(String currentPassword, String newPassword,
			String confirmPassword) {
		sendKeys(currentPasswordBox, currentPasswordBoxTxt, currentPassword);
		sendKeys(newPasswordBox, newPasswordBoxText, newPassword);
		sendKeys(confirmPasswordBox, confirmPasswordTxt, confirmPassword);
		return this;
	}

	// Change Button
	public ProfilePage click_OnChangeButton() {
		click(changeButtonForChangePassword, changeButtonForChangePasswordText);
		return this;
	}

	// Footer Section
	public ProfilePage scrollDown_ToLogoutButton() throws InterruptedException {
		scrollToElement(logoutButton, 8, logoutButtonTxt, "Down");
		return this;
	}

	public ProfilePage click_Navigation_ConfirmLogoutButton() throws InterruptedException {
		click(confirmationLogoutButton, confirmationLogoutButtonText);
		return this;
	}

	public ProfilePage click_OnLogOutButton() {
		click(logoutButton, logoutButtonTxt);
		return this;
	}

	public ProfilePage check_Navigation_TermsOfUse() throws InterruptedException {
		clickElementAndBack(privacyPolicy, privacyPolicyText);
		return this;
	}

	public ProfilePage check_Navigation_PricacyPolicy() throws InterruptedException {
		clickElementAndBack(privacyPolicy, privacyPolicyText);
		return this;
	}

	public ProfilePage check_Navigation_License() throws InterruptedException {
		clickElementAndBack(licenses, licensesText);
		return this;
	}

	public ProfilePage scrollDown_ToDelete() throws InterruptedException {
		scrollToElement(deleteAccount, 6, deleteAccountText, "down");
		return this;
	}

}
