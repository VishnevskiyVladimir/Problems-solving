package leetcode._021_merge_two_sorted_lists;

public class Solution_1 extends Solution {

    ListNode merged = null;
    ListNode last = null;

    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null && list2 != null) {
            return list2;
        }

        if (list1 != null && list2 == null) {
            return list1;
        }

        boolean isList1Ended = false;
        boolean isList2Ended = false;

        while(true) {

            if(list1 == null) {
                isList1Ended = true;
            }

            if(list2 == null) {
                isList2Ended = true;
            }

            if(isList1Ended && !isList2Ended) {
                last.next = list2;
                return merged;
            } else if (!isList1Ended && isList2Ended) {
                last.next = list1;
                return merged;
            } else {
                int val1 = list1.val;
                int val2 = list2.val;
                if (val1 < val2) {
                    addToMerged(val1);
                    list1 = list1.next;
                } else {
                    addToMerged(val2);
                    list2 = list2.next;
                }
            }
        }

    }

    private  void addToMerged(int val) {
        ListNode cur = new ListNode(val);
        if(merged == null) {
            merged = cur;
            last = cur;
        } else if(merged == last) {
            last = cur;
            merged.next = last;
        }else {
            last.next = cur;
            last = last.next;
        }
    }
}
