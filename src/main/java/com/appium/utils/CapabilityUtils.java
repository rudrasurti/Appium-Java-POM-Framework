/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.utils;

import static com.appium.constants.FrameworkConstants.CAPABILITY_ANDROID_APP_ACTIVITY;
import static com.appium.constants.FrameworkConstants.CAPABILITY_ANDROID_APP_PACKAGE;
import static com.appium.constants.FrameworkConstants.CAPABILITY_ANDROID_AVD;
import static com.appium.constants.FrameworkConstants.CAPABILITY_APP;
import static com.appium.constants.FrameworkConstants.CAPABILITY_iOS_WDA_LOCAL_PORT;
import static com.appium.constants.FrameworkConstants.CAPABILITY_iOS_Webkit_Debug_Proxy_PORT;
import static com.appium.constants.FrameworkConstants.RESOURCES_TEST_PATH;
import static com.appium.constants.FrameworkConstants.TRUE;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CapabilityUtils {

	static String browserStackNewGeneratedURLForApk;

	private CapabilityUtils() {

	}

	public static AppiumDriver setCapabilityForAndroid(String emulator, String udid, String deviceName,
			String systemPort, String chromeDriverPort, URL url, DesiredCapabilities caps) {

		AppiumDriver driver;

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigLoader.getInstance().getAndroidAutomationName());
		caps.setCapability(MobileCapabilityType.UDID, udid);

		caps.setCapability(CAPABILITY_ANDROID_APP_PACKAGE, ConfigLoader.getInstance().getAndroidAppPackage());
		caps.setCapability(CAPABILITY_ANDROID_APP_ACTIVITY, ConfigLoader.getInstance().getAndroidAppActivity());

		/* This capability is used to install the application */
		caps.setCapability(CAPABILITY_APP, RESOURCES_TEST_PATH + ConfigLoader.getInstance().getAndroidApplocation());
		caps.setCapability("autoGrantPermissions", true);
		caps.setCapability("autoAcceptAlerts", true);

		caps.setCapability("noReset", true);

		// caps.setCapability(CAPABILITY_ANDROID_SYSTEM_PORT, systemPort);
		// caps.setCapability(CAPABILITY_ANDROID_CHROME_DRIVER_PORT, chromeDriverPort);

		if (emulator.equals(TRUE)) {
			caps.setCapability(CAPABILITY_ANDROID_AVD, deviceName);
			// caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		}

		driver = new AndroidDriver(url, caps);
		return driver;
	}

	public static AppiumDriver setCapabilityFor_iOS(String udid, String deviceName, String wdaLocalPort,
			String webkitDebugProxyPort, URL url, DesiredCapabilities caps) {

		AppiumDriver driver;

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigLoader.getInstance().getiOSAutomationName());
		caps.setCapability(MobileCapabilityType.UDID, udid);
//		caps.setCapability(CAPABILITY_iOS_BUNDLE_ID,ConfigLoader.getInstance().getiOSBundleID());

		/* This capability is used to install the application */
		caps.setCapability(CAPABILITY_APP, RESOURCES_TEST_PATH + ConfigLoader.getInstance().getiOSAppLocation());

		caps.setCapability(CAPABILITY_iOS_WDA_LOCAL_PORT, wdaLocalPort);
		caps.setCapability(CAPABILITY_iOS_Webkit_Debug_Proxy_PORT, webkitDebugProxyPort);
		caps.setCapability("settings[snapshotMaxDepth]", 99999999);
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000000);

		// if (emulator.equals(TRUE)) {
		// caps.setCapability(CAPABILITY_ANDROID_AVD, deviceName);
		// caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		// }

		driver = new IOSDriver(url, caps);
		return driver;
	}

//		desiredCapabilities.setCapability("automationName", props.getProperty("iOSAutomationName"));
//		String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//				+ File.separator + "resources" + File.separator + "app" + File.separator + "SwagLabsMobileApp.app";
//	//	String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
//		utils.log().info("appUrl is" + iOSAppUrl);
//		desiredCapabilities.setCapability("bundleId", props.getProperty("iOSBundleId"));
//		desiredCapabilities.setCapability("wdaLocalPort", wdaLocalPort);
//		desiredCapabilities.setCapability("webkitDebugProxyPort", webkitDebugProxyPort);
//		desiredCapabilities.setCapability("app", iOSAppUrl);
//
//		driver = new IOSDriver(url, desiredCapabilities);

//		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigLoader.getInstance().getiOSAutomationName());
//		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");

	/* This capability is used to install the application */
//		caps.setCapability(CAPABILITY_APP,
//				RESOURCES_TEST_PATH + ConfigLoader.getInstance().getiOSAppLocation());
//
//		driver = new IOSDriver(url, caps);
//		return driver;

