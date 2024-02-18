/**
 * @author  */

/***************************************************/

package com.appium.base;

import static com.appium.constants.FrameworkConstants.EXPECTED_DATA_XML_FILE;
import static com.appium.constants.FrameworkConstants.LOGS;
import static com.appium.constants.FrameworkConstants.PLATFORM_ANDROID;
import static com.appium.constants.FrameworkConstants.PLATFORM_browserStack;
import static com.appium.constants.FrameworkConstants.PLATFORM_iOS;
import static com.appium.constants.FrameworkConstants.ROUTINGKEY;
import static com.appium.constants.FrameworkConstants.SERVER_LOGS;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.appium.constants.FrameworkConstants;
import com.appium.manager.DateTimeManager;
import com.appium.manager.DeviceNameManager;
import com.appium.manager.DriverManager;
import com.appium.manager.PlatformManager;
import com.appium.manager.StringsManager;
import com.appium.utils.AppiumServerUtils;
import com.appium.utils.CapabilityUtils;
import com.appium.utils.ConfigLoader;
import com.appium.utils.TestUtils;
import com.appium.utils.VideoRecordUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class BaseTest {

	private static int port = RandomUtils.nextInt(10000, 50000);
	private static AppiumDriverLocalService server;

	@BeforeMethod
	public void beforeTestMethod(ITestContext context) {		
		String platformName = context.getCurrentXmlTest().getParameter("platformName");
		if (!"browserStack".equalsIgnoreCase(platformName)) {
			VideoRecordUtils.startRecording();
		}
		
	}

	@AfterMethod
	public void afterTestMethod(ITestContext context, ITestResult result) {
		String platformName = context.getCurrentXmlTest().getParameter("platformName");
		if (!"browserStack".equalsIgnoreCase(platformName)) {
			VideoRecordUtils.stopRecording(result);
		}
	}

	/* Executes before any of the test method class is executed */
	@Parameters({ "emulator", "platformName", "udid", "deviceName", "systemPort", "chromeDriverPort", "wdaLocalPort","webkitDebugProxyPort" })
	@BeforeTest
	public void beforeTest(@Optional("androidOnly") String emulator, String platformName, String udid,
			String deviceName, @Optional("androidOnly") String systemPort,
			@Optional("androidOnly") String chromeDriverPort, @Optional("iOSOnly") String wdaLocalPort,
			@Optional("iOSOnly") String webkitDebugProxyPort) throws Exception {
		/*
		 * @Optional("androidOnly") -> means we are setting the default value as
		 * androidOnly and it is Optional
		 */
		URL url;
		InputStream stringsIS;
		AppiumDriver driver;
		

		
//		mlTest test = ct.getCurrentXmlTest().getName();
//		String testtt = context.getName();

		if (StringUtils.isNotBlank(System.getProperty("platformName"))) {
			platformName = System.getProperty("platformName");
		}
		
		if (StringUtils.isNotBlank(System.getProperty("deviceName"))) {
			deviceName = System.getProperty("deviceName");
		}

		PlatformManager.setPlatform(platformName);
		
		DeviceNameManager.setDeviceName(deviceName);
		
		String xmlFileName = EXPECTED_DATA_XML_FILE;
		
		
		stringsIS = getClass().getClassLoader().getResourceAsStream(xmlFileName);
		
		DateTimeManager.setDateTime(TestUtils.dateTime());
		StringsManager.setStrings(TestUtils.parseStringXML(stringsIS));
		url = new URL(ConfigLoader.getInstance().getAppiumURL());
		url = new URL(url.getProtocol(), "0.0.0.0", port, url.getFile());

		String strFile = LOGS + File.separator + platformName + "_" + deviceName;
		File logFile = new File(strFile);
		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		// Route logs to separate file for each thread
		ThreadContext.put(ROUTINGKEY, strFile);
		TestUtils.log().debug("Log file path: " + strFile);

		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			
			TestUtils.log().debug("Setting PLATFORM_NAME to: " + platformName);
			
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			
			TestUtils.log().debug("Setting DEVICE_NAME to: " + deviceName);

			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300000); // TODO: remove in prod

			/* Configuration for Android device(s) */
			if (platformName.equalsIgnoreCase(PLATFORM_ANDROID)) {
				driver = CapabilityUtils.setCapabilityForAndroid(emulator, udid, deviceName	, port + "",chromeDriverPort, url, caps);
			}
			/* Configuration for iOS device(s) */
			else if (platformName.equalsIgnoreCase(PLATFORM_iOS)) {
				// driver = CapabilityUtils.setCapabilityFor_iOS(url, caps);
				driver = CapabilityUtils.setCapabilityFor_iOS(udid, deviceName, wdaLocalPort, webkitDebugProxyPort, url,caps);

			} /* Configuration for Browserstack */
			else if (platformName.equalsIgnoreCase(PLATFORM_browserStack)) {

				driver = CapabilityUtils.setCapabilityForBrowserStack(udid, deviceName, wdaLocalPort,webkitDebugProxyPort, url, caps);

			} else {
				throw new Exception("Invalid Platform: " + platformName);
			}
			DriverManager.setDriver(driver);
			String sessionId = driver.getSessionId().toString();
			TestUtils.log().debug("sessionId: " + sessionId);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (stringsIS != null) {
				stringsIS.close();
			}
		}
	}

	@AfterTest
	public void afterTest() {
		DriverManager.getMobileDriver().quit();
	}

	public void closeApp() {
		((InteractsWithApps) DriverManager.getMobileDriver()).closeApp();
	}

	public void launchApp() {
		((InteractsWithApps) DriverManager.getMobileDriver()).launchApp();
	}

	@BeforeSuite
	public void beforeSuite(ITestContext context) throws AppiumServerHasNotBeenStartedLocallyException, Exception {
		String suiteName = context.getCurrentXmlTest().getSuite().getFileName();

		if (!StringUtils.equals(System.getProperty("platformName"), "browserStack")) {
			killNode();
			ThreadContext.put(ROUTINGKEY, SERVER_LOGS);
			server = AppiumServerUtils.getAppiumService(port);
			if (!AppiumServerUtils.checkIfAppiumServerIsRunnning(port)) {
				server.start();
				/* This will not print the Appium server Logs in IDE console */
				server.clearOutPutStreams();
				TestUtils.log().debug("Appium Server started................. \n");
			} else {
				TestUtils.log().debug("Appium Server is already running................");
			}
		}
		TestUtils.log().debug("Setting XML to: " + suiteName);
		TestUtils.log().debug("Server logs: " + FrameworkConstants.APPIUM_SERVER_LOGS);
	}

	@AfterSuite
	public void afterSuite() {
		if (server != null)
			server.stop();
		TestUtils.log().debug("Appium Server stopped.............");
	}

	public void killNode() {
		String processName = "node.exe";
		// Process name (e.g., "node.exe" for Windows)

		try {
			// Construct the command to kill the Node.js process using taskkill
			String command = "taskkill /F /IM " + processName;

			// Create a ProcessBuilder instance
			ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);

			// Start the process
			Process process = processBuilder.start();

			// Wait for the process to complete
			int exitCode = process.waitFor();

			if (exitCode == 0) {
				System.out.println("Node.js process killed successfully.");
			} else {
				System.out.println("Failed to kill Node.js process.");
			}
		} catch (IOException | InterruptedException e) {
		}
	}

}