package leetcode._006_zig_zag_conversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        String expected = "PAHNAPLSIIGYIR";
        String result = solution.convert("PAYPALISHIRING", 3);
        assertEquals(expected,result);
    }

    @Test
    void test2() {
        String expected = "PINALSIGYAHRPI";
        String result = solution.convert("PAYPALISHIRING", 4);
        assertEquals(expected,result);
    }

    @Test
    void test3() {
        String expected = "a";
        String result = solution.convert("a", 1);
        assertEquals(expected,result);
    }

}