package vladilen.unique_symbols;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import vladilen.unique_symbols.UniqueSymbols;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UniqueSymbolsTest {

    private final UniqueSymbols testedClass = new UniqueSymbols();

    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(String value, boolean expected) {
        Assertions.assertEquals(testedClass.isUnique(value), expected);
    }

    @ParameterizedTest
    @MethodSource("provideNotEqualsCombinations")
    void testNotEqualsSituations(String value, boolean expected) {
        Assertions.assertNotEquals(testedClass.isUnique(value), expected);
    }

    @ParameterizedTest
    @MethodSource("provideExceptionCombinations")
    void checkIllegalArgumentException(String value, Object expected) {
        assertThrows(IllegalArgumentException.class, () -> testedClass.isUnique(value));
    }




    private static Stream<Arguments> provideEqualsCombinations() {
        return Stream.of(
                Arguments.of("abcd", true),
                Arguments.of("abc", true),
                Arguments.of("ba", true),
                Arguments.of("a", true)
        );
    }

    private static Stream<Arguments> provideNotEqualsCombinations() {
        return Stream.of(
                Arguments.of("cabcd", true),
                Arguments.of("abbcd", true),
                Arguments.of("abbcd", true),
                Arguments.of("dabcd", true),
                Arguments.of("abdcd", true),
                Arguments.of("abacd", true),
                Arguments.of("abcda", true),
                Arguments.of("aaa", true),
                Arguments.of("aa", true),
                Arguments.of("", true)
        );
    }

    private static Stream<Arguments> provideExceptionCombinations() {
        return Stream.of(
                Arguments.of(null, IllegalArgumentException.class)
        );
    }


}