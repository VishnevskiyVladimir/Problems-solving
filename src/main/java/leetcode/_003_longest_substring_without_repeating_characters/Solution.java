package leetcode._003_longest_substring_without_repeating_characters;

public class Solution {



    public int lengthOfLongestSubstring(String s) {
        int count;
        int maxLength = 0;
        int[] chars = new int[128];
        for (int rightPointer = 0, leftPointer = 0; rightPointer < s.length(); rightPointer++) {
            char curChar = s.charAt(rightPointer);
            int lastIndex = chars[curChar];
            if(lastIndex != 0) {
                leftPointer = lastIndex;
            }
            chars[curChar] = rightPointer + 1;
            count = rightPointer - leftPointer + 1;
            maxLength = Math.max(maxLength,count);
        }

        return maxLength;
    }
}
