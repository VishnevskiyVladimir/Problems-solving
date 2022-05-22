package leetcode._009_palindrome_number;

public class Solution_npp3 extends Solution{


    @Override
    boolean isPalindrome(int x) {


        if(x < 0) return false;
        long actual = x;
        long reversed = 0;
        do {
            int lastDigit = getLastDigit(x);
            reversed = reversed * 10 + lastDigit;
            x = x / 10;
        } while (x > 0);

//        System.out.println(actual);
//        System.out.println(reversed);
        return reversed == actual;
    }

    private static int getLastDigit(int number) {
        return number % 10;
    }

}
