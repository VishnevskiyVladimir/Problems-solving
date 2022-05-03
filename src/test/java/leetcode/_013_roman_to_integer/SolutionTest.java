package leetcode._013_roman_to_integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void test1() {
        String roman = "XII";
        int expected = 12;
        assertEquals(expected,solution.romanToInt(roman));
    }

    @Test
    void test2() {
        String roman = "MCMXCIV";
        int expected = 1994;
        assertEquals(expected,solution.romanToInt(roman));
    }

    @Test
    void test3() {
        String roman = "LVIII";
        int expected = 58;
        assertEquals(expected,solution.romanToInt(roman));
    }

    @Test
    void test4() {
        String roman = "IX";
        int expected = 9;
        assertEquals(expected,solution.romanToInt(roman));
    }

    @Test
    void test5() {
        String roman = "D";
        int expected = 500;
        assertEquals(expected,solution.romanToInt(roman));
    }
}