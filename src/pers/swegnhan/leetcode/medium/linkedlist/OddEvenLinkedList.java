package pers.swegnhan.leetcode.medium.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        ListNode proto_odd = new ListNode(0), proto_even = new ListNode(0);
        ListNode odd = proto_odd, even = proto_even;
        for(int i = 0; head != null; i++){
            if(i % 2 == 0) {
                odd.next = head;
                odd = odd.next;
            }
            else{
                even.next = head;
                even = even.next;
            }
            head = head.next;
        }
        even.next = null;
        odd.next = proto_even.next;
        return proto_odd.next;
    }

    public static void main(String[] args){
        int[] testn = {1,2,3,4,5};
        ListNode proto_test = new ListNode(0);
        ListNode testl = proto_test;
        for(int i = 0; i < testn.length; i++){
            testl.next = new ListNode(testn[i]);
            testl = testl.next;
        }
        oddEvenList(proto_test.next);
    }

}
