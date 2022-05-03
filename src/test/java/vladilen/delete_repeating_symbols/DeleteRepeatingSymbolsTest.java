package vladilen.delete_repeating_symbols;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DeleteRepeatingSymbolsTest {

    private final DeleteRepeatingSymbols testedClass = new DeleteRepeatingSymbols();

    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(String value, String expected) {
        Assertions.assertEquals(testedClass.delete(value), expected);
    }


    @ParameterizedTest
    @MethodSource("provideExceptionCombinations")
    void checkIllegalArgumentException(String value, Object expected) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> testedClass.delete(value));
    }




    private static Stream<Arguments> provideEqualsCombinations() {
        return Stream.of(
                Arguments.of("aaaaa", "a"),
                Arguments.of("asdf", "asdf"),
                Arguments.of("asdasda", "asd"),
                Arguments.of("  ", " "),
                Arguments.of("a", "a")
        );
    }


    private static Stream<Arguments> provideExceptionCombinations() {
        return Stream.of(
                Arguments.of(null, IllegalArgumentException.class)
        );
    }


}