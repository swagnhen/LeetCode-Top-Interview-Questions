package pers.swegnhan.leetcode.easy.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int llength = 0;
        ListNode temp = head;
        while(temp != null){
            llength++;
            temp = temp.next;
        }
        temp = head;
        if(n == llength){
            head = head.next;
            return head;
        }
        for(int i = 0; i < llength - n - 1; i++)
            temp = temp.next;
        if(temp != null && temp.next != null)
            temp.next = temp.next.next;
        return head;
    }

    public static ListNode removeNthFromEndPlus(ListNode head, int n){
        ListNode mhead = new ListNode(Integer.MIN_VALUE);
        ListNode pre = mhead, post = mhead;
        mhead.next = head;
        for(int i = 0; i < n; i++)
            post = post.next;
        while(post.next != null){
            post = post.next;
            pre = pre.next;
        }
        if(pre != null && pre.next != null)
            pre.next = pre.next.next;
        return mhead.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 1; i < 5; i++){
            temp.next = new ListNode(i + 1);
            temp = temp.next;
        }
        removeNthFromEndPlus(head, 5);
        System.out.println("end;");
    }

}
