package yandex;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultArrayTest {
    private final ResultArray solution = new ResultArray();

    @Test
    void test1() {
        List<Integer> actual = solution.uniteLists(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected,actual);
    }

    @Test
    void test2() {
        List<Integer> actual = solution.uniteLists(Arrays.asList(1, 2, 3), Arrays.asList(3, 5, 6));
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 6);
        assertEquals(expected,actual);
    }

    @Test
    void test3() {
        List<Integer> actual = solution.uniteLists(Arrays.asList(1, 2, 3), Arrays.asList(2, 5, 6));
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 6);
        assertEquals(expected,actual);
    }


}