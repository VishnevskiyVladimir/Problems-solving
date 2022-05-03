package leetcode._001_two_sum;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        Arrays.sort(nums);


        int leftNumber = Integer.MIN_VALUE;
        int rightNumber = Integer.MAX_VALUE;
        outer:
        for (int right = nums.length - 1; right >= 0; right--) {
            rightNumber = nums[right];
            if (rightNumber <= target) {
                inner:
                for (int  left = 0; left < right; left++) {
                    leftNumber = nums[left];
                    int sum = leftNumber + rightNumber;
                    if (sum == target) {
                        break outer;
                    } else if (sum < target){
                        continue inner;
                    }  else if (sum > target) {
                        continue outer;
                    }
                }
            }
        }

        return new int[]{ numsMap.get(rightNumber), numsMap.get(leftNumber)};

    }
}
