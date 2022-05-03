package vladilen.shifted_string.simple_search;

public class SimpleSearch {

    public int findInSortedArray(int[] arr, int target) {

        if(arr == null) {
            throw new IllegalArgumentException();
        }

        int len = arr.length;

        if (len == 0 || arr[0] > target || arr[len - 1] < target) {
            return -1;
        }

        if (arr[0] == target) {
            return 0;
        }

        if (arr[len - 1] == target &&  arr[len - 2] < target) {
            return len - 1;
        }

        int begin = 0;
        int end = len - 1;
        int pointer = (end - begin) / 2;

        while (true) {
            if(arr[pointer] == target && arr[pointer - 1] < target)
                break;
            if (arr[pointer] >= target) {
                end = pointer;
            } else {
                begin = pointer;
            }

            pointer = (begin + end) / 2;
        }

        return pointer;
    }
}
