package pers.swegnhan.leetcode.medium.dynamicprogramming;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max + 1;
    }

    public static int lengthOfLISPlus(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            int low = 0, mid = 0, high = size;
            while(low < high){
                mid = (low + high) / 2;
                if(nums[i] > tail[mid])
                    low = mid + 1;
                else
                    high = mid;
            }
            tail[low] = nums[i];
            if(low == size)
                size++;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLISPlus(new int[]{10,9,2,5,3,7,101,18}));
    }

}
