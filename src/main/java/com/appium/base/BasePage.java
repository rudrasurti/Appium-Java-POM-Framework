/**
 * @author Rudra Surti
 */

/***************************************************/

package com.appium.base;

import static com.appium.constants.FrameworkConstants.EXPLICIT_WAIT;
import static com.appium.constants.FrameworkConstants.LABEL;
import static com.appium.constants.FrameworkConstants.PLATFORM_ANDROID;
import static com.appium.constants.FrameworkConstants.PLATFORM_browserStack;
import static com.appium.constants.FrameworkConstants.PLATFORM_iOS;
import static com.appium.constants.FrameworkConstants.TEXT;
import static com.appium.constants.FrameworkConstants.WAIT;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.manager.DeviceNameManager;
import com.appium.manager.DriverManager;
import com.appium.manager.PlatformManager;
import com.appium.reports.ExtentLogger;
import com.appium.reports.ExtentManager;
import com.appium.utils.ScreenshotUtils;
import com.appium.utils.TestUtils;
import com.appium.utils.VerificationUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.util.concurrent.Uninterruptibles;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public BasePage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getMobileDriver(), Duration.ofSeconds(30)),
				this);
	}

	public void implicitWaitDefault() {
		implicitelyWait(30);
	}

	public static void implicitelyWait(int seconds) {
		DriverManager.getMobileDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void sleep(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
			TestUtils.log().info("Sleeping for " + seconds + " seconds...");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			TestUtils.log().warn("Sleep interrupted. Reason: " + e.getMessage());
		}
	}

	public static void waitForVisibility(MobileElement mobileElement) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getMobileDriver(), EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(mobileElement));
	}

	protected void captureScreenshot() {
		ExtentManager.getExtentTest().info("Capturing Screenshot",
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}

	protected void waitForSomeTime() {
		Uninterruptibles.sleepUninterruptibly(WAIT, TimeUnit.SECONDS);
	}

	protected void waitForGivenTime(long time) {
		Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
	}

	protected void webElementPresent(MobileElement mobileElement, String elementName) {
		VerificationUtils.validate(isDisplayed(mobileElement), true, elementName + " presence");
	}

	protected void webElementAbsent(MobileElement mobileElement, String elementName) {
		VerificationUtils.validate(isDisplayed(mobileElement), false, elementName + " absence");
	}

	public String getAppiumExceptionLogMessage(Exception e) {
		StringBuilder logMessage = new StringBuilder("Appium Exception Details:\n");

		if (e instanceof NoSuchElementException) {
			logMessage.append("Error: Element not found. Details: ").append(e.getMessage());
		} else if (e instanceof TimeoutException) {
			logMessage.append("Error: Timeout waiting for element. Details: ").append(e.getMessage());
		} else if (e instanceof StaleElementReferenceException) {
			logMessage.append("Error: Stale Element Reference. Details: ").append(e.getMessage());
		} else if (e instanceof ElementNotVisibleException) {
			logMessage.append("Error: Element not visible. Details: ").append(e.getMessage());
		} else if (e instanceof ElementNotInteractableException) {
			logMessage.append("Error: Element not interactable. Details: ").append(e.getMessage());
		} else if (e instanceof InvalidElementStateException) {
			logMessage.append("Error: Invalid Element State. Details: ").append(e.getMessage());
		} else if (e instanceof WebDriverException) {
			logMessage.append("Error: WebDriver Exception. Details: ").append(e.getMessage());
		} else {
			logMessage.append("Unexpected Appium Exception. Details: ").append(e.getMessage());
		}
		return logMessage.toString();
	}

	public By elementToBy(MobileElement we) {
		String element = we.toString()
				.split("(?=\\sid:\\s|\\sname:\\s|\\sselector:\\s|\\slink text:|\\sxpath:\\s|"
						+ "By.id:\\s|By.name:\\s|By.tagName:\\s|By.className:\\s|By.cssSelector:\\s|"
						+ "By.linkText:\\s|By.partialLinkText:\\s|By.xpath:\\s)")[1];

		String[] locator = StringUtils.removeEnd(element, "]").split(":\\s");
		String method = locator[0].trim();
		if (method.equals("xpath"))
			return By.xpath(locator[1]);

		String selector = StringUtils.removeEnd(locator[1], "'");
		switch (method) {
		case "id":
		case "By.id":
			return By.id(selector);
		case "name":
		case "By.name":
			return By.name(selector);
		case "By.tagName":
			return By.tagName(selector);
		case "By.className":
			return By.className(selector);
		case "selector":
		case "By.cssSelector":
			return By.cssSelector(selector);
		case "By.linkText":
			return By.linkText(selector);
		case "link text":
		case "By.partialLinkText":
			return By.partialLinkText(selector);
		case "By.xpath":
			selector = StringUtils.substringBeforeLast(selector, "})");
			return By.xpath(selector);
		default:
			System.out.println("Error! [" + method + "]");
			return null;
		}
	}

	// Deiver
	public boolean isAndroid() {
		MobileDriver driver = DriverManager.getMobileDriver();
		return driver instanceof AndroidDriver;
	}

	public boolean isIos() {
		MobileDriver driver = DriverManager.getMobileDriver();
		return driver instanceof IOSDriver;
	}

	// Driver native action
	public void hideKeyboard() {
		MobileDriver driver = DriverManager.getMobileDriver();
		if (isAndroid()) {
			AndroidDriver androidDriver = (AndroidDriver) driver;
			if (androidDriver.isKeyboardShown()) {
				try {
					androidDriver.hideKeyboard();
					TestUtils.log().info("The Android keyboard has been successfully hidden.");
				} catch (Exception e) {
					TestUtils.log().error("Error occurred while hiding the Android keyboard. Reason: " + e.getMessage(),e);
				}
			}
		} else if (isIos()) {
			IOSDriver iosDriver = (IOSDriver) driver;

			// Customize this to match your app's UI
			if (iosDriver.isKeyboardShown()) {
				try {

					iosDriver.getKeyboard().pressKey(Keys.RETURN);
					// ((RemoteWebDriver) driver).getKeyboard().sendKeys(Keys.ENTER);

					TestUtils.log().info("iOS keyboard hidden");
				} catch (Exception e) {
					TestUtils.log().error("Failed to hide iOS keyboard: " + e.getMessage());
				}
			}
		} else {
			TestUtils.log().warn("Unsupported driver type; keyboard hiding not implemented for this driver.");
		}
	}

	protected void navigateBack() {
		try {
			DriverManager.getDriver().navigate().back();
			TestUtils.log().info("Navigated back");
			ExtentLogger.info("<b>Successfully navigated back</b> to the previous page");
		} catch (Exception e) {
			String backErrorMessage = String.format("Error navigating back after performing an action: %s",e.getMessage());
			ExtentLogger.fail(backErrorMessage);
			TestUtils.log().error(backErrorMessage, e);
			throw new RuntimeException(backErrorMessage, e);
		}
	}

	// validation methods
	public boolean isDisplayed(MobileElement element) {
		try {
			waitForVisibility(element);
			ExtentLogger.info("Element " + element + "is displayed");
			return element.isDisplayed();
		} catch (Exception e) {
			String errorMessage = String.format("Error checking if element is displayed: %s", e.getMessage());
			ExtentLogger.fail(errorMessage);
			TestUtils.log().error(errorMessage, e);
			throw new RuntimeException(errorMessage, e);
		}

	}

	public int isDisplayed(List<MobileElement> elements, String elementName) {
		try {
			int displayedCount = 0;
			for (MobileElement element : elements) {
				if (isDisplayed(element)) {
					displayedCount++;
				}
			}
			String logMessage = String.format("Number of displayed elements for '%s' in the list: %d", elementName,
					displayedCount);
			TestUtils.log().info(logMessage);
			ExtentLogger.info(logMessage);
			return displayedCount;
		} catch (Exception ex) {
			String exMsg = getAppiumExceptionLogMessage(ex);
			String errorMessage = String.format("Error counting displayed elements for '%s' in the list: %s",
					elementName, exMsg);
			ExtentLogger.fail(errorMessage);
			TestUtils.log().error(errorMessage, ex);
			throw new RuntimeException(errorMessage, ex);
		}
	}

	private boolean isElementVisible(MobileElement mobileElement) {
		try {
			waitForVisibility(mobileElement);
			return mobileElement.isDisplayed();
		} catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
			return false;
		}
	}


	// All action methods
	public void click(MobileElement mobileElement, String elementName) {
		click(mobileElement, elementName, 2);
	}

	public void click(MobileElement mobileElement, String elementName, int retryCount) {
		boolean actionDone = false;
		Exception lastException = null;

		for (int attempt = 1; attempt <= retryCount; attempt++) {
			try {
				// Wait for the element to be visible before clicking
				waitForVisibility(mobileElement);

				// Log information about the click using ExtentLogger
				String clickLogMessage = String.format("Attempt %d: Clicking on <%s>", attempt, elementName);
				TestUtils.log().info(clickLogMessage);
				ExtentLogger.info(clickLogMessage);

				// Perform the click
				mobileElement.click();

				// Break the loop if click is successful
				String successMessage = String.format("Attempt %d: Clicked on <%s> successfully", attempt, elementName);
				TestUtils.log().info(successMessage);
				ExtentLogger.info(String.format("Attempt %d: Clicked on <b>%s</b> successfully", attempt, elementName));

				actionDone = true;
				break;
			} catch (StaleElementReferenceException e) {
				
				// Retry in case of StaleElementReferenceException
				By byLocator = elementToBy(mobileElement);
				mobileElement = (MobileElement) DriverManager.getMobileDriver().findElement(byLocator);

				// Log retry attempt for StaleElementReferenceException
				String retryMessage = String.format(
						"Attempt %d: StaleElementReferenceException occurred. Retrying click on: <%s>", attempt,
						elementName);
				TestUtils.log().info(retryMessage);
				ExtentLogger.info(retryMessage);

				lastException = e;
			} catch (Exception e) {
				// Log other exceptions
				lastException = e;
				String errorMessage = String.format("Attempt %d: Failed to click on: <%s>. Exception: %s", attempt,
						elementName, e.getMessage());
				TestUtils.log().error(errorMessage, e);
				ExtentLogger.fail(String.format("Attempt %d: Failed to click on: <b>%s</b>. Exception: %s", attempt,
						elementName, e.getMessage()));
			}
		}

		if (!actionDone) {
			// Log and report failure if maximum retries are reached
			String exceptionMessage = getAppiumExceptionLogMessage(lastException);
			String errorMessage = String.format("Failed to click on: <%s>. Exception: %s", elementName,
					exceptionMessage);
			TestUtils.log().error(errorMessage, lastException);
			ExtentLogger
					.fail(String.format("Failed to click on: <b>%s</b>. Exception: %s", elementName, exceptionMessage));
			throw new RuntimeException(errorMessage, lastException);
		}
	}

	public void clickWithJS(MobileElement mobileElement, String elementName, int retryCount) {
		boolean actionDone = false;
		Exception lastException = null;

		for (int attempt = 1; attempt <= retryCount; attempt++) {
			try {
				// Wait for the element to be visible before executing JavaScript click
				waitForVisibility(mobileElement);

				// Log information about the click using ExtentLogger
				String clickLogMessage = String.format("Attempt %d: Clicking on <%s> using JavaScript", attempt,
						elementName);
				TestUtils.log().info(clickLogMessage);
				ExtentLogger.info(clickLogMessage);

				// Perform the click using JavaScript
				JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getMobileDriver();
				jsExecutor.executeScript("arguments[0].click();", mobileElement);

				// Break the loop if click is successful
				String successMessage = String.format("Attempt %d: Clicked on <%s> using JavaScript successfully",
						attempt, elementName);
				TestUtils.log().info(successMessage);
				ExtentLogger.info(String.format("Attempt %d: Clicked on <b>%s</b> using JavaScript successfully",
						attempt, elementName));

				actionDone = true;
				break;
			} catch (StaleElementReferenceException e) {
				// Retry in case of StaleElementReferenceException
				By byLocator = elementToBy(mobileElement);
				mobileElement = (MobileElement) DriverManager.getMobileDriver().findElement(byLocator);

				// Log retry attempt for StaleElementReferenceException
				String retryMessage = String.format(
						"Attempt %d: StaleElementReferenceException occurred. Retrying click on: <%s> using JavaScript",
						attempt, elementName);
				TestUtils.log().info(retryMessage);
				ExtentLogger.info(retryMessage);

				lastException = e;
			} catch (Exception e) {
				// Log other exceptions
				lastException = e;
				String errorMessage = String.format(
						"Attempt %d: Failed to click on: <%s> using JavaScript. Exception: %s", attempt, elementName,
						e.getMessage());
				TestUtils.log().error(errorMessage, e);
				ExtentLogger
						.fail(String.format("Attempt %d: Failed to click on: <b>%s</b> using JavaScript. Exception: %s",
								attempt, elementName, e.getMessage()));
			}
		}

		if (!actionDone) {
			// Log and report failure if maximum retries are reached
			String exceptionMessage = getAppiumExceptionLogMessage(lastException);
			String errorMessage = String.format("Failed to click on: <%s> using JavaScript. Exception: %s", elementName,
					exceptionMessage);
			TestUtils.log().error(errorMessage, lastException);
			ExtentLogger.fail(String.format("Failed to click on: <b>%s</b> using JavaScript. Exception: %s",
					elementName, exceptionMessage));
			throw new RuntimeException(errorMessage, lastException);
		}
	}

	public void click(List<MobileElement> elements, int index, String elementName) {
		click(elements, index, elementName, 2);
	}

	public void click(List<MobileElement> elements, int index, String elementName, int retryCount) {
		if (elements.isEmpty()) {
			String errorMessage = "List of elements is empty. Cannot perform click operation.";
			TestUtils.log().error(errorMessage);
			ExtentLogger.fail(errorMessage);
			throw new RuntimeException(errorMessage);
		}

		boolean actionDone = false;
		Exception lastException = null;
		int initialElementsSize = elements.size();

		for (int attempt = 1; attempt <= retryCount; attempt++) {
			try {
				if (index < 0 || index >= elements.size()) {
					throw new IndexOutOfBoundsException("Index is out of bounds");
				}

				MobileElement mobileElement = elements.get(index);

				// Wait for the element to be visible before clicking
				waitForVisibility(mobileElement);

				// Log information about the click using ExtentLogger
				String clickLogMessage = String.format("Attempt %d: Clicking on <%s>", attempt, elementName);
				TestUtils.log().info(clickLogMessage);
				ExtentLogger.info(clickLogMessage);

				// Perform the click
				mobileElement.click();

				// Break the loop if click is successful
				String successMessage = String.format("Attempt %d: Clicked on <%s> successfully", attempt, elementName);
				TestUtils.log().info(successMessage);
				ExtentLogger.info(successMessage);

				actionDone = true;
				break;
			} catch (IndexOutOfBoundsException e) {
				// Log and handle the IndexOutOfBoundsException
				String errorMessage = String.format(
						"Attempt %d: Index out of bounds while trying to access element at index %d", attempt, index);
				TestUtils.log().error(errorMessage, e);
				ExtentLogger.fail(errorMessage);
			} catch (StaleElementReferenceException e) {

				By byLocator = elementToBy(elements.get(index));
				elements = DriverManager.getMobileDriver().findElements(byLocator);

				// Check if the screen changed after StaleElementReferenceException
				if (initialElementsSize != elements.size()) {
					// Log and retry finding the element before throwing an exception
					String retryMessage = String.format(
							"Attempt %d: StaleElementReferenceException occurred. Retrying finding element: <%s>",
							attempt, elementName);
					TestUtils.log().info(retryMessage);
					ExtentLogger.info(retryMessage);
					continue; // Retry the click operation
				}

				// Log retry attempt for StaleElementReferenceException
				String retryMessage = String.format(
						"Attempt %d: StaleElementReferenceException occurred. Retrying click on: <%s>", attempt,
						elementName);
				TestUtils.log().info(retryMessage);
				ExtentLogger.info(retryMessage);

				lastException = e;
			} catch (Exception e) {
				// Log and handle other exceptions related to the list of elements
				lastException = e;
				String errorMessage = String.format(
						"Attempt %d: Failed to interact with the list of elements. Exception: %s", attempt,
						e.getMessage());
				TestUtils.log().error(errorMessage, e);
				ExtentLogger.fail(errorMessage);
			}
		}

		if (!actionDone) {
			// Log and report failure if maximum retries are reached
			String exceptionMessage = getAppiumExceptionLogMessage(lastException);
			String errorMessage = String.format("Failed to click on: <%s>. Exception: %s", elementName,
					exceptionMessage);
			TestUtils.log().error(errorMessage, lastException);
			ExtentLogger.fail(errorMessage);
			throw new RuntimeException(errorMessage, lastException);
		}
	}

	public void clickIfDisplayedWithRetry(MobileElement mobileElement, String elementName, int maxRetries) {

		if (isElementVisible(mobileElement)) {
			click(mobileElement, elementName, maxRetries);

		} else {
			// Element is not displayed, skipping click
			String notDisplayedMessage = String.format("Element not displayed: %s, Skipping click.", elementName);
			TestUtils.log().info(notDisplayedMessage);
			ExtentLogger.info("Element not displayed: " + elementName + ", Skipping click.");
		}

	}

	public void clickElementAndBack(MobileElement element, String elementName) {
		try {
			click(element, elementName);
			sleep(WAIT);
			navigateBack();
		} catch (Exception e) {
			// Log and throw an error for unexpected exceptions
			String exMsg = getAppiumExceptionLogMessage(e);
			String errorMessage = String.format("Failed to click on %s and navigate back. Exception: %s", elementName,exMsg);
			TestUtils.log().error(errorMessage, e);
			ExtentLogger.fail(errorMessage);
			throw new RuntimeException(errorMessage, e);
		}
	}

	public void clickAllElementsAndBack(List<MobileElement> elements, String elementName) {
		int totalElements = elements.size();

		if (totalElements == 0) {
			throw new NoSuchElementException("No elements found for the click: '" + elementName
					+ "'. Please check the locator or verify the presence of the element on the page.");
		}

		TestUtils.log().info("Clicking all elements of '{}' - Total elements: {}", elementName, totalElements);

		try {
			for (int count = 0; count < totalElements; count++) {
				String logMessage = String.format("Clicking Element %s -> %s/%s", elementName, count + 1,
						totalElements);
				click(elements, count, logMessage);
				sleep(6); // Adjust sleep duration based on your needs
				navigateBack();
			}
		} catch (Exception e) {
			String exMsg = getAppiumExceptionLogMessage(e);
			String errorMessage = String.format("Failed to click on: %s. Exception: %s", elementName, exMsg);
			TestUtils.log().error(errorMessage, e);
			ExtentLogger.fail(errorMessage);
			throw new RuntimeException(errorMessage, e);
		}
	}

	public void clickFirstAndSecondElementWithRetry(MobileElement firstElement, MobileElement secondElement,
			String firstElementName, String secondElementName, int maxRetries) {
		click(firstElement, firstElementName, maxRetries);
		click(secondElement, secondElementName, maxRetries);

	}

	public void clickFirstAndSecondElementWithValidation(MobileElement firstElement, MobileElement secondElement,
			MobileElement validateElement, String firstElementName, String secondElementName) {
		click(firstElement, firstElementName);
		if (!isDisplayed(validateElement)) {
			throw new RuntimeException("Validation element not displayed. Click action aborted.");
		}
		click(secondElement, secondElementName);
	}

	public void clear(MobileElement mobileElement, String elementName) {
		try {
			waitForVisibility(mobileElement);

			// Log clearing information using TestUtils.log()
			String clearingLogMessage = "Clearing: " + elementName;
			TestUtils.log().info(clearingLogMessage);

			// Log clearing information using ExtentLogger with bold formatting for element
			// name
			ExtentLogger.info(String.format("<b>%s</b>: Clearing", elementName));

			mobileElement.clear();

			// Log cleared information using TestUtils.log()
			String clearedLogMessage = "Cleared: " + elementName;
			TestUtils.log().info(clearedLogMessage);

			// Log cleared information using ExtentLogger with bold formatting for element
			// name
			ExtentLogger.info(String.format("<b>%s</b>: Cleared", elementName));

		} catch (Exception e) {
			// Log failure information for both TestUtils.log() and ExtentLogger
			String exMsg = getAppiumExceptionLogMessage(e);
			String errorMessage = String.format("Failed to clear element '<b>%s</b>'. Exception: %s", elementName,
					exMsg);

			TestUtils.log().error(errorMessage, e);
			ExtentLogger.fail(errorMessage);

			throw new RuntimeException(errorMessage, e);
		}
	}

	public void sendKeys(MobileElement mobileElement, String elementName, String text) {
		sendKeys(mobileElement, elementName, text, 2);
	}

	public void sendKeys(MobileElement mobileElement, String elementName, String text, int retryCount) {
		boolean actionDone = false;
		Exception lastException = null;

		for (int attempt = 1; attempt <= retryCount; attempt++) {
			try {
				waitForVisibility(mobileElement);
				clear(mobileElement, elementName);
				mobileElement.sendKeys(text);
				// Log success message
				String successMessage = String.format("Attempt %d: Successfully sent keys to <%s>: \"%s\".", attempt,elementName, text);
				TestUtils.log().info(successMessage);
				ExtentLogger.info(String.format("Attempt %d: Successfully sent keys to <b>%s</b>: \"%s\".", attempt,elementName, text));
				actionDone = true;
				break;
			} catch (StaleElementReferenceException e) {
				// Retry in case of StaleElementReferenceException
				By byLocator = elementToBy(mobileElement);
				mobileElement = (MobileElement) DriverManager.getMobileDriver().findElement(byLocator);

				// Log retry attempt for StaleElementReferenceException
				String retryMessage = String.format("Attempt %d: StaleElementReferenceException occurred. Retrying sending keys on: <%s>", attempt,elementName);
				TestUtils.log().info(retryMessage);
				ExtentLogger.info(retryMessage);

				lastException = e;
			} catch (Exception e) {
				// Log other exceptions
				lastException = e;
				String errorMessage = String.format("Attempt %d: Failed to send keys to: <%s>. Exception: %s", attempt,	elementName, e.getMessage());
				TestUtils.log().error(errorMessage, e);
				ExtentLogger.fail(String.format("Attempt %d: Failed to send keys to: <b>%s</b>. Exception: %s", attempt,elementName, e.getMessage()));
			}
		}

		if (!actionDone) {
			// Log and report failure if maximum retries are reached
			String exceptionMessage = getAppiumExceptionLogMessage(lastException);
			String errorMessage = String.format("Failed to send keys to: <%s>. Exception: %s", elementName,exceptionMessage);
			TestUtils.log().error(errorMessage, lastException);
			ExtentLogger.fail(String.format("Failed to send keys to: <b>%s</b>. Exception: %s", elementName, exceptionMessage));
			throw new RuntimeException(errorMessage, lastException);
		}
	}

	public String getAttribute(MobileElement mobileElement, String attribute) {
		try {
			waitForVisibility(mobileElement);

			// Get attribute value
			String attributeValue = mobileElement.getAttribute(attribute);

			// Log information about getting attribute using TestUtils.log()
			String logMessage = String.format("Attribute: %s value for element with text '%s' is - %s", attribute,mobileElement.getText(), attributeValue);
			TestUtils.log().info(logMessage);

			// Log information about getting attribute using ExtentLogger with additional formatting
			String extentLogMessage = String.format("Attribute: <b>%s</b> value for element with text '<i>%s</i>' is - %s", attribute,mobileElement.getText(), attributeValue);
			ExtentLogger.info(extentLogMessage);

			return attributeValue;
		} catch (Exception e) {
			// Log and report failure if an exception occurs
			String exMsg = getAppiumExceptionLogMessage(e);
			String errorMessage = String.format("Failed to get attribute '%s' for element with text '%s'. Exception: %s", attribute,mobileElement.getText(), exMsg);

			TestUtils.log().error(errorMessage, e);
			ExtentLogger.fail(errorMessage);

			throw new RuntimeException(errorMessage, e);
		}
	}

	public String getText(MobileElement mobileElement, String elementName) {
		try {
			waitForVisibility(mobileElement);

			String platformName = PlatformManager.getPlatform();
			String textAttribute;

			if (platformName.equalsIgnoreCase(PLATFORM_ANDROID)) {
				textAttribute = mobileElement.getAttribute(TEXT);
			} else if (platformName.equalsIgnoreCase(PLATFORM_iOS)) {
				textAttribute = mobileElement.getAttribute(LABEL); // Use LABEL for iOS
			} else if (platformName.equalsIgnoreCase(PLATFORM_browserStack)) {
				String deviceName = DeviceNameManager.getDeviceName();
				textAttribute = (deviceName != null && deviceName.toLowerCase().startsWith("ios"))
						? mobileElement.getAttribute(LABEL)
						: mobileElement.getAttribute(TEXT);
			} else {
				throw new UnsupportedOperationException(String
						.format("Unsupported platform '%s' encountered. Unable to get element text.", platformName));
			}
			// Log information about getting element text using TestUtils.log() and
			// ExtentLogger.info()
			String logMessage = String.format("Getting text attribute '%s' for element '%s' with text '%s'",
					textAttribute, elementName, mobileElement.getText());
			TestUtils.log().info(logMessage);
			ExtentLogger
					.info(String.format("Attribute: <b>%s</b> - value for element '%s' with text '<i>%s</i>' is - %s",
							textAttribute, elementName, mobileElement.getText(), textAttribute));

			return textAttribute;
		} catch (Exception e) {
			String exMsg = getAppiumExceptionLogMessage(e);
			String errorMessage = String.format(
					"Failed to get element text for element '%s' with text '%s'. Exception: %s", elementName,
					mobileElement.getText(), exMsg);

			// Log and report failure if an exception occurs using TestUtils.log() and
			// ExtentLogger.fail()
			TestUtils.log().error(errorMessage, e);
			ExtentLogger.fail(errorMessage);
			throw new RuntimeException(errorMessage, e);
		}
	}

	public String getText(List<MobileElement> elements, int index, String elementName, int retryCount) {
		boolean actionDone = false;
		Exception ex = null;
		int elementsSize = elements.size();

		if (elementsSize == 0) {
			throw new RuntimeException("Element list is empty for: " + elementName);
		}

		MobileElement mobileElement = elements.get(index);
		for (int i = 0; i < retryCount; i++) {
			try {

				if (!isElementVisible(mobileElement)) {
					throw new RuntimeException("Element is not displayed: " + elementName + " at index " + index);
				}
				// Wait for the element to be visible before retrieving text
				waitForVisibility(mobileElement);

				// Log information about retrieving text using ExtentLogger
				ExtentLogger.info("Retrieving text from <b>" + elementName + "</b>");

				String elementText = mobileElement.getText();
				elementText = (elementText != null) ? elementText : "null";
				String logMessage = String.format("Text value for Element %s at index %d: %s", elementName, index,
						elementText);

				// Log the information using TestUtils and ExtentLogger
				TestUtils.log().info(logMessage);
				ExtentLogger.info(logMessage);

				actionDone = true;
				return elementText;
			} catch (StaleElementReferenceException e) {
				By byLocator = elementToBy(mobileElement);
				elements = DriverManager.getMobileDriver().findElements(byLocator);

				if (elementsSize != elements.size()) {
					throw new RuntimeException(
							"StaleElementReferenceException: The screen changed after a stale element exception. Element: "
									+ elementName); 
				}
			} catch (Exception e) {
				ex = e;
			}
		}

		if (!actionDone) {
			// Log and report failure if maximum retries are reached
			String exMsg = getAppiumExceptionLogMessage(ex);
			String errorMessage = String.format("Failed to retrieve text from: %s. Exception: %s", elementName, exMsg);

			// Log the error using TestUtils and ExtentLogger
			TestUtils.log().error(errorMessage, ex);
			ExtentLogger.fail(errorMessage);

			throw new RuntimeException(errorMessage, ex);
		}

		// If unexpected state is reached after text retrieval retries
		throw new RuntimeException("Unexpected state reached after text retrieval retries. Element: " + elementName,
				ex);
	}

	public List<String> getTextValues(List<MobileElement> mobileElements, String elementName) {
		if (mobileElements == null || mobileElements.isEmpty()) {
			ExtentLogger.fail("MobileElements list is empty for elementName: " + elementName);
			throw new IllegalArgumentException("MobileElements list is empty for elementName: " + elementName);
		}

		List<String> textValues = new ArrayList<>();
		int totalElements = mobileElements.size();

		// Log information about fetching text values using ExtentLogger
		ExtentLogger.info("Fetching text values for <b>" + totalElements + "</b> elements with elementName: " + elementName);

		for (int i = 0; i < totalElements; i++) {
			String logMessage = String.format("Fetching text for %s - Element %d/%d", elementName, i + 1,totalElements);
			ExtentLogger.info(logMessage);
			String text = getText(mobileElements, i, logMessage, 2);
			textValues.add(text);
		}
		ExtentLogger.info("Successfully fetched text values for all <b>" + totalElements + "</b> elements with elementName: " + elementName);
		return textValues;
	}

	public void checkElementHeight(MobileElement mobileElement, int height, String elementName) {
		try {
			int elementHeight = mobileElement.getSize().getHeight();
			if (elementHeight >= height) {
				// Log information about the element height using ExtentLogger
				ExtentLogger.info("Element height is greater than or equal to " + height + " pixels for element: <b>"
						+ elementName + "</b>");
				TestUtils.log().info(
						"Element height is greater than or equal to " + height + " pixels for element: " + elementName);
			} else {
				String errorMessage = "Element height is less than " + height + " pixels for element: " + elementName;

				// Log error message using ExtentLogger
				ExtentLogger.fail(errorMessage);
				TestUtils.log().error(errorMessage);

				throw new RuntimeException(errorMessage);
			}
		} catch (Exception e) {
			String exMsg = getAppiumExceptionLogMessage(e);
			String errorMessage = "Exception while checking element height for element: " + elementName
					+ ". Exception: " + exMsg;

			// Log error message using ExtentLogger
			ExtentLogger.fail(errorMessage);
			TestUtils.log().error(errorMessage, e);
		}
	}

	public void checkElementListAndValidateHeight(List<MobileElement> mobileElements, int minHeight,
			String elementName) {
		int count = 1;
		int successCount = 0;
		int failureCount = 0;

		int totalElements = mobileElements.size();

		if (totalElements == 0) {
			throw new IllegalArgumentException(
					"The elements list is empty. Cannot validate height for: " + elementName);
		}

		// Log information about the total number of elements in the list
		ExtentLogger.info("Total elements in the list: " + totalElements);

		try {
			for (MobileElement element : mobileElements) {
				int elementHeight = element.getSize().getHeight();
				if (elementHeight >= minHeight) {
					// Log success message using ExtentLogger
					String successMessage = String.format(
							"Element %s: %d height is greater than or equal to %d pixels.", elementName, count,
							minHeight);
					TestUtils.log().info(successMessage);
					ExtentLogger.info(successMessage + " Element Text: " + element.getText());
					successCount++;
				} else {
					// Log error message using ExtentLogger
					String errorMessage = String.format(
							"Error: Element %s: %d height is less than %d pixels. Element Text: %s", elementName, count,
							minHeight, element.getText());
					TestUtils.log().error(errorMessage);
					ExtentLogger.fail(errorMessage);
					failureCount++;
					throw new RuntimeException(errorMessage);
				}
				count++;
			}

			// Log information about the total number of elements with height >= minHeight
			// and < minHeight
			TestUtils.log().info("Total elements with height >= " + minHeight + ": " + successCount);
			TestUtils.log().info("Total elements with height < " + minHeight + ": " + failureCount);

		} catch (Exception e) {
			// Log exception message using ExtentLogger
			String exceptionMessage = String.format(
					"Exception while checking element list height against %d pixels: %s", minHeight, e.getMessage());
			TestUtils.log().error(exceptionMessage);
			ExtentLogger.fail(exceptionMessage);
		}
	}

	protected void swipeDown(int swipeCount) {
		Dimension dimension = DriverManager.getMobileDriver().manage().window().getSize();
		int startX = dimension.width / 2;
		int endX = startX;
		int startY = (int) (dimension.height * 0.8);
		int endY = (int) (dimension.height * 0.2);

		for (int i = 0; i < swipeCount; i++) {
			TouchAction touchAction = new TouchAction(DriverManager.getMobileDriver());
			touchAction.press(PointOption.point(startX, startY)).
			/* It'll take 2 seconds to complete swipe operation */
					waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).
					// moveTo(PointOption.point(494, 386))
					moveTo(PointOption.point(endX, endY)).release().perform();
		}
	}

	public void scrollToLeftSide() {
		int startY = DriverManager.getMobileDriver().manage().window().getSize().getHeight() / 2;
		int startX = DriverManager.getMobileDriver().manage().window().getSize().getWidth() - 10;
		int endX = 0;
		int endY = startY;

		performSwipe(startX, startY, endX, endY);
	}

	public void scrollElementToRight(MobileElement element, String elementName) {
		try {

			int startX = 200;
			int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
			int endX = DriverManager.getMobileDriver().manage().window().getSize().width - 100;
			int endY = startY;
			Thread.sleep(1000);
			performSwipe(startX, startY, endX, endY);
			TestUtils.log().info("Swipe right on :  " + elementName + "  Sucessfully");
			ExtentLogger.info("Swipe right on <b>" + elementName + "</b> in <b>" + "Sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			TestUtils.log().error("Error while Swipe right on : " + " + elementName+" + e.getMessage());
			ExtentLogger.info("Error while Swipe right on <b>" + elementName + "</b> in <b>" + e.getMessage());
		}
	}

	public void scrollElementsHorizontally(List<MobileElement> elements, String elementName, String direction) {

		final int SWIPE_START_MARGIN = 300;
		final int SWIPE_DURATION_MS = 1000;
		final int SLOW_SWIPE_DURATION_MS = 100; // Adjust as needed for slower swipe
		final boolean isDirectionRight = direction.equals("right");

		try {
			if (elements.size() < 2) {
				String errorMessage = "Insufficient elements to perform swipe for: " + elementName;
				TestUtils.log().error(errorMessage);
				ExtentLogger.info(errorMessage);
				throw new RuntimeException(errorMessage);
			}

			int screenWidth = DriverManager.getMobileDriver().manage().window().getSize().width;
			int startX = isDirectionRight ? screenWidth - SWIPE_START_MARGIN : SWIPE_START_MARGIN; // Adjusted
			// this line

			// Calculate the Y-coordinate for the starting point without an additional gap
			int startY = elements.get(0).getLocation().getY() + elements.get(0).getSize().getHeight() / 2;

			// Calculate the ending point at the right side of the screen for the last
			// element
			MobileElement lastElement = elements.get(elements.size() - 1);
			int endX = isDirectionRight ? SWIPE_START_MARGIN : screenWidth - SWIPE_START_MARGIN; // Adjusted
			// this line
			int endY = lastElement.getLocation().getY() + lastElement.getSize().getHeight() / 2;

			// Ensure startX is greater than endX for a rightward scroll
			if (startX <= endX && isDirectionRight) {
				throw new RuntimeException("Error: startX should be greater than endX for a rightward scroll.");
			}
			if (endX <= startX && !isDirectionRight) {
				throw new RuntimeException("Error: endX should be greater than startX for a leftward scroll.");
			}

			// Perform the swipe with a slower duration
			TouchAction touchAction = new TouchAction(DriverManager.getMobileDriver());
			touchAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(SLOW_SWIPE_DURATION_MS))).moveTo(PointOption.point(endX, endY)).release().perform();

			Thread.sleep(SWIPE_DURATION_MS);
			String successMessage = "Swipe " + direction + " on: " + elementName + " successfully";
			TestUtils.log().info(successMessage);
			ExtentLogger.info(successMessage);

		} catch (ElementNotInteractableException e) {
			String errorMessage = "Element not interactable. Unable to swipe " + direction + " on: " + elementName;
			TestUtils.log().error(errorMessage, e);
			ExtentLogger.info(errorMessage);
			throw new RuntimeException(errorMessage, e);

		} catch (Exception e) {
			String errorMessage = "Error while swiping " + direction + " on: " + elementName;
			TestUtils.log().error(errorMessage, e);
			ExtentLogger.fail(errorMessage);
			throw new RuntimeException(errorMessage, e);
		}
	}

	public void swipeHorizontal(List<MobileElement> elements, String elementName, SwipeDirection direction) {
		try {

			int elementCount = elements.size();
			if (elementCount == 0) {
				TestUtils.log().info("No elements to swipe for: " + elementName);
				return;
			}

			// Get the starting element (first element)
			MobileElement startElement = elements.get(0);

			// Get the starting coordinates from the center of the element
			int startX = startElement.getLocation().getX() + startElement.getSize().getWidth() / 2;
			int startY = startElement.getLocation().getY() + startElement.getSize().getHeight() / 2;

			// Get the ending element (last element)
			MobileElement endElement = elements.get(elementCount - 1);

			// Get the screen width dynamically
			int screenWidth = DriverManager.getMobileDriver().manage().window().getSize().width;

			// Set the end coordinates based on the swipe direction
			int endX, endY;

			if (direction == SwipeDirection.RIGHT) {
				// Swipe to the right
				endX = endElement.getLocation().getX() + endElement.getSize().getWidth();
				endY = startY;
			} else if (direction == SwipeDirection.LEFT) {
				// Swipe to the left
				endX = startElement.getLocation().getX();
				endY = startY;
			} else {
				// Invalid direction, log an error and return
				TestUtils.log().error("Invalid swipe direction: " + direction);
				return;
			}

			// Using TouchAction for swiping
			TouchAction<?> touchAction = new TouchAction<>(DriverManager.getMobileDriver());

			// Perform swipe
			touchAction.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();

			TestUtils.log().info("Swipe on " + elementName + " to " + direction + " successfully");
			ExtentLogger.info("Swipe on <b>" + elementName + "</b> to " + direction + " successfully");

		} catch (Exception e) {
			e.printStackTrace();
			TestUtils.log().error("Error while swiping on " + elementName + " to " + direction + " - " + e.getMessage());
			ExtentLogger.info("Error while swiping on <b>" + elementName + "</b> to " + direction + " - " + e.getMessage());
		}
	}

	public enum SwipeDirection {
		LEFT, RIGHT
	}

	private void performSwipe(int startX, int startY, int endX, int endY) {
		TouchAction touchAction = new TouchAction(DriverManager.getMobileDriver());
		touchAction.press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(endX, endY))
				.release().perform();
	}

	public void scrollElementToLeft(List<MobileElement> elements, String elementName) {
		try {
			MobileElement element = elements.get(0);

			int startX = 200;
			int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
			int endX = DriverManager.getMobileDriver().manage().window().getSize().width - 100;
			int endY = startY;

			Thread.sleep(1000);
			performSwipe(startX, startY, endX, endY);

			TestUtils.log().info("Swipe Left on: " + elementName + " successfully");
			ExtentLogger.info("Swipe Left on <b>" + elementName + "</b> successfully");

		} catch (Exception e) {
			e.printStackTrace();
			TestUtils.log().error("Error while swiping Left on: " + elementName + " - " + e.getMessage());
			ExtentLogger.fail("Error while swiping Left on <b>" + elementName + "</b> - " + e.getMessage());
		}
	}

