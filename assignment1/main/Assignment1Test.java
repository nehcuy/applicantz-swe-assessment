package assignment1.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for Assignment 1 reverseWords() method.
 * @author Huang Yuchen
 * @author hyuchen2607@gmail.com
 */
public class Assignment1Test {
    /**
     * Test case provided from Problem Statement
     */
    @Test
    public void inputTestEg() {
        String expected = "gnirtS; eb2 desrever...";
        String toBeReversed = "String; 2be reversed...";
        String actual = Assignment1.reverseWords(toBeReversed);
        assertEquals(expected, actual);
    }

    /**
     * Test case with all characters
     */
    @Test
    public void inputTestAllChars() {
        String expected = "desreverebotsdrowllA";
        String toBeReversed = "Allwordstobereversed";
        String actual = Assignment1.reverseWords(toBeReversed);
        assertEquals(expected, actual);
    }

    /**
     * Test case with all numbers
     */
    @Test
    public void inputTestAllNums() {
        String expected = "0987654321";
        String toBeReversed = "1234567890";
        String actual = Assignment1.reverseWords(toBeReversed);
        assertEquals(expected, actual);
    }

    /**
     * Test case with all special characters
     */
    @Test
    public void inputTestAllSpecialChars() {
        String expected = "!@#$%^ &*()_+.,";
        String toBeReversed = "!@#$%^ &*()_+.,";
        String actual = Assignment1.reverseWords(toBeReversed);
        assertEquals(expected, actual);
    }

    /**
     * Test case with mix of characters and numbers
     */
    @Test
    public void inputTestCharAndNum() {
        String expected = "321cba";
        String toBeReversed = "abc123";
        String actual = Assignment1.reverseWords(toBeReversed);
        assertEquals(expected, actual);
    }
}
