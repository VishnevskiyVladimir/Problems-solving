package leetcode._009_palindrome_number;

public class Solution_npp1 extends Solution{
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int len = s.length();

        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
