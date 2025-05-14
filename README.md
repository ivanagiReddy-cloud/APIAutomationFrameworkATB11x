#API Automation Framework

# 🚀 API Automation Framework

A robust and scalable **API Automation Framework** built using **Java** and **REST Assured**, integrated with modern tools like **TestNG**, **Allure**, **Jenkins**, and **SonarQube** to ensure test quality, CI/CD, and reporting.

---

## 📦 Tech Stack & Tools

| Category               | Tool / Library                     |
|------------------------|------------------------------------|
| Language               | Java                               |
| API Testing Library    | REST Assured                       |
| Test Runner            | TestNG                             |
| Build Tool             | Maven                              |
| CI/CD Integration      | Jenkins                            |
| Code Quality           | SonarQube                          |
| Reporting              | Allure Report                      |
| Logging                | Log4j                              |
| JSON Handling          | Jackson API                        |
| Payload Management     | External JSON Files / POJOs        |
| Excel Integration      | Apache POI                         |
| Version Control        | Git                                |

---

## 📁 Project Structure

```

project-root/
├── src/test/java
│   ├── tests/               # Test classes
│   ├── utils/               # Utility classes (e.g., Excel reader, log config)
│   ├── payloads/            # POJO builders / Jackson mappers for payloads
│   ├── config/              # Environment configs
│   ├── base/                # Base test setup classes
├── src/test/resources
│   ├── testdata/            # JSON and Excel test data
│   ├── log4j.properties     # Log4j config
├── target/                  # Test output and reports
├── pom.xml                  # Maven dependencies
├── testng.xml               # TestNG suite config
└── README.md                # Project documentation

````

---

## 🧪 Features

- 🔹 Modular and scalable API test framework
- 🔹 Payload management using Jackson
- 🔹 Data-driven testing with Apache POI (Excel)
- 🔹 Real-time reports with Allure
- 🔹 Clean logging via Log4j
- 🔹 CI support with Jenkins
- 🔹 SonarQube for code quality
- 🔹 Maven build support

---

## 🚀 How to Run the Tests

### 🛠️ Prerequisites
- Java 11 or above
- Maven
- Git
- Allure CLI (for report generation)
- IntelliJ IDEA or any Java IDE

### 📦 Install Dependencies
```bash
mvn clean install
````

### ▶️ Run All Tests via Maven

```bash
mvn test
```

### ▶️ Run Specific Test Class

```bash
mvn -Dtest=ClassName test
```

Example:

```bash
mvn -Dtest=LoginAPITest test
```

### 📊 Generate Allure Report

```bash
allure serve target/allure-results
```

---

## ➕ How to Add a New Test Case

To add a new API test to the framework, follow these steps:

### 1️⃣ Create a New Test Class

Inside the `src/test/java/tests/` directory:

```java
package tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class NewUserAPITest {

    @Test
    public void createUserTest() {
        RestAssured.baseURI = "https://api.example.com";
        
        String payload = "{ \"name\": \"John\", \"job\": \"QA\" }";

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/users")
        .then()
            .statusCode(201);
    }
}
```

---

### 2️⃣ Add Test to `testng.xml`

Open `testng.xml` and add your class:

```xml
<classes>
    <class name="tests.NewUserAPITest" />
</classes>
```

---

### 3️⃣ (Optional) Add Payload in JSON File

Store request/response JSON files in `src/test/resources/testdata/` and load using Jackson or a utility method.

---

### 4️⃣ Use Utilities or Loggers

Use built-in utility methods for:

* Logging (via Log4j)
* Reading Excel or JSON
* Building POJOs via Jackson

---

## 🔁 CI/CD Integration

* Framework supports Jenkins for CI pipelines.
* Configure jobs to trigger on Git commits or pull requests.
* Test reports and logs are published on each run.
* SonarQube integration ensures code quality gates.

---

## 🔍 SonarQube Link

> 📡 [View Code Quality Dashboard](http://your-sonarqube-instance.com/dashboard?id=your-project-id)
> *(Replace with actual URL)*

---

## 📄 Logging

* Framework uses **Log4j** for consistent logging.
* Logs are saved in `/logs/` with timestamps for each test run.

---

## 📝 License

This project is licensed under the [MIT License](LICENSE) (or your preferred license).

---

## 👨‍💻 Maintainer

* **Your Name** – [your.email@example.com](mailto:your.email@example.com)
* Team/Org Name

---

## 🙌 Contributions

We welcome contributions and improvements. Please fork the repository and raise a pull request following standard coding practices.

```

---

Would you like this exported as a `.md` file or added to your project directly via code snippet?
```
