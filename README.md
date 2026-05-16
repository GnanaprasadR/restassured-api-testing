# RestAssured API Testing Framework

A Java-based REST API test automation framework built with RestAssured and TestNG, demonstrating end-to-end API validation including request building, response assertion, and dual reporting via ExtentReports and Allure.

---

## What This Project Tests

This framework validates the **[JSONPlaceholder](https://jsonplaceholder.typicode.com/)** public REST API — a free, open API commonly used for prototyping and testing. Test coverage includes:

- `GET /posts` — Retrieve all posts and assert response structure
- `GET /posts/{id}` — Retrieve a single post by ID and validate response body fields
- `POST /posts` — Create a new post and validate the 201 response and returned payload

---

## Tech Stack

| Tool | Version | Purpose |
|---|---|---|
| Java | 11+ | Core language |
| RestAssured | 5.4.0 | HTTP request building and response assertion |
| TestNG | 7.8.0 | Test structure and execution |
| Jackson Databind | 2.16.0 | JSON serialization / deserialization |
| ExtentReports | 5.1.1 | HTML test reporting |
| Allure Maven Plugin | 2.11.2 | Allure report generation |
| Maven | 3.8+ | Build and dependency management |

---

## Prerequisites

- Java JDK 11 or above installed
- Maven 3.8+ installed
- Internet access (tests run against a live public API)

---

## Project Structure

```
restassured-api-testing/
├── src/
│   └── test/
│       └── java/
│           ├── tests/          # Test classes (GET, POST test cases)
│           └── utils/          # Helper utilities (report setup, base config)
├── allure-results/             # Raw Allure result files (auto-generated)
├── target/                     # Maven build output
├── pom.xml                     # Project dependencies and build config
└── README.md
```

---

## How to Run

**Clone the repository:**
```bash
git clone https://github.com/GnanaprasadR/restassured-api-testing.git
cd restassured-api-testing
```

**Run all tests:**
```bash
mvn clean test
```

---

## Test Reports

### ExtentReports (HTML)
After test execution, an HTML report is generated at:
```
test-output/ExtentReports/ExtentReport.html
```
Open this file in any browser to view a detailed test execution summary.

### Allure Report
To generate and view the Allure report:
```bash
mvn allure:report
mvn allure:serve
```
This opens the Allure dashboard in your default browser automatically.

---

## Author

**Gnanaprasad R**
SDET | 10 years of experience in software testing
[LinkedIn](https://www.linkedin.com/in/gnanaprasad-r-556082b7) • [GitHub](https://github.com/GnanaprasadR)
