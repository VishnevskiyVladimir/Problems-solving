package leetcode._006_zig_zag_conversion;

public class Solution {
    public String convert(String s, int numRows) {


        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++)
            sbs[i] = new StringBuilder();

        boolean direction = false; // down/up-right
        int curRow = 0;

        for (int i = 0; i < s.length(); i++) {
            if (curRow == numRows - 1) {
                direction = true;
            } else if (curRow == 0) {
                direction = false;
            }
            sbs[curRow].append(s.charAt(i));

            if(!direction) {
                curRow++;
            } else {
                curRow--;
            }
        }

        StringBuilder response = new StringBuilder();
        for (StringBuilder sb : sbs)
            response.append(sb);

        return response.toString();
    }
}

