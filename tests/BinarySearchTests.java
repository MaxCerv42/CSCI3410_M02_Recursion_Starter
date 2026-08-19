import java.util.Arrays;

public class BinarySearchTests {
    public static void main(String[] args) {
        TestFeedback feedback = new TestFeedback();
        int[] values = {4, 9, 15, 22, 31, 37, 44, 58, 63};

        check(feedback, "middle value", values, 31, 4);
        check(feedback, "left half", values, 9, 1);
        check(feedback, "right half", values, 58, 7);
        check(feedback, "first value", values, 4, 0);
        check(feedback, "last value", values, 63, 8);
        check(feedback, "absent target reaches empty interval", values, 42, -1);
        check(feedback, "empty array", new int[] {}, 42, -1);
        check(feedback, "null array", null, 42, -1);
        feedback.finish();
    }

    private static void check(
            TestFeedback feedback, String name, int[] values,
            int target, int expected) {
        int[] before = values == null ? null : values.clone();
        feedback.run(name, "index " + expected + " and unchanged input", () -> {
            int actual = BinarySearchPractice.binarySearch(values, target);
            boolean unchanged = Arrays.equals(before, values);
            return TestFeedback.result(
                    actual == expected && unchanged,
                    "index " + actual + ", input "
                            + (unchanged ? "unchanged" : "changed"));
        });
    }
}
