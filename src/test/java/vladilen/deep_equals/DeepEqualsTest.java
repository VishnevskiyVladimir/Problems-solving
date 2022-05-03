package vladilen.deep_equals;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class DeepEqualsTest {

    private final DeepEquals testedClass = new DeepEquals();

//    @ParameterizedTest
//    @MethodSource("forEqualsProvideEqualsCombinations")
//    void testEqualsSituations(int[] a1, int[] a2, boolean expected) {
//        Assertions.assertEquals(testedClass.equals(a1, a2), expected);
//    }
//
//    @ParameterizedTest
//    @MethodSource("forEqualsProvideNotEqualsCombinations")
//    void testNotEqualsSituations(int[] a1, int[] a2, boolean expected) {
//        Assertions.assertNotEquals(testedClass.equals(a1, a2), expected);
//    }
//
//
//
//    private static Stream<Arguments> forEqualsProvideEqualsCombinations() {
//        int[] test_a1 = {1, 2, 3, 4, 5};
//        int[] test_a2 = {4};
//        int[] test_a3 = {};
//        return Stream.of(
//                Arguments.of(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5}, true),
//                Arguments.of(test_a1, new int[]{1,2,3,4,5}, true),
//                Arguments.of(new int[]{1,2,3,4,5}, test_a1, true),
//                Arguments.of(test_a1, test_a1, true),
//                Arguments.of(new int[]{}, new int[]{}, true),
//                Arguments.of(test_a3, new int[]{}, true),
//                Arguments.of(new int[]{}, test_a3, true),
//                Arguments.of(test_a3, test_a3, true),
//                Arguments.of(new int[]{4}, new int[]{4}, true),
//                Arguments.of(test_a2, new int[]{4}, true),
//                Arguments.of(new int[]{4}, test_a2, true),
//                Arguments.of(test_a2, test_a2, true),
//                Arguments.of(null, null, true)
//        );
//    }
//
//    private static Stream<Arguments> forEqualsProvideNotEqualsCombinations() {
//        return Stream.of(
//                Arguments.of(new int[]{1,2,3,5}, new int[]{1,2,3,4,5}, true),
//                Arguments.of(new int[]{1,2,3,4,5}, new int[]{1,2,3,4}, true),
//                Arguments.of(new int[]{1,2,3,5}, new int[]{1,3,4,5}, true),
//                Arguments.of(new int[]{}, new int[]{1,2,3,4,5}, true),
//                Arguments.of(new int[]{1,2,3,4,5}, new int[]{}, true),
//                Arguments.of(null, new int[]{1,2,3,4,5}, true),
//                Arguments.of(new int[]{1,2,3,5}, null, true),
//                Arguments.of(new int[]{0}, new int[]{5}, true)
//                );
//    }


    @ParameterizedTest
    @MethodSource("forDeepEqualsProvideEqualsCombinations")
    void testEqualsSituations(Object[] value1, Object[] value2, boolean expected) {
        Assertions.assertEquals(testedClass.deepEquals(value1, value2), expected);
//        Assertions.assertEquals(Arrays.deepEquals(value1, value2), expected);
    }

    @ParameterizedTest
    @MethodSource("forDeepEqualsProvideNotEqualsCombinations")
    void testNotEqualsSituations(Object[] value1, Object[] value2, boolean expected) {
        Assertions.assertNotEquals(testedClass.deepEquals(value1, value2), expected);
//        Assertions.assertNotEquals(Arrays.deepEquals(value1, value2), expected);
    }

//    @ParameterizedTest
//    @MethodSource("provideExceptionCombinations")
//    void checkIllegalArgumentException(Object[] value1, Object[] value2, Object expected) {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> testedClass.deepEquals(value1, value2));
//    }




    private static Stream<Arguments> forDeepEqualsProvideEqualsCombinations() {
        Object[] test_a1 = {1, 2, 3, 4, 5};
        Object[] test_a2 = {4};
        Object[] test_a3 = {};
        return Stream.of(

                Arguments.of(new Object[]{new int[]{1, 2}, new int[]{3, 4, 5}}, new Object[]{new int[]{1, 2}, new int[]{3, 4, 5}}, true),


                Arguments.of(new Object[]{1,2,3,4,5}, new Object[]{1,2,3,4,5}, true),
                Arguments.of(test_a1, new Object[]{1,2,3,4,5}, true),
                Arguments.of(new Object[]{1,2,3,4,5}, test_a1, true),
                Arguments.of(test_a1, test_a1, true),
                Arguments.of(new Object[]{}, new Object[]{}, true),
                Arguments.of(test_a3, new Object[]{}, true),
                Arguments.of(new Object[]{}, test_a3, true),
                Arguments.of(test_a3, test_a3, true),
                Arguments.of(new Object[]{4}, new Object[]{4}, true),
                Arguments.of(test_a2, new Object[]{4}, true),
                Arguments.of(new Object[]{4}, test_a2, true),
                Arguments.of(test_a2, test_a2, true),
                Arguments.of(null, null, true)
        );
    }

    private static Stream<Arguments> forDeepEqualsProvideNotEqualsCombinations() {
        return Stream.of(
                Arguments.of(new Object[]{1,2,3,5}, new Object[]{1,2,3,4,5}, true),
                Arguments.of(new Object[]{1,2,3,4,5}, new Object[]{1,2,3,4}, true),
                Arguments.of(new Object[]{1,2,3,5}, new Object[]{1,3,4,5}, true),
                Arguments.of(new Object[]{}, new Object[]{1,2,3,4,5}, true),
                Arguments.of(new Object[]{1,2,3,4,5}, new Object[]{}, true),
                Arguments.of(null, new Object[]{1,2,3,4,5}, true),
                Arguments.of(new Object[]{1,2,3,5}, null, true),
                Arguments.of(new Object[]{0}, new Object[]{5}, true)
        );
    }

//    private static Stream<Arguments> provideExceptionCombinations() {
//        return Stream.of(
//                Arguments.of(null, null, IllegalArgumentException.class)
//        );
//    }


}