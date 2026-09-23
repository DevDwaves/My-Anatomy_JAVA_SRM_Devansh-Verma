@echo off
echo ============================================
echo   Compiling Multi-Threaded File Processor
echo ============================================

REM Create output directory for compiled .class files
if not exist "out" mkdir out

REM Compile all Java source files
javac -d out src\Main.java src\model\SalesRecord.java src\config\ProcessorConfig.java src\processor\CsvFileProcessor.java src\report\ReportAggregator.java

if %ERRORLEVEL% neq 0 (
    echo.
    echo [ERROR] Compilation failed! Make sure Java JDK is installed.
    pause
    exit /b 1
)

echo. 
echo Compilation successful!
echo.
echo ============================================
echo   Running the Program
echo ============================================
echo.

REM Run Main class from the project root (so data/ folder is found)
java -cp out Main

echo.
pause
