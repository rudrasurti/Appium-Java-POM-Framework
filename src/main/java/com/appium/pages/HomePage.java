/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.pages;

import java.awt.Menu;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

import com.appium.base.BasePage;
import com.appium.components.MenuPage;
import com.appium.manager.DriverManager;
import com.appium.pages.ShopPage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class HomePage extends BasePage {
	private static final String MobileElement = null;

	// Notification
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='home_screen_touchable_opacity_13']")
	// @iOSXCUITFindBy(xpath =
	// "//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement notifications;
	private String notificationsTxt = "Notification";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='avatar_7']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement profileIcon;
	private String profileIconText = "Profile Icon";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='home_screen_text_11']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Hello')]")
	private MobileElement homeTitle;
	private String homeTitleTxt = "Home Title";

	// All Carousel
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_home_screen_button_20']")
	// @iOSXCUITFindBy(xpath =
	// "//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement coinsInCollectionCard;
	private String coinsInCollectionCardLink = "Coins In Collection";

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='home_screen_view_17']//*[(android.widget.TextView and android.widget.ImageView)])[position() >= 2]")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> quickButtons;
	private String quickButtonsTxt = "All Collection Card";

	// New Products Sections
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='shop_screen_19']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement shopHeader;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='home_screen_view_66']")
	// @iOSXCUITFindBy(xpath////
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement newProductsSection;
	private String newProductsSectionTxt = "Scroll Down to the New Product Section";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='home_screen_view_66']/following-sibling::*/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> newProductsCarousel;
	private String newProductsCarouselTxt = "New Products Carousel Cards";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='shop_screen_6']/following-sibling::*/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> newProductsCard;
	private String newProductsCardTxt = "New Products Carousel Cards";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='button_home_screen_button_70']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement newProductsSectionVeiwMoreButton;
	private String newProductsSectionVeiwMoreButtonTxt = "View More Link For New Peoduct Section";

	// Release Calendar
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='event_card_19_home_screen_event_card_74']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement releaseCalendarSection;
	private String releaseCalendarSectionTxt = "Release Calendar Section";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='event_card_24_home_screen_event_card_74']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement calendarIcon;
	private String calendarIconTxt = "Calender Icon";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"icon_button_3_navbar_collapsed_5_mintage_web_view_3_home_screen_mintage_web_view_96\"]")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement closeIconOfNextIcon;
	private String closeIconOfNextIconTxt = "Close Icon for Release Calender Section";

	// News And Highlights Section
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='home_screen_text_78']")
	// @iOSXCUITFindBy(xpath//
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement newsAndHighlightsSection;
	private String newsAndHighlightsSectionTxt = "News And Highlights Sections";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='event_pro_tab_1']/following-sibling::android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath//
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> rightSwipShowAll;
	private String rightSwipShowAllTxt = "Right Swipe All";

	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath//
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> newsAndHighlightsCarousel;
	private String newsAndHighlightsCarouselTxt = "New And Highlights Carouse Cards";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='event_pro_tab_4']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement clubCard;
	private String clubCardTxt = "Club Card";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='event_card_9_home_screen_event_card_0_59']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement selectClubCard;
	private String selectClubCardTxt = "Show All Card";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='event_card_9_home_screen_event_card_0_59']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement selectShowAllCard;
	private String selectShowAllCardTxt = "Show All Card";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='icon_button_3_navbar_collapsed_5_mintage_web_view_3_home_screen_mintage_web_view_96']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement closeIconForClubCard;
	private String closeIconForClubCardTxt = "Close Icon Club Card";

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='icon_button_3_navbar_collapsed_5_mintage_web_view_3_home_screen_mintage_web_view_96']")
	// @iOSXCUITFindBy(xpath//
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement closeIconForShowAll;
	private String closeIconForShowAllTxt = "Close Icon For Show All Card";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='event_pro_tab_6']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement showAllCard;
	private String showAllCardTxt = "Show All Card";

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id, 'event_card_11_home_screen_event_card')]")
	// @iOSXCUITFindBy(xpath//
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> clubTag;
	private String clubTagTxt = "Club Tag";

	// New Coins In Database
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='home_screen_view_81']/following-sibling::android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> newCoinsInDatabaseCarousel;
	private String newCoinsInDatabaseCarouselTxt = "New Coins In Database Carousel cards";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='home_screen_view_81']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement NewCoinsInDatabaseSection;
	private String NewCoinsInDatabaseSectionTxt = "New coins in database Section";

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='home_screen_text_71']")
	// @iOSXCUITFindBy(xpath//
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement viewMoreButtonNewCoinsInDatabaseSection;
	private String viewMoreButtonNewCoinsInDatabaseSectionTxt = "View More Buton";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='home_screen_view_81']/following-sibling::android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> newCoinsInDatabaseSectionAlCoinsCarousel;
	private String newCoinsInDatabaseSectionAlCoinsCarouselTxt = "New Data Base Section";

	// Explore Coiniverse Member Mints Section
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='home_screen_view_84']")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement exploreCoiniverseMemberMintsSectionSection;
	private String exploreCoiniverseMemberMintsSectionSectionTxt = "Explore Coiniverse Member Mints Section";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='home_screen_touchable_opacity_87+0']/following-sibling::android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> exploreCoiniverseMemberMintsSectionSectionAllLinks;
	private String exploreCoiniverseMemberMintsSectionSectionAllLinksTxt = "All Links";

	private MenuPage menuPage;
	private ShopPage shopPage;
	private MyCoinsPage myCoinsPage;

	public HomePage() {
		super();
		menuPage = new MenuPage();
	}

	public ShopPage getShopPage() {
		if (shopPage == null)
			shopPage = new ShopPage();
		return shopPage;
	}

	public MyCoinsPage getMyCoinsPage() {
		return myCoinsPage;
	}

	public MobileElement getReleaseCalendarSection() {
		return releaseCalendarSection;
	}

	public MobileElement getCloseIconOfNextIcon() {
		return closeIconOfNextIcon;
	}

