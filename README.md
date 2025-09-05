# IMDb Selenide Test Project

This project automates a regression test using Selenide, TestNG, and Allure Report on Java 21. It:
1. Opens imdb.com
2. Searches for "QA"
3. Prints 5 members of the People section

## How to run
- Make sure you have Java 21 and Maven installed.
- Place the correct ChromeDriver binary in `resources/chromedriver` (or set the path via system property).
- Run tests with:
  ```
  mvn clean test allure:report
  ```
- To use a custom ChromeDriver path, run:
  ```
  mvn clean test -Dchromedriver.path=/your/path/to/chromedriver
  ```
- Allure results will be generated in `allure-results`.

## Dependencies
- Selenide
- TestNG
- Allure Report

## Maintainer
Update this file as needed for your workflow.
