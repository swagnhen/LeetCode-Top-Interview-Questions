package pers.swegnhan.leetcode.easy.linkedlist;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode mhead = head, temp = null;
        while(head != null){
            temp = head.next;
            head.next = mhead;
            mhead = head;
            head = temp;
        }
        return mhead;
    }

    public static ListNode reverseListRec(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mhead = reverseListRec(head.next);
        ListNode temp = mhead;
        head.next = null;
        while(temp.next != null)
            temp = temp.next;
        temp.next = head;
        return mhead;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 1; i < 5; i++){
            temp.next = new ListNode(i + 1);
            temp = temp.next;
        }
        temp = reverseList(head);
        System.out.println("end;");
    }

}
