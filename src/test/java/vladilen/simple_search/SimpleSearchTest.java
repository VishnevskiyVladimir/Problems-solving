package vladilen.simple_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import vladilen.shifted_string.simple_search.SimpleSearch;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSearchTest {

    private final SimpleSearch testedClass = new SimpleSearch();

    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(int[] value1, int value2, int expected) {
        Assertions.assertEquals(testedClass.findInSortedArray(value1, value2), expected);
    }

    @ParameterizedTest
    @MethodSource("provideNotEqualsCombinations")
    void testNotEqualsSituations(int[] value1, int value2, int expected) {
        Assertions.assertEquals(testedClass.findInSortedArray(value1, value2), expected);
    }

    @ParameterizedTest
    @MethodSource("provideExceptionCombinations")
    void checkIllegalArgumentException(int[] value1, int value2, Object expected) {
        assertThrows(IllegalArgumentException.class, () -> testedClass.findInSortedArray(value1, value2));
    }




    private static Stream<Arguments> provideEqualsCombinations() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 1, 0),
                Arguments.of(new int[]{1,2,3}, 2, 1),
                Arguments.of(new int[]{1,2,3}, 3, 2),

                Arguments.of(new int[]{1,1,2,3}, 1, 0),
                Arguments.of(new int[]{1,1,2,3}, 2, 2),
                Arguments.of(new int[]{1,1,2,3}, 3, 3),

                Arguments.of(new int[]{1,2,3,3}, 1, 0),
                Arguments.of(new int[]{1,2,3,3}, 2, 1),
                Arguments.of(new int[]{1,2,3,3}, 3, 2),

                Arguments.of(new int[]{1,2,2,3}, 1, 0),
                Arguments.of(new int[]{1,2,2,3}, 2, 1),
                Arguments.of(new int[]{1,2,2,3}, 3, 3),

                Arguments.of(new int[]{1,2,3,4}, 1, 0),
                Arguments.of(new int[]{1,2,3,4}, 2, 1),
                Arguments.of(new int[]{1,2,3,4}, 3, 2),
                Arguments.of(new int[]{1,2,3,4}, 4, 3),

                Arguments.of(new int[]{1,1}, 1, 0),
                Arguments.of(new int[]{1}, 1, 0)
        );
    }

    private static Stream<Arguments> provideNotEqualsCombinations() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 4, -1),
                Arguments.of(new int[]{1,2,3}, 0, -1),
                Arguments.of(new int[]{1}, 11, -1),
                Arguments.of(new int[]{1}, 0, -1)
        );
    }

    private static Stream<Arguments> provideExceptionCombinations() {
        return Stream.of(
                Arguments.of(null, 1, IllegalArgumentException.class)
        );
    }

}