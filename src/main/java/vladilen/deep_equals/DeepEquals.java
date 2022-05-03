package vladilen.deep_equals;


import java.util.ArrayList;
import java.util.Arrays;

public class DeepEquals {

    //Make method working the same as Arrays.deepEquals() for nested int arrays;


    public boolean deepEquals(Object[] a1, Object[] a2) {

        if (a1 == a2) {
            return true;
        }

        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {

            Object e1 = a1[i];
            Object e2 = a2[i];

            if (e1 == e2)
                continue;
            if (e1 == null)
                return false;

            // Figure out whether the two elements are equal
            boolean eq = deepEquals__(e1, e2);

            if (!eq)
                return false;

        }

        return true;
    }


    public boolean deepEquals__(Object e1, Object e2) {
        boolean eq;

        if (e1 == null) {
            throw new RuntimeException("e1 is null");
        }

        if (e1 instanceof Object[] && e2 instanceof Object[]) {
            eq = deepEquals((Object[]) e1,(Object[])  e2);
        } else if (e1 instanceof int[] && e2 instanceof int[]) {
            eq = equals((int[]) e1, (int[]) e2);
        } else {
            eq = e1.equals(e2);
        }

        return eq;

    }

    public boolean equals(int[] a1, int[] a2) {
        if (a1 == a2) {
            return true;
        }

        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }

        return true;
    }


}
