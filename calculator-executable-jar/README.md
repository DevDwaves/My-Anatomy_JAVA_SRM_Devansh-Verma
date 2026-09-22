# Simple Calculator – Java Swing Project

## 1. Project Overview

This project is a simple desktop calculator application developed using **Java Swing**. It provides a graphical user interface (GUI) through which users can perform basic arithmetic operations.

### Supported Operations

- Addition
- Subtraction
- Multiplication
- Division
- Exit application
- Input validation for invalid numbers
- Error message for division by zero

---

## 2. Technologies Used

- **Programming Language:** Java
- **GUI Framework:** Java Swing
- **Build Tool Configuration:** Maven
- **IDE:** Visual Studio Code
- **JDK Version Used:** Java 25

---

## 3. Project Structure

```text
calculator-executable-jar/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── myapp/
│   │                   └── App.java
│   │
│   └── test/
│
├── target/
├── pom.xml
└── README.md
```

### Main Source File

```text
src/main/java/com/example/myapp/App.java
```

The `App.java` file contains the graphical interface, buttons, event listeners, and calculation logic.

---

## 4. Requirements

Before executing the project, make sure the following software is installed:

1. Java Development Kit (JDK)
2. Visual Studio Code
3. Java Extension Pack for VS Code (recommended)

Check whether Java is installed by executing the following command in the VS Code terminal:

```powershell
java -version
```

Example output:

```text
java version "25" 2025-09-16 LTS
```

---

## 5. Execution in Visual Studio Code

### Step 1: Open the Project

Open the following folder in Visual Studio Code:

```text
calculator-executable-jar
```

Make sure the terminal is opened in the folder containing `pom.xml`.

Example terminal location:

```text
...\Java Full Stack Practical Code\Maven Project\calculator-executable-jar
```

### Step 2: Compile the Java Program

Run the following command in the PowerShell terminal:

```powershell
javac -d target\classes src\main\java\com\example\myapp\App.java
```

#### Explanation

- `javac` compiles the Java source code.
- `-d target\classes` specifies the output directory for compiled `.class` files.
- `src\main\java\com\example\myapp\App.java` is the path of the main Java file.

If the command executes successfully, the compiled class files are created inside:

```text
target\classes
```

### Step 3: Execute the Calculator

Run the following command:

```powershell
java -cp target\classes com.example.myapp.App
```

#### Explanation

- `java` runs the compiled Java program.
- `-cp target\classes` sets the classpath.
- `com.example.myapp.App` is the fully qualified name of the main class.

After executing the command, the **Simple Calculator** graphical window opens.

---

## 6. Commands Used During Execution

The following commands were used to execute the project successfully:

```powershell
java -version
```

```powershell
javac -d target\classes src\main\java\com\example\myapp\App.java
```

```powershell
java -cp target\classes com.example.myapp.App
```

> Note: Maven was not used for the final execution because Maven was not configured in the system PATH. The Java program was compiled and executed directly using `javac` and `java`.

---

## 7. Application Interface

The application contains:

- First Number input field
- Second Number input field
- Result field
- ADD button
- SUBTRACT button
- MULTIPLY button
- DIV button
- EXIT button

### Screenshot 1: VS Code Project and Terminal

Attach the screenshot showing the project structure and successful execution commands.

```text
[Attach Screenshot Here]
```

Suggested image name:

```text
screenshots/vscode-terminal.png
```

### Screenshot 2: Calculator GUI

Attach the screenshot of the calculator window after it opens.

```text
[Attach Screenshot Here]
```

Suggested image name:

```text
screenshots/calculator-gui.png
```

### Screenshot 3: Calculation Result

Attach a screenshot showing an operation and its result, such as addition or multiplication.

```text
[Attach Screenshot Here]
```

Suggested image name:

```text
screenshots/calculation-result.png
```

---

## 8. Working Principle

1. The user enters the first number.
2. The user enters the second number.
3. The user selects an arithmetic operation.
4. The application reads both input values.
5. The selected operation is performed.
6. The result is displayed in the result field.
7. If the input is invalid, the application displays `Invalid Input`.
8. If the user attempts to divide by zero, the application displays `Error: Divide by 0`.

---

## 9. Conclusion

The Java Swing calculator was successfully compiled and executed in Visual Studio Code using Java commands. The project demonstrates the use of Java GUI components, event handling, user input, arithmetic operations, and basic exception handling.
![alt text](<Screenshot 2026-09-22 215128.png>)
![alt text](<Screenshot 2026-09-22 215142.png>)
![alt text](<Screenshot 2026-09-22 215150.png>)

