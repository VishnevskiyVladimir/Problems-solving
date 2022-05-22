package leetcode._009_palindrome_number;

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

    private final Solution testedSolution = new Solution_npp1();
    private static final int AMOUNT_OF_TEST_SETS = 10;
    private static final int AMOUNT_OF_VALUES_IN_ONE_SET = 900000;
    private static final List<List<Integer>> testSets = new ArrayList<>();
    static{
        for (int i = 0; i < AMOUNT_OF_TEST_SETS; i++) {
            testSets.add(generateValuesForPerformanceTest(AMOUNT_OF_VALUES_IN_ONE_SET));
        }
    }


    @ParameterizedTest
    @MethodSource("provideEqualsCombinations")
    void testEqualsSituations(int value, boolean expected) {
        assertEquals(expected, testedSolution.isPalindrome(value));
    }

    @RepeatedTest(value =  10)
    void performanceTest() {
        for(List<Integer> testSet: testSets) {
            for (Integer value:   testSet) {
//            System.out.println(value + (testedSolution.isPalindrome(value)? " is palindrome" : " is not palindrome"));
                testedSolution.isPalindrome(value);
            }
        }


//        assertEquals(true, true);
    }

    private static Stream<Arguments> provideEqualsCombinations() {
        return Stream.of(
                Arguments.of(1221, true),
                Arguments.of(11, true),
                Arguments.of(1, true),
                Arguments.of(0, true),
                Arguments.of(12121, true),
                Arguments.of(1121, false),
                Arguments.of(122, false),
                Arguments.of(2113, false),
                Arguments.of(21, false),
                Arguments.of(12, false),
                Arguments.of(-1221, false),
                Arguments.of(-121, false),
                Arguments.of(-2113, false),
                Arguments.of(-21, false),
                Arguments.of(-12, false)
        );
    }

    private static List<Integer> generateValuesForPerformanceTest(int length) {

//        int MIN_VALUE = -2147483648; // MAx 10 digits + '-'
//        int MAX_VALUE = 2147483647;  // MAx 10 digits
        int[] palindromes = new int[]{
                1111111111,
                111111111,
                11111111,
                1111111,
                111111,
                11111,
                1111,
                111,
                11,
                1
        };
        int[] numbersForAdding = new int[]{
                1000000000,
                100000000,
                10000000,
                1000000,
                100000,
                10000,
                1000,
                100,
                10,
                1
        };

        Random random = new Random();


        ArrayList<Integer> values = new ArrayList<>();


        for (int i = 0; i < length; i++) {
            int palindrome = palindromes[random.nextInt(10)];
            int numberForAdding = random.nextBoolean() ? numbersForAdding[random.nextInt(10)] : 0;
            int sign = random.nextBoolean() ? -1 : 1;

            values.add(sign * palindrome + numberForAdding);
        }
        return values;
    }

}