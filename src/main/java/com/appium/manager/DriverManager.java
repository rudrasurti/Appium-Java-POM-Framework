/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.manager;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

public final class DriverManager {

	private DriverManager() {
	}

	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static AppiumDriver getMobileDriver() {
		return (AppiumDriver) driver.get();
	}

	public static RemoteWebDriver getDriver() {
		return driver.get();
	}

	public static <T extends RemoteWebDriver> void setDriver(T driverref) {
		driver.set(driverref);
	}

	public static void unload() {
		driver.remove();
	}
}