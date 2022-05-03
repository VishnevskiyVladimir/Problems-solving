package vladilen.is_second_array_a_subset_of_first;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IsSecondArrayIsSubSetOfFirstTest {

    private final isSecondArrayIsSubSetOfFirst testedClass = new isSecondArrayIsSubSetOfFirst();

    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(int[] value1, int[] value2, boolean expected) {
        Assertions.assertEquals(testedClass.isSubSet(value1, value2), expected);
    }

    @ParameterizedTest
    @MethodSource("provideNotEqualsCombinations")
    void testNotEqualsSituations(int[] value1, int[] value2, boolean expected) {
        Assertions.assertEquals(testedClass.isSubSet(value1, value2), expected);
    }

    @ParameterizedTest
    @MethodSource("provideExceptionCombinations")
    void checkIllegalArgumentException(int[] value1, int[] value2, Object expected) {
        assertThrows(IllegalArgumentException.class, () -> testedClass.isSubSet(value1, value2));
    }


    private static Stream<Arguments> provideEqualsCombinations() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, true),
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 3}, true),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2}, true),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3}, true),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1}, true),
                Arguments.of(new int[]{1, 2, 3}, new int[]{2}, true),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{3, 2, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 2, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{3, 2}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 2}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 3}, true)
        );
    }

    private static Stream<Arguments> provideNotEqualsCombinations() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 1, 3}, false),
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 2}, false),
                Arguments.of(new int[]{1, 2, 3}, new int[]{0, 4}, false),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 4, 5}, false),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 1, 4, 5}, false),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 1, 3}, false),
                Arguments.of(new int[]{1, 2, 3}, new int[]{0}, false),
                Arguments.of(new int[]{1, 2, 3}, new int[]{0, 3, 0}, false)
        );
    }

    private static Stream<Arguments> provideExceptionCombinations() {
        return Stream.of(
                Arguments.of(new int[0], new int[0], IllegalArgumentException.class),
                Arguments.of(new int[0], new int[]{1, 2, 3}, IllegalArgumentException.class),
                Arguments.of(new int[]{1, 2, 3}, new int[0], IllegalArgumentException.class),
                Arguments.of(null, new int[]{1, 2, 3}, IllegalArgumentException.class),
                Arguments.of(new int[]{1, 2, 3}, null, IllegalArgumentException.class)
        );
    }

}