package vladilen.unique_symbols;


import java.util.HashSet;

public class UniqueSymbols {

//    public boolean isUnique(String string) {
//
//        if (string == null) {
//            throw new IllegalArgumentException();
//        }
//
//        if (string.length() == 0) {
//            return false;
//        }
//
//        HashSet<Character> words = new HashSet<>();
//        int length = string.length();
//        for (int i = 0; i < length; i++) {
//            char symbol = string.charAt(i);
//            if (words.contains(symbol)) {
//                return false;
//            } else {
//                words.add(symbol);
//            }
//        }
//
//        return true;
//    }

    public boolean isUnique(String string) {

        if (string == null) {
            throw new IllegalArgumentException("String should not be null");
        }

        int length = string.length();

        if (length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            char currentChar = string.charAt(i);
            if (string.indexOf(currentChar, i + 1) > 0) {
                return false;
            }
        }

        return true;
    }
//
//    public boolean isUnique(String string) {
//
//        if (string == null) {
//            throw new IllegalArgumentException("String should not be null");
//        }
//
//        int length = string.length();
//
//        if (length == 0) {
//            return false;
//        }
//
//        HashSet<Character> characters = new HashSet<>();
//        for (int i = 0; i < length; i++) {
//            characters.add(string.charAt(i));
//        }
//
//        return characters.size() == string.length();
//    }

}
