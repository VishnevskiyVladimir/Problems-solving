package leetcode._013_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

class Solution_npp1 extends Solution{

    //Логические ошибки
    // Использовал String вместо Character в качестве ключа HashMap из за этого получал ошибку NPE romansDecimals.get(s.charAt(s.length() - 1));
    // Забывал извлекать из мапы десятичные числа и пробовал прибавить к результату римские символы

    //Сложность алгоритма по времени линейная
    //

    Map<Character, Integer> romansDecimals =  new HashMap<>();

    {
        romansDecimals.put('I', 1);
        romansDecimals.put('V', 5);
        romansDecimals.put('X', 10);
        romansDecimals.put('L', 50);
        romansDecimals.put('C', 100);
        romansDecimals.put('D', 500);
        romansDecimals.put('M', 1000);
    }



    public int romanToInt(String s) {
        if(s == null) {
            throw new IllegalArgumentException();
        }

        if(s.isEmpty()) {
            return 0;
        }


        // Add last digit to result before cycle
        int prevDec;
        int curDec;
        int result = romansDecimals.get(s.charAt(s.length() - 1));


        for(int i = s.length() - 2; i >= 0; i--) {
            prevDec = romansDecimals.get(s.charAt(i + 1));
            curDec = romansDecimals.get(s.charAt(i));
            if(prevDec <= curDec) {
                result = result + curDec;
            } else {
                result = result - curDec;
            }
        }

        return result;

    }
}
