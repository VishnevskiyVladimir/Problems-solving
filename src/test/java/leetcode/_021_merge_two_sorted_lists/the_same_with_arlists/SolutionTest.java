package leetcode._021_merge_two_sorted_lists.the_same_with_arlists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution testedSolution = new Solution1(); // almost the same as first solution


    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(List<Integer> list1, List<Integer> list2, List<Integer> expected) {
        assertEquals(expected, testedSolution.mergeTwoLists(list1, list2));
    }

//    @Test
//    void testException() {
//        assertThrows(IllegalArgumentException.class,() -> testedSolution.mergeTwoLists(null,null));
//    }


    private static Stream<Arguments> provideEqualsCombinations() {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(4, 5, 6);
        List<Integer> l3 = Arrays.asList(1, 2, 4);
        List<Integer> l4 = Arrays.asList(1, 5, 6);
        List<Integer> l5 = Arrays.asList(3);
        List<Integer> l6 = new ArrayList<>();

        List<Integer> l1l1 = Arrays.asList(1, 1, 2, 3, 3, 3);
        List<Integer> l1l2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> l1l3 = Arrays.asList(1, 1, 2, 2, 3, 4);
        List<Integer> l1l4 = Arrays.asList(1, 1, 2, 3, 5, 6);
        List<Integer> l1l5 = Arrays.asList(1, 2, 3, 3);
        List<Integer> l2l5 = Arrays.asList(3, 4, 5, 6);
        List<Integer> l3l5 = Arrays.asList(1, 2, 3, 4);

        return Stream.of(
                Arguments.of(l1, l2, l1l2),
                Arguments.of(l2, l1, l1l2),
                Arguments.of(l1, l1, l1l1),
                Arguments.of(l1, l3, l1l3),
                Arguments.of(l1, l4, l1l4),
                Arguments.of(l1, l5, l1l5),
                Arguments.of(l2, l5, l2l5),
                Arguments.of(l3, l5, l3l5),
                Arguments.of(l1, l6, l1),
                Arguments.of(l6, l2, l2),
                Arguments.of(l6, l6, l6),
                Arguments.of(l5, l6, l5)
        );
    }
}