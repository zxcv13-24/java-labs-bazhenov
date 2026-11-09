package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static edu.course.lab01.CourseToolkit.average;
import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);

    }

    @Test
    void returnsTrueZero() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }
    @Test
    void returnsTrueIfPrime13() {
        boolean result = CourseToolkit.isPrime(13);
        assertTrue(result);
    }

    @Test
    void returnsFalseIfNotPrime24() {
        boolean result = CourseToolkit.isPrime(24);
        assertFalse(result);
    }
    @Test
    void returnsTrueIfPrime11() {
        boolean result = CourseToolkit.isPrime(11);
        assertTrue(result);
    }
    @Test
    void returnsFalseIfNotPrime36() {
        boolean result = CourseToolkit.isPrime(36);
        assertFalse(result);
    }

    @Test
    void returnsTrueIfPalindrome() {
        boolean result = CourseToolkit.isPalindrome("abba");
        assertTrue(result);
    }

    @Test
    void returnsFalseIfNotPalindrome() {
        boolean result = CourseToolkit.isPalindrome("abcde");
        assertFalse(result);
    }

    @Test
    void returnsFalseIfNotPalindrome2() {
        boolean result = CourseToolkit.isPalindrome("qwerty");
        assertFalse(result);
    }

    @Test
    void returnsTrueNumber(){
        int[] value = {2,4,6,8};
        double result = 5.0;
        assertEquals(result, average(value));
    }
    @Test
    void returnsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            average(null);
        });
    }
}
