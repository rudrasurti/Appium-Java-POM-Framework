# Appium + Java POM Framework (Android & iOS)

![Build](https://github.com/rudrasurti/Appium-Java-POM-Framework/actions/workflows/build.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-11%20%7C%2017-007396) ![Appium](https://img.shields.io/badge/Appium-java--client%207-662D91) ![TestNG](https://img.shields.io/badge/TestNG-7-FF7F00)

A mobile test automation framework for Android and iOS apps, built with Appium, Java, TestNG and the Page Object Model.

## At a glance

| Area | What it does |
|---|---|
| Platforms | Android and iOS from one framework, driver chosen by config |
| Design | Page Object Model: screens, locators and actions kept apart from tests |
| Reports | ExtentReports with screenshots, plus logs with Log4j 2 |
| Evidence | Screenshots and screen recordings on failure |
| Security | Log4j updated from 2.14.0 to 2.24.3 (fixes Log4Shell, CVE-2021-44228) |
| CI | GitHub Actions compiles the framework and tests on Java 11 and 17 on every push |

Running the tests needs an Appium server and a device or emulator; CI checks that everything compiles.

---

## Original notes

Automation Testing | Moblie | Appuim | Java | Eclipse | Visual Testing | Videos | Screenshots | Viewport | Logger

This is a mobile automation framework built using Java and Appium. It provides a scalable and customizable solution for testing mobile applications on Android and iOS platforms. The framework incorporates various features and tools to enhance the testing process and generate comprehensive reports.

## Features

- Parallel testing: Supports execution on multiple devices simultaneously, including both real devices and emulators/simulators.
- ExtentReports integration: Utilizes ExtentReports version 5.0.9 for generating detailed HTML reports with test execution results.
- Customization options: Allows users to customize the framework according to their specific requirements.
- Email notifications: Sends email notifications to users using the Java Mail API, including the test report as an attachment.
- Test case retry: Supports retrying failed test cases to improve test stability.
- Custom enums, exceptions, and annotations: Provides custom implementations for better code organization and readability.
- Report archiving: Zips the ExtentReports directory into the project path, allowing users to send the report as a zip file attachment.
- Automatic report opening: Automatically opens the test report after test execution.
- Appium server management: Starts and stops the Appium server programmatically.
- Video recording: Records videos for failed test cases to aid in debugging.
- Test data from JSON files: Loads test data from JSON files for parameterized testing.
- Expected data from XML files: Loads expected data from XML files for validation.
- Jenkins job setup: Provides instructions for setting up the framework in a Jenkins job.
- Jenkins email notifications: Sends email notifications using Jenkins with attachments.

## Project Structure

The framework follows a structured project organization for better maintainability and modularity. Here's an overview of the project structure:

- `BaseTest.java`: Initializes the driver and config properties, and handles the driver exit.
- `BasePage.java`: Provides common functionalities such as explicit waits, page factory initialization, and driver commands.
- `com.qa.pages`: Contains page objects, element definitions, and methods.
- `com.qa.tests`: Includes test classes for executing test cases.
- `com.qa.utils`: Holds common utilities and helper classes.
- `config.properties`: Contains global parameters such as the Appium server URL, AppPackage, BundleID, etc.
- `log4j.properties`: Configures properties for Log4J logging.
- `App/`: Directory for storing application builds (APKs, IPAs).
- `Data/`: Directory for storing test data files (JSON).
- `Strings/`: Directory for storing static texts (XML).

## Getting Started

To get started with the framework, follow these steps:

1. Clone the repository and set up the necessary dependencies.
2. Configure the `config.properties` file with the appropriate parameters.
3. Implement your test cases using the page objects defined in `com.qa.pages`.
4. Execute the tests and generate the ExtentReports HTML report.
5. Customize the framework as needed for your specific requirements.

For detailed instructions and examples, please refer to the documentation provided within the repository.

## Contributors

- Rudra Surti


---

**Rudra Surti** · Senior SDET · [Website](https://rudrasurti.github.io) · [LinkedIn](https://www.linkedin.com/in/rudra-surti/)
