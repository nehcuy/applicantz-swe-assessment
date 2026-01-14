package assignment1.main;
import java.lang.StringBuilder;

/**
 * Assignment 1 - Task as defined in the Problem Statement PDF
 * @author Huang Yuchen
 * @author hyuchen2607@gmail.com
 */
public class Assignment1 {
    /**
     * Reverses each word in the input string while keeping other characters unreversed.
     * A word is only made up of letters and/or numbers.
     * @param str The input string to be reversed.
     * @return The string with each word reversed.
     */
    public static String reverseWords(String str) {
        StringBuilder reversedWord = new StringBuilder();
        StringBuilder tempWordToBeReversed = new StringBuilder();

        for (char c : str.toCharArray()) {
            // Store word characters for reversing
            if (Character.isLetterOrDigit(c)) {
                tempWordToBeReversed.append(c);
                continue;
            }
            // When other characters encountered, perform reversal and append.
            reversedWord.append(tempWordToBeReversed.reverse());
            tempWordToBeReversed.setLength(0);
            reversedWord.append(c);
        }
        reversedWord.append(tempWordToBeReversed.reverse());
        return reversedWord.toString();
    }
}