//	public void scrollToElement(MobileElement element, int maxScrollIterations, String elementName, String direction) {
//		By by = elementToBy(element);
//		implicitelyWait(1);
//
//		int startX;
//		int endX;
//		int startY;
//		int endY;
//		int screenHeight = DriverManager.getMobileDriver().manage().window().getSize().getHeight();
//		int screenWidth = DriverManager.getMobileDriver().manage().window().getSize().getWidth();
//
//		if ("down".equalsIgnoreCase(direction)) {
//			startX = screenWidth / 2;
//			endX = startX;
//			startY = screenHeight / 2;
//			endY = 25;
//		} else if ("up".equalsIgnoreCase(direction)) {
//			startX = screenWidth / 2;
//			startY = screenHeight / 4;
//			endY = screenHeight / 2;
//			endX = startX;
//		} else {
//			throw new RuntimeException("Invalid direction given: " + direction);
//		}
//
//		try {
//			for (int i = 0; i < maxScrollIterations; i++) {
//				try {
//					MobileElement mel = (MobileElement) DriverManager.getMobileDriver().findElements(by).get(0);
//					if (mel.isDisplayed()) {
//						if ("down".equalsIgnoreCase(direction) && element.getLocation().y
//								+ element.getSize().height > screenHeight - (screenHeight / 3)) {
//							continue;
//						} else if ("up".equalsIgnoreCase(direction)
//								&& element.getLocation().y + element.getSize().height < 500) {
//							continue;
//						}
//						TestUtils.log()
//								.info("Element - " + elementName + " :  is now displayed. No need to scroll further.");
//						ExtentLogger.info(
//								"Element - <b> " + elementName + "<b>: is now displayed. No need to scroll further.");
//
//						TouchAction touchAction = new TouchAction(DriverManager.getMobileDriver());
//						touchAction.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY))
//								.release().perform();
//						break;
//					}
//				} catch (Exception ignored) {
//				}
//
//				TestUtils.log().info("Element :" + elementName
//						+ " is not displayed. Scrolling down to find the element: " + elementName + ".");
//				ExtentLogger.info("Element : " + elementName
//						+ " is not displayed. Scrolling down to find the element : " + elementName + ".");
//
//				new TouchAction<>(DriverManager.getMobileDriver()).press(PointOption.point(startX, startY))
//						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//						.moveTo(PointOption.point(startX, endY)).release().perform();
//			}
//
//			MobileElement mel = (MobileElement) DriverManager.getMobileDriver().findElement(by);
//
//			if (!mel.isDisplayed()) {
//				TestUtils.log().error(elementName);
//				ExtentLogger.fail(elementName);
//				throw new RuntimeException(elementName);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			TestUtils.log().error(
//					"Exception while scrolling down and checking element : " + elementName + "  visibility: ",
//					e.getMessage());
//			ExtentLogger.fail("Exception while scrolling down and checking element : <b>" + elementName
//					+ " <b>visibility: " + e.getMessage());
//			throw new RuntimeException("Exception while scrolling down and checking element : " + elementName
//					+ "  visibility: " + e.getMessage());
//		} finally {
//			implicitWaitDefault();
//		}
//	}

	public void scroll(int startX, int startY, int endX, int endY) {
		scroll(startX, startY, endX, endY, 2000);
	}

	public void scroll(int startX, int startY, int endX, int endY, int durationInMillis) {

		TouchAction touchAction = new TouchAction(DriverManager.getMobileDriver());
		touchAction.press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationInMillis)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
