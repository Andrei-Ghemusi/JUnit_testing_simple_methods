# JUnit_testing_simple_methods

## Introduction
In the following project, I create and execute test scripts using JUnit-5. This is an introductory project, following this I will add another more complex one.

## Purpose
These tests are used to show the different capabilities of JUnit-5.

## Project Structure
- in the maina/java - io.javabrains package containing the classes: MathUtils and Grader;
- in the test/java - io.javabrains package containing the classes: MathUtilsTest and GraderTest;

## Testing Software Used
 - JUnit-5
 - this project is using JDK-21;

## Running the project
The project was built and ran on **IntelliJ IDEA 2023.2.2 (Community Edition)**
- To run the project press on the green arrow on the desired class of tests;
- To run the desired test, on the test class, click on the green arrow for that method;
- To run the tests using Maven, click on Maven then: clean, compile, test and then install.
- To run the tests using the terminal, run the following commands in order:
  - `mvn clean compile test package`
  - `mvn install`
  - in case the command does not work add " .\ " to the beggining (Ex: `.\mvn clean compile test package`)
  - Explanation:
    - `mvn` runs maven
    - `clean` deletes the target folder
    - `compile` compiles the code into machine lang
    - `package` in the new 'target' directory it creates a .jar file that can be used by you or someone else
