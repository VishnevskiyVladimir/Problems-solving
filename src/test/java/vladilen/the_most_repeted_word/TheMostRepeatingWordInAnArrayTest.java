package vladilen.the_most_repeted_word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TheMostRepeatingWordInAnArrayTest {
    TheMostRepeatingWordInAnArray testClass = new TheMostRepeatingWordInAnArray();

    @ParameterizedTest
    @NullSource
    void shouldThrowIllegalArgumentException(String[] words) {
        assertThrows(IllegalArgumentException.class, () -> testClass.findUsingHashMap(words));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindTheMostRepeatingWord(String[] words, String expected) {
        assertEquals(expected,testClass.findUsingHashMap(words));
    }


    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"one","two","three","two","three","three"}, "three"),
                Arguments.of(new String[]{"three","two","three","two","three","one"}, "three"),
                Arguments.of(new String[]{"two","three","three","two","three","one"}, "three"),
                Arguments.of(new String[]{"one","two","three","two","three"}, "two"),
                Arguments.of(new String[]{"two","two"}, "two"),
                Arguments.of(new String[]{"one"}, "one"),
                Arguments.of(new String[]{"one","two"}, "one"),
                Arguments.of(new String[]{"two","one"}, "two"),
                Arguments.of(new String[]{null}, null),
                Arguments.of(new String[]{"",""},"")
        );
    }

}