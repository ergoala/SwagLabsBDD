# SwagLabs Android Automation Project

This project is an automated testing suite for the SwagLabs mobile application, designed with scalability and maintainability in mind using modern automation practices.

## Technologies Used

*   **Kotlin**: The primary programming language.
*   **Cucumber (BDD)**: Used for defining test scenarios in natural language (Gherkin).
*   **UI Automator**: The underlying automation engine for interacting with Android system and third-party apps.
*   **Gradle**: Build automation tool for dependency management and execution.

##  Design Pattern: Page Object Model (POM)

The project implements the **Page Object Model (POM)** design pattern to enhance test maintenance and reduce code duplication.

*   **Pages**: Each screen of the application has its own class (e.g., `LoginPage`, `ProductsPage`) containing the specific logic and interactions for that screen.
*   **Decoupling**: Step definitions only orchestrate the flow by calling methods from the Page classes, keeping the business logic separate from the technical implementation.

##  Behavior-Driven Development (BDD)

Tests are written from the user's perspective using **Gherkin** syntax (`Given`, `When`, `Then`). This allows:
*   Clear communication between technical and non-technical stakeholders.
*   Reusable step definitions.
*   Organized test scenarios in `.feature` files located in `src/androidTest/assets/features`.

##  Locator Management (JSON)

Unlike traditional automation where locators are hardcoded in classes, this project uses a **JSON-based locator system**:
*   **JSON files**: Located in `src/androidTest/assets/locators/`.
*   **Structure**: Elements are defined by their `content-desc` or `text` using a simplified XPath-like format.
*   **Benefit**: If an ID changes in the app, you only need to update the JSON file without modifying the Kotlin code.
*   **Helper**: A generic `Helper` class reads these JSONs and converts them into UI Automator `BySelector` objects dynamically.

##  Project Structure

```text
app/src/androidTest/
├── assets/
│   ├── features/      # Gherkin feature files
│   └── locators/      # JSON files with element selectors
└── java/com/swaglabsmobileapp/testapp/
    ├── cucumberPackages/
    │   ├── pages/     # Page Object classes
    │   ├── steps/     # Cucumber Step Definitions
    │   └── utility/   # Hooks, Helpers, and JSON readers
    └── test/          # TestRunner configuration
```

##  How to Execute

### Prerequisites
1.  **Android Studio IDE**: Latest stable version recommended.
2.  **Android Emulator** or Physical Device connected.
3.  **Swag Labs App** installed on the device (Package: `com.swaglabsmobileapp`).
4.  **JAVA_HOME** correctly configured in your environment.

### Execution via Android Studio
1.  Navigate to `src/androidTest/java/.../test/TestRunner.kt`.
2.  Right-click the `TestRunner` class.
3.  Select **Run 'TestRunner'**.

### Execution via Command Line
Open the terminal in the root folder and run:
```bash
./gradlew connectedDebugAndroidTest
```

### Viewing Reports
After execution, a detailed HTML report with screenshots of any failures is generated at:
`app/build/reports/cucumber-report.html`
