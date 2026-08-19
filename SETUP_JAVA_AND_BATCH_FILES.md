# Set up Java and run course code on Windows, macOS, or Linux

CSCI 3410 uses plain Java with **JDK 21 or later**. Python is not required.

## 1. Install and verify JDK 21 or later

Open PowerShell on Windows or Terminal on macOS/Linux and run:

```text
java --version
javac --version
```

Both commands must report major version 21 or later. If either command is missing or reports an older version, install a current JDK 21+ distribution, close the terminal, and open a new one.

## 2. Download and extract the package

All students download the **same ZIP package**, regardless of operating system. Extract it first; do not run code from inside the ZIP preview.

## 3. Use the launcher for your operating system

- Windows PowerShell: `.\run_name.bat`
- macOS/Linux Terminal: `./run_name.sh`

Replace `run_name` with the launcher listed in that package's README. On macOS/Linux, if the terminal reports `Permission denied`, run `chmod +x run_*.sh` once and retry.

The matching `.bat` and `.sh` files compile for Java 21, run the same tests, and return the same status.
