package vladilen.is_second_array_a_subset_of_first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class isSecondArrayIsSubSetOfFirst {

    public boolean isSubSet(int[] arr1, int[] arr2) {

        if((arr1 == null || arr2 == null) || (arr1.length == 0 || arr2.length == 0)) {
            throw new IllegalArgumentException();
        }

        int len1 = arr1.length;
        int len2 = arr2.length;

        if (len2 > len1)
            return false;

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int curValue : arr1) {
            Integer curCount = map1.get(curValue);
            map1.put(curValue, curCount == null ? 1 : curCount + 1);
        }

        for (int curValue : arr2) {
            Integer curCount = map2.get(curValue);
            map2.put(curValue, curCount == null ? 1 : curCount + 1);
        }

        for (int curValue : arr2) {
            if (!map1.containsKey(curValue) || map1.get(curValue) < map2.get(curValue)) {
                return false;
            }
        }

        return true;
    }

}
