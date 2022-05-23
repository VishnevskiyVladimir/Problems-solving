package leetcode._014_longest_common_prefix;

import java.util.Arrays;

public class Solution_2 extends Solution {
    @Override
    public String longestCommonPrefix(String[] strs) {

        if (strs == null) {
            throw new IllegalArgumentException("Parameter is null");
        }


        int amountOfStrings = strs.length;
//        int len = Integer.MAX_VALUE; // length of the shortest String
//        for (int i = 0; i < amountOfStrings; i++) {
//            len = Math.min(len,strs[i].length());
//        }
        int j = 0;
        try {
            outer:
            while (true) {

                char curChar = strs[0].charAt(j);
                for (int i = 1; i < amountOfStrings; i++) {
                    if (curChar != strs[i].charAt(j)) {
                        break outer;
                    }
                }
                j++;


            }
        } catch (StringIndexOutOfBoundsException e) {

        } finally {
            return strs[0].substring(0, j);
        }
    }
}
