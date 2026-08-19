@echo off
setlocal
cd /d "%~dp0"

where javac >nul 2>nul
if errorlevel 1 (
    echo [ERROR] javac was not found. Install JDK 21 or later, then reopen the terminal.
    exit /b 1
)

where java >nul 2>nul
if errorlevel 1 (
    echo [ERROR] java was not found. Install JDK 21 or later, then reopen the terminal.
    exit /b 1
)

set "JAVAC_VERSION="
set "JAVAC_MAJOR="
for /f "tokens=2" %%V in ('javac -version 2^>^&1') do set "JAVAC_VERSION=%%V"
for /f "tokens=1 delims=." %%M in ("%JAVAC_VERSION%") do set "JAVAC_MAJOR=%%M"
if not defined JAVAC_MAJOR (
    echo [ERROR] Could not read the javac version. Install JDK 21 or later.
    exit /b 1
)
if %JAVAC_MAJOR% LSS 21 (
    echo [ERROR] JDK 21 or later is required. Found javac %JAVAC_VERSION%.
    exit /b 1
)

if exist out\task2 rmdir /s /q out\task2
mkdir out\task2

javac --release 21 -Xlint:all,-output-file-clash -d out\task2 src\task2\RecursionPractice.java tests\TestFeedback.java tests\ReverseArrayTests.java
if errorlevel 1 (
    echo.
    echo [ERROR] Compilation failed. Fix the messages above, then run:
    echo   .\run_task2.bat
    exit /b 1
)

java -cp out\task2 ReverseArrayTests
set code=%errorlevel%
exit /b %code%