//		new TouchAction<>(DriverManager.getMobileDriver()).press(PointOption.point(startX, startY))
//				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
//				.moveTo(PointOption.point(endX, endY))
//				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
//				.release().perform();
	}

	private void makeElementCenter(MobileElement mel) {
		int centerBuff =  DriverManager.getMobileDriver().manage().window().getSize().height / 8;
		int driverCenterY = DriverManager.getMobileDriver().manage().window().getSize().height / 2;
		int ely = mel.getRect().y;
		int driverCenterX = DriverManager.getMobileDriver().manage().window().getSize().width / 2;

		// element should be +150/-150 pixels away from center
		while (!Range.between(driverCenterY - centerBuff, driverCenterY + centerBuff).contains(ely)) {
			if (ely > driverCenterY) {
                TestUtils.log().info("Element is below the center of the screen. Scrolling down...");
				// element is down below
				scroll(driverCenterX, driverCenterY + (centerBuff / 2), driverCenterX, driverCenterY, 500);
			} else if (ely < driverCenterY) {
				// element is above
                TestUtils.log().info("Element is above the center of the screen. Scrolling up...");
				scroll(driverCenterX, driverCenterY - (centerBuff / 2), driverCenterX, driverCenterY, 500);
			}

			// scroll
			int newElY = mel.getRect().y;
			if (newElY == ely) {
				// can't scroll more
                TestUtils.log().warn("Unable to scroll further. Stopping the scroll.");
				break;
			}
			ely = newElY;
		}

        TestUtils.log().info("Scrolling complete. Element is now centered on the screen.");
	}

	public void scrollToElement(MobileElement element, int maxScrollIterations, String elementName, String direction) {
		By by = elementToBy(element);
		implicitelyWait(1);

		int startX;
		int endX;
		int startY;
		int endY;
		int screenHeight = DriverManager.getMobileDriver().manage().window().getSize().getHeight();
		int screenWidth = DriverManager.getMobileDriver().manage().window().getSize().getWidth();

		double scrollPercentage = 0.5; // Set your desired scroll percentage (e.g., 50%)
		int scrollDistance = (int) (screenHeight * scrollPercentage);

		if ("down".equalsIgnoreCase(direction)) {
			startX = screenWidth / 2;
			endX = startX;
			startY = screenHeight / 2;
			endY = 100;
		} else if ("up".equalsIgnoreCase(direction)) {
			startX = screenWidth / 2;
			startY = screenHeight / 4;
			endY = screenHeight / 2;
			endX = startX;
		} else {
			throw new RuntimeException("Invalid direction given: " + direction);
		}

		try {
			for (int i = 0; i < maxScrollIterations; i++) {
				try {
					MobileElement mel = (MobileElement) DriverManager.getMobileDriver().findElements(by).get(0);
					if (mel.isDisplayed()) {
//						if ("down".equalsIgnoreCase(direction) && element.getLocation().y
//								+ element.getSize().height > screenHeight - (screenHeight / 3)) {
//							continue;
//						} else if ("up".equalsIgnoreCase(direction)
//								&& element.getLocation().y + element.getSize().height < 500) {
//							continue;
//						}
						makeElementCenter(mel);
						TestUtils.log().info("Element - " + elementName + " :  is now displayed. No need to scroll further.");
						ExtentLogger.info("Element - <b> " + elementName + "<b>: is now displayed. No need to scroll further.");

//						TouchAction touchAction = new TouchAction(DriverManager.getMobileDriver());
//						touchAction.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY - scrollDistance))
//								.release().perform();
						break;
					}
				} catch (Exception ignored) {
				}

				TestUtils.log().info("Element :" + elementName+ " is not displayed. Scrolling down to find the element: " + elementName + ".");
				ExtentLogger.info("Element : " + elementName+ " is not displayed. Scrolling down to find the element : " + elementName + ".");

				new TouchAction<>(DriverManager.getMobileDriver()).press(PointOption.point(startX, startY))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
						.moveTo(PointOption.point(startX, endY)).release().perform();
			}

			MobileElement mel = (MobileElement) DriverManager.getMobileDriver().findElement(by);

			if (!mel.isDisplayed()) {
				TestUtils.log().error(elementName);
				ExtentLogger.fail(elementName);
				throw new RuntimeException(elementName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			TestUtils.log().error("Exception while scrolling down and checking element : " + elementName + "  visibility: ",e.getMessage());
			ExtentLogger.fail("Exception while scrolling down and checking element : <b>" + elementName+ " <b>visibility: " + e.getMessage());
			throw new RuntimeException("Exception while scrolling down and checking element : " + elementName+ "  visibility: " + e.getMessage());
		} finally {
			implicitWaitDefault();
		}
	}

	public void scrollUpIfElementNotDisplayed(MobileElement element, int maxScrollIterations, String elementName) {
		// Convert MobileElement to By for better flexibility
		By by = elementToBy(element);

		// Set a short implicit wait to handle element visibility checks
		implicitelyWait(30);

		// Get screen dimensions
		int screenHeight = DriverManager.getMobileDriver().manage().window().getSize().getHeight();
		int startX = DriverManager.getMobileDriver().manage().window().getSize().getWidth() / 2;
		int startY = 200;
		int endY = screenHeight - 200;

		try {
			int scrollCount = 0;
			while (scrollCount < maxScrollIterations) {
				try {
					MobileElement mel = (MobileElement) DriverManager.getMobileDriver().findElement(by);
					if (mel.isDisplayed()) {
						// Element is already displayed, no need to scroll up
						TestUtils.log()
								.info("The element '" + elementName + "' is already displayed. No need to scroll up.");
						ExtentLogger
								.info("The element '" + elementName + "' is already displayed. No need to scroll up.");
						return;
					}
				} catch (NoSuchElementException e) {
					// Element not found, scrolling to find it
					TestUtils.log()
							.info("The element '" + elementName + "' was not found. Scrolling to find the element.");
					ExtentLogger
							.info("The element '" + elementName + "' was not found. Scrolling to find the element.");

					// Scroll up using TouchAction
					new TouchAction<>(DriverManager.getMobileDriver()).press(PointOption.point(startX, startY))
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
							.moveTo(PointOption.point(startX, endY)).release().perform();
					scrollCount++;
				} catch (Exception e) {
					// Log and report any other exceptions during element visibility check
					TestUtils.log().error("Exception while checking element visibility: " + e.getMessage());
					ExtentLogger.fail("Exception while checking element visibility: " + e.getMessage());
				}
			}

			// Element not found after scrolling up
			String errorMessage = "The element '" + elementName + "' was not found after scrolling up.";
			TestUtils.log().error(errorMessage);
			ExtentLogger.fail(errorMessage);
			throw new RuntimeException(errorMessage);

		} catch (Exception ex) {
			// Handle and report any exceptions during scrolling or other actions
			String exMsg = getAppiumExceptionLogMessage(ex);
			String errorMessage = String.format("Failed to scroll up and find the element '%s'. Exception: %s",
					elementName, exMsg);
			TestUtils.log().error(errorMessage, ex);
			ExtentLogger.fail(errorMessage);
			throw new RuntimeException(errorMessage, ex);

		} finally {
			// Reset implicit wait to default after the operation
			implicitWaitDefault();
			;
		}
	}

	public void scrollDownWithTouch(int pixels, String scrollDescription) {
		try {
			// Log information about the scroll using ExtentLogger
			String scrollLogMessage = String.format("Scrolling down by %d pixels", pixels);
			TestUtils.log().info(scrollLogMessage);
			ExtentLogger.info(scrollLogMessage);

			Dimension dimension = DriverManager.getMobileDriver().manage().window().getSize();
			int startX = dimension.width / 2;
			int endX = startX;
			int startY = (int) (dimension.height * 0.8);
			int endY = startY - pixels; // Adjust the endY based on the pixel value

			TouchAction touchAction = new TouchAction(DriverManager.getMobileDriver());
			touchAction.press(PointOption.point(startX, startY))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endX, endY))
					.release().perform();
			// Log success message

			String successMessage = String.format("Scrolled down by %d pixels successfully", pixels);
			TestUtils.log().info(successMessage);
			ExtentLogger.info(successMessage);

		} catch (Exception e) {
			// Log exception
			String errorMessage = String.format("Failed to scroll down by %d pixels. Exception: %s", pixels,e.getMessage());
			TestUtils.log().error(errorMessage, e);
			ExtentLogger.fail(errorMessage);
			throw new RuntimeException(errorMessage, e);
		}
	}
}
