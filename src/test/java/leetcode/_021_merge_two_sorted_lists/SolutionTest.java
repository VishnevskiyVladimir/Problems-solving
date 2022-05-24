package leetcode._021_merge_two_sorted_lists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution testedSolution = new Solution_1(); // almost the same as first solution





    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(ListNode list1, ListNode list2, ListNode expected) {
        assertEquals(expected, testedSolution.mergeTwoLists(list1, list2));
    }

//    @Test
//    void testException() {
//        assertThrows(IllegalArgumentException.class,() -> testedSolution.mergeTwoLists(null,null));
//    }


    private static Stream<Arguments> provideEqualsCombinations() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode l4 = new ListNode(2, new ListNode(3));
        ListNode l5 = new ListNode(5, new ListNode(6));

        ListNode l1l2 = new ListNode(1, new ListNode(1, new ListNode(2,new ListNode(3, new ListNode(4,new ListNode(4))))));
        ListNode l1l3 = new ListNode(1, new ListNode(2, new ListNode(2,new ListNode(3, new ListNode(4,new ListNode(4))))));
        ListNode l1l4 = new ListNode(1, new ListNode(2, new ListNode(2,new ListNode(3, new ListNode(4)))));
        ListNode l1l5 = new ListNode(1, new ListNode(2, new ListNode(4,new ListNode(5, new ListNode(6)))));

        return Stream.of(
                Arguments.of(l1, null, l1),
                Arguments.of(null, null, null),
                Arguments.of(null, l2, l2),
                Arguments.of(l1, l5, l1l5),
                Arguments.of(l5, l1, l1l5),
                Arguments.of(l1, l2, l1l2),
                Arguments.of(l2, l1, l1l2),
                Arguments.of(l1, l3, l1l3),
                Arguments.of(l3, l1, l1l3),
                Arguments.of(l1, l4, l1l4),
                Arguments.of(l4, l1, l1l4)
        );
    }
}