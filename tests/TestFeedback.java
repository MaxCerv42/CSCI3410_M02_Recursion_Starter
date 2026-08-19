import java.util.Arrays;
import java.util.Objects;

public final class TestFeedback {
    @FunctionalInterface
    public interface TestCase {
        Result run();
    }

    public static final class Result {
        private final boolean passed;
        private final String actual;

        private Result(boolean passed, String actual) {
            this.passed = passed;
            this.actual = actual;
        }
    }

    private int passed;
    private int failed;

    public void run(String name, String expected, TestCase testCase) {
        try {
            Result result = testCase.run();
            report(name, result.passed, expected, result.actual);
        } catch (Throwable error) {
            String message = error.getMessage();
            String actual = "threw " + error.getClass().getSimpleName();
            if (message != null && !message.isBlank()) {
                actual += ": " + message;
            }
            report(name, false, expected, actual);
        }
    }

    public void expectThrows(
            String name,
            Class<? extends Throwable> expectedType,
            Runnable action) {
        String expected = "throws " + expectedType.getSimpleName();
        try {
            action.run();
            report(name, false, expected, "no exception");
        } catch (Throwable actual) {
            report(name, expectedType.isInstance(actual), expected,
                    "threw " + actual.getClass().getSimpleName());
        }
    }

    private void report(
            String name, boolean ok, String expected, String actual) {
        if (ok) {
            passed++;
            System.out.println("[PASS] " + name
                    + " -> expected " + expected + ", got " + actual);
        } else {
            failed++;
            System.out.println("[FAIL] " + name
                    + " -> expected " + expected + ", got " + actual);
        }
    }

    public void finish() {
        System.out.println();
        System.out.println("Summary: " + passed + " passed, "
                + failed + " failed.");
        if (failed > 0) {
            System.exit(1);
        }
    }

    public static Result result(boolean passed, String actual) {
        return new Result(passed, actual);
    }

    public static Result value(Object expected, Object actual) {
        return result(Objects.equals(expected, actual), String.valueOf(actual));
    }

    public static Result ints(int[] expected, int[] actual) {
        return result(Arrays.equals(expected, actual), Arrays.toString(actual));
    }

    public TestFeedback() {
    }
}
