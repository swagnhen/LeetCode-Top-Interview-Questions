package pers.swegnhan.leetcode.easy.dynamicprogramming;

public class HouseRobber {

    public static int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        dp[nums.length - 2] = nums[nums.length - 2];
        dp[nums.length - 3] = nums[nums.length - 3] + nums[nums.length - 1];
        for(int i = nums.length - 4; i >= 0; i--)
            dp[i] = Math.max(dp[i + 2], dp[i + 3]) + nums[i];
        return Math.max(dp[0], dp[1]);
    }

    /*public static int robStep(int[] nums, int i){
        if(i >= nums.length)
            return 0;
        if(i >= nums.length - 2)
            return nums[i];
        return Math.max(nums[i] + robStep(nums,i+2), nums[i] + robStep(nums, i + 3));
    }*/

    public static void main(String[] args){
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

}
