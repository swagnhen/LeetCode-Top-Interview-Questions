package pers.swegnhan.leetcode.easy.design;

public class MinStack {

    class StackNode{

        public StackNode(int x) { val = x; }

        public int val;

        public StackNode next;

    }

    private int size = 0;

    private StackNode head = new StackNode(0);

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        StackNode newNode = new StackNode(x);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void pop() {
        if(size == 0)
            return;
        head = head.next;
        size--;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        StackNode temp = head;
        for(int i = 0; i < size; i++){
            min = temp.val < min ? temp.val : min;
            temp = temp.next;
        }
        return min;
    }

    public static void main(String[] args){
        int test = 0;
        MinStackPlus minStack = new MinStackPlus();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        test = minStack.top();
        minStack.pop();
        test = minStack.getMin();
        minStack.pop();
        test = minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        test = minStack.top();
        test = minStack.getMin();
        minStack.push(-2147483648);
        test = minStack.top();
        test = minStack.getMin();
        minStack.pop();
        test = minStack.getMin();
        System.out.println("end");
    }

}

class MinStackPlus{

    class StackNode{

        public StackNode(long x) { val = x; }

        public long val;

        public StackNode next;

    }

    private int size = 0;

    private long min = Integer.MAX_VALUE;

    private StackNode head = new StackNode(0);

    /** initialize your data structure here. */
    public MinStackPlus() {}

    public void push(int x) {
        StackNode newNode = null;
        if(size == 0)
            newNode = new StackNode(0);
        else
            newNode = new StackNode(x - min);
        if(x < min)
            min = x;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void pop() {
        if(size == 0)
            return;
        if(head.val < 0)
            min = min - head.val;
        head = head.next;
        size--;
        if(size == 0)
            min = Integer.MAX_VALUE;
    }

    public int top() {
        if(head.val < 0)
            return (int)min;
        return (int)(head.val + min);
    }

    public int getMin() {
        return (int)min;
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */