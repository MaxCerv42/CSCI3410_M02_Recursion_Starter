public class CountOccurrencesRecursiveTests {
    public static void main(String[] args) {
        TestFeedback feedback = new TestFeedback();
        check(feedback, "two matches", "cacao", 'c', 2);
        check(feedback, "empty text base case", "", 'c', 0);
        check(feedback, "every character matches", "aaaa", 'a', 4);
        check(feedback, "target is absent", "bobcat", 'z', 0);
        check(feedback, "matching is case-sensitive", "AaA", 'a', 1);
        check(feedback, "single-character match", "x", 'x', 1);
        check(feedback, "single-character miss", "x", 'y', 0);
        check(feedback, "spaces are characters", "a a ", ' ', 2);
        feedback.finish();
    }

    private static void check(
            TestFeedback feedback, String name, String text,
            char target, int expected) {
        feedback.run(name, String.valueOf(expected), () -> TestFeedback.value(
                expected,
                RecursionPractice.countOccurrencesRecursive(text, target)));
    }
}
