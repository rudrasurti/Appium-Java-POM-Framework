/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.testng.ITestResult;

import static com.appium.constants.FrameworkConstants.YES;
import com.appium.manager.DateTimeManager;
import com.appium.manager.DriverManager;
import com.appium.reports.ExtentLogger;

import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;

public class VideoRecordUtils {
	private static boolean newWayToStartRecording = false;

	public static void startRecording() {

		if (ConfigLoader.getInstance().getFailedTestsVideo().equalsIgnoreCase(YES)) {
			// ((CanRecordScreen) driver).startRecordingScreen();
			try {
				((CanRecordScreen) DriverManager.getDriver()).startRecordingScreen();
			} catch (Exception e) {
				Boolean result = (Boolean) DriverManager.getDriver().
						executeScript("mobile: startMediaProjectionRecording", Map.ofEntries());
				newWayToStartRecording = true;
			}
		}
	}

	public static void stopRecording(ITestResult result) {
		boolean recordOnlyFailed = ConfigLoader.getInstance().getFailedTestsVideo().equalsIgnoreCase(YES);
		boolean recordAll = ConfigLoader.getInstance().getRecordAllVideo().equalsIgnoreCase(YES);

		if (recordOnlyFailed || recordAll) {
			/* Do whatever only when Test is failed */
			if ((recordOnlyFailed && result.getStatus() == 2) || recordAll) {
				String media = "";

				if (newWayToStartRecording) {
					String base64 = media = (String) DriverManager.getDriver().
							executeScript("mobile: stopMediaProjectionRecording", Map.ofEntries());
					media = decodeVideoFromBase64(base64);
				} else {
					media = ((CanRecordScreen) DriverManager.getDriver()).stopRecordingScreen();
				}

				Map<String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
				String dir = "Videos" + File.separator + File.separator + params.get("platformName") + "_"
						+ params.get("deviceName") + "_" + params.get("udid") + File.separator
						+ DateTimeManager.getDateTime() + File.separator
						+ result.getTestClass().getRealClass().getSimpleName();
				try {
					createDirectoryAndCopyFile(result, media, dir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static String decodeVideoFromBase64(String encodedString) {
		try {
			byte[] decodedBytes = Base64.decodeBase64(encodedString.getBytes());
			File file2 = Files.createTempFile("media", ".mp4").toFile();
			FileOutputStream os = new FileOutputStream(file2, true);
			os.write(decodedBytes);
			os.close();
			return file2.getAbsolutePath();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	private static void createDirectoryAndCopyFile(ITestResult result, String media, String dir) throws IOException {
	    try {
	        File videoDir = new File(dir);

	        if (!videoDir.exists()) {
	            videoDir.mkdirs();
	         //   ExtentLogger.info("Video directory created: " + videoDir.getAbsolutePath());
	         //   TestUtils.log().info("Video directory created: " + videoDir.getAbsolutePath());
	        }

	        String filePath = videoDir + File.separator + result.getName() + ".mp4";
	        try (FileOutputStream stream = new FileOutputStream(filePath)) {
	            stream.write(Base64.decodeBase64(media));
	         //   ExtentLogger.info("Video file created: " + filePath);
	         //   TestUtils.log().info("Video file created: " + filePath);
	        }

	        ExtentLogger.info("Video path is : " + filePath);
	        TestUtils.log().info("Video path is : " + filePath);
	    } catch (IOException e) {
	        String errorMessage = "Error during video capture: " + e.toString();
	        ExtentLogger.fail(errorMessage);
	        TestUtils.log().error(errorMessage);
	        throw e;
	    }
	}
}
