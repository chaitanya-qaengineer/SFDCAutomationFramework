# SFDC Automation Framework

A Selenium-based UI test automation framework for Salesforce (SFDC), built with Java, TestNG, and Maven. The framework follows the **Page Object Model (POM)** design pattern and supports data-driven testing, structured logging, and HTML test reporting.

---

## 🛠️ Tech Stack

| Tool/Library     | Purpose                          |
|------------------|----------------------------------|
| Java             | Core programming language        |
| Selenium WebDriver | Browser automation             |
| TestNG           | Test execution and configuration |
| Maven            | Build and dependency management  |
| Apache POI       | Excel-based data-driven testing  |
| Log4j2           | Test execution logging           |
| ExtentReports    | HTML test reporting              |

---

## 📁 Project Structure

```
SFDCAutomationFramework/
├── src/test/java/
│   ├── Pages/                  # Page Object classes
│   │   ├── BasePage.java
│   │   ├── LoginPage.java
│   │   ├── HomePage.java
│   │   ├── CreateAccountPage.java
│   │   ├── OpportunitiesPage.java
│   │   ├── UserMenuPage.java
│   │   └── ForgotPasswordPage.java
│   ├── tests/                  # Test classes
│   │   ├── BaseTest.java
│   │   ├── LoginTest.java
│   │   ├── CreateAccountTest.java
│   │   ├── OpportunitiesTest.java
│   │   └── UserMenuTest.java
│   ├── utils/                  # Utility/helper classes
│   │   ├── CommonUtils.java
│   │   ├── DataUtils.java
│   │   ├── FileHandlingMethods.java
│   │   └── excelUtilities.java
│   ├── constants/              # Constants
│   │   ├── FileConstants.java
│   │   └── WaitConstants.java
│   ├── Listeners/              # TestNG Listeners
│   │   └── TestListener.java
│   └── testdata/               # External test data
│       ├── loginTestData.properties
│       ├── AccountTestData.properties
│       ├── OpportunitiesTestData.properties
│       └── usermenuTestData.properties
├── src/test/resources/
│   └── log4j2.xml              # Logging configuration
├── testng.xml                  # TestNG suite configuration
└── pom.xml                     # Maven build file
```

---

## ✅ Test Coverage

| Module           | Test Scenarios                                      |
|------------------|-----------------------------------------------------|
| Login            | Valid login, invalid credentials, forgot password   |
| Create Account   | Create new account with required and optional fields|
| Opportunities    | Create and validate opportunity records             |
| User Menu        | Profile settings, navigation, logout                |

---

## ⚙️ Prerequisites

- Java JDK 11 or higher
- Maven 3.6+
- Chrome browser (ChromeDriver managed automatically)
- Salesforce sandbox or developer org credentials

---

## 🚀 How to Run

**1. Clone the repository**
```bash
git clone https://github.com/chaitanya-qaengineer/SFDCAutomationFramework.git
cd SFDCAutomationFramework
```

**2. Add your credentials**

Update the following file with your Salesforce credentials:
```
src/test/java/testdata/loginTestData.properties
```

**3. Run all tests via Maven**
```bash
mvn clean test
```

**4. Run a specific TestNG suite**
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

---

## 📊 Test Reports

After execution, HTML reports are generated at:
```
src/test/java/reports/<timestamp>.html
```

Open any `.html` file in a browser to view detailed pass/fail results with logs.

---

## 🏗️ Framework Design

- **Page Object Model (POM):** Each Salesforce page has a dedicated class encapsulating its web elements and actions, keeping test logic separate from UI interaction code.
- **BaseTest:** Handles WebDriver initialization, teardown, and shared test configuration.
- **TestListener:** Implements TestNG `ITestListener` to capture screenshots on test failure and log test results automatically.
- **Data-Driven Testing:** Test data is externalized in `.properties` files and Excel sheets, allowing tests to run with multiple data sets without code changes.
- **Logging:** Log4j2 is configured to write timestamped log files for every test run.

---

## Author

**Chaitanya** — QA Engineer  
GitHub: [chaitanya-qaengineer](https://github.com/chaitanya-qaengineer)
