package sber;

import java.util.HashMap;
import java.util.HashSet;

public final class ValidationConfiguration {

    private final static HashMap<Character, Character> pairs;
    private final static HashSet<Character> opening;
    private final static HashSet<Character> closing;

    private ValidationConfiguration() {
    }

    static {
        pairs = new HashMap<>();
        pairs.put('[', ']');
        pairs.put(']', '[');
        pairs.put('(', ')');
        pairs.put(')', '(');
        pairs.put('{', '}');
        pairs.put('}', '{');

        opening = new HashSet<>();
        opening.add('[');
        opening.add('(');
        opening.add('{');

        closing = new HashSet<>();
        closing.add(']');
        closing.add(')');
        closing.add('}');
    }

    public static char getPair(char symbol) {
        return pairs.get(symbol);
    }

    public static boolean isOpening(char symbol) {
        return opening.contains(symbol);
    }

    public static boolean isClosing(char symbol) {
        return closing.contains(symbol);
    }
}
