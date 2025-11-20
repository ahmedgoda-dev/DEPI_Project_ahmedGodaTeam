# 📘 Automation Test Suite -- Selenium + Java + TestNG

This project contains automated test cases for
**AutomationExercise.com** using **Selenium WebDriver**, **Java**, and
**TestNG**.\
The goal is to validate key website functionalities such as checkout,
invoice download, and scrolling behavior.

------------------------------------------------------------------------

# 👤 Author

**Ahmed Tarek**

# 📁 Project Name

**AhmedProject**

------------------------------------------------------------------------

# 🚀 Project Structure

    AhmedProject/
    │
    ├── BaseTest.java             # Driver setup and teardown
    ├── VerifyAddressDetailsTest  # Main test class
    └── README.md                 # Project documentation

------------------------------------------------------------------------

# 🧰 Technologies Used

-   Java (JDK 8 or higher)
-   Selenium WebDriver
-   TestNG
-   ChromeDriver
-   Maven (optional but recommended)

------------------------------------------------------------------------

# ⚙️ How It Works

## ✔ BaseTest.java

Handles: - WebDriver initialization\
- Browser configuration\
- Cleanup after tests

------------------------------------------------------------------------

# 🧪 Test Cases Explained

Your test suite includes **four automated test cases**:

### 1️⃣ Verify Address Details on Checkout Page

Validates delivery and billing address headers after user registration
and checkout.

### 2️⃣ Download Invoice After Purchase

Ensures the invoice can be downloaded after successfully placing an
order.

### 3️⃣ Verify Scroll Up Using Arrow Button

Checks that clicking the "scroll up" button returns the page to the top.

### 4️⃣ Verify Scroll Up Without Arrow Button

Tests manual scroll-to-top functionality using JavaScript.

------------------------------------------------------------------------

# 🔧 Running the Tests

Run via TestNG: - Right-click the test class → **Run** - Or run a
`testng.xml` suite

------------------------------------------------------------------------

If you want enhancements like POM, logging, or reporting, I can build
the full framework for you.
