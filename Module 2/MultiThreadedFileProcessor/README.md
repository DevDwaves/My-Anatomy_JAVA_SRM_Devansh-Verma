# Multi-Threaded CSV File Processor

A Java-based application that processes multiple CSV sales files concurrently using a thread pool and generates a consolidated report.

## Features

- Reads multiple CSV files from the input folder
- Processes files concurrently using `ExecutorService`
- Uses separate processing tasks for each CSV file
- Aggregates sales data into a single report
- Generates the final output in `report.txt`

## Technologies Used

- Java
- Multithreading
- ExecutorService / Thread Pool
- CSV File Processing
- File Handling
- Object-Oriented Programming

## Project Structure

```text
MultiThreadedFileProcessor/
├── data/
├── src/
│   ├── Main.java
│   ├── config/
│   ├── model/
│   ├── processor/
│   └── report/
├── out/
├── report.txt
└── run.bat
```

## How to Execute in VS Code

Open the terminal inside the `MultiThreadedFileProcessor` project folder.

### Method 1: Using run.bat

```powershell
.\run.bat
```

### Method 2: Compile and Run Manually

Compile the project:

```powershell
javac -d out src\Main.java src\model\SalesRecord.java src\config\ProcessorConfig.java src\processor\CsvFileProcessor.java src\report\ReportAggregator.java
```

Run the application:

```powershell
java -cp out Main
```

## Output

The program processes the CSV files concurrently and generates a consolidated report:

```text
report.txt
```

The report contains the aggregated results of the processed sales data.

## Working Process

1. Load the processor configuration.
2. Find CSV files in the input folder.
3. Create a thread pool.
4. Submit one processing task for each CSV file.
5. Collect the results from all tasks.
6. Aggregate the processed data.
7. Generate and save the final report.

## Result

The multi-threaded CSV file processor successfully processes input files concurrently and creates a consolidated sales report.

## Author

**Devansh Verma**  
B.Tech – Computer Science and Engineering  
SRM Institute of Science and Technology
![alt text](<Screenshot 2026-09-23 163313.png>) ![alt text](<Screenshot 2026-09-23 163318.png>)