package leetcode._021_merge_two_sorted_lists.the_same_with_arrays;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    Solution testedSolution = new Solution1(); // almost the same as first solution


    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations( int[] arr1,  int[] arr2,  int[] expected) {
        assertArrayEquals(expected, testedSolution.mergeTwoArrays(arr1, arr2));
    }

//    @Test
//    void testException() {
//        assertThrows(IllegalArgumentException.class,() -> testedSolution.mergeTwoLists(null,null));
//    }


    private static Stream<Arguments> provideEqualsCombinations() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{4, 5, 6};
        int[] arr3 = new int[]{1, 2, 4};
        int[] arr4 = new int[]{1, 5, 6};
        int[] arr5 = new int[]{3};
        int[] arr6 = new int[0];

        int[] arr1arr1 = new int[]{1, 1, 2, 2, 3, 3};
        int[] arr1arr2 = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr1arr3 = new int[]{1, 1, 2, 2, 3, 4};
        int[] arr1arr4 = new int[]{1, 1, 2, 3, 5, 6};
        int[] arr1arr5 = new int[]{1, 2, 3, 3};
        int[] arr2arr5 = new int[]{3, 4, 5, 6};
        int[] arr3arr5 = new int[]{1, 2, 3, 4};

        return Stream.of(
                Arguments.of(arr1, arr2, arr1arr2),
                Arguments.of(arr2, arr1, arr1arr2),
                Arguments.of(arr1, arr1, arr1arr1),
                Arguments.of(arr1, arr3, arr1arr3),
                Arguments.of(arr1, arr4, arr1arr4),
                Arguments.of(arr1, arr5, arr1arr5),
                Arguments.of(arr2, arr5, arr2arr5),
                Arguments.of(arr3, arr5, arr3arr5),
                Arguments.of(arr1, arr6, arr1),
                Arguments.of(arr6, arr2, arr2),
                Arguments.of(arr6, arr6, arr6),
                Arguments.of(arr5, arr6, arr5)
        );
    }
}