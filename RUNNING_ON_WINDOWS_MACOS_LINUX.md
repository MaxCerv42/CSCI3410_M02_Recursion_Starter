# Run the Java code on Windows, macOS, or Linux

> **One ZIP for everyone:** All students download and extract the same ZIP package. Only the launcher command differs by operating system: use the `.bat` file on Windows and the matching `.sh` file on macOS/Linux.

Install **JDK 21 or later** before using these launchers. Verify both tools:

```text
java --version
javac --version
```

Open a terminal in the extracted package folder, then use the command for your operating system.

## Windows PowerShell

- `.\run_task1_iterative.bat`
- `.\run_task1_recursive.bat`
- `.\run_task2.bat`
- `.\run_task3.bat`

## macOS or Linux Terminal

- `./run_task1_iterative.sh`
- `./run_task1_recursive.sh`
- `./run_task2.sh`
- `./run_task3.sh`

If macOS/Linux reports `Permission denied`, run this once and retry:

```bash
chmod +x run_*.sh
```

Each `.bat`/`.sh` pair runs the same Java 21 compilation and test commands. Do not run from inside the ZIP preview.
