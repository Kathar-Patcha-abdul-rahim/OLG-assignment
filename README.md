# OLG Automation Assignment

## Overview

This project was developed as part of the OLG Automation Assignment. The solution uses Java, Playwright, TestNG, and Maven following the Page Object Model (POM) design pattern.

The framework validates:

1. Basic Assertions

   * Verify page title
   * Verify visibility of important page elements

2. Restaurant Search Scenario

   * Search for "Restaurants" using Google Maps
   * Verify search results contain restaurant entries

---

## Tech Stack

| Tool           | Purpose                         |
| -------------- | ------------------------------- |
| Java 21        | Programming language            |
| Playwright     | Browser automation              |
| TestNG         | Test execution and assertions   |
| Maven          | Build and dependency management |
| GitHub Actions | Continuous Integration          |
| IntelliJ IDEA  | Development IDE                 |

### Why Playwright?

Playwright provides reliable browser automation, auto-waiting capabilities, modern browser support, and improved execution stability compared to traditional automation tools.

---

## Framework Design

The framework follows the Page Object Model (POM) design pattern.

```text
src/test/java
├── base
│   └── BaseTest
├── listeners
│   └── TestListener
├── pages
│   ├── OLG
│   │   └── OLGHomePage
│   └── GoogleMap
│       └── GoogleMapHomePage
├── tests
│   └── AssignmentTest
└── utils
    └── ScreenshotUtil
```

### Components

* BaseTest

  * Browser initialization and teardown
  * Supports local and CI execution

* Page Objects

  * Encapsulate page locators and actions

* TestListener

  * Captures screenshots automatically on test failures

* ScreenshotUtil

  * Stores screenshots under the screenshots directory

---

## Test Cases

### Test 1: Basic Assertions

Validates:

* OLG page title
* Login button visibility
* Sign Up button visibility

### Test 2: Restaurant Search Scenario

Validates:

* Google Maps loads successfully
* Search for "Restaurants"
* Results contain restaurant entries

---

## Running the Project

### Prerequisites

* Java 17+
* Maven 3.8+
* Git

### Clone Repository

```bash
git clone <repository-url>
cd OLG-assignment
```

### Install Playwright Browsers

```bash
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install chromium"
```

### Run Tests

```bash
mvn test
```

### Run in Headless Mode

```bash
mvn test -Dheadless=true
```

---

## Continuous Integration

GitHub Actions is configured to execute the automation suite automatically on every push and pull request.

Workflow file:

```text
.github/workflows/olg-assignment.yml
```

---

## Screenshots

Screenshots are automatically captured when a test fails using a TestNG Listener implementation.

Location:

```text
screenshots/
```

---

## Assumptions and Limitations

* Google Maps page structure may change over time, requiring locator maintenance.
* OLG page behavior may vary between headed and headless environments.
* Internet connectivity is required for successful execution.
* Public websites used in the assignment may occasionally introduce UI updates affecting locators.

---

## Future Improvements

If given additional time, I would:

* Add cross-browser execution (Chrome, Firefox, Edge)
* Add Allure reporting
* Implement data-driven testing
* Integrate parallel execution
* Add Docker support
* Improve reporting and logging
* Add environment configuration management

---

## Author

Kathar Patcha Abdul Rahim
