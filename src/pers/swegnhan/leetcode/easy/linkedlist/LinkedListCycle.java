package pers.swegnhan.leetcode.easy.linkedlist;

import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        Set<String> set = new HashSet<String>();
        while(head != null){
            if(set.contains(head.toString()))
                return true;
            set.add(head.toString());
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args){

    }

}
