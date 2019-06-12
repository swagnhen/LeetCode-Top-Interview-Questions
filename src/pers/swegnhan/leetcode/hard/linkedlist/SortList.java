package pers.swegnhan.leetcode.hard.linkedlist;

public class SortList {

    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode p = head;
        while(p != null){
            length++;
            p = p.next;
        }
        if(length <= 1)
            return head;
        ListNode p1 = head, p2 = null;
        for(int i = 0; i < length / 2 - 1; i++)
            p1 = p1.next;
        p2 = p1.next;
        p1.next = null;
        p1 = sortList(head);
        p2 = sortList(p2);
        p = new ListNode(0);
        ListNode newHead = p;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        while(p1 != null){
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while(p2 != null){
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        return newHead.next;
    }

}
