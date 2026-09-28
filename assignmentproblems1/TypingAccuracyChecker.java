import java.util.*;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // Handle different lengths
        if (original.length() != typed.length()) {
            if (firstMismatch == -1) {
                firstMismatch = length;
            }
        }

        double accuracy =
            ((double) matched / original.length()) * 100;

        System.out.printf(
            "Matched: %d/%d | Accuracy: %.2f%%",
            matched, original.length(), accuracy
        );

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {

            char originalChar =
                original.charAt(firstMismatch);

            char typedChar =
                typed.charAt(firstMismatch);

            System.out.println(
                " | First Mismatch at position "
                + (firstMismatch + 1)
                + " ('" + originalChar
                + "' vs '" + typedChar + "')"
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}