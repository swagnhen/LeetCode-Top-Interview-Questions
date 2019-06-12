package pers.swegnhan.leetcode.hard.linkedlist;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        boolean hasChange = false;
        do{
            hasChange = false;
            int min = Integer.MAX_VALUE, maxIndex = -1;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] != null && lists[i].val <= min){
                    min = lists[i].val;
                    maxIndex = i;
                    hasChange = true;
                }
            }
            if(maxIndex != -1) {
                head.next = lists[maxIndex];
                head = head.next;
                lists[maxIndex] = lists[maxIndex].next;
            }
        }while(hasChange);
        return result.next;
    }

    public ListNode mergeKListsPlus(ListNode[] lists) {
        ListNode tail = new ListNode(0);
        ListNode result = tail;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2)->{
            if(n1.val > n2.val)
                return 1;
            else if(n1.val == n2.val)
                return 0;
            else
                return -1;
        });
        for(ListNode list : lists) {
            if(list != null)
                queue.add(list);
        }
        while(queue.size() != 0){
            tail.next = queue.remove();
            tail = tail.next;
            if(tail.next != null)
                queue.add(tail.next);
        }
        return result.next;
    }

}
