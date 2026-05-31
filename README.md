# OLG Automation Assignment

## Overview

This project was developed as part of the OLG Automation Assignment. The automation framework is built using **Java**, **Playwright**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern to ensure maintainability, scalability, and clean test architecture.

The framework validates the following scenarios:

### 1. Basic Assertions

* Verify OLG page title
* Verify Login button visibility
* Verify Sign Up button visibility

### 2. Restaurant Search Scenario

* Navigate to Google Maps
* Search for "Restaurants"
* Verify search results are displayed successfully

---

## Tech Stack

| Tool           | Purpose                       |
| -------------- | ----------------------------- |
| Java 21        | Programming Language          |
| Playwright     | Browser Automation            |
| TestNG         | Test Execution & Assertions   |
| Maven          | Build & Dependency Management |
| GitHub Actions | Continuous Integration        |
| IntelliJ IDEA  | Development IDE               |

---

## Why Playwright?

Playwright was selected because it provides:

* Auto-waiting capabilities
* Fast and reliable execution
* Modern browser support
* Better handling of dynamic web applications
* Improved test stability compared to traditional automation frameworks

---

## Framework Design

The project follows the **Page Object Model (POM)** design pattern.

```text
src/test/java
├── base
│   └── BaseTest.java
├── listeners
│   └── TestListener.java
├── pages
│   ├── OLG
│   │   └── OLGHomePage.java
│   └── GoogleMap
│       └── GoogleMapHomePage.java
├── tests
│   └── AssignmentTest.java
└── utils
    └── ScreenshotUtil.java
```

### Framework Components

#### BaseTest

Responsible for:

* Playwright initialization
* Browser launch and configuration
* Page creation
* Test teardown and cleanup
* Local and CI execution support

#### Page Objects

Encapsulate:

* Page locators
* User actions
* Page-specific validations

This improves maintainability and reduces code duplication.

#### TestListener

Implements TestNG Listeners to:

* Capture screenshots automatically on test failures
* Improve debugging and failure analysis

#### ScreenshotUtil

Utility class responsible for:

* Creating screenshots
* Storing screenshots in the screenshots directory

---

## Test Cases

### Test Case 1 – OLG Page Validation

**Objective**

Validate basic UI elements on the OLG homepage.

**Validations**

* Page title is displayed correctly
* Login button is visible
* Sign Up button is visible

---

### Test Case 2 – Google Maps Restaurant Search

**Objective**

Validate restaurant search functionality using Google Maps.

**Steps**

1. Navigate to Google Maps
2. Search for "Restaurants"
3. Wait for results to load
4. Verify search results are displayed

**Validations**

* Search execution succeeds
* Restaurant results are displayed

---

## Prerequisites

Before running the project, ensure the following are installed:

* Java 21 or higher
* Maven 3.8+
* Git
* IntelliJ IDEA (Recommended)

---

## Project Setup

### Clone Repository

```bash
git clone <repository-url>
cd OLG-assignment
```

### Install Dependencies

```bash
mvn clean install
```

### Install Playwright Browsers

Run the following command once:

```bash
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install chromium"
```

---

## Running the Tests

### Execute All Tests Using Maven

```bash
mvn test
```

### Execute Using TestNG Suite

```bash
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

### Execute from IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Allow Maven dependencies to download
3. Install Playwright browsers (one-time setup)
4. Open `testng.xml`
5. Right-click and select **Run 'testng.xml'**

Alternatively, run the `AssignmentTest` class directly.

### Execute in Headless Mode

```bash
mvn test -Dheadless=true
```

---

## Test Execution Flow

```text
AssignmentTest
        │
        ▼
     BaseTest
        │
        ▼
   Launch Browser
        │
        ▼
    Execute Tests
        │
        ▼
     Assertions
        │
        ▼
   Test Listener
        │
        ▼
 Screenshot on Failure
        │
        ▼
   Browser Cleanup
```

---

## Screenshots

Screenshots are captured automatically whenever a test fails.

### Screenshot Location

```text
screenshots/
```

These screenshots help with:

* Failure analysis
* Debugging
* Reporting

---

## Continuous Integration

GitHub Actions is configured to execute the automation suite automatically.

### Workflow File

```text
.github/workflows/olg-assignment.yml
```

### CI Pipeline Includes

* Maven Build
* Dependency Resolution
* Playwright Browser Installation
* Test Execution
* Build Validation

The workflow runs automatically on:

* Push events
* Pull Requests

---

## Assumptions and Limitations

* Internet connectivity is required.
* Google Maps UI and locators may change over time.
* OLG website behavior may vary across environments.
* Public websites may introduce UI changes that require locator updates.
* Test execution time may vary based on network performance.

---

## Future Enhancements

If additional time were available, the framework could be extended with:

* Cross-browser execution (Chromium, Firefox, WebKit)
* Allure Reporting
* Data-driven testing
* Parallel execution
* Docker support
* Enhanced logging
* Environment-specific configurations
* Retry mechanisms for transient failures
* CI test reports and artifacts

---

## Author

**Kathar Patcha Abdul Rahim**

