package leetcode._014_longest_common_prefix;

import java.util.Arrays;

public class Solution_3 extends Solution{
    @Override
    public String longestCommonPrefix(String[] strs) {

        if(strs == null) {
            throw new IllegalArgumentException("Parameter is null");
        }

        Arrays.sort(strs);
        String firstString = strs[0];
        String lastString = strs[strs.length - 1];

        int len = Math.min(firstString.length(), lastString.length());
        int count = 0;


        for (int i = 0; i < len; i++) {
            if(firstString.charAt(i) != lastString.charAt(i)) {
                break;
            }
            count++;
        }


        return strs[0].substring(0, count);
    }
}
