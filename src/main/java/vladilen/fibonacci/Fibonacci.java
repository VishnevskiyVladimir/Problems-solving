package vladilen.fibonacci;

public class Fibonacci {
    public int[] getFibonacciNumbers(int length) {

        if (length <= 0) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[length];


        int[] firstAndSecondValues = {0, 1};
        int pre_prev = firstAndSecondValues[0];
        int prev = firstAndSecondValues[1];

        for (int i = 0, len = result.length; i < len; i++) {
            if(i < 2) {
                result[i] = firstAndSecondValues[i];
            } else {
                int newVal = prev + pre_prev;
                pre_prev = prev;
                prev = newVal;
                result[i] = newVal;
            }
        }

        return result;
    }
}
