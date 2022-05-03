package vladilen.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private final Fibonacci testedClass = new Fibonacci();

    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(int value, int[] expected) {
        Assertions.assertArrayEquals(testedClass.getFibonacciNumbers(value), expected);
    }

    @ParameterizedTest
    @MethodSource("provideNotEqualsCombinations")
    void testNotEqualsSituations(int value, int[] expected) {
        Assertions.assertFalse(Arrays.equals(testedClass.getFibonacciNumbers(value), expected));
    }

    @ParameterizedTest
    @MethodSource("provideExceptionCombinations")
    void checkIllegalArgumentException(int value, Object expected) {
        assertThrows(IllegalArgumentException.class, () -> testedClass.getFibonacciNumbers(value));
    }


    private static Stream<Arguments> provideEqualsCombinations() {
        return Stream.of(
                Arguments.of(13, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144}),
                Arguments.of(1, new int[]{0}),
                Arguments.of(2, new int[]{0, 1}),
                Arguments.of(3, new int[]{0, 1, 1}),
                Arguments.of(8, new int[]{0, 1, 1, 2, 3, 5, 8, 13})
        );
    }

    private static Stream<Arguments> provideNotEqualsCombinations() {
        return Stream.of(
                Arguments.of(13, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 20, 34, 55, 89, 144}),
                Arguments.of(13, new int[]{0}),
                Arguments.of(13, new int[]{144}),
                Arguments.of(1, new int[]{1}),
                Arguments.of(2, new int[]{0, 0})
        );
    }

    private static Stream<Arguments> provideExceptionCombinations() {
        return Stream.of(
                Arguments.of(-1, IllegalArgumentException.class),
                Arguments.of(0, IllegalArgumentException.class),
                Arguments.of(-100, IllegalArgumentException.class),
                Arguments.of(Integer.MIN_VALUE, IllegalArgumentException.class)
        );
    }

}