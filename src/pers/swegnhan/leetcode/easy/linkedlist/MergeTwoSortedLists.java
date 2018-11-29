package pers.swegnhan.leetcode.easy.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }
        while(l2 !=null){
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode test1 = new ListNode(1), test2 = new ListNode(5);
        ListNode temp1 = test1, temp2 = test2;
        for(int i = 1; i < 5; i++){
            temp1.next = new ListNode(temp1.val + 2);
            temp2.next = new ListNode(temp2.val + 1);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1 = mergeTwoLists(test1, test2);
        System.out.println("end");
    }

}
