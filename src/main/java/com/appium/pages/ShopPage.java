/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.pages;

import java.time.Duration;
import java.util.List;

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

public class ShopPage extends BasePage {

	private static final String MobileElement = null;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='auth_stack_view_4_Shop']")
//	/@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Hello')]")
	private static MobileElement shopTitle;
	private String shopTitleTxt = "Shop Page Title";


	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='shop_screen_7']/../following-sibling::android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath =
	// "//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> promotedCoinsCarousel;
	private String promotedCoinsCarouselTxt = "Promoted Coins Carousel Cards";

	// Most Liked Coins Section Xpath

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='shop_screen_16']/android.view.ViewGroup[3]")
	// @iOSXCUITFindBy(xpath =
	// "//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement mostLikedCoinsSection;
	private String mostLikedCoinsSectionTxt = "Most Liked Coins Section";

	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='home_screen_text_71'])[1]")
	// @iOSXCUITFindBy(xpath
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement mostLikedCoinsSectionViewAllButton;
	private String mostLikedCoinsSectionViewAllButtonTxt = "View all Button of Most Liked Coins Section";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='shop_screen_16']/android.view.ViewGroup[2]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> mostLikedCoinsSectionCarousel;
	private String mostLikedCoinsSectionCarouselTxt = " Most Liked Coins Section : Carousel";

	// Categories section xapth
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='shop_screen_16']/android.view.ViewGroup[3]")
	// @iOSXCUITFindBy(xpath =
	// "//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement CategoriesSection;
	private String CategoriesSectionTxt = "Categories Section";

	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='home_screen_text_83'])[2]/following-sibling::android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup")
	// @iOSXCUITFindBy(xpath
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private List<MobileElement> CategoriesSectionCarousel;
	private String CategoriesSectioCarouselTxt = "Categories Carousel";

	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='home_screen_text_71'])[2]")
	// @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement categoriesSectionViewMoreButton;
	private String categoriesSectionViewMoreButtonTxt = "View More Button";

	// View all shop coins
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='shop_screen_22']")
	// @iOSXCUITFindBy(xpath
	// ="//XCUIElementTypeStaticText[contains(@name,'Hello')]")
	private MobileElement viewAllShopCoinsButton;
	private String viewAllShopCoinsButtonTxt = "View all Button Of Categories";

	private MenuPage menuPage;
	private HomePage homePage;

	public ShopPage() {
		super();
		menuPage = new MenuPage();
	}

	public HomePage getHomePage() {
		if (homePage == null)
			homePage = new HomePage();
		return homePage;
	}

	public MenuPage getMenuPage() {
		return menuPage;
	}

//
	public static MobileElement getShopTitle() {
		return shopTitle;
	}

	public String getTitle() {
		return getText(shopTitle,shopTitleTxt);
	}

	public ShopPage ClickOn_Menu_ShopIcon() throws InterruptedException {
		menuPage.click_OnTheShop();
		return new ShopPage();
	}

	// Promoted coins
	public ShopPage swipingRight_promotedCoinsCarousel() throws InterruptedException {
		scrollElementsHorizontally(promotedCoinsCarousel, promotedCoinsCarouselTxt,"right");
		return this;
	}

	public ShopPage checkNavigation_of_promoteCoinscarousel_AllCards() throws InterruptedException {
		clickAllElementsAndBack(promotedCoinsCarousel, promotedCoinsCarouselTxt);
		return this;
	}

	// Release calendar
	public ShopPage checkNavigation_ReleaseCalendar() throws InterruptedException {
		clickFirstAndSecondElementWithRetry(getHomePage().getReleaseCalendarSection(), getHomePage().getCloseIconOfNextIcon(),"Release Calendar Section", "Close Icon",2);
		return this;
	}

	// Most Liked Coins Section
	public ShopPage ScrollDown_To_MostLikedCoins_Section() throws InterruptedException {
		scrollToElement(mostLikedCoinsSection, 6, mostLikedCoinsSectionTxt, "down");
		return this;
	}

	public ShopPage check_navigation_Of_ViewAllButton() throws InterruptedException {
		clickElementAndBack(mostLikedCoinsSectionViewAllButton, mostLikedCoinsSectionViewAllButtonTxt);
		return this;
	}

	public ShopPage swipingRight__MostLikedCoins_Section_Carousel() throws InterruptedException {
		scrollElementsHorizontally(mostLikedCoinsSectionCarousel, mostLikedCoinsSectionCarouselTxt,"right");
		return this;
	}

	public ShopPage check_navigation_Of_MostLikedCoinsSection_Carousel() throws InterruptedException {
		clickAllElementsAndBack(mostLikedCoinsSectionCarousel, mostLikedCoinsSectionCarouselTxt);
		return this;
	}

	// Categories Section
	public ShopPage ScrollDown_To_Categories_Section() throws InterruptedException {
		scrollToElement(mostLikedCoinsSection, 6, mostLikedCoinsSectionTxt, "down");
		return this;
	}

	public ShopPage check_navigation_Of_ViewAllButtonOfCategories() throws InterruptedException {
		clickElementAndBack(categoriesSectionViewMoreButton, categoriesSectionViewMoreButtonTxt);
		return this;
	}

	public ShopPage check_navigation_Of_CategoriesCarousel() throws InterruptedException {
		//ScrollDown_To_Categories_Section();
		clickAllElementsAndBack(CategoriesSectionCarousel, CategoriesSectioCarouselTxt);
		return this;
	}

	public ShopPage swipingRight_Categories_Section_Carousel() throws InterruptedException {
		scrollElementsHorizontally(CategoriesSectionCarousel, CategoriesSectioCarouselTxt,"right");
		return this;
	}

	// View all shop coins
	public ShopPage check_navigation_Of_ViewAllShopCoins() throws InterruptedException {
		clickElementAndBack(viewAllShopCoinsButton, viewAllShopCoinsButtonTxt);
		return this;
	}
}
