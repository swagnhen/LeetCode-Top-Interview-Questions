package pers.swegnhan.leetcode.easy.linkedlist;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        int llength = 0;
        ListNode iter = head;
        while(iter != null){
            llength++;
            iter = iter.next;
        }
        iter = head;
        for(int i = 0; i < llength / 2; i++){
            list.add(iter.val);
            iter = iter.next;
        }
        if(llength % 2 == 1)
            iter = iter.next;
        while(iter != null){
            if(iter.val != list.get(list.size() - 1))
                return false;
            list.remove(list.size() - 1);
            iter = iter.next;
        }
        return true;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 1; i < 5; i++){
            temp.next = new ListNode(i + 1);
            temp = temp.next;
        }
        for(int i = 0; i < 4; i++){
            temp.next = new ListNode(temp.val - 1);
            temp = temp.next;
        }
        boolean flag = isPalindrome(head);
        System.out.println("end");
    }

}
