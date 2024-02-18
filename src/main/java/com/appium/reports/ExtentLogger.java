package com.appium.reports;

import static com.appium.constants.FrameworkConstants.YES;
import com.appium.utils.ConfigLoader;
import com.appium.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void pass(Markup message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void fail(Markup message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void skip(Markup message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void info(Markup message) {
        ExtentManager.getExtentTest().info(message);
    }

    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) {
        if (ConfigLoader.getInstance().getPassedStepsScreenshot().equalsIgnoreCase(YES)
                && isScreenshotNeeded) {
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            pass(message);
        }
    }

    public static void pass(Markup message, boolean isScreenshotNeeded) {
        if (ConfigLoader.getInstance().getPassedStepsScreenshot().equalsIgnoreCase(YES)
                && isScreenshotNeeded) {
            ExtentManager.getExtentTest().pass(
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            ExtentManager.getExtentTest().pass(message);
        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded) {
        if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(YES) && isScreenshotNeeded) {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            fail(message);
        }
    }

    public static void fail(Markup message, boolean isScreenshotNeeded) {
        if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(YES) && isScreenshotNeeded) {
            ExtentManager.getExtentTest().fail( MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            ExtentManager.getExtentTest().fail(message);
        } else {
            fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded) {
        if (ConfigLoader.getInstance().getSkippedStepsScreenshot().equalsIgnoreCase(YES)
                && isScreenshotNeeded) {
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            skip(message);
        }
    }

    public static void skip(Markup message, boolean isScreenshotNeeded) {
        if (ConfigLoader.getInstance().getSkippedStepsScreenshot().equalsIgnoreCase(YES) && isScreenshotNeeded) {
            ExtentManager.getExtentTest().skip(  MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            ExtentManager.getExtentTest().skip(message);
        } else {
            skip(message);
        }
    }

    // New method to log warnings
    public static void warn(String message) {
        ExtentManager.getExtentTest().warning(message);
    }

    public static void warn(Markup message) {
        ExtentManager.getExtentTest().warning(message);
    }

    public static void warn(String message, boolean isScreenshotNeeded) {
        if (ConfigLoader.getInstance().getWarnStepsScreenshot().equalsIgnoreCase(YES) && isScreenshotNeeded) {
            ExtentManager.getExtentTest().warning(message,
            MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            warn(message);
        }
    }

    public static void warn(Markup message, boolean isScreenshotNeeded) {
        if (ConfigLoader.getInstance().getWarnStepsScreenshot().equalsIgnoreCase(YES)
                && isScreenshotNeeded) {
            ExtentManager.getExtentTest().warning(
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            ExtentManager.getExtentTest().warning(message);
        } else {
            warn(message);
        }
    }
}
