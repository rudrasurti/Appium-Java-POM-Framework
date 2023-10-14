/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.pages;

import com.appium.base.BasePage;
import com.appium.components.MenuPage;
import com.appium.manager.DriverManager;

import static com.appium.constants.FrameworkConstants.TEXT;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

//public class ProductsPage extends MenuPage {
public class HomePage extends BasePage {
	@AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.ImageView)[last()]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'WELCOME TO')]/XCUIElementTypeOther[not(@name)]")
	private MobileElement closeIcon;
	private String closeIconTxt = "Popup Close Icon";

	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
	private MobileElement scrollbar;
	private String txtFldUsernameTxt = "Scrolling all products";

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Hello')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Hello')]")
	private MobileElement productTitle;	
	

	private MenuPage menuPage;

	public HomePage() {
		super();
		// Composition
		menuPage = new MenuPage();
	}

	public MenuPage getMenuPage() {
		return menuPage;
	}

//
	public String getTitle() {
		// return getAttribute(productTitle, "text");
		// return getAttribute(productTitle, TEXT);
		return getElementText(productTitle);
	}

//	public String getSLBTitle() {
////		return getAttribute(SLBTitle, TEXT);
//		return getElementText(SLBTitle);
//	}
//
//	public String getSLBPrice() {
////		return getAttribute(SLBPrice, TEXT);
//		return getElementText(SLBPrice);
//
//	}
//
//	public ProductDetailsPage pressSLBTitle() {
//		click(SLBTitle);
//		return new ProductDetailsPage();
//	}

	public HomePage pressCloseIcon() {
//		closeIcon = (MobileElement) DriverManager.getMobileDriver().findElement(By.xpath("(//android.view.ViewGroup/android.widget.ImageView)[last()]"));
//		waitForVisibility(closeIcon);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(closeIcon, closeIconTxt);
		return this;
	}

	public HomePage swipeProductscards() {
		waitForVisibility(scrollbar);
		swipeDown(1);
		scrollElementToRight(scrollbar);

		int elementSize = DriverManager.getDriver()
				.findElements(
						By.xpath("(//android.widget.HorizontalScrollView)[1]//android.view.ViewGroup[@content-desc]"))
				.size();
		Assert.assertNotEquals(elementSize, 0, "error");
		return this;
	}
}
