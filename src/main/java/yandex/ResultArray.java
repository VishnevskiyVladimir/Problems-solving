package yandex;

import java.util.ArrayList;
import java.util.List;

public class ResultArray {

    public List<Integer> uniteLists(List<Integer> l1, List<Integer> l2) {

        if((l1 == null && l2  == null) ) {
            throw new IllegalArgumentException("Both parameters are null");
        }

        if((l1 == null || l1.isEmpty()) && !l2.isEmpty()) {
            return l2;
        }

        if((l2 == null || l2.isEmpty()) && !l1.isEmpty()) {
            return l1;
        }

        int l1Cursor = 0;
        int l2Cursor = 0;
        Integer lastAddedElement = null;
        boolean l1EndReached = false;
        boolean l2EndReached = false;

        List<Integer> result = new ArrayList<>();

        for(;;) {
            if(l1Cursor >= l1.size()) {
                l1EndReached = true;
            }
            if(l2Cursor >= l2.size()) {
                l2EndReached = true;
            }

            if(l1EndReached && l2EndReached) {
                break;
            } else if(l1EndReached && !l2EndReached) {
                Integer curL2Element = l2.get(l2Cursor);
                if(curL2Element > lastAddedElement) {
                    result.add(curL2Element);
                }
                l2Cursor++;
            } else if (l2EndReached && !l1EndReached) {
                Integer curL1Element = l1.get(l1Cursor);
                if(curL1Element > lastAddedElement){
                    result.add(curL1Element);
                }
                l1Cursor++;
            } else {
                Integer curL1Element = l1.get(l1Cursor);
                Integer curL2Element = l2.get(l2Cursor);

                if(curL1Element < curL2Element) {
                    if(result.isEmpty()) {
                        result.add(curL1Element);
                        lastAddedElement = curL1Element;
                    } else {
                        if(curL1Element > lastAddedElement) {
                            result.add(curL1Element );
                            lastAddedElement = curL1Element;
                        }
                    }
                    l1Cursor++;
                } else if(curL2Element < curL1Element) {
                    if(result.isEmpty()) {
                        result.add(curL2Element);
                        lastAddedElement = curL2Element;
                    } else {
                        if(curL1Element > lastAddedElement) {
                            result.add(curL2Element );
                            lastAddedElement = curL2Element;
                        }
                    }
                    l2Cursor++;
                } else if (curL1Element.equals(curL2Element)) {
                    if(result.isEmpty()) {
                        result.add(curL1Element);
                        lastAddedElement = curL1Element;
                    } else {
                        if(curL1Element > lastAddedElement) {
                            result.add(curL1Element );
                            lastAddedElement = curL1Element;
                        }
                    }
                    l1Cursor++;
                    l2Cursor++;
                }
            }
        }

        return result;
    }
}