//	public static void uploadApp(String deviceName, boolean runTime) throws Exception {
//		if (runTime) {
//			try {
//				String USERNAME = ConfigLoader.getInstance().getBrowserstackUsername();
//				String AUTOMATE_KEY = ConfigLoader.getInstance().getBrowserstackAutomateKey();
//
//				String appLocation;
//
//				if (deviceName.toLowerCase().contains("iphone")) {
//					appLocation = ConfigLoader.getInstance().getiOSAppLocation();
//				} else {
//					appLocation = ConfigLoader.getInstance().getAndroidApplocation();
//				}
//			
//				TestUtils.log().info("Upload app file on Browserstack");
//				String urlS = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@api.browserstack.com/app-automate/upload";
//				File appUrl = new File(RESOURCES_TEST_PATH + appLocation);
//				TestUtils.log().info("App URL is: " + appUrl);
//				Response r = given().multiPart("file", appUrl).post(urlS);
//				TestUtils.log().info("Received Response new Browserstack URL: " + r.body().jsonPath().getString("app_url"));
//				browserStackNewGeneratedURLForApk = r.body().jsonPath().getString("app_url");
//			} catch (Exception e) {
//				TestUtils.log().error("Failed to upload app to Browserstack", e);
//				throw e;
//			}
//		} else {
//			return;
//		}
//	}

	public static void uploadApp(String deviceName, boolean runTime) throws Exception {
		try {
			String USERNAME = ConfigLoader.getInstance().getBrowserstackUsername();
			String AUTOMATE_KEY = ConfigLoader.getInstance().getBrowserstackAutomateKey();

			String appLocation;

			if (deviceName.toLowerCase().contains("iphone")) {
				appLocation = ConfigLoader.getInstance().getiOSAppLocation();
			} else {
				appLocation = ConfigLoader.getInstance().getAndroidApplocation();
			}

			RestAssured.baseURI = "https://api-cloud.browserstack.com";
			Response response = RestAssured.given().auth().basic(USERNAME, AUTOMATE_KEY).get("/app-automate/recent_apps");
			List<String> appNames = response.jsonPath().getList("app_name");
			appNames = appNames.stream().map(el -> el.replace("/app/", "").replace(" ", "").replace("-", "").replace("_", "")).collect(Collectors.toList());
			String appName = appLocation.replace("/app/", "").replace(" ", "").replace("-", "").replace("_", "");
			// Check if any appName matches appLocation
			if (appNames.stream().anyMatch(el -> el.equalsIgnoreCase(appName))) {
				List<String> existingUrls = response.body().jsonPath().getList("app_url");
				int index = appNames.indexOf(appName);
				String existingUrl = existingUrls.get(index);
				TestUtils.log().info("Received Response from Browserstack URL: " + existingUrl);
				browserStackNewGeneratedURLForApk = existingUrl;
				return;
			} else {
				// App_name does not match appLocation, upload apk
				TestUtils.log().info("App_name does not match appLocation. Uploading APK to Browserstack.");
				String uploadUrl = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@api.browserstack.com/app-automate/upload";
				File appFile = new File(RESOURCES_TEST_PATH + appLocation);
				TestUtils.log().info("App file URL is: " + appFile);
				// Upload APK
				Response uploadResponse = given().multiPart("file", appFile).post(uploadUrl);
				String newUrl = uploadResponse.body().jsonPath().getString("app_url");
				TestUtils.log().info("Received Response from new Browserstack URL: " + newUrl);
				browserStackNewGeneratedURLForApk = newUrl;
			}
		} catch (Exception e) {
			TestUtils.log().error("Failed to upload app to Browserstack", e);
			throw e;
		}
	}

	public static AppiumDriver setCapabilityForBrowserStack(String udid, String deviceName, String wdaLocalPort,
			String webkitDebugProxyPort, URL url, DesiredCapabilities caps) throws Exception {

		boolean isIOS = deviceName.toLowerCase().startsWith("iphone");

		boolean uploadAppRequired = ConfigLoader.getInstance().getBrowserstackAppUploadOrNot() != null;

		String USERNAME = ConfigLoader.getInstance().getBrowserstackUsername();
		String AUTOMATE_KEY = ConfigLoader.getInstance().getBrowserstackAutomateKey();

		uploadApp(deviceName, uploadAppRequired);

		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set common capabilities
		capabilities.setCapability("device", deviceName);
		// capabilities.setCapability("app", "" + browserStackNewGeneratedURLForApk +"");
		capabilities.setCapability("browserstack.acceptInsecureCerts", "false");
		capabilities.setCapability("browserstack.debug", true);
		capabilities.setCapability("browserstack.networkLogs", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability("wdaHideKeyboard", true);
		capabilities.setCapability("interactiveDebugging", true);
		capabilities.setCapability("appiumVersion", "2.0.1");
		capabilities.setCapability("debug", true);
		capabilities.setCapability("networkLogs", true);

		if (isIOS) {
			// Configure iOS-specific capabilities
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,ConfigLoader.getInstance().getiOSAutomationName());
			capabilities.setCapability("app", browserStackNewGeneratedURLForApk); // Specify your iOS app URL
		} else {
			capabilities.setCapability(CAPABILITY_ANDROID_APP_PACKAGE,
					ConfigLoader.getInstance().getAndroidAppPackage());
			capabilities.setCapability(CAPABILITY_ANDROID_APP_ACTIVITY,
					ConfigLoader.getInstance().getAndroidAppActivity());
			capabilities.setCapability("app", "" + browserStackNewGeneratedURLForApk + "");
		}

		AppiumDriver driver;
		URL driverUrl = new URL("https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub");

		if (isIOS) {
			driver = new IOSDriver(driverUrl, capabilities);
		} else {
			driver = new AndroidDriver(driverUrl, capabilities);
		}

		return driver;
	}

}