package leetcode._002_add_two_numbers;

import vladilen.linked_list.MyLinkedList;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        //2,4,3    5,6,4   7,0,8

        MyLinkedList2 list = new MyLinkedList2();
        System.out.println(l1);
        System.out.println(l2);

        int overflowed = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int curVal = (val1 + val2) % 10;
            list.add(curVal + overflowed);
            overflowed = (val1 + val2)/10;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }


        System.out.println(list.first);
        return list.first;
    }

    class MyLinkedList2 {
        private ListNode last;
        private ListNode first;
        private int size;

        void add ( int val){
            ListNode cur = new ListNode(val);
            if (size == 0) {
                last = cur;
                first = cur;
            } else {
                last.next = cur;
                last = last.next;
            }
            size++;
        }

        public ListNode getLast() {
            return last;
        }

        public ListNode getFirst() {
            return first;
        }
    }
}