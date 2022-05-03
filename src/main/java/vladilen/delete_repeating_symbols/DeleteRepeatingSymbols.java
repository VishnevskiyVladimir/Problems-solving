package vladilen.delete_repeating_symbols;

import java.util.LinkedHashSet;

public class DeleteRepeatingSymbols {

//    public String delete(String word){
//        return null;
//    }

//    public static void main(String[] args) {
//        String[] strings = {
//                "asd",
//                "asdf",
//                "",
//                null,
//                "asdasd",
//                "aaasssda",
//                "asddsa",
//                "aaaaaaa"
//        };
//
//
//        for (String string : strings) {
//            try {
//                System.out.println(deleteRepeatingChars1(string));
//            } catch (IllegalArgumentException e) {
//                System.out.println(e);
//            }
//        }
//    }
//
    public String delete(String source) {

        if (source == null) {
            throw new IllegalArgumentException("String should not be null");
        }

        if(source.length() < 2) {
            return source;
        }

        char[] chars = source.toCharArray();
        LinkedHashSet<Character> characters = new LinkedHashSet<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character);
        }

        return sb.toString();

    }
//
//    private static String deleteRepeatingChars2(String source) {
//
//        if (source == null) {
//            throw new IllegalArgumentException("String should not be null");
//        }
//
//        if(source.length() < 2) {
//            return source;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0, len = source.length(); i < len; i++) {
//            char ch = source.charAt(i);
//            if(source.indexOf(ch,i) == -1) {
//                sb.append(ch);
//            }
//        }
//
//        return sb.toString();
//

//    }
}
