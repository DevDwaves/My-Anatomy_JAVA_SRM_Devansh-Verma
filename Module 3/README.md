# Employee Management System

A Java-based Employee Management web application built with **Spring Boot**, **Spring MVC**, **Thymeleaf**, and **Spring Security**. The project demonstrates role-based workflows for viewing and managing employees and departments through a browser-based interface.

> **Academic project:** This version stores employee and department data in application memory. Data created while the app is running is cleared when the application restarts. The demo credentials and JWT secret are for local learning only; do not deploy this version publicly without strengthening authentication and configuration.

## Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Run Locally](#run-locally)
- [Demo Login Credentials](#demo-login-credentials)
- [Application Pages](#application-pages)
- [Important Notes](#important-notes)
- [Troubleshooting](#troubleshooting)
- [Future Improvements](#future-improvements)

## Features

- Login page with three demo roles: HR, Manager, and Employee.
- Dashboard with navigation to employee and department pages.
- Employee listing with pagination and sorting by name, email, or salary.
- Create employee records (HR role).
- Edit employee records (HR and Manager roles).
- Delete employee records (HR role).
- View departments and add departments (HR role).
- Thymeleaf templates and a shared CSS stylesheet for the web interface.
- JWT generation using the `jjwt` library and session-based login state.

## Technology Stack

| Technology | Usage |
|---|---|
| Java 22 | Programming language (as configured in `pom.xml`) |
| Spring Boot 4.1.1 | Application framework |
| Spring MVC / WebMVC | Web routes and controllers |
| Thymeleaf | Server-rendered HTML templates |
| Spring Security | Security framework configuration |
| JJWT 0.12.6 | JSON Web Token creation and parsing |
| Maven Wrapper | Build and run the project without installing Maven separately |
| HTML / CSS | User interface |

## Project Structure

```text
employee-management-web/
├── .mvn/wrapper/                 # Maven Wrapper configuration
├── mvnw                          # Maven Wrapper (Linux/macOS)
├── mvnw.cmd                      # Maven Wrapper (Windows)
├── pom.xml                       # Dependencies and Java version
└── src/
    ├── main/
    │   ├── java/com/example/
    │   │   ├── config/            # Security configuration
    │   │   ├── controller/        # Login, dashboard, employee, department routes
    │   │   ├── model/             # Employee, Department, Role models
    │   │   ├── security/          # JWT service
    │   │   ├── service/           # Employee and department operations
    │   │   └── EmployeeManagementWebApplication.java
    │   └── resources/
    │       ├── static/CSS/        # Stylesheet
    │       ├── templates/         # Thymeleaf pages
    │       └── application.properties
    └── test/                      # Application tests
```

## Prerequisites

- **JDK 22** (the project sets `<java.version>22</java.version>` in `pom.xml`).
- Visual Studio Code or another Java IDE.
- Internet access on the first build so the Maven Wrapper can download the required Maven distribution and dependencies.

Confirm Java is installed:

```powershell
java -version
javac -version
```

## Run Locally

### 1. Open the project folder

In VS Code, choose **File → Open Folder** and open the `employee-management-web` directory — the folder that contains `pom.xml` and `mvnw.cmd`.

Open the integrated terminal with **Ctrl + `**. Make sure the terminal is in this project directory.

### 2. Build the project

On **Windows PowerShell**:

```powershell
.\mvnw.cmd clean package
```

On **Linux/macOS**:

```bash
chmod +x mvnw
./mvnw clean package
```

### 3. Start the application

On **Windows PowerShell**:

```powershell
.\mvnw.cmd spring-boot:run
```

On **Linux/macOS**:

```bash
./mvnw spring-boot:run
```

Keep the terminal open while the application is running. When startup completes, open:

- Home / redirect to login: <http://localhost:8080/>
- Login page: <http://localhost:8080/login>
- Dashboard after login: <http://localhost:8080/dashboard>

### 4. If port 8080 is already in use

You can run the project on port `8081` without changing the source code.

Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081"
```

Linux/macOS:

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

Then open <http://localhost:8081/login>.

## Demo Login Credentials

Use one of the following accounts on the login page:

| Role | Username | Password |
|---|---|---|
| HR | `hr` | `1234` |
| Manager | `manager` | `1234` |
| Employee | `employee` | `1234` |

These credentials are hardcoded in the current demo implementation. They are not suitable for a public or production deployment.

## Application Pages

| Page | URL | Purpose |
|---|---|---|
| Login | `/login` | Sign in with a demo account |
| Dashboard | `/dashboard` | View the dashboard and navigate the app |
| Employees | `/employees` | Browse, sort, and paginate employee records |
| New employee | `/employees/new` | Create an employee (HR only) |
| Edit employee | `/employees/edit/{id}` | Update an employee (HR or Manager) |
| Departments | `/departments` | View departments and add a department (HR only) |
| Logout | `/logout` | End the current session |

## Important Notes

- **In-memory storage:** employee records and newly created departments are stored in Java lists, not a database. They reset when the application restarts. The application preloads the `IT`, `HR`, and `Finance` departments at startup.
- **Demo authentication:** usernames and passwords are hardcoded in `LoginController`. Replace this with proper user management and password hashing before production use.
- **JWT secret:** the current development secret is configured in `src/main/resources/application.properties`. Use a strong secret supplied through an environment variable or secret manager, and never commit real secrets to GitHub.
- **Security configuration:** review and strengthen authorization, CSRF settings, and session/token handling before exposing the application to the internet.
- **No database is configured** in the current implementation.

## Troubleshooting

### `Web server failed to start. Port 8080 was already in use.`

Run on another port using the command in [If port 8080 is already in use](#4-if-port-8080-is-already-in-use), or identify and stop the old process only after confirming it is safe to do so.

### `java` or `javac` is not recognized

Install JDK 22 and configure `JAVA_HOME` and your system `PATH`, then restart VS Code and check `java -version` again.

### Build fails while downloading dependencies

Check your internet connection and rerun the build command. Review the first meaningful `[ERROR]` message in the terminal output.

### Login fails

Use one of the exact demo username/password pairs shown above. These credentials are case-sensitive.

## Future Improvements

- Add a persistent database such as PostgreSQL or MySQL with Spring Data JPA.
- Store users securely and hash passwords.
- Move secrets to environment variables and add environment-specific configuration.
- Add validation, exception handling, automated tests, and audit logs.
- Review authorization and CSRF/session settings before production deployment.

![alt text](<Screenshot 2026-10-23 235721.png>)
![alt text](<Screenshot 2026-10-23 235733.png>) 
![alt text](<Screenshot 2026-10-23 235758.png>) 
![alt text](<Screenshot 2026-10-23 235824.png>) 
![alt text](<Screenshot 2026-10-23 235845.png>) 
![alt text](<Screenshot 2026-10-23 235905.png>) 
![alt text](<Screenshot 2026-10-23 235912.png>) 
![alt text](<Screenshot 2026-10-23 235935.png>)
