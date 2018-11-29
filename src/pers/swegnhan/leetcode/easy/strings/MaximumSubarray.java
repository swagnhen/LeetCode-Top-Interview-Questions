package pers.swegnhan.leetcode.easy.strings;

class Solution {

    public static int maxSubArray(int[] nums) {
        int sums = Integer.MIN_VALUE, temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(temp >= 0)
                temp += nums[i];
            else
                temp = nums[i];
            sums = Math.max(sums, temp);
        }
        return sums;
    }

}

public class MaximumSubarray {

    public static void main(String[] args){
        System.out.println(Solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}
