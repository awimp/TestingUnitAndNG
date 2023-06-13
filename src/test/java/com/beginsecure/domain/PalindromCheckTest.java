package com.beginsecure.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromCheckTest {

    private PalindromCheck.GFG palindromCheck;

    @BeforeAll
    public static void setUpBeforeClass() {
        // Executed once before all test methods
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void setUp() {
        // Executed before each test method
        System.out.println("Before each test");
        palindromCheck = new PalindromCheck().new GFG();
    }

    @Test
    public void testIsPalindrome() {
        String str = "geeks";
        boolean result = palindromCheck.isPalindrome(str);
        assertFalse(result);
    }

    @Test
    public void testIsPalindromeWithEmptyString() {
        String str = "";
        boolean result = palindromCheck.isPalindrome(str);
        assertTrue(result);
    }

    @Test
    public void testIsPalindromeWithSingleCharacter() {
        String str = "a";
        boolean result = palindromCheck.isPalindrome(str);
        assertTrue(result);
    }

    @Test
    public void testIsPalindromeWithPalindromeString() {
        String str = "level";
        boolean result = palindromCheck.isPalindrome(str);
        assertTrue(result);
    }

    @Test
    public void testIsPalindromeWithNonPalindromeString() {
        String str = "hello";
        boolean result = palindromCheck.isPalindrome(str);
        assertFalse(result);
    }

    @Test
    public void testAssertEquals() {
        String str1 = "hello";
        String str2 = "hello";
        assertEquals(str1, str2);
    }

    @Test
    public void testAssertNotEquals() {
        int num1 = 5;
        int num2 = 10;
        assertNotEquals(num1, num2);
    }

    @Test
    public void testAssertTrue() {
        boolean condition = true;
        assertTrue(condition);
    }

    @Test
    public void testAssertFalse() {
        boolean condition = false;
        assertFalse(condition);
    }

    @Test
    public void testUsingHamcrestMatchersForStrings() {
        String str = "level";
        boolean result = palindromCheck.isPalindrome(str);
        assertThat(result, equalTo(true));

        assertThat(str, is(not(nullValue())));
        assertThat(str, containsString("ev"));
    }

    @Test
    public void testUsingHamcrestMatchersForCollections() {
        String str = "hello";
        String[] array = {"hello", "world"};

        assertThat(Arrays.asList(array), hasItem(str));
        assertThat(Arrays.asList(array), hasSize(2));
    }
    @ParameterizedTest
    @CsvSource({
            "level, true",    // palindrome
            "hello, false",   // not a palindrome
            "radar, true"     // palindrome
    })
    public void testIsPalindrome(String inputString, boolean expectedPalindrome) {
        boolean result = palindromCheck.isPalindrome(inputString);
        assertEquals(expectedPalindrome, result);
    }

    @ParameterizedTest
    @CsvSource({
            ", NullPointerException"  // null input
    })
    public void testExceptionHandling(String inputString, String exceptionType) {
        assertThrows(getExceptionClass(exceptionType), () -> palindromCheck.isPalindrome(inputString));
    }

    private Class<? extends Throwable> getExceptionClass(String exceptionType) {
        switch (exceptionType) {
            case "NullPointerException":
                return NullPointerException.class;
            default:
                throw new IllegalArgumentException("Invalid exception type: " + exceptionType);
        }
    }


}
