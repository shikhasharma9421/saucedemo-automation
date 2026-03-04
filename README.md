# SauceDemo Automation Framework (Selenium + Java + TestNG)

This is my first automation testing project where I am building the framework structure by myself.
The framework is designed using **Page Object Model (POM)** to keep tests clean, reusable, and maintainable.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- IntelliJ IDEA

## Application Under Test
SauceDemo website (login + end-to-end checkout flow)

---

## Project Structure
saucedemo-automation/
├── src
│ └── test
│ └── java
│ ├── base
│ │ └── BaseTest.java
│ ├── pages
│ │ ├── LoginPage.java
│ │ ├── InventoryPage.java
│ │ ├── CartPage.java
│ │ └── ...
│ └── tests
│ ├── LoginTest.java
│ └── endToEndCheckoutTest.java
├── pom.xml
├── .gitignore
└── README.md


### Folder Explanation
- **base/**: Common setup/teardown (browser start/quit), shared utilities
- **pages/**: Page classes (locators + actions), following POM
- **tests/**: Test classes (TestNG test cases)

Test Scenarios Covered

Login functionality
Inventory page validations
Add to cart
End-to-end checkout flow (Login → Add items → Cart → Checkout)
