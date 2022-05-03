package leetcode._013_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;

        int cur, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            cur = map.get(s.charAt(i));
            if (i < s.length() - 1)
                prev = map.get(s.charAt(i + 1));
            if (cur < prev) {
                res = res - cur;
            } else {
                res = res + cur;
            }
        }
        return res;
    }
}
