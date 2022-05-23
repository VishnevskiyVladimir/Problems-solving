package leetcode._014_longest_common_prefix;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {


//    private final Solution testedSolution = new Solution_1(); // about 316 ms in last repetitions
//    private final Solution testedSolution = new Solution_2(); // about 12 seconds one repetition. Very slow and return in finally block
    private final Solution testedSolution = new Solution_3(); // almost the same as first solution


    private static final int AMOUNT_OF_TEST_ARRAYS = 200;
    private static final int AMOUNT_OF_WORDS_IN_ONE_TEST_ARRAY = 5000;
    private static final int WORD_LENGTH_COEFFICIENT = 100;
    private static final List<String[]> testSets = new ArrayList<>();

    static {
        for (int i = 0; i < AMOUNT_OF_TEST_ARRAYS; i++) {
            testSets.add(generateValuesForPerformanceTest(AMOUNT_OF_WORDS_IN_ONE_TEST_ARRAY));
        }
    }


    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(String[] value, String expected) {
        assertEquals(expected, testedSolution.longestCommonPrefix(value));
    }

    @RepeatedTest(value = 10)
    void performanceTest() {
//        int count = 0;
        for (String[] testSet : testSets) {
//            System.out.println(count++);

            testedSolution.longestCommonPrefix(testSet);


//            for (int i = 0; i < testSet.length; i++) {
//                System.out.println(testSet[i]);
//            }
//            System.out.println("common_prefix = " + testedSolution.longestCommonPrefix(testSet));
        }
    }

    private static Stream<Arguments> provideEqualsCombinations() {
        return Stream.of(
                Arguments.of(new String[]{"str1", "string", "strike"}, "str"),
                Arguments.of(new String[]{"str1", "str1", "str1"}, "str1"),
                Arguments.of(new String[]{"", "", ""}, ""),
                Arguments.of(new String[]{"asd", "sdf", "dsa"}, ""),
                Arguments.of(new String[]{"", "ss", "  "}, ""),
                Arguments.of(new String[]{"str1", "str1", "st"}, "st"),
                Arguments.of(new String[]{"str1", "str", "strike"}, "str")
        );
    }

    private static String[] generateValuesForPerformanceTest(int length) {


        String[] commonParts = new String[]{
                "welcome",
                "asdf",
                "fox",
                "qwerty",
                "mine",
                "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd",
                "number",
                "///////////////////////////////////////////////////////////////////////////////////////////////////////",
                ""
        };


        Random random = new Random();

        String[] values = new String[length];
        StringBuilder sb;
        String commonPart = commonParts[random.nextInt(10)] ;
        boolean isLongCommonPartsGeneration = random.nextBoolean();
        for (int i = 0; i < length; i++) {
            sb = new StringBuilder();
            sb.append(commonPart); //appending the common part
            for (int j = 0; j < WORD_LENGTH_COEFFICIENT; j++) {
                if(isLongCommonPartsGeneration) {
                    sb.append(commonPart);
                } else {
                    sb.append(random.nextBoolean() ? commonParts[random.nextInt(10)] : ""); // appending suffix
                }
            }
            values[i] = sb.toString();
        }
        return values;
    }

}