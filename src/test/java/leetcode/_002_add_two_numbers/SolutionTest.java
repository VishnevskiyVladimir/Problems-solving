package leetcode._002_add_two_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    private final Solution solution = new Solution();


    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(ListNode l1, ListNode l2, ListNode expected ) {
        Assertions.assertEquals(expected, solution.addTwoNumbers(l1, l2));
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("provideNotEqualsCombinations")
    void testNotEqualsSituations(ListNode l1, ListNode l2, ListNode expected ) {
        Assertions.assertEquals(expected,solution.addTwoNumbers(l1, l2));
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("provideExceptionCombinations")
    void checkIllegalArgumentException(ListNode l1, ListNode l2, ListNode expected ) {
        assertThrows(IllegalArgumentException.class, () -> solution.addTwoNumbers(l1, l2));
    }


    private static Stream<Arguments> provideEqualsCombinations() {
        return Stream.of(
                Arguments.of(new ListNode(2, new ListNode(4,new ListNode(3))), new ListNode(5, new ListNode(6,new ListNode(4))),new ListNode(7, new ListNode(0,new ListNode(8))))

        );
    }

    private static Stream<Arguments> provideNotEqualsCombinations() {
        return Stream.of(

        );
    }

    private static Stream<Arguments> provideExceptionCombinations() {
        return Stream.of(
            null
        );
    }
}