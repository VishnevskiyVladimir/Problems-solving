package leetcode._009_palindrome_number;

public class Solution_npp2 extends Solution{
    @Override
    public boolean isPalindrome(int x) {
        String actual = String.valueOf(x);
        String reversed = new StringBuilder(actual).reverse().toString();
        return actual.equals(reversed);
    }
}
