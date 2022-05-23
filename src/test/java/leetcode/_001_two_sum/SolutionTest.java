package leetcode._001_two_sum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
//    Solution solution = new Solution();
    Solution solution = new Solution_npp1();





    @Test
    void test1() {
        int[] nums = new int[]{11,2,7,10,15};
        int[] correct_result = new int[]{1,2};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        Arrays.sort(result);
        assertArrayEquals(correct_result, result);
    }

    @Test
    void test2() {
        int[] nums = new int[]{11,2,7,10,15};
        int[] correct_result = new int[]{3,4};
        int target = 25;
        int[] result = solution.twoSum(nums, target);
        Arrays.sort(result);
        assertArrayEquals(correct_result, result);
    }

    @Test
    void test3() {
        int[] nums = new int[]{11,2,7,10,15};
        int[] correct_result = new int[]{0,1};
        int target = 13;
        int[] result = solution.twoSum(nums, target);
        Arrays.sort(result);
        assertArrayEquals(correct_result, result);
    }

    @Test
    void test4() {
        int[] nums = new int[]{11,2,7,10};
        int[] correct_result = new int[]{1,2};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        Arrays.sort(result);
        assertArrayEquals(correct_result, result);
    }

    @Test
    void test5() {
        int[] nums = new int[]{11,2,7,10};
        int[] correct_result = new int[]{2,3};
        int target = 17;
        int[] result = solution.twoSum(nums, target);
        Arrays.sort(result);
        assertArrayEquals(correct_result, result);
    }

    @Test
    void test6() {
        int[] nums = new int[]{11,2,7,10};
        int[] correct_result = new int[]{0,1};
        int target = 13;
        int[] result = solution.twoSum(nums, target);
        Arrays.sort(result);
        assertArrayEquals(correct_result, result);
    }
}