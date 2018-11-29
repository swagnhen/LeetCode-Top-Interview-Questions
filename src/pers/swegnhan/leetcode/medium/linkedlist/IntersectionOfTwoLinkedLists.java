package pers.swegnhan.leetcode.medium.linkedlist;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA != null){
            lengthA++;
            nodeA = nodeA.next;
        }
        while (nodeB != null){
            lengthB++;
            nodeB = nodeB.next;
        }
        if(lengthA > lengthB){
            for(int i = 0; i < lengthA - lengthB; i++)
                headA = headA.next;
        }
        else{
            for(int i = 0; i < lengthB - lengthA; i++)
                headB = headB.next;
        }
        while(headA != null && headB !=null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args){

    }

}
