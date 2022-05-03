package vladilen.shifted_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShiftedStringTest {

    private final ShiftedString testedClass = new ShiftedString();

    @ParameterizedTest
    @MethodSource("provideTrueCombinations")
    void checkTrueSituations(String orig, String target) {
        assertTrue(testedClass.isShifted(orig, target));
    }

    @ParameterizedTest
    @MethodSource("provideFalseCombinations")
    void checkFalseSituations(String orig, String target) {
        assertFalse(testedClass.isShifted(orig, target));
    }

    @ParameterizedTest
    @MethodSource("provideExceptionCombinations")
    void checkIllegalArgumentException(String orig, String target) {
        assertThrows(IllegalArgumentException.class, () -> testedClass.isShifted(orig, target));
    }


    private static Stream<Arguments> provideTrueCombinations() {
        return Stream.of(
                Arguments.of("FIRST", "FIRST"),
                Arguments.of("FIRST", "IRSTF"),
                Arguments.of("FIRST", "RSTFI"),
                Arguments.of("FIRST", "STFIR"),
                Arguments.of("FIRST", "TFIRS")
        );
    }

    private static Stream<Arguments> provideFalseCombinations() {
        return Stream.of(
                Arguments.of("FIRST", ""),
                Arguments.of("", "TFIRS"),
                Arguments.of("", ""),
                Arguments.of("FIRST", "FIRSTT"),
                Arguments.of("FIRST", "FIRS"),
                Arguments.of("FIRST", "TFFRS")
        );
    }

    private static Stream<Arguments> provideExceptionCombinations() {
        return Stream.of(
                Arguments.of(null, "TFFRS"),
                Arguments.of("FIRST", null),
                Arguments.of(null, null)
        );
    }

}