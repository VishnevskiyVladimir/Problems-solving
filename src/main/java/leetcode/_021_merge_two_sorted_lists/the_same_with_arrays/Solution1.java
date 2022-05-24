package leetcode._021_merge_two_sorted_lists.the_same_with_arrays;

public class Solution1 extends Solution {
    @Override
    public int[] mergeTwoArrays(int[] arr1, int[] arr2) {

        if (arr1 == null && arr2 == null) {
            // Or throw exception
            return new int[0];
        }

        if (arr1 == null && arr2.length == 0) {
            return new int[0];
        }

        if (arr2 == null && arr1.length == 0) {
            return new int[0];
        }

        if (arr1 != null && arr2 != null && arr2.length == 0) {
            return arr1;
        }

        if (arr2 != null && arr1 != null && arr1.length == 0) {
            return arr2;
        }

        int resultLen = arr1.length + arr2.length;
        int[] result = new int[resultLen];

        int i = 0; //cursor for arr1
        int j = 0; //cursor for arr2
        int k = 0; //cursor for result array

        boolean arr1isEnded = false;
        boolean arr2isEnded = false;
        while (true) {
            if (i == arr1.length) {
                arr1isEnded = true;
            }

            if (j == arr2.length) {
                arr2isEnded = true;
            }


            if (arr1isEnded && arr2isEnded) {
                break;
            } else if (arr1isEnded && !arr2isEnded) {
                for (; j < arr2.length; ) {
                    k = i + j;
                    result[k] = arr2[j];
                    j++;
                }
            } else if (!arr1isEnded && arr2isEnded) {
                for (; i < arr1.length; ) {
                    k = i + j;
                    result[k] = arr1[i];
                    i++;
                }
            } else {
                k = i + j;
                if (arr1[i] < arr2[j]) {
                    result[k] = arr1[i];
                    i++;
                } else {
                    result[k] = arr2[j];
                    j++;
                }
            }
        }

        return result;
    }
}
