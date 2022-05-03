package yandex;

import java.util.HashSet;

public class TaskA {

//    Даны две строки строчных латинских символов: строка J и строка S.
//    Символы, входящие в строку J, — «драгоценности», входящие в строку S — «камни».
//    Нужно определить, какое количество символов из S одновременно являются «драгоценностями».
//    Проще говоря, нужно проверить, какое количество символов из S входит в J.

    public int count(String j, String s) {
        int count = 0;

        if (s.length() == 0) {
            return count;
        }

//        String[] stones = s.split("");
//        String[] jewels = j.split("");


        HashSet<Character> jewels = new HashSet<>();
        for (int i = 0; i < j.length(); i++) {
            jewels.add(j.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if(jewels.contains(s.charAt(i))) {
                count ++;
            }
        }
        return count;

    }




}
