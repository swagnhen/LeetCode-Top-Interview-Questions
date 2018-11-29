package pers.swegnhan.leetcode.medium.linkedlist;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0;
        while(l1 != null && l2 != null){
            temp.next = new ListNode(0);
            temp = temp.next;
            temp.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            temp.next = new ListNode(0);
            temp = temp.next;
            temp.val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
        }
        while(l2 != null){
            temp.next = new ListNode(0);
            temp = temp.next;
            temp.val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }
        if(carry != 0)
            temp.next = new ListNode(carry);
        return result.next;
    }

    public static void main(String[] args){
        int[] test1 = {9, 9, 9, 9};
        int[] test2 = {9, 9};
        ListNode t1 = new ListNode(0);
        ListNode t2 = new ListNode(0);
        ListNode testl1 = t1, testl2 = t2;
        for(int i = 0; i < test1.length; i++){
            t1.next = new ListNode(0);
            t1 = t1.next;
            t1.val = test1[i];
        }
        for(int i = 0; i < test2.length; i++){
            t2.next = new ListNode(0);
            t2 = t2.next;
            t2.val = test2[i];
        }
        ListNode t3 = addTwoNumbers(testl1.next, testl2.next);
        while(t3 != null){
            System.out.println(t3.val);
            t3 = t3.next;
        }
    }

}
