# API Automation with Gauge

This project focuses on automating API testing using [Gauge](https://gauge.org/), an open-source test automation framework that is both user-friendly and powerful. It is structured to facilitate the implementation and organization of test scenarios in a readable and maintainable format.

## Requirements

To set up and run this project, ensure the following are installed:

- **Maven**: For dependency management and building the project.
- **Java**: Required to run Gauge and the testing framework.
- **Gauge**: The core framework used for writing and executing test cases.

## Project Structure

The project is organized into the following directories:

### 1. `Base`
Contains reusable generic methods that support test steps and core functionalities across the project. This structure allows easy access to commonly used functions throughout the project.

### 2. `Implementations`
Holds step implementations for each test case. This directory defines the behavior of each test step, providing the necessary step definitions to execute tests.

### 3. `Models`
Contains model classes representing the structure of service responses. These models are used to map and validate API response data during tests. Each model represents the structure of the response from the API being tested and assists in the verification process.

### 4. `Specs`
The main directory for test specifications, which includes:
   - **Happy Path Cases**: Tests covering standard, expected flows.
   - **Negative Cases**: Tests that check edge cases and error handling. These tests verify how the system responds in unexpected situations.

---
