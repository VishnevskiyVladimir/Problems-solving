package leetcode._003_longest_substring_without_repeating_characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void test1() {
        String s = "abcabcbb";
        assertEquals(3,solution.lengthOfLongestSubstring(s));
    }

    @Test
    void test2() {
        String s = "acbb";
        assertEquals(3,solution.lengthOfLongestSubstring(s));
    }

    @Test
    void test3() {
        String s = "bba";
        assertEquals(2,solution.lengthOfLongestSubstring(s));
    }

    @Test
    void test4() {
        String s = "bbb";
        assertEquals(1,solution.lengthOfLongestSubstring(s));
    }

    @Test
    void test5() {
        String s = "pwwkew";
        assertEquals(3,solution.lengthOfLongestSubstring(s));
    }
}