import java.util.Arrays;

public class ReverseArrayTests {
    public static void main(String[] args) {
        TestFeedback feedback = new TestFeedback();
        reverseCase(feedback, "odd-length array",
                new int[] {8, 23, 43, 57, 37, 15, 19},
                new int[] {19, 15, 37, 57, 43, 23, 8});
        reverseCase(feedback, "even-length array",
                new int[] {8, 23, 43, 57, 37, 15, 19, 4},
                new int[] {4, 19, 15, 37, 57, 43, 23, 8});
        reverseCase(feedback, "two values", new int[] {4, 9},
                new int[] {9, 4});
        reverseCase(feedback, "duplicates",
                new int[] {2, 2, 7, 2}, new int[] {2, 7, 2, 2});
        reverseCase(feedback, "negative values",
                new int[] {-3, 0, 8}, new int[] {8, 0, -3});
        reverseCase(feedback, "one value", new int[] {7}, new int[] {7});
        reverseCase(feedback, "empty array", new int[] {}, new int[] {});
        feedback.run("null input", "no exception", () -> {
            RecursionPractice.reverseArray(null);
            return TestFeedback.result(true, "no exception");
        });
        feedback.finish();
    }

    private static void reverseCase(
            TestFeedback feedback, String name, int[] input, int[] expected) {
        int[] actual = input.clone();
        feedback.run(name, Arrays.toString(expected), () -> {
            RecursionPractice.reverseArray(actual);
            return TestFeedback.ints(expected, actual);
        });
    }
}