//
	public String getTitle() {
		return getText(homeTitle,homeTitleTxt);
	}

	public HomePage check_Navigation_OfNotification() throws InterruptedException {
		clickElementAndBack(notifications, notificationsTxt);
		return this;
	}

	public HomePage check_Navigation_ProfileIcon() throws InterruptedException {
		click(profileIcon, profileIconText);
		menuPage.click_OnTheHome();
		return this;
	}

	public HomePage checkNavigation_CoinCollectionValue() throws InterruptedException {
		click(coinsInCollectionCard, coinsInCollectionCardLink);
		menuPage.click_OnTheHome();
		return this;
	}

	public HomePage checkNavigation_AllQuickButtons() throws InterruptedException {
		clickAllElementsAndBack(quickButtons, quickButtonsTxt);
		return this;
	}

	// Release calendar
	public HomePage ScrollDown_ToThe_ReleaseCalendarSection() throws InterruptedException {
		scrollToElement(releaseCalendarSection, 2, releaseCalendarSectionTxt, "down");
		return this;
	}

	public HomePage checkNavigation_ReleaseCalendar() throws InterruptedException {
		clickFirstAndSecondElementWithRetry(calendarIcon, closeIconOfNextIcon, calendarIconTxt, closeIconOfNextIconTxt,2);
		return this;
	}

	// New products Section
	public HomePage ScrollDown_ToThe_NewProductSection() throws InterruptedException {
		scrollToElement(newProductsSection, 2, newProductsSectionTxt, "down");
		return this;
	}

	public HomePage check_NewProductsCarouselInsightAllCardsHeight() throws InterruptedException {
		checkElementListAndValidateHeight(newProductsCarousel, 100, newProductsCarouselTxt);
		return this;
	}

	public HomePage swipingRight_NewProductsCarousel() throws InterruptedException {
		scrollElementsHorizontally(newProductsCarousel, newProductsCarouselTxt, "right");
		return this;
	}

	public HomePage clickAndCheck_ViewAllButtonOfNewProductionSection() throws InterruptedException {
		click(newProductsSectionVeiwMoreButton, newProductsSectionVeiwMoreButtonTxt);
		return this;
	}

	public HomePage swipingRight_UnderViewMoreNewProductsCarousel() throws InterruptedException {
		scrollElementsHorizontally(newProductsCard, newProductsCardTxt, "right");
		menuPage.click_OnTheHome();
		return this;
	}

	// News and highlights Section
	public HomePage ScrollDown_ToThe_NewsAndHighlightsSection() throws InterruptedException {
		scrollToElement(newsAndHighlightsSection, 2, newsAndHighlightsSectionTxt, "down");
		return this;
	}

	public HomePage check_newsAndHighlightCarouselAllCardsHeight() throws InterruptedException {
		checkElementListAndValidateHeight(newsAndHighlightsCarousel, 100, newsAndHighlightsCarouselTxt);
		return this;
	}

	public HomePage swipingRight_newsAndHighlightCarouselOfClubCard() throws InterruptedException {
		scrollElementsHorizontally(newsAndHighlightsCarousel, newsAndHighlightsSectionTxt, "right");
		return this;
	}

	public HomePage swipingRight_newAndHighlightCarouselOfShowAll() throws InterruptedException {
		scrollElementsHorizontally(rightSwipShowAll, rightSwipShowAllTxt, "right");
		return this;
	}

	public HomePage swipingLeft_newAndHighlightCarouselOfShowAll() throws InterruptedException {
		scrollElementsHorizontally(rightSwipShowAll, rightSwipShowAllTxt, "left");
		return this;
	}

	public HomePage clickOnClubCardUnder_newAndHighlightSection() throws InterruptedException {
		click(clubCard, clubCardTxt);
		return this;
	}

	public HomePage check_Navigation_SelectClubCard() throws InterruptedException {
		click(selectClubCard, selectClubCardTxt);
		click(closeIconForClubCard, closeIconForClubCardTxt);
		return this;
	}

	public HomePage clickOnshowAllCard_newAndHighlightSection() throws InterruptedException {
		click(showAllCard, showAllCardTxt);
		return this;
	}

	public HomePage check_Navigation_SelectShowAllCard() throws InterruptedException {
		clickFirstAndSecondElementWithRetry(selectShowAllCard, closeIconForShowAll, selectShowAllCardTxt,
				closeIconForShowAllTxt, 2);
		return this;
	}

	public HomePage check_AndValidate_ClubTag() throws InterruptedException {
		isDisplayed(clubTag, clubCardTxt);
		return this;
	}

	// New coins in database Section
	public HomePage scrollDown_ToNewCoinsInDatabaseSection() throws InterruptedException {
		scrollToElement(NewCoinsInDatabaseSection, 2, NewCoinsInDatabaseSectionTxt, "down");
		return this;
	}

	public HomePage clickAndCheck_ViewAllButton_Of_NewCoinsInDatabase_Section() throws InterruptedException {
		clickElementAndBack(viewMoreButtonNewCoinsInDatabaseSection, viewMoreButtonNewCoinsInDatabaseSectionTxt);
		return this;
	}

	public HomePage swipingRight_NewCoinsInDatabaseSectionCarousel() throws InterruptedException {

		scrollElementsHorizontally(newCoinsInDatabaseSectionAlCoinsCarousel,
				newCoinsInDatabaseSectionAlCoinsCarouselTxt, "right");
		return this;
	}

	public HomePage checkNavigation_OfAllConis_of_NewCoinsInDatabaseSection() throws InterruptedException {
		clickAllElementsAndBack(newCoinsInDatabaseSectionAlCoinsCarousel, newCoinsInDatabaseSectionAlCoinsCarouselTxt);
		return this;
	}

	public HomePage check_newCoinsInDatabaseAllCardsHeight() throws InterruptedException {
		checkElementListAndValidateHeight(newCoinsInDatabaseCarousel, 100, newCoinsInDatabaseCarouselTxt);
		return this;
	}

	public HomePage checkNavigation_ConisCard_of_NewCoinsInDatabaseSection() throws InterruptedException {
		clickElementAndBack(viewMoreButtonNewCoinsInDatabaseSection, viewMoreButtonNewCoinsInDatabaseSectionTxt);
		return this;
	}

	// Explore Coiniverse Member mints
	public HomePage scrollDown_ToExploreCoiniverseMemberMintsSection() throws InterruptedException {
		scrollToElement(exploreCoiniverseMemberMintsSectionSection, 6, exploreCoiniverseMemberMintsSectionSectionTxt,
				"down");
		return this;
	}

	public HomePage checkNavigation_AllLinks_of_ExploreCoiniverseMemberMintsSection() throws InterruptedException {
		clickAllElementsAndBack(exploreCoiniverseMemberMintsSectionSectionAllLinks,
				exploreCoiniverseMemberMintsSectionSectionAllLinksTxt);
		return this;
	}

	public HomePage scrollUp_ToHeader() throws InterruptedException {
		scrollUpIfElementNotDisplayed(notifications, 6, notificationsTxt);
		return this;
	}
}
