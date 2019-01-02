package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0)
            return new int[]{};
        int[] result = new int[nums.length - k + 1];
        for(int i = k; i <= nums.length; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i - k; j < i; j++)
                max = max >= nums[j] ? max : nums[j];
            result[i - k] = max;
        }
        return result;
    }

    public static int[] maxSlidingWindowPlus(int[] nums, int k) {
        if(nums.length == 0)
            return new int[]{};
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList();
        for(int i = 0; i < nums.length; i++){
            if(!deque.isEmpty() && deque.peek() <= i - k)
                deque.poll();
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.add(i);
            if(i >= k - 1)
                result[i - k + 1] = nums[deque.peek()];
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.stream(maxSlidingWindowPlus(new int[]{1,3,-1,-3,5,3,6,7}, 3)).boxed().collect(Collectors.toList()));
    }

}
