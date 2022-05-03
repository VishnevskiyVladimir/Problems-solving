package vladilen.shifted_string;

public class ShiftedString {

    public boolean isShifted(String orig, String compared) {

        if(orig == null )
            throw new IllegalArgumentException("Parameter orig is null");

        if(compared == null)
            throw new IllegalArgumentException("Parameter compared is null");


        int origLen = orig.length();
        int comparedLen = compared.length();

        if ((origLen == 0 || comparedLen == 0) || origLen != comparedLen)
            return false;

        String doubledOrig = orig + orig;
        return doubledOrig.contains(compared);
    }

}
