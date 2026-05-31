# OLG Automation Assignment

## Introduction

This project was developed as part of the OLG Automation Assignment to demonstrate automation framework design, browser automation, test organization, maintainability, and CI/CD integration.

The framework is built using **Java 21**, **Playwright**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern to ensure clean architecture, reusability, and scalability.

---

## Assignment Coverage

### Part 1 – Basic Assertions

The framework validates:

* OLG homepage title
* Login button visibility
* Sign Up button visibility

### Part 2 – Restaurant Search Scenario

The framework validates:

* Navigation to Google Maps
* Search for "Restaurants"
* Verification that restaurant search results are returned successfully

---

## Technology Stack

| Technology     | Purpose                       |
| -------------- | ----------------------------- |
| Java 21        | Programming Language          |
| Playwright     | Browser Automation            |
| TestNG         | Test Framework                |
| Maven          | Dependency & Build Management |
| GitHub Actions | Continuous Integration        |
| IntelliJ IDEA  | Development Environment       |

---

## Why These Technologies?

### Playwright

Playwright was selected because it provides:

* Fast and reliable browser automation
* Auto-waiting capabilities
* Modern browser support
* Better handling of dynamic web applications
* Improved stability compared to traditional automation frameworks

### TestNG

TestNG provides:

* Flexible test execution
* Assertions
* Test lifecycle management
* Listener support for failure handling and screenshot capture

### Maven

Maven simplifies:

* Dependency management
* Build management
* Test execution
* Project portability across local and CI environments

---

## Framework Design

The framework follows the **Page Object Model (POM)** design pattern.

The Page Object Model was chosen to separate test logic from page interactions, making the framework easier to maintain, extend, and debug.

This approach improves:

* Maintainability
* Readability
* Reusability
* Scalability

---

## Project Structure

```text
OLG-assignment
│
├── .github
│   └── workflows
│       └── olg-assignment.yml
│
├── screenshots
│
├── src
│   └── test
│       └── java
│           ├── base
│           │   └── BaseTest.java
│           │
│           ├── listeners
│           │   └── TestListener.java
│           │
│           ├── pages
│           │   ├── OLG
│           │   │   └── OLGHomePage.java
│           │   │
│           │   └── GoogleMap
│           │       └── GoogleMapHomePage.java
│           │
│           ├── tests
│           │   └── AssignmentTest.java
│           │
│           └── utils
│               └── ScreenshotUtil.java
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## Framework Components

### BaseTest

Responsible for:

* Playwright initialization
* Browser launch
* Browser context creation
* Page creation
* Test setup and teardown
* Local and CI execution support

### Page Objects

Page Objects encapsulate:

* Locators
* Page actions
* Page-specific functionality

Benefits:

* Cleaner test code
* Reduced duplication
* Easier maintenance

### TestListener

Implements TestNG listeners to:

* Capture screenshots automatically on test failures
* Improve debugging and failure analysis

### ScreenshotUtil

Responsible for:

* Screenshot creation
* Screenshot storage
* Failure evidence collection

---

## Test Cases

### Test Case 1 – OLG Homepage Validation

**Objective**

Validate important elements on the OLG homepage.

**Validations**

* Page title verification
* Login button visibility
* Sign Up button visibility

---

### Test Case 2 – Restaurant Search Validation

**Objective**

Validate restaurant search functionality using Google Maps.

**Steps**

1. Navigate to Google Maps
2. Search for "Restaurants"
3. Wait for results to load
4. Extract search results
5. Verify at least one restaurant is returned

**Validations**

* Search executes successfully
* Results are displayed
* Restaurant list is not empty

---

## Prerequisites

Before running the framework, ensure the following are installed:

* Java 21 or higher
* Maven 3.8+
* Git
* IntelliJ IDEA recommended for local execution

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

## Executing Tests

### Run All Tests

```bash
mvn test
```

### Run Using TestNG Suite

```bash
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

### Run in Headless Mode

```bash
mvn test -Dheadless=true
```

### Run from IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Allow Maven dependencies to download
3. Install Playwright browsers using the command mentioned above
4. Open `testng.xml`
5. Right-click and select **Run 'testng.xml'**

Alternatively, the `AssignmentTest` class can be executed directly from IntelliJ IDEA.

---

## Screenshots

The framework automatically captures screenshots whenever a test fails.

### Screenshot Location

```text
screenshots/
```

Screenshots captured during failures can be used for debugging both in local execution and CI environments.

### Benefits

* Faster debugging
* Improved failure analysis
* Better troubleshooting

---

## Continuous Integration

GitHub Actions has been configured to automatically execute the framework.

### Workflow File

```text
.github/workflows/olg-assignment.yml
```

### CI Pipeline Includes

* Source checkout
* Java 21 setup
* Maven build
* Dependency resolution
* Playwright browser installation
* Test execution
* Build validation
* Screenshot artifact upload if failures occur

### Trigger Events

The workflow executes automatically on:

* Push events
* Pull requests

---

## Assumptions and Limitations

* Internet connectivity is required.
* Public website content may change over time.
* Google Maps locators may require maintenance if the UI changes.
* OLG website behavior may vary across regions and environments.
* Test execution duration depends on network conditions.

---

## Future Enhancements

Given additional time, the framework could be enhanced with:

* Cross-browser execution using Chromium, Firefox, and WebKit
* Parallel execution
* Data-driven testing
* Allure reporting
* Docker support
* Enhanced logging
* Environment-specific configuration management
* Retry mechanisms
* Test reporting dashboards
* CI artifact publishing for reports and screenshots

---

## Author

**Kathar Patcha Abdul Rahim**

Automation Framework developed for the OLG Automation Assignment.
