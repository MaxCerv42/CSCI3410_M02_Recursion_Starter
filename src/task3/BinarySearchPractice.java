/*
 * TASK: Search a sorted array with recursive binary search.
 * RUN:  From the package folder, type .\run_task3.bat (Windows) or ./run_task3.sh (macOS/Linux)
 * CONTRACT: null returns -1, and the method must not modify the array.
 * Read every [PASS]/[FAIL] line, then check the summary.
 */
public class BinarySearchPractice {
    public static int binarySearch(int[] values, int target) {
        // TODO: handle null, then call the helper on the full interval.
        return -1;
    }

    private static int binarySearch(
            int[] values, int target, int low, int high) {
        // TODO: stop on an empty interval or a match.
        // Otherwise recurse into only the half that may contain target.
        return -1;
    }
}
