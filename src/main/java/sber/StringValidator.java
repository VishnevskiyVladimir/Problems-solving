package sber;

import java.util.Stack;

public class StringValidator {
    public boolean validate(String string){

        Stack<Character> characters = new Stack<>();

        int length = string.length();


        if (length % 2 != 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {

            char curSymbol = string.charAt(i);
            if (ValidationConfiguration.isOpening(curSymbol)) {
                characters.add(curSymbol);
            } else if (ValidationConfiguration.isClosing(curSymbol)) {
                Character prevSymbol = characters.peek();
                if (prevSymbol == ValidationConfiguration.getPair(curSymbol)) {
                    characters.pop();
                }
            }
        }
//        string.toCharArray()[0] = 1;

        return characters.isEmpty();
    }
}
