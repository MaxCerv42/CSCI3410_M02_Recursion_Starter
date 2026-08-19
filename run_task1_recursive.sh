#!/usr/bin/env bash
set -uo pipefail

SCRIPT_DIR=$(CDPATH= cd "$(dirname "$0")" && pwd)
cd "$SCRIPT_DIR"

if ! command -v javac >/dev/null 2>&1 || ! command -v java >/dev/null 2>&1; then
    echo "[ERROR] Java was not found. Install JDK 21 or later, then reopen the terminal." >&2
    exit 1
fi

JAVAC_VERSION=$(javac -version 2>&1)
JAVAC_VERSION=${JAVAC_VERSION#javac }
JAVAC_MAJOR=${JAVAC_VERSION%%.*}
case "$JAVAC_MAJOR" in
    ''|*[!0-9]*)
        echo "[ERROR] Could not read the javac version. Install JDK 21 or later." >&2
        exit 1
        ;;
esac
if [ "$JAVAC_MAJOR" -lt 21 ]; then
    echo "[ERROR] JDK 21 or later is required. Found javac $JAVAC_VERSION." >&2
    exit 1
fi

BUILD_DIR='out/task1_recursive'
rm -rf -- "$BUILD_DIR"
mkdir -p -- "$BUILD_DIR"

if ! javac --release 21 -Xlint:all,-output-file-clash -d "$BUILD_DIR" src/task1_recursive/RecursionPractice.java tests/TestFeedback.java tests/CountOccurrencesRecursiveTests.java; then
    echo >&2
    echo '[ERROR] Compilation failed. Fix the messages above, then run:' >&2
    echo '  ./run_task1_recursive.sh' >&2
    exit 1
fi

java -cp "$BUILD_DIR" CountOccurrencesRecursiveTests
status=$?
if [ "$status" -ne 0 ]; then
    exit "$status"
fi
exit 0
