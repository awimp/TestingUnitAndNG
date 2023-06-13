package com.beginsecure.domain;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class PalindromCheckTestNG {

    private PalindromCheck.GFG palindromCheck;

    @BeforeClass
    public void setUpBeforeClass() {
        System.out.println("Before executing any test methods");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before each test method");
        palindromCheck = new PalindromCheck().new GFG();
    }

    @Test
    public void testIsPalindrome() {
        PalindromCheck.GFG palindromCheck = new PalindromCheck().new GFG();

        // Test a palindrome string
        String palindrome = "madam";
        assertTrue(palindromCheck.isPalindrome(palindrome), "The string should be identified as a palindrome.");

        // Test a non-palindrome string
        String nonPalindrome = "hello";
        assertFalse(palindromCheck.isPalindrome(nonPalindrome), "The string should not be identified as a palindrome.");
    }
    @Test
    public void testIsPalindrome_EmptyString() {
        PalindromCheck.GFG palindromCheck = new PalindromCheck().new GFG();

        // Test an empty string
        String emptyString = "";
        assertTrue(palindromCheck.isPalindrome(emptyString), "The empty string should be identified as a palindrome.");
    }

    @Test
    public void testIsPalindrome_SingleCharacter() {
        PalindromCheck.GFG palindromCheck = new PalindromCheck().new GFG();

        // Test a single character string
        String singleChar = "a";
        assertTrue(palindromCheck.isPalindrome(singleChar), "The single character string should be identified as a palindrome.");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testIsPalindrome_NullString() {
        String nullString = null;
        palindromCheck.isPalindrome(nullString);
    }

    @DataProvider(name = "palindromeTestData")
    public Object[][] palindromeTestData() {
        return new Object[][] {
                {"madam", true},
                {"hello", false},
                {"radar", true},
                {"world", false}
        };
    }

    @Test(dataProvider = "palindromeTestData")
    public void testIsPalindrome_Parameterized(String input, boolean expected) {
        assertEquals(palindromCheck.isPalindrome(input), expected);
    }
}
