# Java Practical Projects

A collection of beginner-friendly Java projects developed and executed using **Visual Studio Code**. This repository contains two practical applications that demonstrate basic Java programming, project structure, compilation, and execution.

## Projects Included

| Project | Description | Application Type |
|---|---|---|
| `first-app` | A basic Java program that prints `Hello World!` | Console Application |
| `calculator-executable-jar` | A simple calculator supporting basic arithmetic operations | Java Swing GUI Application |

---

## Technologies Used

- **Programming Language:** Java
- **JDK Version Used:** Java 25
- **IDE:** Visual Studio Code
- **GUI Framework:** Java Swing
- **Project Configuration:** Maven structure
- **Terminal:** PowerShell

> **Note:** The projects were compiled and executed directly using `javac` and `java`. Maven was not used for execution because Maven was not configured in the system PATH.

---

## Repository Structure

```text
Java-Practical-Projects/
│
├── first-app/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── com/
│   │   │           └── example/
│   │   │               └── myapp/
│   │   │                   └── App.java
│   │   ├── test/
│   │   └── ...
│   ├── target/
│   ├── pom.xml
│   └── README.md
│
├── calculator-executable-jar/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── com/
│   │   │           └── example/
│   │   │               └── myapp/
│   │   │                   └── App.java
│   │   ├── test/
│   │   └── ...
│   ├── target/
│   ├── pom.xml
│   └── README.md
│
└── README.md
```

---

# 1. First App

## Overview

The `first-app` project is a simple Java console application that prints:

```text
Hello World!
```

It is designed to demonstrate the basic process of compiling and executing a Java program.

## Execution Steps

Open the `first-app` folder in Visual Studio Code and open the integrated terminal.

### Compile the Program

```powershell
javac -d target\classes src\main\java\com\example\myapp\App.java
```

### Run the Program

```powershell
java -cp target\classes com.example.myapp.App
```

### Expected Output

```text
Hello World!
```

## Command Explanation

- `javac`: Compiles the Java source code.
- `-d target\classes`: Stores compiled class files in the specified directory.
- `java`: Runs the compiled Java program.
- `-cp target\classes`: Sets the classpath.
- `com.example.myapp.App`: Specifies the fully qualified main class.

---

# 2. Calculator Project

## Overview

The `calculator-executable-jar` project is a desktop calculator application developed using **Java Swing**. It provides a graphical user interface for performing basic arithmetic operations.

## Features

- Addition
- Subtraction
- Multiplication
- Division
- Result display
- Exit button
- Invalid input handling
- Division-by-zero error handling

## Execution Steps

Open the `calculator-executable-jar` folder in Visual Studio Code.

### Compile the Program

```powershell
javac -d target\classes src\main\java\com\example\myapp\App.java
```

### Run the Calculator

```powershell
java -cp target\classes com.example.myapp.App
```

After running the command, the calculator GUI should open.

## Command Explanation

- `javac`: Compiles the Java source file.
- `-d target\classes`: Saves the compiled `.class` files in the target directory.
- `java`: Starts the compiled Java application.
- `-cp target\classes`: Provides the location of the compiled classes.
- `com.example.myapp.App`: Identifies the main application class.

---


## Requirements

Before running the projects, install:

1. Java Development Kit (JDK)
2. Visual Studio Code
3. Java Extension Pack for Visual Studio Code (recommended)

### Verify Java Installation

Run:

```powershell
java -version
```

Verify the Java compiler:

```powershell
javac -version
```

---

## General Execution Workflow

The common workflow for both projects is:

```text
Open Project
     |
     v
Open VS Code Terminal
     |
     v
Compile App.java using javac
     |
     v
Generate .class Files
     |
     v
Run Main Class using java
     |
     v
View Program Output
```

---

## Troubleshooting

### Java Is Not Recognized

Check whether the JDK is installed:

```powershell
java -version
javac -version
```

If either command fails, install the JDK and configure the Java PATH environment variable.

### Maven Is Not Recognized

If you see an error stating that `mvn` is not recognized, Maven is either not installed or not added to the system PATH.

The projects can still be compiled and executed directly using:

```powershell
javac
java
```

### Calculator GUI Does Not Open

Check that:

- The compilation command completed without errors.
- The correct project directory is open.
- The fully qualified class name is correct.
- The Java application is not being terminated immediately.

---

## Learning Outcomes

These projects demonstrate:

- Java source-code compilation
- Java bytecode execution
- Package and folder structure
- Main class execution
- Command-line execution
- Java Swing GUI development
- Basic arithmetic operations
- Basic input validation and error handling
- Working with Java projects in Visual Studio Code

---

## Conclusion

This repository contains two Java practical projects: a basic `Hello World` console application and a graphical calculator application. Both projects were compiled and executed in Visual Studio Code using Java's `javac` compiler and `java` runtime commands.

The repository provides a simple reference for understanding Java project organization, compilation, execution, and basic GUI application development.

---

## Author

**Devansh Verma**

B.Tech – Computer Science and Engineering  
SRM Institute of Science and Technology
