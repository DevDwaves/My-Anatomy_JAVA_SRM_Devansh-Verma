# Java Practical Projects

A collection of Java practical projects developed and executed using **Visual Studio Code**. The repository includes basic Java programming, Java Swing GUI development, inventory management, and multithreaded CSV processing.

## Projects Included

| Module | Project | Description | Type |
|---|---|---|---|
| Module 1 | `first-app` | Prints `Hello World!` | Console Application |
| Module 1 | `Inventory Management System` | Manages products, categories, stock, and low-stock reports | Console Application |
| Module 2 | `calculator-executable-jar` | Performs basic arithmetic operations using a graphical interface | Java Swing GUI |
| Module 2 | `MultiThreadedFileProcessor` | Processes CSV sales files concurrently and generates a report | Multithreaded Console Application |

---

## Technologies Used

- **Language:** Java
- **JDK:** Java 25
- **IDE:** Visual Studio Code
- **GUI:** Java Swing
- **Concurrency:** `ExecutorService` and Thread Pool
- **File Handling:** Java File I/O
- **Data Storage:** Java Serialization
- **Terminal:** PowerShell

> **Note:** The projects can be compiled and executed directly using `javac` and `java`. Maven commands are not required for the direct execution method.

---

## Repository Structure

```text
Maven Project/
│
├── README.md
│
├── Module 1/
│   ├── first-app/
│   │   ├── src/
│   │   ├── target/
│   │   └── pom.xml
│   │
│   └── Inventory Management System/
│       ├── Main.java
│       ├── InventoryManager.java
│       ├── Product.java
│       ├── Category.java
│       ├── FileManager.java
│       ├── products.dat
│       └── categories.dat
│
└── Module 2/
    ├── calculator-executable-jar/
    │   ├── src/
    │   ├── target/
    │   └── pom.xml
    │
    └── MultiThreadedFileProcessor/
        ├── data/
        ├── src/
        ├── out/
        ├── report.txt
        └── run.bat
```

---

# 1. First App

## Overview

A basic Java console application that prints:

```text
Hello World!
```

## Execution

Open the `first-app` folder in VS Code and run the following commands from its project root.

### Compile

```powershell
javac -d target\classes src\main\java\com\example\myapp\App.java
```

### Run

```powershell
java -cp target\classes com.example.myapp.App
```

### Expected Output

```text
Hello World!
```

---

# 2. Inventory Management System

## Overview

A menu-driven Java console application for managing products, categories, stock quantities, and low-stock reports.

## Features

- Add, view, search, update, and delete products
- Add, view, update, and delete categories
- Add and remove stock
- Display low-stock products
- Validate user input
- Store data using Java serialization

## Main Files

| File | Purpose |
|---|---|
| `Main.java` | Main method and menu flow |
| `InventoryManager.java` | Inventory operations |
| `Product.java` | Product details |
| `Category.java` | Category details |
| `FileManager.java` | Saving and loading data |

## Execution

Open the `Inventory Management System` folder in VS Code.

### Compile

```powershell
javac -d out *.java
```

### Run

```powershell
java -cp out Main
```

The inventory menu will appear in the terminal.

> Run the application from the project folder so the relative paths for `products.dat` and `categories.dat` work correctly.

---

# 3. Calculator Project

## Overview

A Java Swing desktop calculator application that provides a graphical interface for performing basic arithmetic operations.

## Features

- Addition
- Subtraction
- Multiplication
- Division
- Result display
- Exit option
- Invalid input handling
- Division-by-zero handling

## Execution

Open the `calculator-executable-jar` folder in VS Code.

### Compile

```powershell
javac -d target\classes src\main\java\com\example\myapp\App.java
```

### Run

```powershell
java -cp target\classes com.example.myapp.App
```

The calculator GUI should open after execution.

---

# 4. Multi-Threaded CSV File Processor

## Overview

A Java application that processes multiple CSV sales files concurrently using a thread pool and generates a consolidated sales report.

## Features

- Reads CSV files from the `data` folder
- Processes files concurrently
- Uses `ExecutorService`
- Creates processing tasks for CSV files
- Aggregates processing results
- Generates `report.txt`

## Main Components

| Component | Purpose |
|---|---|
| `Main.java` | Application entry point |
| `ProcessorConfig.java` | Processor configuration |
| `SalesRecord.java` | Sales data model |
| `CsvFileProcessor.java` | CSV file processing |
| `ReportAggregator.java` | Result aggregation and report generation |

## Execution Method 1: Using run.bat

Open the terminal inside the `MultiThreadedFileProcessor` folder:

```powershell
.\run.bat
```

## Execution Method 2: Manual Compilation

### Compile

Run this command from the project root:

```powershell
javac -d out src\Main.java src\model\SalesRecord.java src\config\ProcessorConfig.java src\processor\CsvFileProcessor.java src\report\ReportAggregator.java
```

### Run

```powershell
java -cp out Main
```

### Output

The application generates:

```text
report.txt
```

The report contains the consolidated results of the processed sales data.

---

## Requirements

Install the following software:

1. Java Development Kit (JDK)
2. Visual Studio Code
3. Java Extension Pack for Visual Studio Code (recommended)

### Check Java Installation

```powershell
java -version
```

### Check Java Compiler

```powershell
javac -version
```

---

## General Execution Workflow

```text
Open the Required Project
          |
          v
Open the VS Code Terminal
          |
          v
Move to the Project Root
          |
          v
Compile Java Files using javac
          |
          v
Generate .class Files
          |
          v
Run the Main Class using java
          |
          v
View the Output or Generated Report
```

---

## Troubleshooting

### Java or javac Is Not Recognized

Run:

```powershell
java -version
javac -version
```

If either command fails, install the JDK and configure the Java PATH environment variable.

### Maven Is Not Recognized

If `mvn` is not recognized, Maven is either not installed or not configured in the system PATH.

The projects can still be executed directly using:

```powershell
javac
java
```

### File Not Found During Compilation

Make sure the command matches your current directory:

- From the project root, use paths beginning with `src\`.
- If you are already inside the `src` folder, do not add another `src\` prefix.

### Main Class Not Found

Check that:

- Compilation completed without errors.
- The classpath points to the correct output folder.
- The correct main class is used.
- Package names match the execution command where applicable.

### Inventory Data File Error

Run the Inventory Management System from its own project folder because it uses relative data-file paths.

### CSV Report Not Generated

Check that:

- CSV files are available in the expected `data` folder.
- Compilation completed successfully.
- The program is run from the project root.
- The application has permission to create `report.txt`.

---

## Learning Outcomes

These projects demonstrate:

- Java compilation and bytecode execution
- Java package and folder structure
- Object-oriented programming
- Java Swing GUI development
- CRUD operations
- File handling and serialization
- CSV processing
- Multithreading with `ExecutorService`
- Thread pool execution
- Report generation
- Input validation and exception handling
- Running Java applications in Visual Studio Code

---

## Conclusion

This repository contains Java practical projects covering console applications, GUI development, inventory management, file handling, and multithreaded CSV processing.

The projects provide practical experience with Java programming, compilation, execution, object-oriented design, serialization, concurrency, and report generation.

---

## Author

**Devansh Verma**

B.Tech – Computer Science and Engineering

SRM Institute of Science and Technology
