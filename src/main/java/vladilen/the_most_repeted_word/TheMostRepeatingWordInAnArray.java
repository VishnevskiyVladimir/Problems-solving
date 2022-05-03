package vladilen.the_most_repeted_word;

import java.util.HashMap;

public class TheMostRepeatingWordInAnArray {

    public String findUsingHashMap(String[] words) {

        if (words == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }

        HashMap<String, Integer> map = new HashMap<>();

        int maxCount = 0;
        for (String word : words) {
            int count = map.get(word) == null ? 1 : map.get(word) + 1;
            maxCount = Math.max(maxCount, count);
            map.put(word, count);
        }

        String theMostRepeatingWord = words[0];

        for (String word : words) {
            if (map.get(word) == maxCount) {
                theMostRepeatingWord = word;
                break;
            }
        }

        return theMostRepeatingWord;
    }

//    public String find(String[] words) {
//
//        checkNull(words);
//
//
//        String theMostRepeatingWord;
//
//
//
//
//        return theMostRepeatingWord;
//    }

}
